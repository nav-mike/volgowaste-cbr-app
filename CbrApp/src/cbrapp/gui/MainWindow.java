package cbrapp.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

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
    
    public MainWindow(String ns) {
        super("CBR с адаптацией");
        
        this.ns = ns;
        
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
