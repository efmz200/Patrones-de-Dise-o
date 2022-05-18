
import java.util.*;
import java.awt.Dimension;
import javax.swing.JButton;

public class Casilla implements Constantes {
    public int[] coordenadas;

    public Casilla(int posx, int posy) {

            coordenadas = new int[2];
            coordenadas[X] = posx;
            coordenadas[Y] = posy;

            setBackground(BG_Color);
            setPreferredSize(new Dimension(Casilla_Width, Casilla_Height));
    }


    public int[] getCoords() {
        return coordenadas;
    }

    public void setAsTarget() {
        setBackground(Enemy_Color);
    }

    public void clearTarget() {
        setBackground(BG_Color);
    }

    public void setAsDot() {
        setBackground(Player_Color);
    }

    public void clearDot() {
        setBackground(BG_Color);
    }
}