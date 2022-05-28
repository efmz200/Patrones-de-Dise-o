
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;
/**
 * 
 */
public class GUI extends JButton implements Constantes, ActionListener  {
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
        Personaje pj = tablero.jugador;
        
        mapa.tablero[pj.pos[X]][pj.pos[Y]].setAsTarget();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("next")){
            //dot.move();
            //moveDot();

        }
        else{
            //mapa.tablero[dot.target[X]][dot.target[Y]].clearTarget();
            //dot.target = ((Casilla)e.getSource()).getCoords();
            //((Casilla)e.getSource()).setAsTarget();
            //moveDot();
        }
        
    }
    
   




}