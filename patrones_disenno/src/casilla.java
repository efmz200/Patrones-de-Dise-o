
import java.awt.Dimension;
import javax.swing.JButton;

public class Casilla extends JButton implements Constantes {
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

    public void setAsTarget(int vida) {
        setBackground(Player_Color);        
        setText(Integer.toString(vida));
        setForeground(Text_Color);
    }

    public void setAsDot() {
        setBackground(Enemy_Color);        
    }

    public void setAsAli(){
        setBackground(Ally_Color);
    }
    public void clearDot() {
        setBackground(BG_Color);
        setText("");
    }
}