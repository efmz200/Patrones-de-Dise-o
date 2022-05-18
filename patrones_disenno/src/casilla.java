
import java.util.*;
import java.awt.Dimension;
import javax.swing.JButton;

public class casilla implements Constantes {
    public int[] coordenadas;

    public casilla(int posx, int posy) {

            coordenadas = new int[2];
            coordenadas[X] = posx;
            coordenadas[Y] = posy;

            setBackground(BG_COLOR);
            setPreferredSize(new Dimension(CASILLA_WIDTH, CASILLA_HEIGHT));
    }


    public int[] getCoords() {
        return coordenadas;
    }

    public void setAsTarget() {
        setBackground(TARGET_COLOR);
    }

    public void clearTarget() {
        setBackground(BG_COLOR);
    }

    public void setAsDot() {
        setBackground(DOT_COLOR);
    }

    public void clearDot() {
        setBackground(BG_COLOR);
    }
}