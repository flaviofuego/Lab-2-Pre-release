package Frames;

import Classes.Campo;
import Classes.evento;
import javax.swing.JOptionPane;

public class Relaciones extends javax.swing.JPanel {

    private int[][] matrizRelaciones;
    private Campo campo;
    private evento listener;

    public Relaciones() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cargar = new javax.swing.JButton();
        contenedor = new javax.swing.JScrollPane();
        input = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(137, 162, 162));
        setForeground(new java.awt.Color(137, 162, 162));

        Cargar.setForeground(new java.awt.Color(0, 0, 0));
        Cargar.setText("Cargar");
        Cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarActionPerformed(evt);
            }
        });

        input.setColumns(20);
        input.setRows(5);
        input.setToolTipText("escriba en forma CSV y matriz las relaciones de adyacencia de los jugadores");
        contenedor.setViewportView(input);

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Matriz de adyacencia");
        jLabel1.setToolTipText("");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Por favor asegurese");
        jLabel2.setToolTipText("");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("de que no haya espacios al");
        jLabel3.setToolTipText("");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ingresar la matrix");
        jLabel4.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(Cargar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(168, 168, 168))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cargar)
                        .addGap(44, 44, 44))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarActionPerformed
        String respuesta = input.getText();
        String[] lineas = respuesta.split("\n");
        String[] columna = lineas[0].split(",");
        if ((lineas.length <= 1 || columna.length <= 1) && (lineas.length > 11 || columna.length > 4)) {
            input.setText("");
            JOptionPane.showMessageDialog(null, "ha digitado un valor no esperado");
        } else {
            matrizRelaciones = new int[lineas.length][columna.length - 1];
            for (int i = 0; i < lineas.length; i++) {
                for (int j = 1; j < columna.length; j++) {
                    matrizRelaciones[i][j - 1] = Integer.parseInt(lineas[i].split(",")[j]);
                }
            }
            campo.setMatrizAdyacencia(matrizRelaciones);
            for (int i = 0; i < lineas.length; i++) {
                for (int j = 0; j < columna.length - 1; j++) {
                    System.out.print(matrizRelaciones[i][j] + " ");
                }
                System.out.println("");
            }
            if (listener != null) {
                listener.onSetCampo(this);
            }
        }
    }//GEN-LAST:event_CargarActionPerformed

    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    public void setListener(evento listener) {
        this.listener = listener;
    }

    public int[][] getMatrizRelaciones() {
        return matrizRelaciones;
    }

    public Campo getCampo() {
        return campo;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cargar;
    private javax.swing.JScrollPane contenedor;
    private javax.swing.JTextArea input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
