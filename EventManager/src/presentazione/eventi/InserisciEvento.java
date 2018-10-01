/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentazione.eventi;
import logica.generali.HomeController;
import data.Categorie;
import static data.Categorie.getAllCategories;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import logica.eventi.InserisciEventoController;
import presentazione.eventi.AvvisoErroreInserimento;
/**
 *
 * @author Dastler
 */
public class InserisciEvento extends javax.swing.JFrame {
    private final String[] categories=getAllCategories();
    InserisciEventoController controller;
    JDialog errore;
    /**
     * Creates new form InserisciEvento
     */
    public InserisciEvento(InserisciEventoController controller) {
        this.controller=controller;
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        insEventoLabel = new javax.swing.JLabel();
        nomeLabel = new javax.swing.JLabel();
        descrizioneLabel = new javax.swing.JLabel();
        cittaLabel = new javax.swing.JLabel();
        dataLabel = new javax.swing.JLabel();
        categoriaLabel = new javax.swing.JLabel();
        bigliettiLabel = new javax.swing.JLabel();
        addImgLabel = new javax.swing.JLabel();
        prezzoLabel = new javax.swing.JLabel();
        nomeTextField = new javax.swing.JTextField();
        descrizioneTextField = new javax.swing.JTextField();
        cittaComboBox = new javax.swing.JComboBox<>();
        dataChooser = new com.toedter.calendar.JDateChooser();
        bigliettiSpinField = new com.toedter.components.JSpinField();
        prezzoTextField = new javax.swing.JTextField();
        categoriaComboBox = new javax.swing.JComboBox<>();
        imgTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        indietroButton = new javax.swing.JButton();
        salvaButton = new javax.swing.JButton();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" Inserisci evento");
        setLocation(new java.awt.Point(300, 100));
        setPreferredSize(new java.awt.Dimension(470, 520));
        setResizable(false);

        insEventoLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        insEventoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        insEventoLabel.setText("Inserisci evento");

        nomeLabel.setText("Nome evento : ");

        descrizioneLabel.setText("Descrizione : ");

        cittaLabel.setText("Città : ");

        dataLabel.setText("Data :");

        categoriaLabel.setText("Categoria :");

        bigliettiLabel.setText("N° biglietti disponibili :");

        addImgLabel.setText("Aggiungi immagini :");

        prezzoLabel.setText("Prezzo :");

        nomeTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomeTextFieldKeyReleased(evt);
            }
        });

        descrizioneTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descrizioneTextFieldKeyReleased(evt);
            }
        });

        cittaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aosta", "Verbania", "Biella", "Novara", "Torino", "Vercelli", "Asti", "Alessandria", "Cuneo", "Savona", "Imperia", "La Spezia", "Genova", "Sondrio", "Como", "Lecco", "Varese", "Bergamo", "Milano", "Brescia", "Pavia", "Lodi", "Cremona", "Mantova", "Trento", "Bolzano", "Belluno", "Vicenza", "Treviso", "Verona", "Venezia", "Padova", "Rovigo", "Pordenone", "Gorizia", "Udine", "Trieste", "Piacenza-ParmaReggio", "Emilia", "Modena", "Bologna", "Ferrara", "Ravenna", "Forlì", "Rimini", "Massa", "Lucca", "Pistoia", "Prato", "Firenze", "Pisa", "Arezzo", "Livorno", "Siena", "Grosseto", "Perugia", "Terni", "Pesaro", "Ancona", "Macerata", "Ascoli", "Piceno", "Viterbo", "Rieti", "Roma", "Latina", "Frosinone", "Teramo", "Pescara", "L’Aquila", "Chieti", "Isernia", "Campobasso", "Avellino", "Napoli", "Benevento", "Caserta", "Salerno", "Foggia", "Bari", "Taranto", "Brindisi", "Potenza", "Matera", "Cosenza", "Crotone", "Catanzaro", "Vibo Valentia", "Reggio Calabria", "Lecce", "Trapani", "Palermo", "Messina", "Caltanissetta", "Agrigento", "Enna", "Catania", "Ragusa", "Siracusa", "Olbia Tempio", "Sassari", "Nuoro", "Oristano", "Ogliastra", "Medio Campidano", "Cagliari", "Carbonia Iglesias" }));

        dataChooser.setDateFormatString("d/MM/yyyy");
        dataChooser.setMinSelectableDate(java.util.Calendar.getInstance().getTime());
        dataChooser.setDate(java.util.Calendar.getInstance().getTime());

        bigliettiSpinField.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bigliettiSpinFieldPropertyChange(evt);
            }
        });

        prezzoTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        prezzoTextField.setText("0.00");
        prezzoTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prezzoTextFieldKeyReleased(evt);
            }
        });

        categoriaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cinema", "Spettacolo","Musica", "Conferenza", "Sport" }));
        categoriaComboBox.setSelectedIndex(0);

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("es. 23.7");
        jLabel1.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(insEventoLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeLabel)
                            .addComponent(descrizioneLabel)
                            .addComponent(cittaLabel)
                            .addComponent(dataLabel)
                            .addComponent(categoriaLabel)
                            .addComponent(prezzoLabel)
                            .addComponent(bigliettiLabel)
                            .addComponent(addImgLabel))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(descrizioneTextField)
                                    .addComponent(nomeTextField)
                                    .addComponent(cittaComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dataChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(prezzoTextField)
                                    .addComponent(categoriaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(imgTextField)
                            .addComponent(bigliettiSpinField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(insEventoLabel)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeLabel)
                    .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descrizioneLabel)
                    .addComponent(descrizioneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cittaLabel)
                    .addComponent(cittaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataLabel)
                    .addComponent(dataChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoriaLabel)
                    .addComponent(categoriaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prezzoLabel)
                    .addComponent(prezzoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bigliettiLabel)
                    .addComponent(bigliettiSpinField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addImgLabel)
                    .addComponent(imgTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        indietroButton.setText("Indietro");
        indietroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indietroButtonActionPerformed(evt);
            }
        });

        salvaButton.setText("Salva");
        salvaButton.setEnabled(false);
        salvaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(indietroButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(salvaButton)
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(indietroButton)
                    .addComponent(salvaButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void indietroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indietroButtonActionPerformed
        // TODO add your handling code here:
        new HomeController();
        this.dispose();
    }//GEN-LAST:event_indietroButtonActionPerformed

    private void salvaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvaButtonActionPerformed
        try {
            Date o = dataChooser.getDate();  
            String x = String.format("%1$td/%1$tm/%1$tY",o);   
            // TODO add your handling code here:
            if(controller.eseguiInserimento(nomeTextField.getText(),descrizioneTextField.getText(),(String)cittaComboBox.getSelectedItem(),x,(String)categoriaComboBox.getSelectedItem(),prezzoTextField.getText(),bigliettiSpinField.getValue(),imgTextField.getText())){ 
                new SuccessoInserimento().setVisible(true);    
                this.dispose();
            }
            else{ 
                new ErroreInserimento().setVisible(true);
                this.dispose();
            }
        } catch (IOException ex) {
            Logger.getLogger(InserisciEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_salvaButtonActionPerformed

    private void nomeTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeTextFieldKeyReleased
        // TODO add your handling code here:
        if(areFull()) salvaButton.setEnabled(true);
        else salvaButton.setEnabled(false);
    }//GEN-LAST:event_nomeTextFieldKeyReleased

    private void descrizioneTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descrizioneTextFieldKeyReleased
        // TODO add your handling code here:
        if(areFull()) salvaButton.setEnabled(true);
        else salvaButton.setEnabled(false);
    }//GEN-LAST:event_descrizioneTextFieldKeyReleased

    private void prezzoTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prezzoTextFieldKeyReleased
        // TODO add your handling code here:
        if(areFull() && inputTextControl(prezzoTextField.getText())){
            salvaButton.setEnabled(true);
            jLabel1.setEnabled(false);
        }
        else{ 
            salvaButton.setEnabled(false);
            jLabel1.setEnabled(true);
        }
        
    }//GEN-LAST:event_prezzoTextFieldKeyReleased

    private void bigliettiSpinFieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bigliettiSpinFieldPropertyChange
        // TODO add your handling code here:
        if(areFull()) salvaButton.setEnabled(true);
        else salvaButton.setEnabled(false);
    }//GEN-LAST:event_bigliettiSpinFieldPropertyChange

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
            java.util.logging.Logger.getLogger(InserisciEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InserisciEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InserisciEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InserisciEvento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InserisciEvento(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addImgLabel;
    private javax.swing.JLabel bigliettiLabel;
    private com.toedter.components.JSpinField bigliettiSpinField;
    private javax.swing.JComboBox<String> categoriaComboBox;
    private javax.swing.JLabel categoriaLabel;
    private javax.swing.JComboBox<String> cittaComboBox;
    private javax.swing.JLabel cittaLabel;
    private com.toedter.calendar.JDateChooser dataChooser;
    private javax.swing.JLabel dataLabel;
    private javax.swing.JLabel descrizioneLabel;
    private javax.swing.JTextField descrizioneTextField;
    private javax.swing.JTextField imgTextField;
    private javax.swing.JButton indietroButton;
    private javax.swing.JLabel insEventoLabel;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JLabel prezzoLabel;
    private javax.swing.JTextField prezzoTextField;
    private javax.swing.JButton salvaButton;
    // End of variables declaration//GEN-END:variables

    private boolean areFull(){
        return !nomeTextField.getText().isEmpty() && !descrizioneTextField.getText().isEmpty() && !prezzoTextField.getText().isEmpty() && bigliettiSpinField.getValue()>0 ;
    }
    private boolean inputTextControl(String text1){
        return text1.matches("^[0-9]+[.]+[0-9]*" );
    
    }
}