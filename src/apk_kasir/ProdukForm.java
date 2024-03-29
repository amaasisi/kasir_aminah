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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author LENOVO
 */
public class ProdukForm extends javax.swing.JFrame {
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
            new Object[] {"ID PRODUK", "NAMA PRODUK", "HARGA", "STOK",});
        tb_produk.setModel(tm);
        tm.getDataVector().removeAllElements();
        
        try{
            PreparedStatement s = con.prepareStatement("SELECT * FROM produk");
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
    

    /**
     * Creates new form PelangganForm
     */
    public ProdukForm() {
        initComponents();
        connect();
        refreshTable();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        idpro = new javax.swing.JTextField();
        hrg = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_produk = new javax.swing.JTable();
        btnsearch = new javax.swing.JButton();
        jbsearch = new javax.swing.JTextField();
        btndelete = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        stok = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Id Produk");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Nama Produk");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("Stok");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Harga");

        idpro.setBackground(new java.awt.Color(204, 204, 204));
        idpro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idpro.setForeground(new java.awt.Color(0, 51, 102));

        hrg.setBackground(new java.awt.Color(204, 204, 204));
        hrg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        hrg.setForeground(new java.awt.Color(0, 51, 102));

        nama.setBackground(new java.awt.Color(204, 204, 204));
        nama.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nama.setForeground(new java.awt.Color(0, 51, 102));

        btnsave.setBackground(new java.awt.Color(204, 204, 255));
        btnsave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnsave.setForeground(new java.awt.Color(0, 51, 102));
        btnsave.setText("SAVE");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        btnupdate.setBackground(new java.awt.Color(204, 204, 255));
        btnupdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnupdate.setForeground(new java.awt.Color(0, 51, 102));
        btnupdate.setText("UPDATE");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        tb_produk.setBackground(new java.awt.Color(204, 204, 255));
        tb_produk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_produk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_produkMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_produk);

        btnsearch.setBackground(new java.awt.Color(204, 204, 255));
        btnsearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnsearch.setForeground(new java.awt.Color(0, 51, 102));
        btnsearch.setText("SEARCH DATA PRODUK");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        jbsearch.setBackground(new java.awt.Color(204, 204, 204));
        jbsearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbsearch.setForeground(new java.awt.Color(0, 51, 102));

        btndelete.setBackground(new java.awt.Color(204, 204, 255));
        btndelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btndelete.setForeground(new java.awt.Color(0, 51, 102));
        btndelete.setText("DELETE");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btnback.setBackground(new java.awt.Color(204, 204, 255));
        btnback.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnback.setForeground(new java.awt.Color(0, 51, 102));
        btnback.setText("BACK");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        stok.setBackground(new java.awt.Color(204, 204, 204));
        stok.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        stok.setForeground(new java.awt.Color(0, 51, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA PRODUK");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jbsearch))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(idpro)
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(hrg, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stok, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(141, 141, 141))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idpro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 670, 440));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/bg_form.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -6, 850, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
    // TODO add your handling code here:
    try{
    PreparedStatement ps = con.prepareStatement("INSERT INTO produk VALUES (?,?,?,?)");
    ps.setString(1, idpro.getText());
    ps.setString(2, nama.getText());
    ps.setString(3, hrg.getText());
    ps.setString(4, stok.getText());
    ps.executeUpdate();
    JOptionPane.showMessageDialog(this,"Data telah tersimpan");
    refreshTable();   
    } catch(Exception e) {
    System.out.print("ERROR KUERI KE DATABASE:\n" + e + "\n\n");
    } 
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
    // TODO add your handling code here:
    try {
    PreparedStatement ps = con.prepareStatement(
    "UPDATE produk SET nama_produk=?, harga=?, stok=? where id_produk=?");
    
    ps.setString(1, nama.getText());
    ps.setString(2, hrg.getText());
    ps.setString(3, stok.getText());
    ps.setString(4, idpro.getText());
    ps.executeUpdate();
    JOptionPane.showMessageDialog(this,"Data telah di update");
    refreshTable();    
    } catch(Exception e) {
    System.out.print("ERROR KUERI KE DATABASE:\n" + e + "\n\n");
    }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
    // TODO add your handling code here:
    int ok = JOptionPane.showConfirmDialog(null,"Yakin mau dihapus='"+ 
        idpro.getText()+"'",".:: Konfirmasi ::.", JOptionPane.YES_NO_CANCEL_OPTION);
    if (ok==0){
    try {
    PreparedStatement ps = con.prepareStatement("DELETE FROM produk WHERE id_produk=?");
    ps.setString(1, idpro.getText());
    ps.executeUpdate();
    JOptionPane.showMessageDialog(this,"Data telah di delete");
    refreshTable(); 
    }catch(Exception e) {
    System.out.print("ERROR KUERI KE DATABASE:\n" + e + "\n\n");
    }
    }
         
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
    // TODO add your handling code here:
    tm = new DefaultTableModel (null,
        new Object[] {"id_produk","nama_produk","harga","stok"});
        tb_produk.setModel(tm);
        tm.getDataVector().removeAllElements();
        try
        {
         PreparedStatement s = con.prepareStatement("SELECT*FROM produk where nama_produk LIKE '%" + jbsearch.getText().toString() +"%'");
         ResultSet r = s.executeQuery();
         while(r.next())
         {
             Object[] data ={
             r.getString(1),
             r.getString(2),
             r.getString(3),
             r.getString(4),
             };
         tm.addRow(data);
         }
         
        }
        catch(Exception e)
        {
        System.out.print("ERROR KUERI KE DATABASE:\n" + e + "\n\n");
        }    
    }//GEN-LAST:event_btnsearchActionPerformed

    private void tb_produkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_produkMouseClicked
    // TODO add your handling code here:
    int i = tb_produk.getSelectedRow();
    if (i== -1){
        return;
    }
    String idproduk = (String) tm.getValueAt(i, 0);
    idpro.setText(idproduk);
    String namapro = (String) tm.getValueAt(i, 1);
    nama.setText(namapro);
    String harga = (String) tm.getValueAt(i, 2);
    hrg.setText(harga);
    String stokpro = (String) tm.getValueAt(i, 3);
    stok.setText(stokpro);    
    }//GEN-LAST:event_tb_produkMouseClicked

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
    // TODO add your handling code here:
    dispose();    
    }//GEN-LAST:event_btnbackActionPerformed

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
            java.util.logging.Logger.getLogger(ProdukForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdukForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdukForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdukForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProdukForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnsearch;
    private javax.swing.JButton btnupdate;
    private javax.swing.JTextField hrg;
    private javax.swing.JTextField idpro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jbsearch;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField stok;
    private javax.swing.JTable tb_produk;
    // End of variables declaration//GEN-END:variables
}
