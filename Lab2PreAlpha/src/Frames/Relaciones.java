package Frames;

import Classes.Campo;
import Classes.evento;

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

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("matriz de adyacencia");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cargar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(Cargar)
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarActionPerformed
        String respuesta = input.getText();
        String[] lineas = respuesta.split("\n");
        String[] columna = lineas[0].split(",");
        matrizRelaciones = new int[lineas.length][columna.length-1];
        for (int i = 0; i < lineas.length; i++) {
            for (int j = 1; j < columna.length; j++) {
                matrizRelaciones[i][j-1] = Integer.parseInt(lineas[i].split(",")[j]);
            }
        }
        campo.setMatrizAdyacencia(matrizRelaciones);
        for (int i = 0; i < lineas.length; i++) {
            for (int j = 0; j < columna.length-1; j++) {
                System.out.print(matrizRelaciones[i][j] + " ");
            }
            System.out.println("");
        }
        if (listener != null){
            listener.onSetCampo(this);
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
    // End of variables declaration//GEN-END:variables
}