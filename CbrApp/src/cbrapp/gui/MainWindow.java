package cbrapp.gui;

import cbrapp.AdaptationRules;
import cbrapp.ReadSolutions;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Класс главного окна.
 * @author M. Navrotskiy.
 * @version 1.0
 */
public class MainWindow extends JFrame {
    
    /* Поля класса. */
    /** Выпадающий список количества. */
    private JComboBox<String> countValues = new JComboBox<>();
    /** Выпадающий список класса опасности. */
    private JComboBox<String> classValues = new JComboBox<>();
    /** Выпадающий список агрегатных состояний. */
    private JComboBox<String> stateValues = new JComboBox<>();
    /** Выпадающий список типа отходов. */
    private JComboBox<String> typeValues = new JComboBox<>();
    
    /** Подпись выпадающего списка количества. */
    private final JLabel countLabel = new JLabel("Количество отходов:");
    /** Подпись выпадающего списка классов опасности. */
    private final JLabel classLabel = new JLabel("Класс опасности:");
    /** Подпись выпадающего списка агрегатных состояний. */
    private final JLabel stateLabel = new JLabel("Агрегатное состояние:");
    /** Подпись типа отходов. */
    private final JLabel typeLabel = new JLabel("Тип отходов:");
    
    /** Поле вывода списка рекомендаций. */
    private JTable table;
    
    /** Кнопка запуска анализа. */
    private final JButton runBtn = new JButton("Поиск");
    /** Кнопка запуска процесса адаптации. */
    private JButton adaptBtn = new JButton("Адаптировать");
    
    /** Пространство имен онтологии. */
    private final String ns;
  
    /**
     * Метод инициализации выпадающих списков.
     * @param ontoClass Класс выпадающего списка в онтологии.
     * @return Список значений для выпадающего списка.
     */
    private Vector initComboBox (String ontoClass) {
        try {
            Vector<String> result = new Vector();
            
            OntModel model = 
                    ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
            model.read(new FileInputStream("vw_cbr.owl"), "");
            
            OntClass c = model.getOntClass(ns + ontoClass);
            
            ExtendedIterator it = c.listInstances();
            
            while (it.hasNext()) {
                String item = it.next().toString();
                result.add(item.substring(item.indexOf('#') + 1, item.length()));
            }
            
            model.close();
            
            return result;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Конструктор.
     * @param ns Пространство имен онтологии.
     */
    public MainWindow(String ns) {
        super("CBR с адаптацией");
        this.table = new JTable(
                new DefaultTableModel(new Object[]{"Column1"}, 0));
        
        this.ns = ns;
        
        this.countValues = new JComboBox<>(this.initComboBox("TrashCount"));
        this.classValues = new JComboBox<>(this.initComboBox("Danger"));
        this.stateValues = new JComboBox<>(this.initComboBox("AggregateState"));
        this.typeValues  = new JComboBox<>(this.initComboBox("Type"));
        
        this.setLayout(new GridLayout(1, 2, 50, 50));
        
        GridLayout left = new GridLayout(9, 1, 10, 10);
        
        JPanel leftPanel = new JPanel(left);
        leftPanel.add(this.countLabel);
        leftPanel.add(this.countValues);
        leftPanel.add(this.classLabel);
        leftPanel.add(this.classValues);
        leftPanel.add(this.stateLabel);
        leftPanel.add(this.stateValues);
        leftPanel.add(this.typeLabel);
        leftPanel.add(this.typeValues);
        leftPanel.add(this.runBtn);
        
        GridLayout right = new GridLayout(2, 1);
        JPanel rightPanel = new JPanel(right);
        rightPanel.add(this.table);
        this.adaptBtn.setEnabled(false);
        JPanel rightInPanel = new JPanel(new BorderLayout());
        this.adaptBtn.setSize(73, 27);
        rightInPanel.add(this.adaptBtn, BorderLayout.SOUTH);
        rightPanel.add(rightInPanel);
        
        this.add(leftPanel);
        this.add(rightPanel);
        
        this.setSize(625, 344);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        final int WIDTH = screenSize.width;
        final int HEIGHT = screenSize.height;
        this.setLocation(WIDTH / 8, WIDTH / 8);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.runBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                DefaultTableModel dtm = (DefaultTableModel) table.getModel();
                dtm.setRowCount(0);
                
                String[] values = new String[5];
                values[0] = (String) countValues.getSelectedItem();
                values[1] = (String) classValues.getSelectedItem();
                values[2] = (String) stateValues.getSelectedItem();
                values[3] = "fdt_1";
                values[4] = (String) typeValues.getSelectedItem();
                
                ArrayList<String> solutionsText = 
                        ReadSolutions.getSolutionsText(cbrapp.CbrApp.cbr(values));
                
                cbrapp.CbrApp.writeResult(solutionsText);
                
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);
                for (String item : solutionsText) {
                    
                    model.addRow(new Object[]{item});
                }
                
                adaptBtn.setEnabled(true);
                
            }
        });
        
        this.adaptBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                String[] values = new String[5];
                values[0] = (String) countValues.getSelectedItem();
                values[1] = (String) classValues.getSelectedItem();
                values[2] = (String) stateValues.getSelectedItem();
                values[3] = "fdt_1";
                values[4] = (String) typeValues.getSelectedItem();
                
                String[] result = AdaptationRules.useRules(values);
                
                ArrayList<String> solutionsText = 
                        ReadSolutions.getSolutionsText(cbrapp.CbrApp.cbr(result));
                
                cbrapp.CbrApp.writeResult(solutionsText);
                
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);
                for (String item : solutionsText) {
                    
                    model.addRow(new Object[]{item});
                }
            }
        });
    }
    
}
