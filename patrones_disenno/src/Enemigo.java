public class Enemigo extends Entidades {
    boolean destruir;
    public Enemigo(int pos_x, int pos_y,int objetivo_x,int objetivo_y ) {
        super(pos_x, pos_y, Enemy_Color, -1);
        objetivo[X] = objetivo_x;
        objetivo[Y] = objetivo_y;
        destruir = false;
    }

    

    

}