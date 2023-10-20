package Frames;

import Classes.Campo;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import Classes.Arista;
import Classes.Jugador;
import java.util.ArrayList;

public class ver extends javax.swing.JPanel {

    private Campo campo;
    private final int[][] pos = { { 50, 150 }, { 130 * 2, 20 }, { 170 * 2, 20 }, { 250 * 2, 20 } };

    public ver() {
        initComponents();
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    protected void dibuja_camino(Graphics g, ArrayList<Integer> lista) {
        ArrayList<Arista> aristas = new ArrayList();
        for (int i = 0; i < lista.size(); i++) {
            for (Arista arista : campo.getJugadores().get(i).getArista()) {
                if (arista.getJugador2().getNombre().equalsIgnoreCase(campo.getJugadores().get(i + 1).getNombre())) {
                    aristas.add(arista);
                }
            }
        }

        for (Arista arista : aristas) {
            g.setColor(Color.RED);

            Jugador nodo1 = arista.getJugador1();
            Jugador nodo2 = arista.getJugador2();

            // g.drawLine(nodo1.x, nodo1.y, nodo2.x/2+ 50, nodo2.y/2 + 50);
            // g.drawLine(nodo2.x/2+ 50, nodo2.y/2 + 50, nodo2.x/2+ 50, nodo2.y/2 + 50);
            g.drawLine(nodo1.x, nodo1.y, nodo2.x, nodo2.y);

            // Dibuja el valor de la arista
            g.setColor(Color.RED);
            int valorX = (nodo1.x + nodo2.x) / 2;
            int valorY = (nodo1.y + nodo2.y) / 2;
            g.drawString(String.valueOf(arista.getPeso()), valorX, valorY);
        }
    }
    public Arista buscarArista(int x1, int y1, int x2, int y2){
            for(Arista arista : campo.getAristas()){
                if(arista.getJugador1().x == x1 && arista.getJugador1().y == y1 && arista.getJugador2().x == x2 && arista.getJugador2().y == y2){
                    return arista;
                }
            }
            return null;
        }
    protected void dibuja(Graphics g) {
        super.paintComponent(g);
        int[] posisiones = { 1, 4, 4, 3 };
        int cantidad = 1;
        int nivel = 0;
        int iterador = 1;

        for (Jugador nodo : campo.getJugadores()) {
            /*
             * if (cantidad < posisiones[nivel]) {
             * if (cantidad == 0) {
             * nodo.x = pos[nivel][0];
             * nodo.y = pos[nivel][1];
             * } else {
             * nodo.x = pos[nivel][0] * 2;
             * nodo.y = pos[nivel][1] * cantidad * 6;
             * }
             * cantidad++;
             * } else {
             * nivel++;
             * nodo.x = pos[nivel][0];
             * nodo.y = pos[nivel][1] * iterador;
             * iterador++;
             * cantidad = 1;
             * }
             */
            //Jugador1
                /*X:10 Y:300
                Jugador2
                X:100 Y:150
                Jugador3
                X:122 Y:250
                Jugador4
                X:122 Y:350
                Jugador5
                X:100 Y:450
                Jugador6
                X:350 Y:200
                Jugador7
                X:350 Y:300
                Jugador8
                X:350 Y:400
                Jugador9
                X:600 Y:175
                Jugador10
                X:600 Y:300
                Jugador11
                X:600 Y:425*/
             if(iterador == 1){
                 nodo.x = 60;
                 nodo.y = 300;
                }else if(iterador == 2){
                    nodo.x = 300;
                    nodo.y = 150;
                }else if(iterador == 3){
                    nodo.x = 450;
                    nodo.y = 250;
                }else if(iterador == 4){
                    nodo.x = 450;
                    nodo.y = 350;
                }else if(iterador == 5){
                    nodo.x = 300;
                    nodo.y = 450;
                }else if(iterador == 6){
                    nodo.x = 650;
                    nodo.y = 200;
                }else if(iterador == 7){
                    nodo.x = 650;
                    nodo.y = 300;
                }else if(iterador == 8){
                    nodo.x = 650;
                    nodo.y = 400;
                }else if(iterador == 9){
                    nodo.x = 950;
                    nodo.y = 175;
                }else if(iterador == 10){
                    nodo.x = 950;
                    nodo.y = 300;
                }else if(iterador == 11){
                    nodo.x = 950;
                    nodo.y = 425;
                }
             iterador++;
            System.out.println(nodo.x + ", " + nodo.y);
        }
        //crea una funcion buscar arista por coordenadas
        

        ArrayList<Arista> aristaauxiliar = new ArrayList();

        for (Arista arista : campo.getAristas()) {
            g.setColor(Color.BLACK);
            Jugador nodo1 = arista.getJugador1();
            Jugador nodo2 = arista.getJugador2();
            int x = nodo1.x;
            int y = nodo1.y;
            int w = nodo2.x;
            int z = nodo2.y;

            //comprobar que la arista no esta en la lista auxiliar
            if (!aristaauxiliar.contains(buscarArista(w, z, x, y))) {
                aristaauxiliar.add(buscarArista(x, y,w, z));
            }

        }
        int couuunter = 1;
        for (Arista arista : aristaauxiliar) {
            g.setColor(Color.BLACK);

            Jugador nodo1 = arista.getJugador1();
            Jugador nodo2 = arista.getJugador2();
            int x = nodo1.x;
            int y = nodo1.y;
            int w = nodo2.x;
            int z = nodo2.y;
            /*System.out.println("Arista:1");
            System.out.println("x:" + x + " y:" + y);
            System.out.println("w:" + w + " z:" + z);
            System.out.println("arista:" + 2);
            System.out.println("x:" + buscarArista(w, z,x, y).getJugador1().x + " y:" + buscarArista(w, z,x, y).getJugador1().y);
            System.out.println("w:" + buscarArista(w, z,x, y).getJugador2().x + " z:" + buscarArista(w, z,x, y).getJugador2().y);*/
            if (x == w && y == z) {
                System.out.println("ARISTA:" + couuunter);
                g.drawArc(x + 10, y + 5, 20, 30, 320, 290);
                x = x + 15;
                y = y + 20;
                couuunter++;
            } else {
                if (x==w) {

                    g.setColor(Color.BLACK);
                    System.out.println("ARISTA:" + couuunter);
                    g.drawLine(x, y, ((x - w) / 2) + w-10, ((y - z) / 2) + z - 10);
                    g.drawLine(((x - w) / 2) + w-10, ((y - z) / 2) + z - 10, w, z);
                    g.setColor(Color.decode("#3BCE1E"));
                    g.drawString(String.valueOf(arista.getPeso()), ((x - w) / 2) + w-25, ((y - z) / 2) + z - 20);
                    int x2 = w;
                    int y2 = z;
                    g.setColor(Color.BLACK);

                    g.drawLine(x2, y2, ((x2 - x) / 2) + x+10, ((y2 - y) / 2) + y + 10);
                    g.drawLine(((x2 - x) / 2) + x+10, ((y2 - y) / 2) + y + 10, x, y);

                    g.setColor(Color.decode("#C256FC"));
                    g.drawString(String.valueOf(buscarArista(w, z, x, y).getPeso()), ((x2 - x) / 2) + x+15, ((y2 - y) / 2) + y + 20);


                    // h.drawLine(x + 18 + 20, y + 20 + 45, w + 20 + 18, z + 45 + 20);
                    couuunter++;
                } else {

                g.setColor(Color.BLACK);
                System.out.println("ARISTA:" + couuunter);
                g.drawLine(x, y, ((x - w) / 2) + w, ((y - z) / 2) + z - 10);
                g.drawLine(((x - w) / 2) + w, ((y - z) / 2) + z - 10, w, z);
                g.setColor(Color.decode("#3BCE1E"));
                g.drawString(String.valueOf(arista.getPeso()), ((x - w) / 2) + w, ((y - z) / 2) + z - 20);
                int x2 = w;
                int y2 = z;
                g.setColor(Color.BLACK);
                g.drawLine(x2, y2, ((x2 - x) / 2) + x, ((y2 - y) / 2) + y + 10);
                g.drawLine(((x2 - x) / 2) + x, ((y2 - y) / 2) + y + 10, x, y);

                    g.setColor(Color.decode("#C256FC"));
                g.drawString(String.valueOf(buscarArista(w, z, x, y).getPeso()), ((x2 - x) / 2) + x, ((y2 - y) / 2) + y + 20);


                // h.drawLine(x + 18 + 20, y + 20 + 45, w + 20 + 18, z + 45 + 20);
                couuunter++;
            }
            }

        }
        // Dibuja las aristas y sus valores
        /*for (Arista arista : campo.getAristas()) {
            g.setColor(Color.BLACK);

            Jugador nodo1 = arista.getJugador1();
            Jugador nodo2 = arista.getJugador2();


            int x = nodo1.x;
            int y = nodo1.y;
            int w = nodo2.x;
            int z = nodo2.y;

            int x1 = x;
            int y1 = y;
            int e = 0, f = 0;
            g.setColor(Color.BLACK);
            if (x == w && y == z) {
                g.drawArc(x + 10, y + 5, 20, 30, 320, 290);
                x = x + 15;
                y = y + 20;
            } else {
                e = x;
                f = y;
                //System.out.println("Jugador1:" + nodo1.getNombre());
                //System.out.println("Jugador2:" + nodo2.getNombre());
                //System.out.println("Valor peso:" + arista.getPeso());
                // comprobar que 2 vertices no posean una arista
                for (int i = 0; i < campo.getAristas().size(); i++) {
                    if (campo.getAristas().get(i).getJugador1().x == w && campo.getAristas().get(i).getJugador1().y == z
                            && campo.getAristas().get(i).getJugador2().x == x
                            && campo.getAristas().get(i).getJugador2().y == y) {
                        e = 1;
                    }

                }
                System.out.println("e:" + e);
                if (e == 1) {
                    System.out.println(" entro a 1");
                    g.drawLine(x, y, ((x - w) / 2) + w, ((y - z) / 2) + z - 10);
                    g.drawLine(((x + 20 - w) / 2) + w, ((y + 45 - z) / 2) + z - 10, w, z);
                    int x2 = ((x + 20 - w) / 2) + w;
                    int y2 = ((y + 45 - z + 45) / 2) + z - 10;
                    g.setColor(Color.decode("#3BCE1E"));
                    g.drawString(String.valueOf(arista.getPeso()), x2, y2 - 40);
               

                // h.drawLine(x + 18 + 20, y + 20 + 45, w + 20 + 18, z + 45 + 20);

            }}

            System.out.println("x:" + x1 + " y:" + y1);
            System.out.println("w:" + w + " z:" + z);
        }*/

        // Dibuja los nodos y sus nombres
        for (Jugador nodo : campo.getJugadores()) {
            g.setColor(Color.WHITE);

            // Calcula el ancho del nombre
            FontMetrics fm = g.getFontMetrics();
            int anchoNombre = fm.stringWidth(nodo.getNombre());

            // Calcula el tamaño del nodo en función del ancho del nombre
            int radio = Math.max(20, anchoNombre / 2 + 10);

            g.fillOval(nodo.x - radio, nodo.y - radio, 2 * radio, 2 * radio);

            // Dibuja el nombre del nodo
            g.setColor(Color.BLACK);
            g.drawString(nodo.getNombre(), nodo.x - anchoNombre / 2, nodo.y + fm.getHeight() / 2);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 714, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 363, Short.MAX_VALUE));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
