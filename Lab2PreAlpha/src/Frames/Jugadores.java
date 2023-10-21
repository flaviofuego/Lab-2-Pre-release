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
        input.setToolTipText("escriba en forma CSV y matriz las caracteristicas de los jugadores");
        contenedor.setViewportView(input);

        texto.setForeground(new java.awt.Color(0, 0, 0));
        texto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        texto.setText("Matriz de jugadores");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(texto, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(Cargar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(texto)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(123, 123, 123))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cargar)
                        .addGap(34, 34, 34))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarActionPerformed
        String respuesta = input.getText();
        String[] lineas = respuesta.split("\n");
        String[] columna = lineas[0].split(",");
        if ((lineas.length <= 1 || columna.length <= 1) && (lineas.length > 11 || columna.length > 4)){
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel texto;
    // End of variables declaration//GEN-END:variables
}