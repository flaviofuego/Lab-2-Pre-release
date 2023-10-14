package Classes;

import java.util.ArrayList;
import java.util.List;

// grafo no dirigido (el enfoque significa el peso para ir hacia el otro jugador)
public class Campo {
    private static final long INFI = Integer.MAX_VALUE;

    private ArrayList<Jugador> jugadores;
    private ArrayList<Integer> rutaOptima; // lista con las posisiones de los jugadores en el camino optimo
    private int balonPosicion;             // posision actual del balon (posicion de un jugador que tiene el balon)
    private int[][] matrizAdyacencia;

    public Campo() {
        jugadores = new ArrayList<Jugador>();
        rutaOptima = new ArrayList<Integer>();
        balonPosicion = 0;
        //matrizAdyacencia = new int[10][10];
        //relaciones = new ArrayList<Arista>();
    }

    public void addJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void addRelacion(Jugador j1, Jugador j2) {
        j1.agregar(j2);
    }

    public void setBalonposicion(int balonPosicion) {
        this.balonPosicion = balonPosicion;
    }

    public void setEnfoque(String enfoque) {
        for (Jugador jugador : jugadores) {
            for (Arista arista : jugador.getArista()) {
                arista.setEnfoque(enfoque);
            }
        }
    }

    public void setMatrizAdyacencia(int[][] matrizAdyacencia) { // recibe toda una matriz de adyacencia para crear todas las relaciones de los jugadores
        this.matrizAdyacencia = matrizAdyacencia;
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            for (int j = 0; j < matrizAdyacencia[i].length; j++) {
                if (matrizAdyacencia[i][j] == 1) {
                    this.addRelacion(jugadores.get(j), jugadores.get(i));
                }
            }
        }
    }

    public void mostrarMatrizA() {
        System.out.println("matriz de adyacencia");
        for (int i = 0; i < jugadores.size(); i++) {
            for (int j = 0; j < jugadores.size(); j++) {
                System.out.print(matrizAdyacencia[i][j]);
            }
            System.out.println("");
        }
    }

    public List<Integer> dijkstra(int inicio, int fin) {
        List<Edge> new_aristas = new ArrayList<>();
        for (Jugador jugador: jugadores){
            for (Arista arista: jugador.getArista()){
                new_aristas.add(new Edge(arista.getJugador1().getID(),arista.getJugador2().getID(), arista.getPeso()));
            }
        }
        Graph graph = new Graph(new_aristas, jugadores.size());
        return Dijkstra.findShortestPaths(graph, inicio, jugadores.size(), fin);
    }

    public ArrayList<Jugador> bellmand_ford() {
        return jugadores;
    }

    public long[][] getRecorrido() {
        long[][] matriz = new long[matrizAdyacencia.length][matrizAdyacencia.length];
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            for (int j = 0; j < matrizAdyacencia.length; j++) {
                if (matrizAdyacencia[i][j] != 0) {
                    for(Arista arista: jugadores.get(i).getArista()){
                        if (jugadores.get(j).getID() == arista.getJugador2().getID()){
                            matriz[i][j] = arista.getPeso();
                        }
                    }
                } else {
                    matriz[i][j] = INFI;
                }
            }
        }
        return matriz;
    }
}
