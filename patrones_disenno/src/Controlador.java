
public class Controlador {
    Tablero tablero;
    Factory creador;
    public Controlador(Tablero tablero) {
        this.tablero = tablero;
        creador = new Factory();
    }

    public void revisarTurnos() {
        if(tablero.turnos%6==0) {
            tablero.enemigos.add((Enemigo) creador.crearEntidad("Enemigo"));
        }
        if(tablero.turnos%10==0) {
            tablero.aliados.add((Aliado) creador.crearEntidad("Aliado"));
        }        
    }

    public void eliminarAliado(int pos) {
        tablero.aliados.remove(pos);    
    }
    public void eliminarEnemigo(int pos) {
        tablero.enemigos.remove(pos);
    }

    public void Add_Aliado () {
        tablero.aliados.add((Aliado) creador.crearEntidad("Aliado"));

    }

    public void Add_Enemigo () {
        tablero.enemigos.add((Enemigo) creador.crearEntidad("Enemigo"));
        
    }

}