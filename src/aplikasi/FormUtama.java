/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplikasi;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

/**
 *
 * @author USER
 */
public class FormUtama extends javax.swing.JFrame {
    private DefaultTableModel model;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormUtama.class.getName());

    /**
     * Creates new form FormUtama
     */
  public FormUtama() {
    initComponents();
    setLocationRelativeTo(null);
    lblWelcome.setText("Selamat datang, " + Sesi.namaUser);
    siapkanTabel();
    updateTotalSiswa();
}

private void siapkanTabel() {
    model = new DefaultTableModel(
        new Object[]{"NIS", "Nama", "Kelas", "Alamat"}, 0) {
        @Override
        public boolean isCellEditable(int row, int col) {
            return false;
        }
    };

    tblSiswa.setModel(model);
    tampilData();
}


private void tampilData() {
    model.setRowCount(0);

    try (Connection c = Koneksi.getKoneksi();
         Statement st = c.createStatement();
         ResultSet rs = st.executeQuery("SELECT * FROM siswa")) {

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("nis"),
                rs.getString("nama"),
                rs.getString("kelas"),
                rs.getString("alamat")
            });
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
            "Gagal membaca data: " + e.getMessage());
    }
}


private void bersih() {
    txtNis.setText("");
    txtNama.setText("");
    cmbKelas.setSelectedIndex(0);
    txtAlamat.setText("");
    tblSiswa.clearSelection();
    txtNis.requestFocus();
}

private void updateTotalSiswa() {
    lblTotalSiswa.setText("Total Siswa: " + model.getRowCount());
}

private void simpanKeFile() {
    try (BufferedWriter writer = new BufferedWriter(
            new FileWriter("data_siswa.txt"))) {

        for (int i = 0; i < model.getRowCount(); i++) {
            writer.write(
                model.getValueAt(i, 0) + "\t" +
                model.getValueAt(i, 1) + "\t" +
                model.getValueAt(i, 2) + "\t" +
                model.getValueAt(i, 3)
            );
            writer.newLine();
        }

    } catch (IOException e) {
        JOptionPane.showMessageDialog(this,
            "Gagal menyimpan data: " + e.getMessage());
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblWelcome = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        lblNis = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNis = new javax.swing.JTextField();
        lblNama = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        lblKelas = new javax.swing.JLabel();
        cmbKelas = new javax.swing.JComboBox<>();
        lblAlamat = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSiswa = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        lblTotalSiswa = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblWelcome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblWelcome.setText("Selamat datang");

        btnLogout.setBackground(new java.awt.Color(255, 0, 51));
        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("LOGOUT");
        btnLogout.addActionListener(this::btnLogoutActionPerformed);

        lblNis.setText("NIS");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("DATA SISWA");

        txtNis.addActionListener(this::txtNisActionPerformed);

        lblNama.setText("Nama");

        txtNama.addActionListener(this::txtNamaActionPerformed);

        lblKelas.setText("Kelas");

        cmbKelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "X", "XI", "XII", "XIII" }));
        cmbKelas.addActionListener(this::cmbKelasActionPerformed);

        lblAlamat.setText("Alamat");

        txtAlamat.addActionListener(this::txtAlamatActionPerformed);

        btnSimpan.setBackground(new java.awt.Color(51, 204, 0));
        btnSimpan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(this::btnSimpanActionPerformed);

        btnUbah.setBackground(new java.awt.Color(204, 204, 0));
        btnUbah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUbah.setText("UBAH");
        btnUbah.addActionListener(this::btnUbahActionPerformed);

        btnHapus.setBackground(new java.awt.Color(204, 0, 0));
        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(this::btnHapusActionPerformed);

        tblSiswa.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSiswaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSiswa);

        jLabel2.setText("Cari nama");

        btnCari.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCari.setText("Temukan nama");
        btnCari.addActionListener(this::btnCariActionPerformed);

        lblTotalSiswa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotalSiswa.setText("Total siswa : 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblWelcome)
                                    .addComponent(jLabel1)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNama)
                                    .addComponent(lblNis)
                                    .addComponent(lblKelas)
                                    .addComponent(lblAlamat)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNama, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                                    .addComponent(txtNis, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                                    .addComponent(cmbKelas, 0, 281, Short.MAX_VALUE)
                                    .addComponent(txtAlamat, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                                    .addComponent(txtCari))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnCari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnUbah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTotalSiswa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWelcome)
                    .addComponent(btnLogout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNis)
                    .addComponent(txtNis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSimpan))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNama)
                    .addComponent(btnUbah))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKelas)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAlamat)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalSiswa))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int pilih = JOptionPane.showConfirmDialog(this,
                "Yakin ingin logout?", "Konfirmasi Logout",
                JOptionPane.YES_NO_OPTION);
        
        if (pilih == JOptionPane.YES_OPTION) {
            Sesi.namaUser = null;
            new FormLogin().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void txtNisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNisActionPerformed

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String nis = txtNis.getText().trim();
String nama = txtNama.getText().trim();
String kelas = cmbKelas.getSelectedItem().toString();
String alamat = txtAlamat.getText().trim();

if (nis.isEmpty() || nama.isEmpty()) {
    JOptionPane.showMessageDialog(this,
        "NIS dan Nama wajib diisi!",
        "Peringatan",
        JOptionPane.WARNING_MESSAGE);
    return;
}


    try (Connection c = Koneksi.getKoneksi();
         PreparedStatement ps = c.prepareStatement(
             "INSERT INTO siswa (nis, nama, kelas, alamat) VALUES (?, ?, ?, ?)")) {

        ps.setString(1, nis);
        ps.setString(2, nama);
        ps.setString(3, kelas);
        ps.setString(4, alamat);

        ps.executeUpdate();

        JOptionPane.showMessageDialog(this, "Data berhasil disimpan.");
        tampilData();
        bersih();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this,
            "NIS sudah terdaftar atau terjadi kesalahan!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
            "Error: " + e.getMessage());
    }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
    int baris = tblSiswa.getSelectedRow();

if (baris == -1) {
    JOptionPane.showMessageDialog(this,
        "Pilih data pada tabel terlebih dahulu!");
    return;
}

model.setValueAt(txtNis.getText().trim(), baris, 0);
model.setValueAt(txtNama.getText().trim(), baris, 1);
model.setValueAt(cmbKelas.getSelectedItem().toString(), baris, 2);
model.setValueAt(txtAlamat.getText().trim(), baris, 3);

updateTotalSiswa();
simpanKeFile();

JOptionPane.showMessageDialog(this, "Data berhasil diubah.");
bersih();
        
    }//GEN-LAST:event_btnUbahActionPerformed

    private void tblSiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSiswaMouseClicked
        int baris = tblSiswa.getSelectedRow();

if (baris == -1) {
    return;
}

txtNis.setText(model.getValueAt(baris, 0).toString());
txtNama.setText(model.getValueAt(baris, 1).toString());
cmbKelas.setSelectedItem(model.getValueAt(baris, 2).toString());
txtAlamat.setText(model.getValueAt(baris, 3).toString());
    }//GEN-LAST:event_tblSiswaMouseClicked

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        
    int baris = tblSiswa.getSelectedRow();

    if (baris == -1) {
        JOptionPane.showMessageDialog(this,
            "Pilih data pada tabel terlebih dahulu!");
        return;
    }

    int pilih = JOptionPane.showConfirmDialog(this,
        "Yakin ingin menghapus data ini?",
        "Konfirmasi Hapus",
        JOptionPane.YES_NO_OPTION);

    if (pilih == JOptionPane.YES_OPTION) {
        String nis = model.getValueAt(baris, 0).toString();

        try (Connection c = Koneksi.getKoneksi();
             PreparedStatement ps = c.prepareStatement(
                 "DELETE FROM siswa WHERE nis=?")) {

            ps.setString(1, nis);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this,
                "Data berhasil dihapus.");

            tampilData();
            bersih();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Error: " + e.getMessage());
        }
    }
   
    }//GEN-LAST:event_btnHapusActionPerformed

    private void cmbKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbKelasActionPerformed

    private void txtAlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlamatActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        String cari = txtCari.getText().trim().toLowerCase();

if (cari.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Masukkan nama yang dicari!");
    return;
}

for (int i = 0; i < model.getRowCount(); i++) {
    String nama = model.getValueAt(i, 1).toString().toLowerCase();

    if (nama.contains(cari)) {
        tblSiswa.setRowSelectionInterval(i, i);
        tblSiswa.scrollRectToVisible(
            tblSiswa.getCellRect(i, 0, true)
        );
        return;
    }
}

JOptionPane.showMessageDialog(this, "Nama siswa tidak ditemukan.");
    }//GEN-LAST:event_btnCariActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FormUtama().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> cmbKelas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAlamat;
    private javax.swing.JLabel lblKelas;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblNis;
    private javax.swing.JLabel lblTotalSiswa;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTable tblSiswa;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNis;
    // End of variables declaration//GEN-END:variables
}
