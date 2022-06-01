
public class Controlador implements Constantes {
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

    public void addTurno(){
        tablero.turnos++;
        revisarTurnos();
    }
    public void eliminarAliado(int pos) {
        tablero.jugador.vida++;
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
        tablero.jugador.seguidores=tablero.enemigos;        
    }

    public void moverEnemigos(){
        for (int i=0; i<tablero.enemigos.size(); i++){
            tablero.enemigos.get(i).mover();                
        }    
    }
    public void Actualizar_enemigo () {
        Personaje jugador = tablero.jugador;
        for(int i = 0; i < tablero.jugador.seguidores.size(); i++) {
            tablero.jugador.seguidores.get(i).objetivo[X] = jugador.pos[X];
            tablero.jugador.seguidores.get(i).objetivo[Y] = jugador.pos[Y];
            tablero.jugador.seguidores.get(i).mover();
        }
    }

    public void movPlayer(String dir){
        tablero.jugador.mover(dir);
    }
}