package Frames;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import Classes.Campo;
import Classes.evento;

public class CampoVista extends javax.swing.JFrame implements evento {
    public Campo campo;
    Jugadores j1;
    Relaciones r;
    
    private void cambiar_modo(JPanel p){
        p.setSize(500, 262);
        modo.removeAll();
        modo.add(p, BorderLayout.CENTER);
        modo.revalidate();
        modo.repaint();
    }
    
    public CampoVista() {
        campo = new Campo();
        initComponents();
        this.setLocationRelativeTo(null);
        mostrar.setEnabled(false);
        j1 = new Jugadores();
        j1.setCampo(campo);
        cambiar_modo(j1);
        j1.setListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Fondo = new javax.swing.JPanel();
        mostrar = new javax.swing.JButton();
        modo = new javax.swing.JPanel();
        VOLVER1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mostrar.setText("Ver campo");
        mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout modoLayout = new javax.swing.GroupLayout(modo);
        modo.setLayout(modoLayout);
        modoLayout.setHorizontalGroup(
            modoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
        );
        modoLayout.setVerticalGroup(
            modoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 281, Short.MAX_VALUE)
        );

        VOLVER1.setText("Volver");
        VOLVER1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VOLVER1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_FondoLayout = new javax.swing.GroupLayout(Panel_Fondo);
        Panel_Fondo.setLayout(Panel_FondoLayout);
        Panel_FondoLayout.setHorizontalGroup(
            Panel_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_FondoLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(modo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(Panel_FondoLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(Panel_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_FondoLayout.createSequentialGroup()
                    .addContainerGap(408, Short.MAX_VALUE)
                    .addComponent(VOLVER1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(15, 15, 15)))
        );
        Panel_FondoLayout.setVerticalGroup(
            Panel_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_FondoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(modo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(Panel_FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_FondoLayout.createSequentialGroup()
                    .addContainerGap(331, Short.MAX_VALUE)
                    .addComponent(VOLVER1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(15, 15, 15)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarActionPerformed
        // TODO add your handling code here:
        VistaGrafo v = new VistaGrafo(r.getCampo());
        v.setVisible(true);
        //v.setCampo(r.getCampo());
        this.setVisible(false);
        
    }//GEN-LAST:event_mostrarActionPerformed

    private void VOLVER1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VOLVER1ActionPerformed
        Inicio v = new Inicio();
        this.setVisible(false);
        v.setVisible(true);
    }//GEN-LAST:event_VOLVER1ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Campo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Campo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Campo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Campo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CampoVista().setVisible(true);
            }
        });
    }

    @Override
    public void onSetCampo(Jugadores j) {
        r = new Relaciones();
        r.setCampo(j1.getCampo());
        r.setListener(this);
        cambiar_modo(r);
    }

    @Override
    public void onSetCampo(Relaciones r) {
        mostrar.setEnabled(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Fondo;
    private javax.swing.JButton VOLVER1;
    private javax.swing.JPanel modo;
    private javax.swing.JButton mostrar;
    // End of variables declaration//GEN-END:variables
}
