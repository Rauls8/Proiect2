package Aplicatie;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Ecran extends JFrame{
    private JPanel PanouSus;
    private JPanel PanouStanga;
    private JPanel PanouDreapta;
    private JList listaPersoane;
    private JButton buttonNou;
    private JButton buttonSave;
    private JTextField textnume;
    private JTextField textemail;
    private JTextField textnumartelefon;
    private JLabel LabelAni;
    private JTextField textziuanasterii;
    private JPanel panelMain;
    private ArrayList<Agenda> persoane;
    private DefaultListModel Listapersmodel;

    Ecran(){
        super("Proiectul meu de contacte");
        this.setContentPane(this.panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        persoane = new ArrayList<Agenda>();
        Listapersmodel = new DefaultListModel();
        listaPersoane.setModel(Listapersmodel);
        buttonSave.setEnabled(false);



        buttonNou.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonNouClick(e);
            }
        });

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSaveClick(e);
            }
        });
        listaPersoane.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                listpeopleSelectin(e);
            }
        });
    }

    public void buttonNouClick(ActionEvent e) {
        Object[] options = { "DA", "RENUNTA" };

        int numevariabila = JOptionPane.showOptionDialog(null, "Doriti sa adaugati contactul?", "Notificare",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);
        if(numevariabila==0) {
            Agenda p = new Agenda(
                    textnume.getText(),
                    textemail.getText(),
                    textnumartelefon.getText(),
                    textziuanasterii.getText()
            );
            persoane.add(p);
            refreshPeopleList();
        }
    }

    public void buttonSaveClick(ActionEvent e){
        Object[] options = { "OK", "RENUNTA" };

        int numevariabila = JOptionPane.showOptionDialog(null, "Contactul a fost salvat!", "Notificare",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);
        if(numevariabila==0) {
        int numarpersoana = listaPersoane.getSelectedIndex();
        if (numarpersoana >= 0) {
            Agenda p = persoane.get(numarpersoana);
            p.setNume(textnume.getText());
            p.setEmail(textemail.getText());
            p.setNumartelefon(textnumartelefon.getText());
            p.setziuanasterii(textziuanasterii.getText());
            refreshPeopleList();
        }
        }
    }
    public void listpeopleSelectin(ListSelectionEvent e){
        int numarpersoana = listaPersoane.getSelectedIndex();
        if (numarpersoana >= 0){
            Agenda p = persoane.get(numarpersoana);
            textnume.setText(p.getNume() );
            textemail.setText(p.getEmail() );
            textnumartelefon.setText(p.getNumartelefon() );
            textziuanasterii.setText(p.getZiuanasterii().format(DateTimeFormatter.ofPattern("dd/MM/yyy")));
            LabelAni.setText( Integer.toString(p.getAge())+" ani");
            buttonSave.setEnabled(true);
        } else {
            buttonSave.setEnabled(false);
        }
    }

    public void refreshPeopleList(){
        Listapersmodel.removeAllElements();
        System.out.println("Stergere toate persoanele din lista");
        for (Agenda p:persoane){
            System.out.println("Adaugare persoane in lista"+p.getNume());
           Listapersmodel.addElement(p.getNume());
        }
    }

    public void addPerson(Agenda p){
        persoane.add(p);
        refreshPeopleList();
    }

    public static void main(String[] args) {
        Ecran ecran = new Ecran();
        ecran.setVisible(true);

        Agenda NOU = new Agenda("Creaza contact nou ", " ",  " ", "27/10/2021");
        Agenda Ion = new Agenda("Ion Dumitru", "ion.dumitru@gmail.com",  "0762452134", "25/04/1998");
        Agenda Paula = new Agenda("Paula Mihalache", "paula.m@yahoo.com",  "0756452497", "02/12/1987");
        Agenda Marcel = new Agenda("Marcel Moldovan", "moldovan.marcel@gmail.com",  "0754612348", "10/01/2001");
        Agenda Mihaela = new Agenda("Mihaela Costache", "Mihaelacos@hotmail.com",  "0758564219", "20/11/2002");
        Agenda Costel = new Agenda("Costel Marius", "Costelm@gmail.com",  "0764249751", "19/04/2005");

        ecran.addPerson(NOU);
        ecran.addPerson(Ion);
        ecran.addPerson(Paula);
        ecran.addPerson(Marcel);
        ecran.addPerson(Mihaela);
        ecran.addPerson(Costel);

    }
}
