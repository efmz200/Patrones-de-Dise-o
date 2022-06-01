

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
        control = new Controlador(tablero);
        ventana.add(mapa.panelTablero);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setVisible(true);
        actualizarPlayer(); 
        generarEntidades();
        actualizarEnemies();
    }

    private void generarEntidades() {
        control.Add_Enemigo();
        control.Add_Enemigo();
        control.Add_Enemigo();
        control.Add_Aliado();
        control.Add_Aliado();
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        boolean mover= false;
        int ataque =-1;
        if (e.getKeyCode()==KeyEvent.VK_W){
            if(tablero.jugador.pos[Y]>0){
                control.movPlayer("W");
                mover= true;
            }
            
        }
        if (e.getKeyCode()==KeyEvent.VK_A){
            if(tablero.jugador.pos[X]>0){
                control.movPlayer("A");
                mover= true;
            }
        } 
        if (e.getKeyCode()==KeyEvent.VK_S){
            if(tablero.jugador.pos[Y]<TABLERO_SIZE-1){
                control.movPlayer("S");   
                mover= true;         
            }
            
        }            
        if (e.getKeyCode()==KeyEvent.VK_D){ 
            if(tablero.jugador.pos[X]<TABLERO_SIZE-1){
                control.movPlayer("D");                
                mover= true;
            }           
        }
        if (e.getKeyCode()==KeyEvent.VK_UP){
            ataque=control.tablero.jugador.atacar("Up");
        } 
        if (e.getKeyCode()==KeyEvent.VK_DOWN){
            ataque=control.tablero.jugador.atacar("Dw");
            } 
        if (e.getKeyCode()==KeyEvent.VK_LEFT){
            ataque=control.tablero.jugador.atacar("L");
        } 
        if (e.getKeyCode()==KeyEvent.VK_RIGHT){
            ataque=control.tablero.jugador.atacar("R");
        } 
        if (e.getKeyCode()==KeyEvent.VK_SPACE){
            control.addTurno();  
            control.moverEnemigos();          
            actualizarEnemies();                       
            actualizarPlayer();
        } 
        if (ataque>-1){
            Enemigo enemigo = tablero.enemigos.get(ataque);
            mapa.tablero[enemigo.pos[Y]][enemigo.pos[X]].clearDot();
            control.eliminarEnemigo(ataque);
        }
        if (mover){
            control.addTurno();
            actualizarAliados(); 
            actualizarEnemies();            
            actualizarPlayer();
        }
        
    }
    
    public void actualizarEnemies(){
        for (int i=0; i<tablero.enemigos.size(); i++){
            Enemigo enemy = tablero.enemigos.get(i);
            mapa.tablero[enemy.pos_anterior[Y]][enemy.pos_anterior[X]].clearDot();
            mapa.tablero[enemy.pos[Y]][enemy.pos[X]].setAsDot(); 
        }
    }
    public void actualizarPlayer(){
        Personaje pj = tablero.jugador;
        mapa.tablero[pj.pos_anterior[Y]][pj.pos_anterior[X]].clearDot();
        mapa.tablero[pj.pos[Y]][pj.pos[X]].setAsTarget();     
    }
    public void actualizarAliados(){
        System.out.println("aliados");
        for (int i=0; i<tablero.aliados.size(); i++){
            Aliado al = tablero.aliados.get(i);
            System.out.println("otro");
            System.out.println(al.pos[X]); 
            System.out.println(al.pos[Y]);
            System.out.println(al.mostrar);             
            if(al.mostrar){
                mapa.tablero[al.pos[Y]][al.pos[X]].setAsAli(); 
                continue;   
            }else{
                mapa.tablero[al.pos[Y]][al.pos[X]].clearDot();    
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}