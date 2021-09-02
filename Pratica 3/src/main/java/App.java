import entity.ObjBibliotecario;
import gui.LivrosGUI;
import jdk.jfr.Percentage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<ObjBibliotecario> objetos = new ArrayList<ObjBibliotecario>();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Livraria");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        LivrosGUI livrosGUI = new LivrosGUI(entityManager);

        livrosGUI.startGUI();
    }
}
