

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
            control.tablero.jugador.atacar("Up");
        } 
        if (e.getKeyCode()==KeyEvent.VK_DOWN){
            control.tablero.jugador.atacar("Dw");
            } 
        if (e.getKeyCode()==KeyEvent.VK_LEFT){
            control.tablero.jugador.atacar("L");
        } 
        if (e.getKeyCode()==KeyEvent.VK_RIGHT){
            control.tablero.jugador.atacar("R");
        } 
        if (e.getKeyCode()==KeyEvent.VK_SPACE){
            control.addTurno();  
            if(control.muerto()){
                JOptionPane.showMessageDialog(this,"Has perdido");
                System.exit(0);   
            }
            control.moverEnemigos();
            limpiarMapa(); 
            actualizarAliados();         
            actualizarEnemies();                       
            actualizarPlayer();
        } 
        
        if (mover){
            control.addTurno();
            if(control.muerto()){
                JOptionPane.showMessageDialog(this,"Has perdido");
                System.exit(0);   
            }
            limpiarMapa();
            actualizarAliados(); 
            actualizarEnemies();            
            actualizarPlayer();
        }else if (!mover){
            limpiarMapa();
            actualizarAliados(); 
            actualizarEnemies();            
            actualizarPlayer();     
        }
        
    }
    public void limpiarMapa(){
        for (int i=0; i<TABLERO_SIZE; i++){
            for(int j=0;j<TABLERO_SIZE;j++){
                mapa.tablero[i][j].clearDot();
            }
        }
    }
    public void actualizarEnemies(){
        for (int i=0; i<tablero.enemigos.size(); i++){
            Enemigo enemy = tablero.enemigos.get(i);
            mapa.tablero[enemy.pos[Y]][enemy.pos[X]].setAsDot(); 
        }
    }
    public void actualizarPlayer(){
        Personaje pj = tablero.jugador;
        mapa.tablero[pj.pos[Y]][pj.pos[X]].setAsTarget(tablero.jugador.vida);     
    }
    public void actualizarAliados(){
        for (int i=0; i<tablero.aliados.size(); i++){
            Aliado al = tablero.aliados.get(i);                       
            if(al.mostrar){
                mapa.tablero[al.pos[Y]][al.pos[X]].setAsAli(); 
                continue;   
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}