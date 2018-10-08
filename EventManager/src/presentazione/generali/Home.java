/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentazione.generali;
import logica.generali.LoginController;
import logica.eventi.InserisciEventoController;
import logica.eventi.RicercaEventoController;
/**
 *
 * @author Dastler
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        gestioneEventiLabel = new javax.swing.JLabel();
        inserisciEventoButton = new javax.swing.JButton();
        ricercaEventoButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" Home");
        setLocation(new java.awt.Point(500, 250));

        gestioneEventiLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        gestioneEventiLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gestioneEventiLabel.setText("Gestione eventi");

        inserisciEventoButton.setText("Inserisci evento");
        inserisciEventoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserisciEventoButtonActionPerformed(evt);
            }
        });
        inserisciEventoButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                inserisciEventoButtonKeyReleased(evt);
            }
        });

        ricercaEventoButton.setText("Ricerca evento");
        ricercaEventoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ricercaEventoButtonActionPerformed(evt);
            }
        });
        ricercaEventoButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ricercaEventoButtonKeyReleased(evt);
            }
        });

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        logoutButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                logoutButtonKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inserisciEventoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gestioneEventiLabel)
                            .addComponent(ricercaEventoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(logoutButton)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(gestioneEventiLabel)
                .addGap(47, 47, 47)
                .addComponent(inserisciEventoButton)
                .addGap(34, 34, 34)
                .addComponent(ricercaEventoButton)
                .addGap(32, 32, 32)
                .addComponent(logoutButton)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inserisciEventoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserisciEventoButtonActionPerformed
        // TODO add your handling code here:
        //InserisciEvento
        new InserisciEventoController();
        this.dispose();
    }//GEN-LAST:event_inserisciEventoButtonActionPerformed

    private void ricercaEventoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ricercaEventoButtonActionPerformed
        // TODO add your handling code here:
        // Ricerca evento
        new RicercaEventoController();
        this.dispose();
    }//GEN-LAST:event_ricercaEventoButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        new LoginController();
        this.dispose();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void inserisciEventoButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inserisciEventoButtonKeyReleased
        // TODO add your handling code here:
        new InserisciEventoController();
        this.dispose();
    }//GEN-LAST:event_inserisciEventoButtonKeyReleased

    private void ricercaEventoButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ricercaEventoButtonKeyReleased
        // TODO add your handling code here:
         new RicercaEventoController();
        this.dispose();
    }//GEN-LAST:event_ricercaEventoButtonKeyReleased

    private void logoutButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_logoutButtonKeyReleased
        // TODO add your handling code here:
        new LoginController();
        this.dispose();
    }//GEN-LAST:event_logoutButtonKeyReleased

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel gestioneEventiLabel;
    private javax.swing.JButton inserisciEventoButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton ricercaEventoButton;
    // End of variables declaration//GEN-END:variables
}
