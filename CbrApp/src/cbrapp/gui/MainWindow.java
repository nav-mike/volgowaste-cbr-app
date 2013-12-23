package cbrapp.gui;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.OntResource;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;
import es.ucm.fdi.gaia.ontobridge.OntoBridge;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import jcolibri.util.OntoBridgeSingleton;

/**
 * Класс главного окна.
 * @author M. Navrotskiy.
 * @version 1.0
 */
public class MainWindow extends JFrame {
    
    /* Поля класса. */
    /** Выпадающий список количества. */
    private JComboBox<String> countValues = new JComboBox<String>();
    /** Выпадающий список класса опасности. */
    private JComboBox<String> classValues = new JComboBox<String>();
    /** Выпадающий список агрегатных состояний. */
    private JComboBox<String> stateValues = new JComboBox<String>();
    /** Выпадающий список типа отходов. */
    private JComboBox<String> typeValues = new JComboBox<String>();
    
    /** Подпись выпадающего списка количества. */
    private JLabel countLabel = new JLabel("Количество отходов:");
    /** Подпись выпадающего списка классов опасности. */
    private JLabel classLabel = new JLabel("Класс опасности:");
    /** Подпись выпадающего списка агрегатных состояний. */
    private JLabel stateLabel = new JLabel("Агрегатное состояние:");
    /** Подпись типа отходов. */
    private JLabel typeLabel = new JLabel("Тип отходов:");
    
    /** Поле вывода списка рекомендаций. */
    private JList<String> solutoinsList = new JList<String>();
    
    /** Подпись рекомендаций. */
    private JLabel solutionsLabel = new JLabel("Рекомендации:");
    
    /** Кнопка запуска анализа. */
    private JButton runBtn = new JButton("Поиск");
    
    /** Пространство имен онтологии. */
    private String ns;
  
    /**
     * Метод инициализации выпадающих списков.
     * @param ontoClass Класс выпадающего списка в онтологии.
     * @return Список значений для выпадающего списка.
     */
    private Vector initComboBox (String ontoClass) {
        try {
            Vector<String> result = new Vector();
            
            OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
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
        
        GridLayout right = new GridLayout(1, 1);
        JPanel rightPanel = new JPanel(right);
        rightPanel.add(this.solutoinsList);
        
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
    }
    
}
