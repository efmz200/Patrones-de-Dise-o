
import java.awt.*;
import java.util.ArrayList;


public class Personaje implements Constantes {
    public int vida;
    public int[] pos;
    public int pos_anterior [];
    public ArrayList<Enemigo> seguidores;
    public Color color;

    public Aliado aliados []; 
  
    public Personaje() {
        pos= new int[2];
        pos_anterior= new int[2];
        seguidores= new ArrayList<Enemigo>();
        pos[X] = TABLERO_SIZE / 2;
        pos[Y] = TABLERO_SIZE /2;
        pos_anterior[X] = TABLERO_SIZE / 2;
        pos_anterior[Y] = TABLERO_SIZE / 2;
        vida = 3;
        color = Ally_Color;

    }
}

    