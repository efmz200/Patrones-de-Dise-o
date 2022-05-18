
import java.util.*;
import java.awt.*;
import javax.swing.*;



public class Factory implements Constantes { 


    public Factory(int posx, int posy) {
    }


    public void crearEntidad (String tipo) {

    switch(tipo)  {
        case "Aliado":
            Aliado aliado = new Aliado((int)(Math.random() * TABLERO_SIZE), (int)(Math.random() * TABLERO_SIZE));
            break;
        case "Enemigo":
            Enemigo enemigo = new Enemigo((int)(Math.random() * TABLERO_SIZE), (int)(Math.random() * TABLERO_SIZE));
            break;
    }
    } 
        
    public void crearAliado(int tipo) {

    }
}
