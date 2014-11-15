package org.jorge.fightclub.gui;

import com.toedter.calendar.JDateChooser;
import org.jorge.fightclub.base.Boxer;
import org.jorge.fightclub.base.Coach;
import org.jorge.fightclub.base.Dojo;

import javax.swing.*;
import java.util.List;
import java.util.*;

/**
 * Created by jorge on 10/11/14.
 */
public class Window extends JFrame{
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JLabel loadLabel;
    private JTextField txtNameDojo;
    private JTextField txtStreetDojo;
    private JList listCoachInDojo;
    private JList listBoxerInDojo;
    private JButton btNewDojo;
    private JButton btSaveDojo;
    private JButton btChangeDojo;
    private JButton btCancelDojo;
    private JButton btDeleteDojo;
    private JButton btFirstDojo;
    private JButton btBeforeDojo;
    private JButton btAfterDojo;
    private JButton btLastDojo;
    private JTextField txtNameCoach;
    private JTextField txtYearCoach;
    private JComboBox cbDojoInCoach;
    private JList listBoxerInCoach;
    private JTextField searchDojo;
    private JList listDojo;
    private JDateChooser dateCoach;
    private JList listCoach;
    private JTextField searchCoach;
    private JButton btNewCoach;
    private JButton btSaveCoach;
    private JButton btChangeCoach;
    private JButton btDeleteCoach;
    private JButton btCancelCoach;
    private JButton btFirstCoach;
    private JButton btBeforeCoach;
    private JButton btAfterCoach;
    private JButton btLastCoach;
    private JTextField txtNameBoxer;
    private JTextField txtWinBoxer;
    private JTextField txtLoseBoxer;
    private JTextField txtWeightBoxer;
    private JComboBox cbCoachInBoxer;
    private JComboBox cbDojoInBoxer;
    private JButton btNewBoxer;
    private JButton btSaveBoxer;
    private JButton btChangeBoxer;
    private JButton btDeleteBoxer;
    private JButton btCancelBoxer;
    private JButton btFirstBoxer;
    private JButton btBeforeBoxer;
    private JButton btAfterBoxer;
    private JButton btLastBoxer;
    private JList listBoxer;
    private JTextField searchBoxer;
    private JDateChooser dateDojo;

    private List<Dojo> arrayListDojo;
    private List<Coach> arrayListCoach;
    private List<Boxer> arrayListBoxer;

    private DefaultListModel<Dojo> modelDojo;
    private DefaultListModel<Coach> modelCoach,modelCoachInDojo;
    private DefaultListModel<Boxer> modelBoxer,modelBoxerInCoach,modelBoxerInDojo;

    private static MenuBar menuBar;

    private boolean manual;

    private String path;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Window");
        menuBar = new MenuBar();
        Window window = new Window();
        frame.setJMenuBar(menuBar.menuBar());
        menuBar.setWindow(window);
        frame.setContentPane(window.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * method to initialize all variable and set default values.
     */
    public void initialize(){
        dateDojo.setEnabled(false);
        dateCoach.setEnabled(false);

        arrayListBoxer = new ArrayList<Boxer>();
        arrayListDojo = new ArrayList<Dojo>();
        arrayListCoach = new ArrayList<Coach>();

        modelBoxer = new DefaultListModel<Boxer>();
        modelBoxerInCoach = new DefaultListModel<Boxer>();
        modelBoxerInDojo = new DefaultListModel<Boxer>();
        modelCoach = new DefaultListModel<Coach>();
        modelCoachInDojo = new DefaultListModel<Coach>();
        modelDojo = new DefaultListModel<Dojo>();

        listBoxer.setModel(modelBoxer);
        listBoxerInCoach.setModel(modelBoxerInCoach);
        listBoxerInDojo.setModel(modelBoxerInDojo);
        listCoach.setModel(modelCoach);
        listCoachInDojo.setModel(modelCoachInDojo);
        listDojo.setModel(modelDojo);

        manual = false;
    }

    public Window(){
        initialize();
        configureListeners();
    }

    /**
     * create my own listeners
     */
    public void configureListeners(){
        ActionBoxer actionBoxer = new ActionBoxer(this);
        ActionCoach actionCoach = new ActionCoach(this);
        ActionDojo actionDojo = new ActionDojo(this);

        //action button
        btNewBoxer.addActionListener(actionBoxer);
        btCancelBoxer.addActionListener(actionBoxer);
        btSaveBoxer.addActionListener(actionBoxer);
        btChangeBoxer.addActionListener(actionBoxer);
        btDeleteBoxer.addActionListener(actionBoxer);

        btNewDojo.addActionListener(actionDojo);
        btCancelDojo.addActionListener(actionDojo);
        btSaveDojo.addActionListener(actionDojo);
        btChangeDojo.addActionListener(actionDojo);
        btDeleteDojo.addActionListener(actionDojo);

        btNewCoach.addActionListener(actionCoach);
        btCancelCoach.addActionListener(actionCoach);
        btSaveCoach.addActionListener(actionCoach);
        btChangeCoach.addActionListener(actionCoach);
        btDeleteCoach.addActionListener(actionCoach);
        //navigate button
        btFirstBoxer.addActionListener(actionBoxer);
        btLastBoxer.addActionListener(actionBoxer);
        btAfterBoxer.addActionListener(actionBoxer);
        btBeforeBoxer.addActionListener(actionBoxer);

        btFirstDojo.addActionListener(actionDojo);
        btLastDojo.addActionListener(actionDojo);
        btAfterDojo.addActionListener(actionDojo);
        btBeforeDojo.addActionListener(actionDojo);

        btFirstCoach.addActionListener(actionCoach);
        btLastCoach.addActionListener(actionCoach);
        btBeforeCoach.addActionListener(actionCoach);
        btAfterCoach.addActionListener(actionCoach);
        //JList navigate
        listDojo.addMouseListener(actionDojo);
        listCoach.addMouseListener(actionCoach);
        listBoxer.addMouseListener(actionBoxer);
        //TextArea search
        searchDojo.addKeyListener(actionDojo);
        searchCoach.addKeyListener(actionCoach);
        searchBoxer.addKeyListener(actionBoxer);
        //menuBar
        tabbedPane1.addChangeListener(menuBar);
        tabbedPane1.addChangeListener(actionDojo);
        tabbedPane1.addChangeListener(actionCoach);
        tabbedPane1.addChangeListener(actionBoxer);
    }

    public boolean isManual() {
        return manual;
    }

    public void setManual(boolean manual) {
        this.manual = manual;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public JTabbedPane getTabbedPane1() {
        return tabbedPane1;
    }

    public JLabel getLoadLabel() {
        return loadLabel;
    }

    public JTextField getTxtNameDojo() {
        return txtNameDojo;
    }

    public JTextField getTxtStreetDojo() {
        return txtStreetDojo;
    }

    public JList getListCoachInDojo() {
        return listCoachInDojo;
    }

    public JList getListBoxerInDojo() {
        return listBoxerInDojo;
    }

    public JButton getBtNewDojo() {
        return btNewDojo;
    }

    public JButton getBtSaveDojo() {
        return btSaveDojo;
    }

    public JButton getBtChangeDojo() {
        return btChangeDojo;
    }

    public JButton getBtCancelDojo() {
        return btCancelDojo;
    }

    public JButton getBtDeleteDojo() {
        return btDeleteDojo;
    }

    public JButton getBtFirstDojo() {
        return btFirstDojo;
    }

    public JButton getBtBeforeDojo() {
        return btBeforeDojo;
    }
    public JButton getBtAfterDojo() {
        return btAfterDojo;
    }

    public JButton getBtLastDojo() {
        return btLastDojo;
    }

    public JTextField getTxtNameCoach() {
        return txtNameCoach;
    }

    public JTextField getTxtYearCoach() {
        return txtYearCoach;
    }

    public JComboBox getCbDojoInCoach() {
        return cbDojoInCoach;
    }

    public JList getListBoxerInCoach() {
        return listBoxerInCoach;
    }

    public JTextField getSearchDojo() {
        return searchDojo;
    }

    public JList getListDojo() {
        return listDojo;
    }

    public JDateChooser getDateCoach() {
        return dateCoach;
    }

    public JList getListCoach() {
        return listCoach;
    }

    public JTextField getSearchCoach() {
        return searchCoach;
    }

    public JButton getBtNewCoach() {
        return btNewCoach;
    }

    public JButton getBtSaveCoach() {
        return btSaveCoach;
    }

    public JButton getBtChangeCoach() {
        return btChangeCoach;
    }

    public JButton getBtDeleteCoach() {
        return btDeleteCoach;
    }

    public JButton getBtCancelCoach() {
        return btCancelCoach;
    }

    public JButton getBtFirstCoach() {
        return btFirstCoach;
    }

    public JButton getBtBeforeCoach() {
        return btBeforeCoach;
    }

    public JButton getBtAfterCoach() {
        return btAfterCoach;
    }

    public JButton getBtLastCoach() {
        return btLastCoach;
    }

    public JTextField getTxtNameBoxer() {
        return txtNameBoxer;
    }

    public JTextField getTxtWinBoxer() {
        return txtWinBoxer;
    }

    public JTextField getTxtLoseBoxer() {
        return txtLoseBoxer;
    }

    public JTextField getTxtWeightBoxer() {
        return txtWeightBoxer;
    }

    public JComboBox getCbCoachInBoxer() {
        return cbCoachInBoxer;
    }

    public JComboBox getCbDojoInBoxer() {
        return cbDojoInBoxer;
    }

    public JButton getBtNewBoxer() {
        return btNewBoxer;
    }

    public JButton getBtSaveBoxer() {
        return btSaveBoxer;
    }

    public JButton getBtChangeBoxer() {
        return btChangeBoxer;
    }

    public JButton getBtDeleteBoxer() {
        return btDeleteBoxer;
    }

    public JButton getBtCancelBoxer() {
        return btCancelBoxer;
    }

    public JButton getBtFirstBoxer() {
        return btFirstBoxer;
    }

    public JButton getBtBeforeBoxer() {
        return btBeforeBoxer;
    }

    public JButton getBtAfterBoxer() {
        return btAfterBoxer;
    }

    public JButton getBtLastBoxer() {
        return btLastBoxer;
    }

    public JList getListBoxer() {
        return listBoxer;
    }

    public JTextField getSearchBoxer() {
        return searchBoxer;
    }

    public JDateChooser getDateDojo() {
        return dateDojo;
    }

    public List<Dojo> getArrayListDojo() {
        return arrayListDojo;
    }

    public void setArrayListDojo(List<Dojo> arrayListDojo) {
        this.arrayListDojo = arrayListDojo;
    }

    public List<Coach> getArrayListCoach() {
        return arrayListCoach;
    }

    public void setArrayListCoach(List<Coach> arrayListCoach) {
        this.arrayListCoach = arrayListCoach;
    }

    public List<Boxer> getArrayListBoxer() {
        return arrayListBoxer;
    }

    public void setArrayListBoxer(List<Boxer> arrayListBoxer) {
        this.arrayListBoxer = arrayListBoxer;
    }

    public DefaultListModel<Dojo> getModelDojo() {
        return modelDojo;
    }

    public DefaultListModel<Coach> getModelCoach() {
        return modelCoach;
    }

    public DefaultListModel<Coach> getModelCoachInDojo() {
        return modelCoachInDojo;
    }

    public DefaultListModel<Boxer> getModelBoxer() {
        return modelBoxer;
    }

    public DefaultListModel<Boxer> getModelBoxerInCoach() {
        return modelBoxerInCoach;
    }

    public DefaultListModel<Boxer> getModelBoxerInDojo() {
        return modelBoxerInDojo;
    }
}
