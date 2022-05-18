
import java.awt.Color;
import java.util.*;


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
        if(objetivo[X] != pos[X]){
            pos[X]+=(objetivo[X]-pos[X])/Math.abs(objetivo[X]-pos[X]);
        }
        if(objetivo[Y] != pos[Y]){
            pos[Y]+=(objetivo[Y]-pos[Y])/Math.abs(objetivo[Y]-pos[Y]);
        }            
    }

    public void actualizar(int new_x_target,int new_y_target){
        objetivo[X]=new_x_target;
        objetivo[Y]=new_y_target;

    }
}