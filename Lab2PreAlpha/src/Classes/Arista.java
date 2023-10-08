package Classes;

public class Arista {
    private Jugador jugador1;
    private Jugador jugador2;
    private String enfoque;
    private int peso;
    private Boolean paso;

    public Arista(Jugador jugador1, Jugador jugador2, String enfoque){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.enfoque = enfoque;
        this.paso = false;
    }
    
    public Arista(Jugador jugador1, Jugador jugador2){
        this.jugador1 = jugador1; // inicio
        this.jugador2 = jugador2; // destino
        this.enfoque = ""; // en que se esta enfocando (velocidad, posesion, habilidad)
        this.paso = false; // si ya se paso por hay
    }
    
    public void setEnfoque(String enfoque){
        this.enfoque = enfoque;
        if (enfoque.equalsIgnoreCase("velocidad")){
            peso = jugador1.getVelocidad();
        } else if (enfoque.equalsIgnoreCase("habilidad")){
            peso = jugador1.getHabilidad();
        } else if (enfoque.equalsIgnoreCase("posesion")){
            peso = jugador1.getPosesion();
        }  
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public String getEnfoque() {
        return enfoque;
    }

    public Boolean getPaso() {
        return paso;
    }

    public void setPaso(Boolean paso) {
        this.paso = paso;
    }
}
