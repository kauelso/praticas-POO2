import java.util.ArrayList;
import java.util.List;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.*;


public class ListaObjetosGUI {
    
    private JFrame frame = new JFrame("Objetos Bibliotecarios");

    private JPanel printPanel = new JPanel();

    private List<JLabel> labels = new ArrayList<>();

    public void printObj(List<ObjBibliotecario> lista){
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(300,300);

         try{
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
