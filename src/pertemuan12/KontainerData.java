/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pertemuan12;

import com.sun.jdi.connect.spi.Connection;
import java.awt.List;
import java.beans.Statement;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author LENOVO
 */
public class KontainerData extends javax.swing.JFrame {

    java.sql.Connection conn;
    java.sql.Statement stmt;
    PreparedStatement pstmt = null;
    String Driver = "org.postgresql.Driver";
    String DB_URL = "jdbc:postgresql://localhost:5432/PBO12";
    String USER = "postgres";
    String PASS = "300106";

    private EntityManagerFactory emf;
    private EntityManager em;
    String absen, nama, walkel, walmur, idkelas;
    String jurusan;

    public KontainerData() {
        initComponents();
        initJPA();
        tampilDatasiswa();
        tampilDataKelas();

        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jTable3.getSelectedRow();

                absen = jTable3.getValueAt(row, 0).toString();
                nama = jTable3.getValueAt(row, 1).toString();
                walkel = jTable3.getValueAt(row, 2).toString();
                walmur = jTable3.getValueAt(row, 3).toString();

            }
        });

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jTable1.getSelectedRow();

                idkelas = jTable1.getValueAt(row, 0).toString();
                nama = jTable1.getValueAt(row, 1).toString();
                jurusan = jTable1.getValueAt(row, 2).toString();
            }
        });
    }

    private void initJPA() {
        emf = Persistence.createEntityManagerFactory("Pertemuan12PU");
        em = emf.createEntityManager();
    }

    private void tampilDatasiswa() {
        EntityManager em = emf.createEntityManager();
        try {
            java.util.List<Datasiswa> datalist = em.createQuery("SELECT d FROM Datasiswa d ORDER BY d.absen", Datasiswa.class).getResultList();

            // Buat model tabel dengan kolom yang sesuai
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Absen");
            model.addColumn("Nama");
            model.addColumn("Wali Kelas");
            model.addColumn("Wali Murid");
            model.addColumn("Nama Kelas");

            model.setRowCount(0); // hapus semua baris lama

            for (Datasiswa p : datalist) {
                model.addRow(new Object[]{
                    p.getAbsen(),
                    p.getNama(),
                    p.getWaliKelas(),
                    p.getWaliMurid(),
                    p.getIdKelas() != null ? p.getIdKelas().getNamaKelas() : "" // Cek null untuk idKelas
                });
            }

            jTable3.setModel(model); // Set model ke jTable3

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void tampilDataKelas() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Kelas");
        model.addColumn("Nama Kelas");
        model.addColumn("Jurusan");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pertemuan12PU");
        EntityManager em = emf.createEntityManager();

        try {
            java.util.List<Kelas> dataList = em.createQuery("SELECT k FROM Kelas k ORDER BY k.idKelas ASC", Kelas.class).getResultList();

            for (Kelas k : dataList) {
                model.addRow(new Object[]{
                    k.getIdKelas(),
                    k.getNamaKelas(),
                    k.getJurusan()
                });
            }

            jTable1.setModel(model);
        } finally {
            em.close();
            emf.close();
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ABSEN", "NAMA", "WALI KELAS", "WALI MURID"
            }
        ));
        jScrollPane1.setViewportView(jTable3);

        jButton1.setText("INSERT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("UPLOAD");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("CETAK");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton11.setText("DOWNLOAD");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(47, 47, 47)
                        .addComponent(jButton2)
                        .addGap(33, 33, 33)
                        .addComponent(jButton3)
                        .addGap(34, 34, 34)
                        .addComponent(jButton4)
                        .addGap(34, 34, 34)
                        .addComponent(jButton5)))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(jButton11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addComponent(jButton11)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DATASISWA", jPanel1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID KELAS", "NAMA KELAS", "JURUSAN"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jButton6.setText("INSERT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("UPDATE");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("DELETE");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("UPLOAD");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("CETAK");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton12.setText("DOWNLOAD");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(27, 27, 27)
                .addComponent(jButton7)
                .addGap(27, 27, 27)
                .addComponent(jButton8)
                .addGap(27, 27, 27)
                .addComponent(jButton9)
                .addGap(27, 27, 27)
                .addComponent(jButton10)
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton12)
                .addGap(233, 233, 233))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton9)
                        .addComponent(jButton10)
                        .addComponent(jButton6)
                        .addComponent(jButton8)))
                .addGap(18, 18, 18)
                .addComponent(jButton12)
                .addGap(10, 10, 10))
        );

        jTabbedPane1.addTab("KELAS", jPanel2);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SDN NEGERI 99");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        JasperReport reports;
        String path = ".\\src\\Pertemuan12\\Kelasreport.jasper";

        try {
            Class.forName(Driver);
            java.sql.Connection conn = java.sql.DriverManager.getConnection(DB_URL, USER, PASS);
            reports = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(path, null, conn);
            JasperViewer jviewer = new JasperViewer(jprint, false);
            jviewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jviewer.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(Datasiswa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Datasiswa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Datasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        InsertDatasiswa dialog = new InsertDatasiswa(this, true);
        dialog.setLocationRelativeTo(this); // posisi di tengah JFrame
        dialog.setVisible(true); // tampilkan dialog
        tampilDatasiswa();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int row = jTable3.getSelectedRow();
        System.out.println("Selected row: " + row); // Debug

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin diupdate terlebih dahulu!");
            return;
        }

        try {
            String absen = jTable3.getValueAt(row, 0).toString();
            String nama = jTable3.getValueAt(row, 1).toString();
            String walkel = jTable3.getValueAt(row, 2).toString();
            String walmur = jTable3.getValueAt(row, 3).toString();
            String idkelas = jTable3.getValueAt(row, 4).toString();

            System.out.println("Data selected - Absen: " + absen + ", Nama: " + nama); // Debug

            UpdateDatasiswa dialog = new UpdateDatasiswa(this, true, absen, nama, walkel, walmur, idkelas);
            dialog.setVisible(true);
            tampilDatasiswa();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error mengambil data: " + e.getMessage());
            e.printStackTrace();
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row = jTable3.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data dulu di tabel!");
            return;
        }

        String absen = jTable3.getValueAt(row, 0).toString();
        String nama = jTable3.getValueAt(row, 1).toString();
        String walkel = jTable3.getValueAt(row, 2).toString();
        String walmur = jTable3.getValueAt(row, 3).toString();
        String idkelas = jTable3.getValueAt(row, 4).toString();

        DeleteDatasiswa dialog = new DeleteDatasiswa(this, true, absen, nama, walkel, walmur, idkelas);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
        tampilDatasiswa();


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {

                EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pertemuan12PU");
                EntityManager em = emf.createEntityManager();

                em.getTransaction().begin();

                String line;
                while ((line = br.readLine()) != null) {

                    // Lewati baris kosong
                    if (line.trim().isEmpty()) {
                        continue;
                    }
                    // Pisahkan data berdasarkan koma
                    String[] data = line.split(",");

                    if (data.length == 5) {
                        try {
                            String absen = data[0].trim();
                            String nama = data[1].trim();
                            String walkel = data[2].trim();
                            String walmur = data[3].trim();
                            String idkelas = data[4].trim();

                            Kelas kelas = em.find(Kelas.class, idkelas);
                            if (kelas == null) {

                                // BATALKAN TRANSAKSI LANGSUNG
                                em.getTransaction().rollback();
                                em.close();
                                emf.close();

                                JOptionPane.showMessageDialog(this,
                                        "Upload gagal!\nID kelas tidak ditemukan: " + idkelas,
                                        "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }

                            Datasiswa siswa = new Datasiswa(absen);
                            siswa.setNama(nama);
                            siswa.setWaliKelas(walkel);
                            siswa.setWaliMurid(walmur);
                            siswa.setIdKelas(kelas);

                            em.persist(siswa);

                        } catch (NumberFormatException e) {
                            System.out.println("Format angka salah, dilewati: " + line);
                        }
                    } else {
                        System.out.println("Format kolom tidak sesuai: " + line);
                    }
                }

                em.getTransaction().commit();
                em.close();
                emf.close();

                tampilDatasiswa();
                JOptionPane.showMessageDialog(this, "File berhasil diupload via JPA!");

            } catch (IOException e) {
                JOptionPane.showMessageDialog(this,
                        "Gagal membaca file: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Upload dibatalkan.");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        InsertKelas dialog = new InsertKelas(this, true); // true = modal
        dialog.setLocationRelativeTo(this); // supaya muncul di tengah
        dialog.setVisible(true);
        tampilDataKelas();

    }//GEN-LAST:event_jButton6ActionPerformed


    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int row = jTable1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data kelas yang ingin diupdate terlebih dahulu!");
            return;
        }

        try {
            // Ambil data dari tabel kelas
            String idKelas = jTable1.getValueAt(row, 0).toString();
            String namaKelas = jTable1.getValueAt(row, 1).toString();
            String jurusan = jTable1.getValueAt(row, 2).toString();

            // Debug
            System.out.println("Data yang akan diupdate:");
            System.out.println("ID Kelas: " + idKelas);
            System.out.println("Nama Kelas: " + namaKelas);
            System.out.println("Jurusan: " + jurusan);

            // Buka dialog update dengan data yang dipilih
            UpdateKelas dialog = new UpdateKelas(this, true, idKelas, namaKelas, jurusan);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);

            // Refresh tabel setelah update
            tampilDataKelas();
            tampilDatasiswa();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error mengambil data kelas: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {

                EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pertemuan12PU");
                EntityManager em = emf.createEntityManager();

                em.getTransaction().begin();

                String line;
                while ((line = br.readLine()) != null) {

                    if (line.trim().isEmpty()) {
                        continue; // skip baris kosong
                    }
                    // CSV dipisah koma
                    String[] data = line.split(",");

                    if (data.length == 3) {
                        String idKelas = data[0].trim();
                        String namaKelas = data[1].trim();
                        String jurusan = data[2].trim();

                        Kelas kelas = new Kelas();
                        kelas.setIdKelas(idKelas);
                        kelas.setNamaKelas(namaKelas);
                        kelas.setJurusan(jurusan);

                        em.persist(kelas);

                    } else {
                        System.out.println("Format kolom tidak sesuai: " + line);
                    }
                }

                em.getTransaction().commit();
                em.close();
                emf.close();

                JOptionPane.showMessageDialog(this, "File Kelas berhasil diupload via JPA!");
                tampilDataKelas();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this,
                        "Gagal membaca file: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Upload dibatalkan.");
        }

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        int row = jTable1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data dulu di tabel!");
            return;
        }

        String idkelas = jTable1.getValueAt(row, 0).toString();
        String nama = jTable1.getValueAt(row, 1).toString();
        String jurusan = jTable1.getValueAt(row, 2).toString();

        DeleteKelas dialog = new DeleteKelas(this, true, idkelas, nama, jurusan);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
        tampilDataKelas();
        tampilDatasiswa();

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JasperReport reports;
        String path = ".\\src\\Pertemuan12\\Datasiswa.jasper";

        try {
            Class.forName(Driver);
            java.sql.Connection conn = java.sql.DriverManager.getConnection(DB_URL, USER, PASS);
            reports = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(path, null, conn);
            JasperViewer jviewer = new JasperViewer(jprint, false);
            jviewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jviewer.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(Datasiswa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Datasiswa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Datasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(new File("data_siswa.csv"));

        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pertemuan12PU");
            EntityManager em = emf.createEntityManager();

            try (FileWriter fw = new FileWriter(file)) {

                // Header
                // Query data siswa
                java.util.List<Datasiswa> list = em.createQuery("SELECT d FROM Datasiswa d ORDER BY d.absen", Datasiswa.class).getResultList();

                for (Datasiswa d : list) {

                    // VALIDASI: kalau kelas NULL → tampilkan error dan hentikan export
                    if (d.getIdKelas() == null) {
                        JOptionPane.showMessageDialog(this,
                                "Gagal export!\nID kelas tidak ditemukan untuk siswa: "
                                + d.getNama() + "\nMohon periksa tabel kelas.");
                        return; // stop seluruh proses
                    }

                    // Tulis CSV
                    fw.write(
                            d.getAbsen() + ","
                            + d.getNama() + ","
                            + d.getWaliKelas() + ","
                            + d.getWaliMurid() + ","
                            + d.getIdKelas().getIdKelas() + "\n"
                    );
                }

                JOptionPane.showMessageDialog(this, "Data siswa berhasil disimpan!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gagal export siswa: " + e.getMessage());
            } finally {
                em.close();
                emf.close();

            }
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed

        JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(new File("data_kelas.csv"));

        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pertemuan12PU");
            EntityManager em = emf.createEntityManager();

            try (FileWriter fw = new FileWriter(file)) {

                // Header
                // Query data kelas
                java.util.List<Kelas> list = em.createQuery("SELECT k FROM Kelas k ORDER BY k.idKelas ASC", Kelas.class).getResultList();

                for (Kelas k : list) {
                    fw.write(k.getIdKelas() + ","
                            + k.getNamaKelas() + ","
                            + k.getJurusan() + "\n");
                }

                JOptionPane.showMessageDialog(this, "Data kelas berhasil disimpan!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Gagal export kelas: " + e.getMessage());
            } finally {
                em.close();
                emf.close();
            }
        }


    }//GEN-LAST:event_jButton12ActionPerformed

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
            java.util.logging.Logger.getLogger(KontainerData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KontainerData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KontainerData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KontainerData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KontainerData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
