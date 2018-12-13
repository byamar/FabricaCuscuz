/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricacuscuz.interfaces;

import connection.ItemCompraDAO;
import connection.ProdutoDAO;
import fabricacuscuz.dominio.Produto;
import fabricacuscuz.dominio.itemCompra;
import fabricacuscuz.dominio.itemSaida;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Beatriz
 */
public class compra extends javax.swing.JFrame {

    /**
     * Creates new form venda
     */
    public compra() {
         initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        jTable1.setRowSorter(new TableRowSorter(dtm));
        readJTable();
    }
    
    public void readJTable(){
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setNumRows(0);
        ItemCompraDAO dao = new ItemCompraDAO();
     
        
        for(itemCompra item : dao.readCompra()){
            dtm.addRow(new Object[]{
               item.getId(),
                item.getFuncionario(),
                item.getDescricao(),
                item.getQuantidade(),
                item.getPreco(),
                item.getCategoria(),
                item.getFornecedor(),
                item.getDataCompra()
                
                    
            });
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

        txtFuncionario = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        txtQuantidade = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        txtFornecedor = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        REGISTRAR = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(txtFuncionario);
        txtFuncionario.setBounds(180, 160, 110, 30);
        getContentPane().add(txtDescricao);
        txtDescricao.setBounds(410, 160, 150, 30);
        getContentPane().add(txtQuantidade);
        txtQuantidade.setBounds(750, 160, 150, 30);
        getContentPane().add(txtPreco);
        txtPreco.setBounds(980, 160, 150, 30);
        getContentPane().add(txtCategoria);
        txtCategoria.setBounds(160, 200, 160, 30);
        getContentPane().add(txtFornecedor);
        txtFornecedor.setBounds(470, 200, 390, 30);
        getContentPane().add(txtData);
        txtData.setBounds(1020, 200, 160, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "FUNCIONÁRIO", "DESCRIÇÃO", "QUANTIDADE", "PREÇO", "CATEGORIA", "FORNECEDOR", "DATA COMPRA"
            }
        ));
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 260, 1110, 490);

        REGISTRAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fabricacuscuz/imagens/registrar.jpg"))); // NOI18N
        REGISTRAR.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        REGISTRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REGISTRARActionPerformed(evt);
            }
        });
        getContentPane().add(REGISTRAR);
        REGISTRAR.setBounds(1150, 400, 170, 40);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fabricacuscuz/imagens/botaoexluir.jpg"))); // NOI18N
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1150, 330, 170, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fabricacuscuz/imagens/registrocompra_2.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1369, 768);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void REGISTRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REGISTRARActionPerformed
        
        itemCompra item = new itemCompra();
        ItemCompraDAO dao = new ItemCompraDAO();
       
       
        item.setFuncionario(txtFuncionario.getText());
        item.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
        item.setPreco(Double.parseDouble(txtPreco.getText()));
        item.setCategoria(txtCategoria.getText());
        item.setDescricao(txtDescricao.getText());
        item.setDataCompra(item.StringParaDate(txtData.getText()));
        item.setFornecedor(txtFornecedor.getText());
        
    

        
        try {
            dao.salvar(item);
            readJTable();
            txtFuncionario.setText("");
            txtQuantidade.setText("");
            txtPreco.setText("");
            txtQuantidade.setText("");
            txtCategoria.setText("");
            txtData.setText("");
            txtFornecedor.setText("");
            
           
        } catch (SQLException ex) {
            Logger.getLogger(RegistroVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
          
            
    }//GEN-LAST:event_REGISTRARActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         if (jTable1.getSelectedRow() != -1) {

            itemCompra i = new itemCompra();
            ItemCompraDAO dao = new ItemCompraDAO();

            i.setId((int) jTable1.getValueAt(jTable1.getSelectedRow(), 0));
            dao.apagar(i);
  readJTable();
            txtFuncionario.setText("");
            txtDescricao.setText("");
            txtPreco.setText("");
            txtQuantidade.setText("");
            txtCategoria.setText("");
            txtFornecedor.setText("");
            txtData.setText("");
            
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para excluir.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
         if (jTable1.getSelectedRow() != -1) {

            txtFuncionario.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
            txtDescricao.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
            txtPreco.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
            txtQuantidade.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
            txtCategoria.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());
            txtFornecedor.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString());
            txtData.setText(jTable1.getValueAt(jTable1.getSelectedRow(),7).toString());
         }
    }//GEN-LAST:event_jTable1KeyReleased

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
            java.util.logging.Logger.getLogger(compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(compra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new compra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton REGISTRAR;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtFornecedor;
    private javax.swing.JTextField txtFuncionario;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}