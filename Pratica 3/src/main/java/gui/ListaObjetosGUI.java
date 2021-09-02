package gui;

import entity.Livro;
import entity.ObjBibliotecario;
import entity.Revista;
import interfaces.LivroRepository;
import interfaces.RevistaRepository;

import java.util.ArrayList;
import java.util.List;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Table;
import javax.swing.*;

public class ListaObjetosGUI {

    private JFrame frame = new JFrame("Objetos Bibliotecarios");

    private JPanel printPanel = new JPanel();

    private List<JLabel> labels = new ArrayList<>();

    public void printObj(EntityManager entityManager){
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(300,300);

        try{
            LivroRepository livroRepository = new LivroRepository(entityManager);
            List<Livro> livros = livroRepository.findAll();
            RevistaRepository revistaRepository = new RevistaRepository(entityManager);
            List<Revista> revistas = revistaRepository.findAll();
            List<ObjBibliotecario> lista = new ArrayList<>(List.of());
            lista.addAll(livros);
            lista.addAll(revistas);
            printPanel.setLayout(new BoxLayout(printPanel, BoxLayout.Y_AXIS));
            for(ObjBibliotecario o:lista){
                String dados = o.print();
                labels.add(new JLabel (dados));
            }

            for (JLabel j:labels){
                printPanel.add(j);
            }

            frame.getContentPane().add(printPanel);
            frame.setVisible(true);
        }
        catch(Exception e){
            JDialog dialog = new JDialog(frame,"Erro");

            JLabel l = new JLabel("Algum erro inesperado aconteceu:\n" + e.toString());

            dialog.add(l);
            dialog.setSize(100,100);
            dialog.setVisible(true);
        }
    }
}
