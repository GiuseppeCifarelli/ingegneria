/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentazione.eventi;

import data.Eventi;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import logica.eventi.ModificaEventoController;
import logica.eventi.RicercaEventoController;
import logica.eventi.EliminaEventoController;

/**
 *
 * @author Dastler
 */
public class RisultatiRicerca extends javax.swing.JFrame {
    List<Eventi> eventi;
    /**
     * Creates new form RisultatiRicerca
     */
    
    public RisultatiRicerca(DefaultTableModel model, List<Eventi> list) {
        eventi=list;
        initComponents();
        eventiTable.setModel(model);
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
        modificaButton = new javax.swing.JButton();
        eliminaButton = new javax.swing.JButton();
        indietroButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        eventiTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Risultati ricerca");
        setLocation(new java.awt.Point(300, 150));
        setResizable(false);

        modificaButton.setText("Modifica");
        modificaButton.setEnabled(false);
        modificaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificaButtonActionPerformed(evt);
            }
        });

        eliminaButton.setText("Elimina");
        eliminaButton.setEnabled(false);
        eliminaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminaButtonActionPerformed(evt);
            }
        });

        indietroButton.setText("Indietro");
        indietroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indietroButtonActionPerformed(evt);
            }
        });

        eventiTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eventiTableMouseClicked(evt);
            }
        });
        eventiTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                eventiTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(eventiTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Risultati ricerca");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(indietroButton)
                        .addGap(200, 200, 200)
                        .addComponent(modificaButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eliminaButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(indietroButton)
                    .addComponent(eliminaButton)
                    .addComponent(modificaButton))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modificaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificaButtonActionPerformed
        try {
            // TODO add your handling code here:
            new ModificaEventoController(eventi.get(eventiTable.getSelectedRow()),this);
            this.setVisible(false);
        } catch (ParseException ex) {
            Logger.getLogger(RisultatiRicerca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_modificaButtonActionPerformed

    private void eliminaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminaButtonActionPerformed
        // TODO add your handling code here:
        new EliminaEventoController(eventi.get(eventiTable.getSelectedRow()),this);
        this.setVisible(false);
    }//GEN-LAST:event_eliminaButtonActionPerformed

    private void eventiTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventiTableMouseClicked
        // TODO add your handling code here:
        if(eventiTable.getSelectedRow()!=-1){
            eliminaButton.setEnabled(true);
            modificaButton.setEnabled(true);
        }else {
            modificaButton.setEnabled(false);
            eliminaButton.setEnabled(false);
        }
    }//GEN-LAST:event_eventiTableMouseClicked

    private void indietroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indietroButtonActionPerformed
        // TODO add your handling code here:
        new RicercaEventoController();
        this.dispose();
    }//GEN-LAST:event_indietroButtonActionPerformed

    private void eventiTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eventiTableKeyReleased
        // TODO add your handling code here:
        if(eventiTable.getSelectedRow()!=-1){
            eliminaButton.setEnabled(true);
            modificaButton.setEnabled(true);
        }else {
            modificaButton.setEnabled(false);
            eliminaButton.setEnabled(false);
        }
    }//GEN-LAST:event_eventiTableKeyReleased

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
            java.util.logging.Logger.getLogger(RisultatiRicerca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RisultatiRicerca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RisultatiRicerca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RisultatiRicerca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RisultatiRicerca(null,null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton eliminaButton;
    private javax.swing.JTable eventiTable;
    private javax.swing.JButton indietroButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificaButton;
    // End of variables declaration//GEN-END:variables
}
