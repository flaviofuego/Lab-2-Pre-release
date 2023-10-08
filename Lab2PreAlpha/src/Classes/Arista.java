package Classes;

public class Arista {
    Jugador jugador1;
    Jugador jugador2;
    String enfoque;
    Boolean paso;

    public Arista(Jugador jugador1, Jugador jugador2, String enfoque){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.enfoque = enfoque;
        this.paso = false;
    }
    public void cambiarenfoque(String enfoque){
        this.enfoque = enfoque;
    }

}
