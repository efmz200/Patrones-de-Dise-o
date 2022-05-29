
import java.awt.Color;

/**
 * 
 */
public abstract class Entidades implements Constantes{
    public int pos[];
    public int pos_anterior[];
    public Color color;
    public int vida;
    public int objetivo[];
    
    
    public Entidades(int pos_x,int pos_y,Color enemyColor,int vida) {
        pos= new int[2];
        pos_anterior= new int[2];
        objetivo= new int[2];
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
        boolean mov=false;
        pos_anterior[X]=pos[X];
        pos_anterior[Y]=pos[Y];
        if(objetivo[X] != pos[X]){
            pos[X]+=(objetivo[X]-pos[X])/Math.abs(objetivo[X]-pos[X]);
            mov=true;
        }
        if(objetivo[Y] != pos[Y] && mov==false){
            pos[Y]+=(objetivo[Y]-pos[Y])/Math.abs(objetivo[Y]-pos[Y]);
        }            
    }

    public void actualizar(int new_x_target,int new_y_target){
        objetivo[X]=new_x_target;
        objetivo[Y]=new_y_target;
    }
}