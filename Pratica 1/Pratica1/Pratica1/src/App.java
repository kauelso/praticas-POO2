import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<ObjBibliotecario> objetos = new ArrayList<ObjBibliotecario>();
        
        LivrosGUI livrosGUI = new LivrosGUI(objetos);

        livrosGUI.startGUI();
    }
}
