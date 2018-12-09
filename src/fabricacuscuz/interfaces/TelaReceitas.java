/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricacuscuz.interfaces;

import connection.ProdutoDAO;
import connection.ReceitaDAO;
import fabricacuscuz.dominio.Produto;
import fabricacuscuz.dominio.Receita;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Beatriz
 */
public class TelaReceitas extends javax.swing.JFrame {

    /**
     * Creates new form TelaReceitas
     */
    public TelaReceitas() {
        initComponents();
         this.setExtendedState(MAXIMIZED_BOTH);
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        jTable1.setRowSorter(new TableRowSorter(dtm));
        readJTable();

    }
    public void readJTable(){
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setNumRows(0);
        ReceitaDAO dao = new ReceitaDAO();
        
        for(Receita receita : dao.read()){
            dtm.addRow(new Object[]{
                receita.getNome(),
                receita.getIngredientes(),
                receita.getModopreparo()
                    
            });
            
            
        }
    }
      public void readjTableForNome(String nome){
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setNumRows(0);
        ReceitaDAO dao = new ReceitaDAO();
        
        for(Receita receita : dao.readForNome(nome)){
            dtm.addRow(new Object[]{
                receita.getNome(),
                receita.getIngredientes(),
                receita.getModopreparo()
                    
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

        botaoSair = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textModo = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        textIngre = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        registrar = new javax.swing.JButton();
        txtBusca = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        botaoSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fabricacuscuz/imagens/left-pointing-arrow.png"))); // NOI18N
        botaoSair.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });
        getContentPane().add(botaoSair);
        botaoSair.setBounds(1280, 20, 40, 40);
        getContentPane().add(txtNome);
        txtNome.setBounds(220, 150, 200, 30);

        textModo.setColumns(20);
        textModo.setRows(5);
        jScrollPane1.setViewportView(textModo);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(820, 190, 460, 150);

        textIngre.setColumns(20);
        textIngre.setRows(5);
        jScrollPane2.setViewportView(textIngre);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(430, 190, 380, 150);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "NOME", "INGREDIENTES", "MODO PREPARO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable1);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(50, 350, 1110, 420);

        registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fabricacuscuz/imagens/botaoregistrarreceita.jpg"))); // NOI18N
        registrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });
        getContentPane().add(registrar);
        registrar.setBounds(1180, 410, 170, 60);
        getContentPane().add(txtBusca);
        txtBusca.setBounds(0, 230, 240, 40);

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fabricacuscuz/imagens/buscar.jpg"))); // NOI18N
        buscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        getContentPane().add(buscar);
        buscar.setBounds(250, 230, 170, 45);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fabricacuscuz/imagens/telareceitas_4.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1370, 770);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_botaoSairActionPerformed

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        ReceitaDAO dao = new ReceitaDAO();
        Receita r = new Receita();
        r.setNome(txtNome.getText());
        r.setIngredientes(textIngre.getText());
        r.setModopreparo(textModo.getText());
        
        try {
            dao.salvar(r);
             readJTable();
             textIngre.setText("");
             textModo.setText("");
             txtNome.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(TelaReceitas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_registrarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        readjTableForNome(txtBusca.getText());
    }//GEN-LAST:event_buscarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaReceitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaReceitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaReceitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaReceitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaReceitas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoSair;
    private javax.swing.JButton buscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton registrar;
    private javax.swing.JTextArea textIngre;
    private javax.swing.JTextArea textModo;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
