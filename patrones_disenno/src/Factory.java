

public class Factory implements Constantes { 


    public Factory() {
    }

    public Entidades crearEntidad (String tipo) {

    switch(tipo)  {
        case "Aliado":
            Aliado aliado = new Aliado((int)(Math.random() * TABLERO_SIZE), (int)(Math.random() * TABLERO_SIZE));
            return aliado;
            
        case "Enemigo":
            Enemigo enemigo = new Enemigo((int)(Math.random() * TABLERO_SIZE), (int)(Math.random() * TABLERO_SIZE));
            return enemigo;
    }
    return null;
    } 
        
    public void crearAliado(int tipo) {

    }
}