public class Controlador implements Constantes {
    Tablero tablero;
    Factory creador;
    public Controlador(Tablero tablero) {
        this.tablero = tablero;
        creador = new Factory();
    }

    public void revisarTurnos() {
        if(tablero.turnos%6==0) {
           Add_Enemigo();
        }
        if(tablero.turnos%10==0) {
            Add_Aliado();
        }        
    }

    public void addTurno(){
        tablero.turnos++;
        revisarColisiones();
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
        int pj_pos[] = tablero.jugador.pos;  
        if (tablero.aliados.size()<5)   
            tablero.aliados.add((Aliado) creador.crearEntidad("Aliado",pj_pos[X],pj_pos[Y]));

    }

    public void Add_Enemigo () {
        int pj_pos[] = tablero.jugador.pos;
        tablero.enemigos.add((Enemigo) creador.crearEntidad("Enemigo",pj_pos[X],pj_pos[Y]));
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
    public void revisarColisiones(){
        Personaje pj = tablero.jugador;
        for(int i=0; i< tablero.enemigos.size(); i++){
            Enemigo enemy= pj.seguidores.get(i);
            if(pj.pos[X]==enemy.pos[X]&& pj.pos[Y]==enemy.pos[Y]){
                pj.vida--;
                tablero.enemigos.remove(i);
            }
        }
        for (int i=0; i< pj.aliados.size();i++){
            Aliado al =tablero.aliados.get(i);
            if(pj.pos[X]==al.pos[X]&& pj.pos[Y]==al.pos[Y]){
                if(pj.vida<5)
                    pj.vida++;
                tablero.aliados.remove(i);
            }
        }
    }
    public boolean muerto(){
        if(tablero.jugador.vida==0){
            return true;
        }else{
            return false;
        }
    }
    public void movPlayer(String dir){
        tablero.jugador.mover(dir);
    }
}