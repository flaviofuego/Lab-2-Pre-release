package Classes;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Jugador {
    private String nombre;
    private ArrayList<Arista> aristas;
    private int velocidad;
    private int habilidad;
    private int posesion;
    private int ID;
    private Circulo circulo;
    private static int cd;

    public Jugador(String nombre, int velocidad, int remate, int posesion){
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.habilidad = remate;
        this.posesion = posesion;
        this.aristas = new ArrayList<>();
        circulo = null;
        this.ID = cd++;
    }
    
    public Circulo getCirculo() {
        return circulo;
    }
    
    public int getID() {
        return ID;
    }

    public String getNombre(){
        return nombre;
    }
    
    public int getVelocidad(){
        return velocidad;
    }
    
    public int getHabilidad(){
        return habilidad;
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
    
    public void setHabilidad(int habilidad){
        this.habilidad = habilidad;
    }
    
    public void setPosesion(int posesion){
        this.posesion = posesion;
    }
    
    public ArrayList<Arista> getArista() {
        return aristas;
    }
    
    public void agregar(Jugador destino){
        aristas.add(new Arista(this, destino));
        //destino.agregar(this., peso);
    } 
    
    public ArrayList<Jugador> getAdyacente() {
        ArrayList<Jugador> adyacente = new ArrayList<>();
        for (Arista arista: aristas){
            adyacente.add(arista.getJugador2());
        }
        return adyacente;
    }
    
    @Override
    public String toString() {
        return this.nombre + "{" +
            ",adyacentes="+ this.getAdyacente().stream().map(Jugador::getNombre).map(Object::toString).collect(Collectors.joining(", ")) +
            '}';
    }
}
