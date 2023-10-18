package grafosCodigoPatito;

public class Arista {
    private int peso = 0;
    private Vertice origen;
    private Vertice destino;

    public Arista(Vertice origen, Vertice destino) {
        this.origen = origen;
        this.destino = destino;
        this.peso = 0;
    }

    public Vertice getOrigen() {
        return origen;
    }

    public Vertice getDestino() {
        return destino;
    }
}
