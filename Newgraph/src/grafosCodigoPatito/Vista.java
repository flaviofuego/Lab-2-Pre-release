package grafosCodigoPatito;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Objects;

import java.util.Scanner;
//import java.lang.runtime.SwitchBootstraps;

/**
 *
 * @author Codigo Patito
 */
public class Vista extends javax.swing.JFrame {

    public static ArrayList<Vertice> panel = new ArrayList<>();
    public static ArrayList<Arista> panelA = new ArrayList<>();
    public static String[][] matrizAdyacencia = new String[11][12];
    static Scanner sc = new Scanner(System.in);
    //rellena la matriz de adyacencia, en la primera columna va "Jugador"+i y el resto con 1 aleatorios

    //imprime la matriz de adyacencia
    public static String[][] texto_matriz() {
        String respuesta = sc.hasNext() ? sc.nextLine() : "";
        System.out.println(respuesta);
        String[] lineas = respuesta.split("\n");
        int columna = 12;
        String[][] matrizRelaciones = new String[11][columna];
        for (int i = 0; i < lineas.length; i++) {
            for (int j = 0; j < columna; j++) {
                matrizRelaciones[i][j] = lineas[i].split(",")[j];
            }
        }
        return matrizRelaciones;

    }

    public static int c, d = 0;
    public static int cl = 0;
    public static int maxN = 11;
    public static int hack = 0;
    public static boolean N = false;
    public static boolean L = false;
    public static Graphics h;
    public static String nombreN[] = {"J1", "J2", "J3", "J4", "J5", "J6", "J7", "J8", "J9", "J10", "J11"};
    //crea un arraylist de 20 elementos
    public static ArrayList<String> nombreL = new ArrayList<>();

    //rellena el arraylist con 11 pesos
    static {
        for (int i = 0; i < 100; i++) {
            nombreL.add("J" + (i + 1));
        }
    }
    public static int maxL = nombreL.size();
    public static boolean eligioP = true;
    public Point punto;
    public static int x1, x2, y1, y2;
    public static int i = -1, j = -1;
    public static boolean MAdyacencia[][] = new boolean[maxN][maxN];
    public static boolean MIncidencia[][] = new boolean[maxN][maxL];
    private String matrizAdyacente = "", matrizIncedencia = "";

    public Vista() {
        initComponents();
        h = this.getGraphics();
        setTitle("Grafos");
        setLocationRelativeTo(null);
        setResizable(false);
        inicializa();


    }

    public void inicializa() {
        for (int r = 0; r < maxN; r++) {
            for (int s = 0; s < maxN; s++) {
                MAdyacencia[r][s] = false;
            }
        }
        for (int e = 0; e < maxN; e++) {
            for (int f = 0; f < maxL; f++) {
                MIncidencia[e][f] = false;
            }
        }
    }

    public static void linea(int x, int y, int w, int z, int peso) {
        x1 = x;
        y1 = y;
        h.setColor(Color.GRAY);
        if (x == w && y == z) {
            h.drawArc(x + 10, y + 5, 20, 30, 320, 290);
            x = x + 15;
            y = y + 20;
        } else {
            h.drawLine(x + 18 + 20, y + 20 + 45, w + 20 + 18, z + 45 + 20);
            x = ((x + 20 - w + 20) / 2) + w;
            y = ((y + 45 - z + 45) / 2) + z;
        }
        Arista aristad = new Arista(buscaVertice(x1, y1), buscaVertice(w, z));
        panelA.add(aristad);
        System.out.println("x:" + x1 + " y:" + y1);
        System.out.println("w:" + w + " z:" + z);
        System.out.println("Arista creada: " + panelA.get(d).getDestino().getNombre() + " - " + panelA.get(d).getOrigen().getNombre());
        d++;
        h.setColor(Color.BLACK);
        h.drawString("" + peso, x, y);
//        h.drawString(nombreL.get(cl), ((x + 20 - w + 20) / 2) + w, ((y + 45 - z + 45) / 2) + z);
        if (cl == 20) {
            cl = 0;
        }
        cl++;

    }







    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnVertice = new javax.swing.JButton();
        panelView = new javax.swing.JPanel();
        lblEstado = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        contenedor = new javax.swing.JScrollPane();
        input = new javax.swing.JTextArea();
        Cargar = new javax.swing.JButton();
        btnSalir1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Menu"));

        btnVertice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circulo.png"))); // NOI18N
        btnVertice.setText("Visualizar");
        btnVertice.setToolTipText("");
        btnVertice.setFocusPainted(false);
        btnVertice.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVertice.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVertice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerticeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnVertice, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(176, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVertice, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        panelView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        panelView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelViewMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelViewLayout = new javax.swing.GroupLayout(panelView);
        panelView.setLayout(panelViewLayout);
        panelViewLayout.setHorizontalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
        );
        panelViewLayout.setVerticalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblEstado.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado"));

        input.setColumns(20);
        input.setRows(5);
        input.setToolTipText("escriba en forma CSV y matriz las relaciones de adyacencia de los jugadores");
        contenedor.setViewportView(input);

        Cargar.setText("Cargar");
        Cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarActionPerformed(evt);
            }
        });

        btnSalir1.setText("Salir");
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSalir1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Cargar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cargar)
                    .addComponent(btnSalir1))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerticeActionPerformed
        if (N) {
            N = false;
            L = false;
            lblEstado.setText("Vertice y Arista Desactivado");
            btnVertice.setBackground(null);

        } else {
            L = false;
            N = true;
            btnVertice.setBackground(Color.decode("#3F3634"));

            lblEstado.setText("Vertice Activo");
//////////////////////////////////////////////////////////////////////
        }

        Vista.formacion433pro();
        


    }//GEN-LAST:event_btnVerticeActionPerformed

    // funcion que busca el vertice en el panel en base a las coordenadas
    public static Vertice buscaVertice(int x, int y) {
        Vertice v = null;
        for (int i = 0; i < panel.size(); i++) {
            if (panel.get(i).getX() == x && panel.get(i).getY() == y) {
                v = panel.get(i);
            }
        }
        return v;
    }

    public static void formacion433pro() {
        int cont = 1;
        //Jugadores Equipo 1
        Vertice ko = new Vertice("Jugador" + cont);
        ko.setX(10);
        ko.setY(300);
        ko.setBounds(ko.getX(), ko.getY(), 41, 41);
        panelView.add(ko);
        panel.add(ko);
        ko.dibuja(ko.getGraphics());
        cont++;

        int linea1x = 100;
        int linea1y = 150;
        for (int i = 0; i < 4; i++) {
            Vertice prueba = new Vertice("Jugador" + cont);
            if(cont==3||cont==4){
                prueba.setX(linea1x+50);
            }else{
            prueba.setX(linea1x);}

            prueba.setY(linea1y);
            prueba.setBounds(prueba.getX(), prueba.getY(), 41, 41);
            if(cont==3||cont==4){
                prueba.setBounds(prueba.getX()+50, prueba.getY(), 41, 41);
            }
            panelView.add(prueba);
            panel.add(prueba);
            prueba.dibuja(prueba.getGraphics());
            cont++;


            linea1y = linea1y + 100;
        }

        int ddd = 100;
        int xxx = 150;
        //crea una arista entre los vertices de la linea 1

        int linea2x = 350;
        int linea2y = 200;
        for (int i = 0; i < 3; i++) {

            Vertice prueba = new Vertice("Jugador" + cont);
            prueba.setX(linea2x);
            prueba.setY(linea2y);
            prueba.setBounds(prueba.getX(), prueba.getY(), 41, 41);
            panelView.add(prueba);
            panel.add(prueba);
            prueba.dibuja(prueba.getGraphics());
            cont++;
            linea1x = 118;
            linea1y = 170;

            linea2y = linea2y + 100;

        }
        ddd = 100;
        xxx = 150;

        ddd = 350;
        xxx = 200;
        //crea una arista entre los vertices de la linea 1

        int linea3x = 600;
        int linea3y = 175;
        for (int i = 0; i < 3; i++) {
            Vertice prueba = new Vertice("Jugador" + cont);
            prueba.setX(linea3x);
            prueba.setY(linea3y);
            prueba.setBounds(linea3x, linea3y, 41, 41);
            panelView.add(prueba);
            panel.add(prueba);
            prueba.dibuja(prueba.getGraphics());
            cont++;
            linea2x = 368;
            linea2y = 220;

            linea3y = linea3y + 125;
        }
        ddd = 600;
        xxx = 175;
        //crea una arista entre los vertices de la linea 1

        //////////////////////////////////////////////////
        for (Vertice v : panel) {
            System.out.println(v.getNombre());
            System.out.println("X:" + v.getX() + " Y:" + v.getY());
        }

    }

    //crea una funcion que busque un vertice en base a su nombre
    public static Vertice buscaVertice(String nombre) {
        Vertice v = null;
        for (int i = 0; i < panel.size(); i++) {
            if (panel.get(i).getNombre().equals(nombre)) {
                v = panel.get(i);
            }
        }
        return v;
    }

    public static void matriz_arista(String[][] matrizAdyacencia) {
        int cont = 1;
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            for (int j = 0; j < matrizAdyacencia.length; j++) {
                //buscara en la matriz de adyacencia los 1 y creara una arista
                //se usa el nombre de la posicion (0,j) para encontrar el vertice de origen
                //se usa busca el vertice de destino con la funcion buscaVertice ingresando "Jugador"+j
                if (Objects.equals(matrizAdyacencia[i][j], "1")) {
                    linea(buscaVertice(matrizAdyacencia[i][0]).getX(), buscaVertice(matrizAdyacencia[i][0]).getY(),
                            buscaVertice("Jugador" + j).getX(), buscaVertice("Jugador" + j).getY(), 0);

                }
            }
        }

    }

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void panelViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelViewMouseClicked
        /*if (panelView.getMousePosition() != null) {
            Point p = panelView.getMousePosition().getLocation();
            if (!L) {
                if (N) {
                    
                    Vertice prueba = new Vertice();
                    prueba.setBounds(p.x - 15, p.y - 10, 31, 31);
                    panelView.add(prueba);
                    panel.add(prueba);
                    prueba.dibuja(prueba.getGraphics());
                }
            }
        }*/
    }//GEN-LAST:event_panelViewMouseClicked

    private void CargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarActionPerformed
        String respuesta = input.getText();
        System.out.println(respuesta);
        String[] lineas = respuesta.split("\n");
        int columna = 12;
        String[][] matrizRelaciones = new String[11][columna];
        for (int i = 0; i < lineas.length; i++) {
            for (int j = 0; j < columna; j++) {
                matrizRelaciones[i][j] = lineas[i].split(",")[j];
            }
        }
        matriz_arista(matrizRelaciones);
        
       
    }
//GEN-LAST:event_CargarActionPerformed

public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

}
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cargar;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JButton btnVertice;
    private javax.swing.JScrollPane contenedor;
    private javax.swing.JTextArea input;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblEstado;
    private static javax.swing.JPanel panelView;
    // End of variables declaration//GEN-END:variables
}
