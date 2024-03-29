/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apk_kasir;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class PenjualanForm extends javax.swing.JFrame {
    Connection con;
    DefaultTableModel tm;
    
    private void connect(){
        con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kasir_anggie", "root", "");
        }catch(Exception e){
            System.out.print("ERROR KUERI KE DATABASE:\n" + e );
        }
    }
     
    private void refreshTable(){
        tm = new DefaultTableModel(
            null,
            new Object[] {"ID PENJUALAN", "TANGGAL PENJUALAN", "TOTAL HARGA", "ID PELANGGAN",});
        tb_penjualan.setModel(tm);
        tm.getDataVector().removeAllElements();
        
        try{
            PreparedStatement s = con.prepareStatement("SELECT * FROM penjualan");
            ResultSet r = s.executeQuery();
            while(r.next()){
                Object[] data = {
                    r.getString(1),
                    r.getString(2),
                    r.getString(3),
                    r.getString(4)
                };
                tm.addRow(data);
            }
        }catch(Exception e){
            System.out.print("ERROR KUERI KE DATABASE:\n" + e + "\n\n");
        }
    }
    
    private void id_otomatis(){
    try {
        Connection c = con;
        Statement s = c.createStatement();
        String sql = "SELECT * FROM penjualan ORDER BY id_penjualan DESC";
        ResultSet r = s.executeQuery(sql);
        if (r.next()){
            String No = r.getString("id_penjualan");
            String otomatis = "" +(Integer.parseInt(No)+1);
            idpen.setText(otomatis);
        } else {
            idpen.setText("1");
        }
        r.close();
        s.close();
    }catch (Exception e) {
        System.out.println("autonumber error");
    }
}
    
    
    public void cbidpelanggan(){
try {
PreparedStatement s = con.prepareStatement("SELECT*FROM pelanggan");
ResultSet r = s.executeQuery();
    while (r.next()) {                
    cbidpel.addItem(r.getString("nama_pelanggan"));
    }
} catch (SQLException e) {
}
}
    public void tanggal(){
        Date now = new Date();
        jtgl.setDate((now));
    }
    
      /**
     * Creates new form PelangganForm
     */
    public PenjualanForm() {
        initComponents();
        connect();
        id_otomatis();
        cbidpelanggan();
        refreshTable();
        tanggal();
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        idpen = new javax.swing.JTextField();
        simpan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_penjualan = new javax.swing.JTable();
        hapus = new javax.swing.JButton();
        kembali = new javax.swing.JButton();
        cbidpel = new javax.swing.JComboBox<>();
        txtidpel = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        hrg = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        byr = new javax.swing.JTextField();
        ttl_hrg = new javax.swing.JTextField();
        subtotal = new javax.swing.JTextField();
        jmlh = new javax.swing.JTextField();
        nmbrg = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tambah = new javax.swing.JButton();
        kembalian1 = new javax.swing.JTextField();
        total1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtgl = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        iddetail = new javax.swing.JTextField();
        idpro = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Id Penjualan");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("Harga");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Total Harga");

        idpen.setBackground(new java.awt.Color(204, 204, 204));
        idpen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idpen.setForeground(new java.awt.Color(0, 51, 102));
        idpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idpenActionPerformed(evt);
            }
        });

        simpan.setBackground(new java.awt.Color(204, 204, 255));
        simpan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        simpan.setForeground(new java.awt.Color(0, 51, 102));
        simpan.setText("SAVE");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        tb_penjualan.setBackground(new java.awt.Color(204, 204, 255));
        tb_penjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_penjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_penjualanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_penjualan);

        hapus.setBackground(new java.awt.Color(204, 204, 255));
        hapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        hapus.setForeground(new java.awt.Color(0, 51, 102));
        hapus.setText("DELETE");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        kembali.setBackground(new java.awt.Color(204, 204, 255));
        kembali.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        kembali.setForeground(new java.awt.Color(0, 51, 102));
        kembali.setText("BACK");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });

        cbidpel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbidpelMouseClicked(evt);
            }
        });
        cbidpel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbidpelActionPerformed(evt);
            }
        });
        cbidpel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbidpelKeyPressed(evt);
            }
        });

        txtidpel.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GIE BEAUTY STORE");

        hrg.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Id Pelanggan");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("Jumlah");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("Kembalian");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 153));
        jLabel10.setText("Bayar");

        byr.setBackground(new java.awt.Color(204, 204, 204));
        byr.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        byr.setForeground(new java.awt.Color(0, 51, 102));

        ttl_hrg.setBackground(new java.awt.Color(204, 204, 204));
        ttl_hrg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ttl_hrg.setForeground(new java.awt.Color(0, 51, 102));

        subtotal.setBackground(new java.awt.Color(255, 153, 153));
        subtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subtotalActionPerformed(evt);
            }
        });

        jmlh.setBackground(new java.awt.Color(204, 204, 204));

        nmbrg.setBackground(new java.awt.Color(204, 204, 204));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 153));
        jLabel11.setText("Nama Barang");

        tambah.setBackground(new java.awt.Color(204, 204, 255));
        tambah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tambah.setForeground(new java.awt.Color(0, 51, 102));
        tambah.setText("ADD");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        kembalian1.setEnabled(false);

        total1.setBackground(new java.awt.Color(204, 204, 204));
        total1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                total1ActionPerformed(evt);
            }
        });
        total1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                total1KeyPressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 153));
        jLabel12.setText("total");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kembalian1)
                            .addComponent(byr, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(ttl_hrg, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                        .addGap(125, 125, 125))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 887, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(hapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(kembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(idpen, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtgl, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(cbidpel, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtidpel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel6))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nmbrg, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(hrg, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jmlh, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12)
                                        .addComponent(total1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(idpen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12))
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtidpel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbidpel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(hrg, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nmbrg, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jmlh, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(total1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(131, 131, 131)
                                        .addComponent(tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(kembali, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 40, Short.MAX_VALUE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(ttl_hrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(byr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(kembalian1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))))
                        .addGap(49, 49, 49))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jtgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 1000, 630));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/bg form2.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 770));

        iddetail.setText("jTextField1");
        getContentPane().add(iddetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 740, -1, -1));

        idpro.setText("jTextField1");
        getContentPane().add(idpro, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 740, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
    // TODO add your handling code here:
    String Tampilan="yyyy-MM-dd";
    SimpleDateFormat fm=new SimpleDateFormat(Tampilan);
    String tglbyr=String.valueOf(fm.format(jtgl.getDate()));
    try {
    Connection c = con;
    int baris = tb_penjualan.getRowCount();
    for ( int a = 0; a < baris; a++) {
    id_otomatis();
    PreparedStatement ps = con.prepareStatement("INSERT INTO penjualan VALUES (?,?,?,?)");
    ps.setString(1, idpen.getText());
    ps.setString(2, tglbyr);
    ps.setString(3, ttl_hrg.getText());
    ps.setString(4, txtidpel.getText());
    ps.executeUpdate();
   JOptionPane.showMessageDialog(this,"Data telah tersimpan");
   }
    } catch(Exception e) {
    System.out.print("ERROR KUERI KE DATABASE:\n" + e + "\n\n");
    }
    }//GEN-LAST:event_simpanActionPerformed

    private void cbidpelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbidpelActionPerformed
    // TODO add your handling code here:
    try {
        PreparedStatement s = con.prepareStatement("SELECT*FROM pelanggan where "
        + "nama_pelanggan='" + cbidpel.getSelectedItem().toString() + "'");
        ResultSet r = s.executeQuery();
        while (r.next()) { 
        txtidpel.setText(r.getString("id_pelanggan"));
        }
        } catch (SQLException e) {
        
        }    
    }//GEN-LAST:event_cbidpelActionPerformed

    private void cbidpelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbidpelKeyPressed
    // TODO add your handling code here:    
    }//GEN-LAST:event_cbidpelKeyPressed

    private void cbidpelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbidpelMouseClicked
    // TODO add your handling code here:    
    }//GEN-LAST:event_cbidpelMouseClicked

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
    // TODO add your handling code here:
    int ok = JOptionPane.showConfirmDialog(null,"Yakin mau dihapus='"+ 
        idpen.getText()+"'",".:: Konfirmasi ::.", JOptionPane.YES_NO_CANCEL_OPTION);
    if (ok==0){
    try {
    PreparedStatement ps = con.prepareStatement("DELETE FROM penjualan WHERE id_penjualan=?");
    ps.setString(1, idpen.getText());
    ps.executeUpdate();
    JOptionPane.showMessageDialog(this,"Data telah di delete");
    refreshTable(); 
    }catch(Exception e) {
    System.out.print("ERROR KUERI KE DATABASE:\n" + e + "\n\n");
    }
    }    
    }//GEN-LAST:event_hapusActionPerformed

    private void tb_penjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_penjualanMouseClicked
    // TODO add your handling code here:
    int i = tb_penjualan.getSelectedRow();
    if (i== -1){
        return;
    }
    String id_pen = (String) tm.getValueAt(i, 0);
    idpen.setText(id_pen);
    String tgl = (String) tm.getValueAt(i, 1);
    jtgl.setDateFormatString (tgl);
    String ttl = (String) tm.getValueAt(i, 2);
    ttl_hrg.setText(ttl);
    String idpel = (String) tm.getValueAt(i, 3);
    cbidpel.setSelectedItem (idpel);

    }//GEN-LAST:event_tb_penjualanMouseClicked

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
    // TODO add your handling code here:
    dispose();    
    }//GEN-LAST:event_kembaliActionPerformed

    private void subtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subtotalActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
    // TODO add your handling code here:
    int i =tb_penjualan.getSelectedRow();
            String harga= (String) tm.getValueAt(i, 2);
            int Total= Integer.parseInt(harga);
            int jumlah=Integer.parseInt(jmlh.getText());
            int hasil=Total*jumlah;
            DefaultTableModel model = (DefaultTableModel) tb_penjualan.getModel();
            model.addRow(new Object []{
            iddetail.getText(),idpen.getText(),idpro.getText(),jmlh.getText(),total1.getText(),
            tb_penjualan.getValueAt(i,0)});        
    }//GEN-LAST:event_tambahActionPerformed

    private void idpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idpenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idpenActionPerformed

    private void total1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_total1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_total1ActionPerformed

    private void total1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_total1KeyPressed
    // TODO add your handling code here:
    
        
    }//GEN-LAST:event_total1KeyPressed

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
            java.util.logging.Logger.getLogger(PenjualanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PenjualanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PenjualanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PenjualanForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PenjualanForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField byr;
    private javax.swing.JComboBox<String> cbidpel;
    private javax.swing.JButton hapus;
    private javax.swing.JTextField hrg;
    private javax.swing.JTextField iddetail;
    private javax.swing.JTextField idpen;
    private javax.swing.JTextField idpro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jmlh;
    private com.toedter.calendar.JDateChooser jtgl;
    private javax.swing.JButton kembali;
    private javax.swing.JTextField kembalian1;
    private javax.swing.JTextField nmbrg;
    private javax.swing.JButton simpan;
    private javax.swing.JTextField subtotal;
    private javax.swing.JButton tambah;
    private javax.swing.JTable tb_penjualan;
    private javax.swing.JTextField total1;
    private javax.swing.JTextField ttl_hrg;
    private javax.swing.JTextField txtidpel;
    // End of variables declaration//GEN-END:variables
}
