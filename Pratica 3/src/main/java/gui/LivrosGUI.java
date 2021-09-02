package gui;

import entity.Livro;
import entity.ObjBibliotecario;

import javax.persistence.EntityManager;
import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class LivrosGUI implements ActionListener{
    private EntityManager entityManager;
    //Creating JFrame
    private JFrame frame = new JFrame("Objetos Bibliotecarios");
    //Creating Buttons
    private JButton incluirButton = new JButton("Incluir");
    private JButton revistasButton = new JButton("Revistas");
    private JButton listagemButton = new JButton("Listagem");
    //Creating JPanels
    private JPanel buttonPanel = new JPanel();
    private JPanel tituloPanel = new JPanel();
    //Creating Labels
    private JLabel tituloLabel = new JLabel("LIVROS", SwingConstants.CENTER);
    private JLabel autorLabel = new JLabel("Autor");
    private JLabel livroTituloLabel = new JLabel("Titulo");
    private JLabel anoLabel = new JLabel("Ano", SwingConstants.CENTER);
    //Creating Text Fields
    private JTextField tituloTf = new JTextField(20);
    private JTextField autorTf = new JTextField(20);
    private JTextField anoTf = new JTextField(20);

    public LivrosGUI(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void startGUI(){
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(300,300);

        tituloPanel.add(livroTituloLabel);
        tituloPanel.add(tituloTf);
        tituloPanel.add(autorLabel);
        tituloPanel.add(autorTf);
        tituloPanel.add(anoLabel);
        tituloPanel.add(anoTf);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Incluir")){
            try{
                Livro livro = new Livro(tituloTf.getText(), Integer.parseInt(anoTf.getText()), autorTf.getText());
                livro.incluir(entityManager);
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

        if(e.getActionCommand().equals("Revistas")){
            RevistasGUI revista = new RevistasGUI(entityManager);
            revista.startGUI();
        }
    }
}
