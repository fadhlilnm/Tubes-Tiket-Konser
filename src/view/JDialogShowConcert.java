/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Koneksi.db;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class JDialogShowConcert extends javax.swing.JDialog {

    
    public Connection conn;
    public ResultSet rs;
    public Statement stm;
    public DefaultTableModel model;
    
    private String selectedArtistName;
    private String selectedConcertDate;
    private String selectedLocation;
    private int selectedConcertId;
    /**
     * Creates new form JDialogShowConcert
     */
    public JDialogShowConcert(java.awt.Frame parent, boolean modal) {
        
        super(parent, modal);
        initComponents();
        displayConcertData();
    }
    
    
    // Metode untuk mendapatkan Concert ID yang dipilih
    public int getSelectedConcertId() {
        return selectedConcertId;
    }
    
    // Metode untuk mendapatkan nilai yang dipilih
    public String getSelectedArtistName() {
        return selectedArtistName;
    }

    public String getSelectedConcertDate() {
        return selectedConcertDate;
    }

    public String getSelectedLocation() {
        return selectedLocation;
    }

    // Metode ini akan dipanggil saat salah satu data konser dipilih
    private void selectConcertData() {
        int selectedRow = jTableShowConcert.getSelectedRow();
        selectedConcertId = Integer.parseInt(jTableShowConcert.getValueAt(selectedRow, 0).toString());
        selectedArtistName = jTableShowConcert.getValueAt(selectedRow, 1).toString();
        selectedConcertDate = jTableShowConcert.getValueAt(selectedRow, 3).toString();
        selectedLocation = jTableShowConcert.getValueAt(selectedRow, 4).toString();
        this.dispose();
    }
    
    // Method to fetch and display concert data in jTableAdmin
    private void displayConcertData() {
        try {
            conn = (Connection)db.mycon();
            String sql = "SELECT concert_id, artist_name, category, concert_date, concert_location, country FROM konser";
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);

            // Create a DefaultTableModel for jTableAdmin
            model = new DefaultTableModel(new Object[][]{}, new String[]{"Concert ID", "Artist Name", "Category", "Concert Date", "Location", "Country"});

            // Populate the model with data from the result set
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("concert_id"),
                    rs.getString("artist_name"),
                    rs.getString("category"),
                    rs.getString("concert_date"),
                    rs.getString("concert_location"),
                    rs.getString("country")
                });
            }

            // Set the model to jTableAdmin
            jTableShowConcert.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTableShowConcert = new javax.swing.JTable();
        jButtonPilih = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableShowConcert.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTableShowConcert.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTableShowConcert);

        jButtonPilih.setText("Pilih");
        jButtonPilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPilihActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel1.setText("Konser Tersedia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(jButtonPilih, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButtonPilih, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPilihActionPerformed
        // TODO add your handling code here:
        selectConcertData();
    }//GEN-LAST:event_jButtonPilihActionPerformed

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
            java.util.logging.Logger.getLogger(JDialogShowConcert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogShowConcert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogShowConcert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogShowConcert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogShowConcert dialog = new JDialogShowConcert(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPilih;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableShowConcert;
    // End of variables declaration//GEN-END:variables
}
