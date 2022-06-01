
import java.awt.*;
import java.util.ArrayList;


public class Personaje implements Constantes {
    public int vida;
    public int[] pos;
    public int pos_anterior [];
    public ArrayList<Enemigo> seguidores;
    public ArrayList<Aliado> aliados;
    public Color color;
 
  
    public Personaje(ArrayList<Enemigo> enemigos,ArrayList<Aliado> aliados) {
        pos= new int[2];
        pos_anterior= new int[2];
        seguidores= enemigos;
        this.aliados= aliados;
        pos[X] = TABLERO_SIZE / 2;
        pos[Y] = TABLERO_SIZE /2;
        pos_anterior[X] = TABLERO_SIZE / 2;
        pos_anterior[Y] = TABLERO_SIZE / 2;
        vida = 3;
        color = Ally_Color;

    }
    public void mover(String dir) {
        pos_anterior[X]=pos[X];
        pos_anterior[Y]=pos[Y];
        System.out.println(dir);
        switch(dir){
            case "W":
                pos[Y] -=1;
                break;
            case "A":
                pos[X] -=1;
                break;
            case "S":
                pos[Y]+=1;
                break;
            case "D":
                pos[X]+=1;
                break;
        }
        for (int i=0; i<seguidores.size(); i++){
            seguidores.get(i).objetivo[X]=pos[X];
            seguidores.get(i).objetivo[Y]=pos[Y];
            seguidores.get(i).mover();
            System.out.println(i);
        }
        for (int i=0; i<aliados.size(); i++){
            aliados.get(i).mostrarme(this);
            System.out.println(aliados.get(i).mostrar);
        }

    }
    public int atacar(String dir){
        int ataque[]= new int[2];
        ataque[X]=pos[X];
        ataque[Y]=pos[Y];
        switch(dir){
            case "Up":         
                ataque[Y] -=1;
                break;
            case "L":
                ataque[X] -=1;
                break;
            case "Dw":
                ataque[Y]+=1;
                break;
            case "R":
                ataque[X]+=1;                
                break;
        }
        for (int i=0; i<seguidores.size(); i++){
            if(seguidores.get(i).pos[X]==ataque[X] && seguidores.get(i).pos[Y]==ataque[Y]){
                return i;
            }
        }
        return -1;
    }
}

    