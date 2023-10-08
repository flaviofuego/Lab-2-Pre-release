package Classes;


import java.util.ArrayList;

public class Campo {
    ArrayList<Jugador> jugadores;
    ArrayList<Integer> rutas;
    int balonposicion;
    int [][] matrizadyacencia;
    ArrayList<Arista> relaciones;

    public Campo(){
        jugadores = new ArrayList<Jugador>();
        rutas = new ArrayList<Integer>();
        balonposicion = 0;
        matrizadyacencia = new int[11][11];
        relaciones = new ArrayList<Arista>();
    }

    public void addJugador(Jugador jugador){
        jugadores.add(jugador);
    }

    public void addRuta(int ruta){
        rutas.add(ruta);
    }
    public void addRelacion(Arista relacion){
        relaciones.add(relacion);
    }
    public void setBalonposicion(int balonposicion){
        this.balonposicion = balonposicion;
    }

    public void seleccionenfoque(String enfoque){
        if (enfoque.equals("velocidad")){
            for (int i = 0; i < jugadores.size(); i++){
                jugadores.get(i).setVelocidad(jugadores.get(i).getVelocidad() + 10);
            }
        }
        if (enfoque.equals("posesion")){
            for (int i = 0; i < jugadores.size(); i++){
                jugadores.get(i).setPosesion(jugadores.get(i).getPosesion() + 10);
            }
        }
        if (enfoque.equals("remate")){
            for (int i = 0; i < jugadores.size(); i++){
                jugadores.get(i).setRemate(jugadores.get(i).getRemate() + 10);
            }
        }
    }

    public String rutaoptima(){
        return "Ruta óptima: " + rutas.toString();
    }
    public ArrayList<Jugador> dykstra(){
        return jugadores;
    }
    public ArrayList<Jugador> bellmand_ford(){
        return jugadores;
    }

}
