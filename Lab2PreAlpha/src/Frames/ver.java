package Frames;

import Classes.Arista;
import Classes.Campo;
import Classes.Jugador;
import java.util.ArrayList;
import Classes.Circulo;
import Classes.Coordenadas;
import Classes.LineaQuebrada;

public class ver extends javax.swing.JPanel {

    private Campo campo;
    private final int[][] pos = {{1, 4, 4, 3}, {50, 150}, {130, 20}, {170, 20}, {250, 20}};

    public ver() {
        initComponents();
        dibujarNodos();
        dibujarAristas();
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    private void crearNodo(int x, int y, Jugador jugador) {
        Coordenadas c = new Coordenadas(100000, 100000, x, y);
        String dato = jugador.getNombre();
        Circulo circulo = new Circulo(c);
        circulo.setDiametro(12);
        circulo.setEtiqueta(dato + "");
        circulo.dibujarCirculo(this.getGraphics());
    }

    public void dibujarNodos() {
        ArrayList<Jugador> listaNodo = campo.getJugadores();
        int posision = 0;
        int nivel = 1;
        for (Jugador nodo : listaNodo) {
            if (posision < pos[0][nivel - 1]) {
                if (posision != 0) {
                    crearNodo(pos[nivel][0], pos[nivel][1] * posision, nodo);
                } else {
                    crearNodo(pos[nivel][0], pos[nivel][1], nodo);
                }
                posision++;
            } else {
                posision = 0;
                nivel++;
            }
        }
    }

    private LineaQuebrada crearArista(Arista arista) {
        Coordenadas c = new Coordenadas(100000, 100000);
        Jugador nodoInicio = arista.getJugador1();
        Jugador nodoFin = arista.getJugador2();
        c.addCoordenada(nodoInicio.getCirculo().getX() + (nodoInicio.getCirculo().getDiametro() / 2), nodoInicio.getCirculo().getY() + (nodoInicio.getCirculo().getDiametro() / 2));
        c.addCoordenada(nodoFin.getCirculo().getX() + (nodoInicio.getCirculo().getDiametro() / 2), nodoFin.getCirculo().getY() + (nodoInicio.getCirculo().getDiametro() / 2));
        LineaQuebrada lq = new LineaQuebrada(c);
        lq.setLongitud(arista.getPeso());
        return lq;
    }

    public void dibujarAristas() {
        ArrayList<Arista> listaEnlace = campo.getAristas();
        if (listaEnlace != null) {
            for (Arista arista : listaEnlace) {
                crearArista(arista).dibujarLineaQuebrada(this.getGraphics());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(687, 304));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 687, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 304, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}