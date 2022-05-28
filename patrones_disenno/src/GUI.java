
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;
/**
 * 
 */
public class GUI extends JButton implements Constantes, KeyListener  {
    JFrame ventana;
    Mapa mapa;
    Tablero tablero;
    Personaje jugador;
    Entidades enemigos[];
    Entidades aliados[]; 
    int turnos;
    Controlador control;


    public GUI () {
        ventana = new JFrame();
        mapa = new Mapa(this); 
        tablero = new Tablero();
        Controlador control = new Controlador(tablero);
        ventana.add(mapa.panelTablero);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
        actualizarPlayer(); 
        generarEnemigosIniciales();   

    }

    private void generarEnemigosIniciales() {
        control.Add_Enemigo();
        control.Add_Enemigo();
        control.Add_Enemigo();
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        boolean mover= false;
        if (e.getKeyCode()==KeyEvent.VK_W){
            if(tablero.jugador.pos[Y]>0){
                tablero.jugador.pos_anterior[X]=tablero.jugador.pos[X];
                tablero.jugador.pos_anterior[Y]=tablero.jugador.pos[Y];
                tablero.jugador.pos[Y] -=1;
                mover= true;
            }
            
        }
        if (e.getKeyCode()==KeyEvent.VK_A){
            if(tablero.jugador.pos[X]>0){
                tablero.jugador.pos_anterior[X]=tablero.jugador.pos[X];
                tablero.jugador.pos_anterior[Y]=tablero.jugador.pos[Y];
                tablero.jugador.pos[X] -=1;
                mover= true;
            }
        } 
        if (e.getKeyCode()==KeyEvent.VK_S){
            if(tablero.jugador.pos[Y]<TABLERO_SIZE-1){
                tablero.jugador.pos_anterior[X]=tablero.jugador.pos[X];
                tablero.jugador.pos_anterior[Y]=tablero.jugador.pos[Y];
                tablero.jugador.pos[Y]+=1;   
                mover= true;         
            }
            
        }            
        if (e.getKeyCode()==KeyEvent.VK_D){ 
            if(tablero.jugador.pos[X]<TABLERO_SIZE-1){
                tablero.jugador.pos_anterior[X]=tablero.jugador.pos[X];
                tablero.jugador.pos_anterior[Y]=tablero.jugador.pos[Y];
                tablero.jugador.pos[X]+=1;
                mover= true;
            }           
        }
        if (e.getKeyCode()==KeyEvent.VK_SPACE){
            System.out.println("dispara");
        } 
        if (mover){
            
        }
        actualizarPlayer();
    }
    public void actualizarEnemies(){
        for (int i=0; i<tablero.enemigos.size(); i++){
            Enemigo enemy = tablero.enemigos.get(i);
            mapa.tablero[enemy.pos_anterior[Y]][enemy.pos_anterior[X]].clearDot();
            mapa.tablero[enemy.pos[Y]][enemy.pos[X]].setAsTarget(); 
        }
    }
    public void actualizarPlayer(){
        Personaje pj = tablero.jugador;
        mapa.tablero[pj.pos_anterior[Y]][pj.pos_anterior[X]].clearDot();
        mapa.tablero[pj.pos[Y]][pj.pos[X]].setAsTarget();     
    }
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}