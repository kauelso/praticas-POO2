package gui;

import entity.ObjBibliotecario;
import entity.Revista;

import javax.persistence.EntityManager;
import javax.swing.*;
import java.util.List;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.*;

public class RevistasGUI implements ActionListener{
    private EntityManager entityManager;
    //Creating JFrame
    private JFrame frame = new JFrame("Objetos Bibliotecarios");
    //Creating Buttons
    private JButton incluirButton = new JButton("Incluir");
    private JButton revistasButton = new JButton("Livros");
    private JButton listagemButton = new JButton("Listagem");
    //Creating JPanels
    private JPanel buttonPanel = new JPanel();
    private JPanel tituloPanel = new JPanel();
    //Creating Labels
    private JLabel tituloLabel = new JLabel("rEVISTAS", SwingConstants.CENTER);
    private JLabel orgLabel = new JLabel("Org");
    private JLabel revistaTituloLabel = new JLabel("Titulo");
    private JLabel anoLabel = new JLabel("Ano");
    private JLabel volLabel = new JLabel("Vol");
    private JLabel nroLabel = new JLabel("Nro");
    //Creating Text Fields
    private JTextField tituloTf = new JTextField(20);
    private JTextField orgTf = new JTextField(20);
    private JTextField anoTf = new JTextField(4);
    private JTextField volTf = new JTextField(2);
    private JTextField nroTf = new JTextField(3);

    RevistasGUI(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void startGUI(){
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(300,300);

        tituloPanel.add(revistaTituloLabel);
        tituloPanel.add(tituloTf);
        tituloPanel.add(orgLabel);
        tituloPanel.add(orgTf);
        tituloPanel.add(anoLabel);
        tituloPanel.add(anoTf);
        tituloPanel.add(volLabel);
        tituloPanel.add(volTf);
        tituloPanel.add(nroLabel);
        tituloPanel.add(nroTf);

        buttonPanel.add(incluirButton);
        buttonPanel.add(revistasButton);
        buttonPanel.add(listagemButton);

        incluirButton.addActionListener(this);
        revistasButton.addActionListener(this);
        listagemButton.addActionListener(this);

        frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
        frame.getContentPane().add(BorderLayout.PAGE_START, tituloLabel);
        frame.getContentPane().add(BorderLayout.CENTER, tituloPanel);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Incluir")){
            try{
                new Revista(tituloTf.getText(), Integer.parseInt(anoTf.getText()), orgTf.getText(), Integer.parseInt(volTf.getText()), Integer.parseInt(nroTf.getText())).incluir(entityManager);
            }
            catch(Exception exc){
                JDialog dialog = new JDialog(frame,"Erro");

                JLabel l = new JLabel("Campos em branco e/ou em formato inválido");

                dialog.add(l);
                dialog.setSize(100,100);
                dialog.setVisible(true);
            }
        }

        if(e.getActionCommand().equals("Listagem")){
            ListaObjetosGUI lista = new ListaObjetosGUI();
            lista.printObj(entityManager);
        }

        if(e.getActionCommand().equals("Livros")){
            LivrosGUI livro = new LivrosGUI(entityManager);
            livro.startGUI();
        }
    }
}
