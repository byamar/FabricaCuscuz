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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Beatriz
 */
public class RegistroVenda extends javax.swing.JFrame {

    /**
     * Creates new form RegistroVenda
     */
    public RegistroVenda() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        jTable1.setRowSorter(new TableRowSorter(dtm));
        readJTable();
    }
    
     public void readJTable(){
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setNumRows(0);
        ProdutoDAO dao = new ProdutoDAO();
     
        
        for(itemSaida item : dao.readVenda()){
            dtm.addRow(new Object[]{
                item.getId(),
                item.getVendedor(),
                item.getDescricao(),
                item.getQuantidade(),
                item.getPreco(),
                item.getDataVenda(),
                item.getDataValidade(),
                item.getDataEntrega(),
                item.getDistribuidora(),
                
                    
                    
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

        txtVendedor = new javax.swing.JTextField();
        txtQuantidade = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        txtDataValidade = new javax.swing.JTextField();
        txtDataEntreg = new javax.swing.JTextField();
        txtDistribuidora = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        botaoRegistrar = new javax.swing.JButton();
        txtDataVenda = new javax.swing.JTextField();
        botaoVoltar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        txtDescricao = new javax.swing.JTextField();
        labelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().add(txtVendedor);
        txtVendedor.setBounds(140, 140, 190, 30);

        txtQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantidadeActionPerformed(evt);
            }
        });
        getContentPane().add(txtQuantidade);
        txtQuantidade.setBounds(950, 140, 110, 30);
        getContentPane().add(txtPreco);
        txtPreco.setBounds(1160, 140, 130, 30);
        getContentPane().add(txtDataValidade);
        txtDataValidade.setBounds(570, 180, 190, 30);
        getContentPane().add(txtDataEntreg);
        txtDataEntreg.setBounds(980, 180, 160, 30);

        txtDistribuidora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDistribuidoraActionPerformed(evt);
            }
        });
        getContentPane().add(txtDistribuidora);
        txtDistribuidora.setBounds(190, 210, 360, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "VENDEDOR", "DESCRIÇÃO", "QUANTIDADE", "PREÇO", "DATA VENDA", "DATA VALIDADE", "DATA ENTREGA", "DISTRIBUIDORA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 260, 1120, 540);

        botaoRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fabricacuscuz/imagens/registrar.jpg"))); // NOI18N
        botaoRegistrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoRegistrar);
        botaoRegistrar.setBounds(1150, 360, 170, 40);
        getContentPane().add(txtDataVenda);
        txtDataVenda.setBounds(150, 180, 190, 30);

        botaoVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fabricacuscuz/imagens/left-pointing-arrow.png"))); // NOI18N
        botaoVoltar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoVoltar);
        botaoVoltar.setBounds(1290, 30, 40, 40);

        excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fabricacuscuz/imagens/botaoexluir.jpg"))); // NOI18N
        excluir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });
        getContentPane().add(excluir);
        excluir.setBounds(1150, 280, 175, 40);
        getContentPane().add(txtDescricao);
        txtDescricao.setBounds(480, 140, 320, 30);

        labelFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fabricacuscuz/imagens/registrodevenda_6.jpg"))); // NOI18N
        getContentPane().add(labelFundo);
        labelFundo.setBounds(-1, 0, 1370, 768);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantidadeActionPerformed

    private void botaoRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRegistrarActionPerformed

        itemSaida item = new itemSaida();
        ProdutoDAO dao = new ProdutoDAO();
       
       
        item.setVendedor(txtVendedor.getText());
        item.setDescricao(txtDescricao.getText());
        item.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
        item.setPreco(Double.parseDouble(txtPreco.getText()));
        item.setDataEntrega(item.StringParaDate(txtDataEntreg.getText()));
        item.setDataVenda(item.StringParaDate(txtDataVenda.getText()));
        item.setDataValidade(item.StringParaDate(txtDataValidade.getText()));
        item.setDistribuidora(txtDistribuidora.getText());

    

        
        try {
            dao.registrarVenda(item);
            readJTable();
            txtVendedor.setText("");
            txtQuantidade.setText("");
            txtPreco.setText("");
            txtQuantidade.setText("");
            txtDataVenda.setText("");
            txtDataEntreg.setText("");
            txtDataValidade.setText("");
            txtDescricao.setText("");
            txtDistribuidora.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(RegistroVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
          
            
           
       
    }//GEN-LAST:event_botaoRegistrarActionPerformed

    private void txtDistribuidoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDistribuidoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDistribuidoraActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        // TODO add your handling code here:
        new TelaPrincipal().setVisible(true);
        dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
                if (jTable1.getSelectedRow() != -1) {

            itemSaida i = new itemSaida();
            ProdutoDAO dao = new ProdutoDAO();

            i.setId((int) jTable1.getValueAt(jTable1.getSelectedRow(), 0));
            dao.apagarItem(i);
  readJTable();
            txtVendedor.setText("");
            txtDescricao.setText("");
            txtPreco.setText("");
            txtQuantidade.setText("");
            txtDataVenda.setText("");
            txtDistribuidora.setText("");
            txtDataEntreg.setText("");
            txtDataValidade.setText("");
                         readJTable();

            
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para excluir.");
        }
    }//GEN-LAST:event_excluirActionPerformed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
         if (jTable1.getSelectedRow() != -1) {

            txtVendedor.setText(jTable1.getValueAt(jTable1.getSelectedRow(),1).toString());
            txtDescricao.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
            txtPreco.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
            txtQuantidade.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
            txtDataVenda.setText(jTable1.getValueAt(jTable1.getSelectedRow(),5).toString());
            txtDataValidade.setText(jTable1.getValueAt(jTable1.getSelectedRow(),6).toString());
            txtDataEntreg.setText(jTable1.getValueAt(jTable1.getSelectedRow(),7).toString());
         txtDistribuidora.setText(jTable1.getValueAt(jTable1.getSelectedRow(),8).toString());
            

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
            java.util.logging.Logger.getLogger(RegistroVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoRegistrar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JButton excluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelFundo;
    private javax.swing.JTextField txtDataEntreg;
    private javax.swing.JTextField txtDataValidade;
    private javax.swing.JTextField txtDataVenda;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtDistribuidora;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtVendedor;
    // End of variables declaration//GEN-END:variables
}
