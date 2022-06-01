public class Aliado extends Entidades {
    public boolean mostrar;
    public Aliado(int pos_x, int pos_y) {
        super(pos_x, pos_y, Ally_Color, 1);
        mostrar = false;
    }
    public void mostrarme(Personaje jugador) {
        if(Math.abs(pos[X]-jugador.pos[X])<CERCANO && Math.abs(pos[Y]-jugador.pos[Y])<CERCANO){
            mostrar = true;
        }else{
            mostrar = false;
        }

    }
}