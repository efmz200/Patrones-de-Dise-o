
import java.awt.Dimension;
import java.util.*;
import javax.swing.JButton;
/**
 * 
 */
public class GUI extends JButton implements Constantes  {

    public Tablero mapa;

    public GUI() {
        mapa = new Tablero();
        setBackground(BG_Color);
        setPreferredSize(new Dimension(Casilla_Width, Casilla_Height));
        

    }

   




}