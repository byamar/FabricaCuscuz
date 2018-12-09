/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import fabricacuscuz.dominio.Funcionario;
import fabricacuscuz.dominio.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Beatriz
 */
public class UsuarioDAO {
    public void salvarUsuario(Funcionario funcionario) throws SQLException{
          
                Connection con = ConnectionFactory.getConexao();
        PreparedStatement stm = null;
        
  
        try {
            stm = con.prepareStatement("INSERT INTO `usuario`(`nome`, `senha`) VALUES (?,?)");
            
            stm.setString(1, funcionario.getNome());
            stm.setString(2, funcionario.getSenha());
            stm.execute();
                    
                  JOptionPane.showMessageDialog(null,"Cadastrado com sucesso");
                  
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "erro: "+ex);
                    }
     

        
}
    public boolean checkLogin(String nome, String senha){
       
       Connection con = ConnectionFactory.getConexao();
       PreparedStatement stmt = null;
       ResultSet rs = null;
       boolean check = false;
       
       
       List<Funcionario> usuarios = new ArrayList();
       
       try{
           stmt = con.prepareStatement("SELECT * FROM usuario WHERE nome = ? and senha = ?");
          stmt.setString(1, nome);
          stmt.setString(2, senha);
           rs = stmt.executeQuery();
          
          if(rs.next()){
              
             check = true;
              
          }
       }catch (SQLException ex){
           Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE,null,ex);
           
       
       } 
        return check;
       
       
       
   
    
    
    
}
}
