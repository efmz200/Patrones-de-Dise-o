
import java.util.*;

/**
 * 
 */
public class Tablero {

    public int turnos;
    public Personaje jugador;
    public ArrayList<Enemigo> enemigos;
    public ArrayList<Aliado> aliados;
    public Controlador control;
    
    public Tablero() {
        turnos = 0;
        enemigos = new ArrayList<Enemigo>() ; 
        aliados = new ArrayList<Aliado>(); 
        jugador = new Personaje(); 
    }
}