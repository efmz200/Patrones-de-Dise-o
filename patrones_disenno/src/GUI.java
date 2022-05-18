
import java.util.*;
import javax.swing.JButton;
/**
 * 
 */
public class GUI extends JButton implements Constantes  {

    public Tablero mapa;

    public GUI() {
        mapa = new Tablero();
        setBackground(BG_COLOR);
        setPreferredSize(new Dimension(CASILLA_WIDTH, CASILLA_HEIGHT));
        

    }

   




}