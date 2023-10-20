package Frames;

import Classes.Campo;
import Classes.Jugador;
import javax.swing.JOptionPane;
import Classes.evento;

public class Jugadores extends javax.swing.JPanel {
    private String[][] matrizCaracteristicas;
    private Campo campo;
    private evento listener;
    
    public Jugadores() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cargar = new javax.swing.JButton();
        contenedor = new javax.swing.JScrollPane();
        input = new javax.swing.JTextArea();
        texto = new javax.swing.JLabel();

        Cargar.setText("Cargar");
        Cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarActionPerformed(evt);
            }
        });

        input.setColumns(20);
        input.setRows(5);
        input.setToolTipText("escriba en forma CSV y matriz las caracteristicas de los jugadores");
        contenedor.setViewportView(input);

        texto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        texto.setText("matriz de jugadores");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cargar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(texto, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Cargar)
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarActionPerformed
        String respuesta = input.getText();
        String[] lineas = respuesta.split("\n");
        String[] columna = lineas[0].split(",");
        if (lineas.length <= 1 || columna.length <= 1){
            input.setText("");
            JOptionPane.showMessageDialog(null,"ha digitado un valor no esperado");
        } else {
            matrizCaracteristicas = new String[lineas.length][columna.length];
            for (int i = 0; i < lineas.length; i++) {
                for (int j = 0; j < columna.length; j++) {
                    matrizCaracteristicas[i][j] = lineas[i].split(",")[j];
                }
            }
            for (int i = 0; i < matrizCaracteristicas.length; i++) {
                campo.addJugador(new Jugador(matrizCaracteristicas[i][0],Integer.parseInt(matrizCaracteristicas[i][1]),Integer.parseInt(matrizCaracteristicas[i][2]),Integer.parseInt(matrizCaracteristicas[i][3])));
            }
            if (listener != null){
                listener.onSetCampo(this);
            }
        }
        
    }//GEN-LAST:event_CargarActionPerformed

    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    public String[][] getMatrizCaracteristicas() {
        return matrizCaracteristicas;
    }
    
    public void setListener(evento listener) {
        this.listener = listener;
    }

    public Campo getCampo() {
        return campo;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cargar;
    private javax.swing.JScrollPane contenedor;
    private javax.swing.JTextArea input;
    private javax.swing.JLabel texto;
    // End of variables declaration//GEN-END:variables
}