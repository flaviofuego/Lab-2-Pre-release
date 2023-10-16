package grafosCodigoPatito;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.lang.Math;
//import java.lang.runtime.SwitchBootstraps;

/**
 *
 * @author Codigo Patito
 */
public class Vista extends javax.swing.JFrame {

    public static ArrayList<Vertice> panel = new ArrayList<>();
    public static int c = 0;
    public static int cl = 0;
    public static int maxN = 11;
    public static int hack = 0;
    public static boolean N = false;
    public static boolean L = false;
    public static Graphics h;
    public static String nombreN[] = {"J1", "J2", "J3", "J4", "J5", "J6", "J7", "J8", "J9", "J10", "J11"};
    public static String nombreL[] = {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-",
        "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"};
    public static int maxL = nombreL.length;
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
        Matriz.setEditable(false);
        btnLinea.setEnabled(false);
        btnAyacente.setEnabled(false);
        btnIncidencia.setEnabled(false);
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

    public static void linea(int x, int y, int w, int z) {
        h.setColor(Color.GRAY);
        if (x == w && y == z) {
            h.drawArc(x + 10, y + 5, 20, 30, 320, 290);
            x = x + 15;
            y = y + 20;
        } else {
            h.drawLine(x + 20, y + 45, w + 20, z + 45);
            x = ((x + 20 - w + 20) / 2) + w;
            y = ((y + 45 - z + 45) / 2) + z;
        }
        h.setColor(Color.BLACK);
        h.drawString(nombreL[1], x, y);
//        h.drawString(nombreL[cl], ((x + 20 - w + 20) / 2) + w, ((y + 45 - z + 45) / 2) + z);
        if (cl == 20) {
            cl = 0;
        }
        cl++;
    }

    public void muestraAdyacencia() {
        matrizAdyacente = "Matriz de Adyacencia  \n\n";
        int tNodos = panel.size();
        int bit = 0;
        String Nom = "";
        matrizAdyacente += "   ";
        matrizAdyacente += "  ";
        for (int k = 0; k < tNodos; k++) {
            matrizAdyacente += "  " + nombreN[k];
        }
        for (int k = 0; k < tNodos; k++) {
            matrizAdyacente += "  \n";
            for (int l = 0; l < tNodos; l++) {
                if (MAdyacencia[k][l]) {
                    bit = 1;
                } else {
                    bit = 0;
                }
                if (l == 0) {
                    Nom = nombreL[k] + "  ";
                } else {
                    Nom = "";
                }
                matrizAdyacente += Nom + bit + "   ";
            }
        }
        setMatriz(matrizAdyacente, matrizIncedencia);
    }

    public void Incidencia() {
        matrizIncedencia = "Matriz de Incidencia  \n\n";
        int tNodos = panel.size();
        int bit = 0;
        String Nom = "";
        matrizIncedencia += "  ";
        matrizIncedencia += "  ";
        for (int k = 0; k < tNodos; k++) {
            matrizIncedencia += "   " + nombreN[k];
        }
        for (int k = 0; k < tNodos; k++) {
            matrizIncedencia += "   \n";
            for (int l = 0; l < tNodos; l++) {
                if (MIncidencia[k][l]) {
                    bit = 0;
                } else {
                    bit = 1;
                }
                if (l == 0) {
                    Nom = nombreL[k] + "  ";
                } else {
                    Nom = "";
                }
                matrizIncedencia += Nom + bit + "   ";
            }
        }
        setMatriz(matrizIncedencia, matrizAdyacente);
    }

    private void setMatriz(String matriz1, String matriz2) {
        Matriz.setText(matriz1 + "\n\n" + matriz2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnAyacente = new javax.swing.JButton();
        btnIncidencia = new javax.swing.JButton();
        btnSalir1 = new javax.swing.JButton();
        btnVertice = new javax.swing.JButton();
        btnLinea = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Matriz = new javax.swing.JTextArea();
        panelView = new javax.swing.JPanel();
        lblEstado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Menu"));

        btnAyacente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/matriz.png"))); // NOI18N
        btnAyacente.setText("Adyacencia");
        btnAyacente.setFocusPainted(false);
        btnAyacente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAyacente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAyacente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyacenteActionPerformed(evt);
            }
        });

        btnIncidencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/matriz.png"))); // NOI18N
        btnIncidencia.setText("Incidencia");
        btnIncidencia.setFocusPainted(false);
        btnIncidencia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIncidencia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnIncidencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncidenciaActionPerformed(evt);
            }
        });

        btnSalir1.setText("Salir");
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });

        btnVertice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/circulo.png"))); // NOI18N
        btnVertice.setText("Vertice");
        btnVertice.setToolTipText("");
        btnVertice.setFocusPainted(false);
        btnVertice.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVertice.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVertice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerticeActionPerformed(evt);
            }
        });

        btnLinea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/linea.png"))); // NOI18N
        btnLinea.setText("Arista");
        btnLinea.setFocusPainted(false);
        btnLinea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLinea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLineaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalir1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVertice, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAyacente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnIncidencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAyacente, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                    .addComponent(btnVertice, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLinea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIncidencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir1)
                .addContainerGap())
        );

        Matriz.setColumns(20);
        Matriz.setRows(5);
        Matriz.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Matrizes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tempus Sans ITC", 1, 12))); // NOI18N
        jScrollPane1.setViewportView(Matriz);

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
            .addGap(0, 696, Short.MAX_VALUE)
        );
        panelViewLayout.setVerticalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblEstado.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)))
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
            btnLinea.setBackground(null);
        } else {
            L = false;
            N = true;
            btnVertice.setBackground(Color.decode("#3F3634"));
            btnLinea.setBackground(null);
            lblEstado.setText("Vertice Activo");
//////////////////////////////////////////////////////////////////////

            //Jugadores Equipo 1
            Vertice ko = new Vertice();
            /*int x = (int) (Math.random() * 400);
                int y = (int) (Math.random() * 400);*/
            ko.setBounds(10, 300, 41, 41);
            panelView.add(ko);
            panel.add(ko);
            ko.dibuja(ko.getGraphics());

            int linea1x = 100;
            int linea1y = 150;
            for (int i = 0; i < 4; i++) {
                Vertice prueba = new Vertice();
                /*int x = (int) (Math.random() * 400);
                int y = (int) (Math.random() * 400);*/
                prueba.setBounds(linea1x, linea1y, 41, 41);
                panelView.add(prueba);
                panel.add(prueba);
                prueba.dibuja(prueba.getGraphics());
                Vista.linea(28, 320,
                        linea1x+18, linea1y+20);

                switch (linea1y) {
                    case 150:
                        Vista.linea(linea1x+18, linea1y+20,
                                linea1x+18, linea1y+20 + 100);

                        break;
                    case 250:
                        Vista.linea(linea1x+18, linea1y+20,
                                linea1x+18, linea1y+20 + 100);
                        break;

                    case 350:
                        Vista.linea(linea1x+18, linea1y+20,
                                linea1x+18, linea1y+20 + 100);
                        break;

                    default:
                        System.out.println(":v");
                }

                linea1y = linea1y + 100;
            }

            int linea2x = 200;
            int linea2y = 200;
            for (int i = 0; i < 3; i++) {

                Vertice prueba = new Vertice();
                /*int x = (int) (Math.random() * 400);
                int y = (int) (Math.random() * 400);*/
                prueba.setBounds(linea2x, linea2y, 41, 41);
                panelView.add(prueba);
                panel.add(prueba);
                prueba.dibuja(prueba.getGraphics());

                linea1x = 118;
                linea1y = 170;
                /*for (int h = 0; h < 4; h++) {
                    Vista.linea(linea1x, linea1y,
                            linea2x, linea2y);
                    linea1y = linea1y + 100;
                }*/
                switch (linea2y) {
                    case 200:
                        Vista.linea(linea1x, linea1y,
                                linea2x+18, linea2y+20);
                        Vista.linea(linea1x, linea1y + 100,
                                linea2x+18, linea2y+20);
                        Vista.linea(linea2x+18, linea2y+20 + 100,
                                linea2x+18, linea2y+20);

                        break;
                    case 300:
                        /*Vista.linea(linea1x, linea1y + 100,
                                linea2x+18, linea2y+20);
                        Vista.linea(linea1x, linea1y + 200,
                                linea2x+18, linea2y+20);*/
                        Vista.linea(linea2x+18, linea2y+20 + 100,
                                linea2x+18, linea2y+20);
                        break;

                    case 400:
                        Vista.linea(linea1x, linea1y + 200,
                                linea2x+18, linea2y+20);
                        Vista.linea(linea1x, linea1y + 300,
                                linea2x+18, linea2y+20);

                        break;

                    default:
                        System.out.println(":v");
                }

                linea2y = linea2y + 100;
            }

            int linea3x = 300;
            int linea3y = 175;
            for (int i = 0; i < 3; i++) {
                Vertice prueba = new Vertice();
                /*int x = (int) (Math.random() * 400);
                int y = (int) (Math.random() * 400);*/
                prueba.setBounds(linea3x, linea3y, 41, 41);
                panelView.add(prueba);
                panel.add(prueba);
                prueba.dibuja(prueba.getGraphics());
                linea2x = 218;
                linea2y = 220;
                switch (linea3y) {
                    case 175:
                        Vista.linea(linea1x, linea1y,
                                linea3x+18, linea3y+20);
                        Vista.linea(linea2x, linea2y,
                                linea3x+18, linea3y+20);
                        /*Vista.linea(linea2x, linea2y + 100,
                                linea3x+18, linea3y+20);*/
                        Vista.linea(linea3x+18, linea3y+20 + 125,
                                linea3x+18, linea3y+20);

                        break;
                    case 300:
                        Vista.linea(linea2x, linea2y + 100,
                                linea3x+18, linea3y+20);
                        /*Vista.linea(linea1x, linea1y + 300,
                                linea3x+18, linea3y+20);*/
                        Vista.linea(linea3x+18, linea3y+20 + 125,
                                linea3x+18, linea3y+20);
                        break;

                    case 425:
                        Vista.linea(linea1x, linea1y + 300,
                                linea3x+18, linea3y+20);
                        Vista.linea(linea2x, linea2y + 200,
                                linea3x+18, linea3y+20);
                        break;

                    default:
                        System.out.println(":v");
                }

                linea3y = linea3y + 125;
            }
            //////////////////////////////////////////////////
           
            //Jugadores Equipo 2

            Vertice ko2 = new Vertice();

            ko2.setBounds(655, 300, 41, 41);

            panelView.add(ko2);
            panel.add(ko2);
            ko2.dibuja(ko2.getGraphics());

            int linea4x = 555;
            int linea4y = 150;

            for (int i = 0; i < 4; i++) {
                Vertice prueba = new Vertice();
                /*int x = (int) (Math.random() * 400);
                int y = (int) (Math.random() * 400);*/
                prueba.setBounds(linea4x, linea4y, 41, 41);
                panelView.add(prueba);
                panel.add(prueba);
                prueba.dibuja(prueba.getGraphics());
                Vista.linea(670, 320,
                        linea4x+18, linea4y+20);

                switch (linea4y) {
                    case 150:
                        Vista.linea(linea4x+18, linea4y+20,
                                linea4x+18, linea4y+20 + 100);

                        break;
                    case 250:
                        Vista.linea(linea4x+18, linea4y+20,
                                linea4x+18, linea4y+20 + 100);
                        break;

                    case 350:
                        Vista.linea(linea4x+18, linea4y+20,
                                linea4x+18, linea4y+20 + 100);
                        break;

                    default:
                        System.out.println(":v");
                }

                linea4y = linea4y + 100;
            }

            int linea5x = 455;
            int linea5y = 200;
            for (int i = 0; i < 3; i++) {

                Vertice prueba = new Vertice();
                /*int x = (int) (Math.random() * 400);
                int y = (int) (Math.random() * 400);*/
                prueba.setBounds(linea5x, linea5y, 41, 41);
                panelView.add(prueba);
                panel.add(prueba);
                prueba.dibuja(prueba.getGraphics());

                linea4x = 573;
                linea4y = 170;
                /*for (int h = 0; h < 4; h++) {
                    Vista.linea(linea1x, linea1y,
                            linea2x, linea2y);
                    linea1y = linea1y + 100;
                }*/
                switch (linea5y) {
                    case 200:
                        Vista.linea(linea4x, linea4y,
                                linea5x+18, linea5y+20);
                        Vista.linea(linea4x, linea4y + 100,
                                linea5x+18, linea5y+20);
                        Vista.linea(linea5x+18, linea5y+20 + 100,
                                linea5x+18, linea5y+20);

                        break;
                    case 300:
                        /*Vista.linea(linea1x, linea1y + 100,
                                linea2x+18, linea2y+20);
                        Vista.linea(linea1x, linea1y + 200,
                                linea2x+18, linea2y+20);*/
                        Vista.linea(linea5x+18, linea5y+20 + 100,
                                linea5x+18, linea5y+20);
                        break;

                    case 400:
                        Vista.linea(linea4x, linea4y + 200,
                                linea5x+18, linea5y+20);
                        Vista.linea(linea4x, linea4y + 300,
                                linea5x+18, linea5y+20);

                        break;

                    default:
                        System.out.println(":v");
                }

                linea5y = linea5y + 100;
            }

            int linea6x = 355;
            int linea6y = 175;
            for (int i = 0; i < 3; i++) {
                Vertice prueba = new Vertice();
                /*int x = (int) (Math.random() * 400);
                int y = (int) (Math.random() * 400);*/
                prueba.setBounds(linea6x, linea6y, 41, 41);
                panelView.add(prueba);
                panel.add(prueba);
                prueba.dibuja(prueba.getGraphics());
                linea5x = 473;
                linea5y = 220;
                switch (linea6y) {
                    case 175:
                        Vista.linea(linea4x, linea4y,
                                linea6x+18, linea6y+20);
                        Vista.linea(linea5x, linea5y,
                                linea6x+18, linea6y+20);
                        /*Vista.linea(linea2x, linea2y + 100,
                                linea3x+18, linea3y+20);*/
                        Vista.linea(linea6x+18, linea6y+20 + 125,
                                linea6x+18, linea6y+20);

                        break;
                    case 300:
                        Vista.linea(linea5x, linea5y + 100,
                                linea6x+18, linea6y+20);
                        /*Vista.linea(linea1x, linea1y + 300,
                                linea3x+18, linea3y+20);*/
                        Vista.linea(linea6x+18, linea6y+20 + 125,
                                linea6x+18, linea6y+20);
                        break;

                    case 425:
                        Vista.linea(linea4x, linea4y + 300,
                                linea6x+18, linea6y+20);
                        Vista.linea(linea5x, linea5y + 200,
                                linea6x+18, linea6y+20);
                        break;

                    default:
                        System.out.println(":v");
                }

                linea6y = linea6y + 125;
            }
            
            //////////////////////////////////////////////////


        }
        Vista.linea(347, -10,
                                347, 580);
    }//GEN-LAST:event_btnVerticeActionPerformed

    private void btnLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLineaActionPerformed
        if (L) {
            L = false;
            N = false;
            lblEstado.setText("Vertice y Arista Desactivado");
            btnVertice.setBackground(null);
            btnLinea.setBackground(null);
        } else {
            N = false;
            L = true;
            btnLinea.setBackground(Color.decode("#79f966"));
            btnVertice.setBackground(null);
            lblEstado.setText("Arista Activo");
        }
    }//GEN-LAST:event_btnLineaActionPerformed

    private void btnAyacenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyacenteActionPerformed
        muestraAdyacencia();
    }//GEN-LAST:event_btnAyacenteActionPerformed

    private void btnIncidenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncidenciaActionPerformed
        Incidencia();
    }//GEN-LAST:event_btnIncidenciaActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void panelViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelViewMouseClicked
        if (panelView.getMousePosition() != null) {
            Point p = panelView.getMousePosition().getLocation();
            if (!L) {
                if (N) {
                    btnLinea.setEnabled(true);
                    btnAyacente.setEnabled(true);
                    btnIncidencia.setEnabled(true);
                    Vertice prueba = new Vertice();
                    prueba.setBounds(p.x - 15, p.y - 10, 31, 31);
                    panelView.add(prueba);
                    panel.add(prueba);
                    prueba.dibuja(prueba.getGraphics());
                }
            }
        }
    }//GEN-LAST:event_panelViewMouseClicked

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
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JTextArea Matriz;
    private javax.swing.JButton btnAyacente;
    private javax.swing.JButton btnIncidencia;
    private javax.swing.JButton btnLinea;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JButton btnVertice;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JPanel panelView;
    // End of variables declaration//GEN-END:variables
}
