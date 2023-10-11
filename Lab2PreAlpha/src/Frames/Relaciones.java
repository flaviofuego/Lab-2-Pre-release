package Frames;

import Classes.Campo;
import java.util.Arrays;

public class Relaciones extends javax.swing.JPanel {
    private String[][] matrizRelaciones;
    private Campo campo;
    
    public Relaciones() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cargar = new javax.swing.JButton();
        contenedor = new javax.swing.JScrollPane();
        input = new javax.swing.JTextArea();

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cargar))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Cargar)
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarActionPerformed
        String respuesta = input.getText();
        String[] lineas = respuesta.split("\n");
        String[] columna = lineas[0].split(",");
        matrizRelaciones = new String[lineas.length][columna.length];
        for (int i = 0; i < lineas.length; i++) {
            for (int j = 0; j < columna.length; j++) {
                matrizRelaciones[i][j] = lineas[i].split(",")[j];
            }
        }
        System.out.println(Arrays.toString(matrizRelaciones));
    }//GEN-LAST:event_CargarActionPerformed

    public void setCampo(Campo campo) {
        this.campo = campo;
    }
 
    public String[][] getMatrizRelaciones() {
        return matrizRelaciones;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cargar;
    private javax.swing.JScrollPane contenedor;
    private javax.swing.JTextArea input;
    // End of variables declaration//GEN-END:variables
}