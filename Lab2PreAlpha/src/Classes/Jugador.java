package Classes;

public class Jugador {
    String nombre;
    int velocidad;
    int remate;
    int posesion;

    public Jugador(String nombre, int velocidad, int remate, int posesion){
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.remate = remate;
        this.posesion = posesion;
    }

    public String getNombre(){
        return nombre;
    }
    public int getVelocidad(){
        return velocidad;
    }
    public int getRemate(){
        return remate;
    }
    public int getPosesion(){
        return posesion;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setVelocidad(int velocidad){
        this.velocidad = velocidad;
    }
    public void setRemate(int remate){
        this.remate = remate;
    }
    public void setPosesion(int posesion){
        this.posesion = posesion;
    }
}
