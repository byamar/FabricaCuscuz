/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricacuscuz.interfaces;

import connection.ProdutoDAO;
import connection.UsuarioDAO;
import fabricacuscuz.dominio.Funcionario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Beatriz
 */
public class CadastrarUsuario extends javax.swing.JFrame {

    /**
     * Creates new form CadastrarUsuario
     */
    public CadastrarUsuario() {
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

        txtNome = new javax.swing.JTextField();
        Senha = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        labelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(605, 626));
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().add(txtNome);
        txtNome.setBounds(160, 250, 360, 40);
        getContentPane().add(Senha);
        Senha.setBounds(170, 390, 350, 40);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fabricacuscuz/imagens/botaocadastrar.jpg"))); // NOI18N
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setPreferredSize(new java.awt.Dimension(201, 47));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(380, 457, 170, 40);

        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fabricacuscuz/imagens/icon (1).png"))); // NOI18N
        sair.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        getContentPane().add(sair);
        sair.setBounds(520, 60, 37, 40);

        labelFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fabricacuscuz/imagens/cadastrarusuario.jpg"))); // NOI18N
        labelFundo.setMaximumSize(new java.awt.Dimension(650, 626));
        labelFundo.setMinimumSize(null);
        getContentPane().add(labelFundo);
        labelFundo.setBounds(0, -30, 780, 630);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        UsuarioDAO dao = new UsuarioDAO();
        Funcionario f = new Funcionario();
        f.setNome(txtNome.getText());
        f.setSenha(Senha.getText());
        try {
            dao.salvarUsuario(f);
            txtNome.setText("");
            Senha.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        // TODO add your handling code here:
        Tela1 t = new Tela1();
        t.setVisible(true);
        dispose();
    }//GEN-LAST:event_sairActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Senha;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel labelFundo;
    private javax.swing.JButton sair;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
