/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Koneksi.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class JDialogEdit extends javax.swing.JDialog {

    /**
     * Creates new form JDialogTambah
     */
    private boolean dataAdded = false;
    private Object[] selectedData;
    private int concertId;
    public Connection conn;
    public ResultSet rs;
    public Statement stm;
    public DefaultTableModel model;
    
    // Modifikasi konstruktor untuk menerima parameter concertId
    public JDialogEdit(java.awt.Frame parent, boolean modal, int concertId) {
        super(parent, modal);
        initComponents();
        this.concertId = concertId;
        displayConcertData(concertId);
    }


    // Modifikasi metode updateConcertData untuk melakukan penyuntingan
    private void updateConcertData() {
        try {
            // Mendapatkan data dari input form
            String artistName = jTextFieldArtistName.getText();
            String category = jTextFieldCategory.getText();
            String date = jTextFieldConcertDate.getText();
            String location = jTextFieldLocation.getText();
            String country = jTextFieldCountry.getText();

            // Melakukan penyuntingan data di database
            conn = (Connection) db.mycon();
            String sql = "UPDATE konser SET artist_name=?, category=?, concert_date=?, concert_location=?, country=? WHERE concert_id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, artistName);
            pstmt.setString(2, category);
            pstmt.setString(3, date);
            pstmt.setString(4, location);
            pstmt.setString(5, country);
            pstmt.setInt(6, concertId);

            // Eksekusi pernyataan SQL
            int rowsAffected = pstmt.executeUpdate();

            // Memeriksa apakah penyuntingan sukses
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil diupdate.", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                
                // Tutup dialog
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal melakukan penyuntingan data.", "Gagal", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(JDialogEdit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void displayConcertData(int concertId) {
    try {
        conn = (Connection) db.mycon();
        String sql = "SELECT artist_name, category, concert_date, concert_location, country FROM konser WHERE concert_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, concertId);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            jTextFieldArtistName.setText(rs.getString("artist_name"));
            jTextFieldCategory.setText(rs.getString("category"));
            jTextFieldConcertDate.setText(rs.getString("concert_date"));
            jTextFieldLocation.setText(rs.getString("concert_location"));
            jTextFieldCountry.setText(rs.getString("country"));
        }
    } catch (SQLException ex) {
        Logger.getLogger(JDialogEdit.class.getName()).log(Level.SEVERE, null, ex);
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

        jTextFieldArtistName = new javax.swing.JTextField();
        jLabelArtist = new javax.swing.JLabel();
        jTextFieldCategory = new javax.swing.JTextField();
        jLabelCategory = new javax.swing.JLabel();
        jTextFieldConcertDate = new javax.swing.JTextField();
        jLabelConcertDate = new javax.swing.JLabel();
        jTextFieldLocation = new javax.swing.JTextField();
        jLabelLocation = new javax.swing.JLabel();
        jTextFieldCountry = new javax.swing.JTextField();
        jLabelCountry = new javax.swing.JLabel();
        jButtonSimpan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextFieldArtistName.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabelArtist.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabelArtist.setText("Nama Artist : ");

        jTextFieldCategory.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabelCategory.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabelCategory.setText("Kategori : ");

        jTextFieldConcertDate.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabelConcertDate.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabelConcertDate.setText("Tanggal Konser : ");

        jTextFieldLocation.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabelLocation.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabelLocation.setText("Lokasi Konser :");

        jTextFieldCountry.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabelCountry.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabelCountry.setText("Negara :");

        jButtonSimpan.setText("Simpan");
        jButtonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel1.setText("Edit Konser");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelCountry)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelLocation)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelConcertDate)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldConcertDate, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelCategory)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelArtist)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldArtistName, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jButtonSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(206, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(230, 230, 230))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldArtistName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelArtist))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCategory))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldConcertDate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelConcertDate))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLocation))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCountry))
                .addGap(28, 28, 28)
                .addComponent(jButtonSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimpanActionPerformed
        // TODO add your handling code here:
        // Panggil metode updateConcertData untuk melakukan penyuntingan
        updateConcertData();
    }//GEN-LAST:event_jButtonSimpanActionPerformed


    
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
            java.util.logging.Logger.getLogger(JDialogEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogEditTicket dialog = new JDialogEditTicket(new javax.swing.JFrame(), true, "", 0.0);
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
    private javax.swing.JButton jButtonSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelArtist;
    private javax.swing.JLabel jLabelCategory;
    private javax.swing.JLabel jLabelConcertDate;
    private javax.swing.JLabel jLabelCountry;
    private javax.swing.JLabel jLabelLocation;
    private javax.swing.JTextField jTextFieldArtistName;
    private javax.swing.JTextField jTextFieldCategory;
    private javax.swing.JTextField jTextFieldConcertDate;
    private javax.swing.JTextField jTextFieldCountry;
    private javax.swing.JTextField jTextFieldLocation;
    // End of variables declaration//GEN-END:variables
}