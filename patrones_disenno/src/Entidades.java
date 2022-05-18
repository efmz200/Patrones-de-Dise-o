
import java.awt.Color;
import java.util.*;

/**
 * 
 */
public class Entidades implements Constantes{
    public int pos[];
    public int pos_anterior[];
    public Color color;
    public int vida;
    public int objetivo[];
    
    
    public Entidades(int pos_x,int pos_y,Color enemyColor,int vida) {
        pos[X]=pos_x;
        pos[Y]=pos_y;
        pos_anterior[X]=pos_x;
        pos_anterior[Y]=pos_y;
        this.color=enemyColor;
        this.vida=vida;
        objetivo[X]=0;
        objetivo[Y]=0; 
    }

    public void mover(){

    }
}