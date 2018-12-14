/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import fabricacuscuz.dominio.Produto;
import fabricacuscuz.dominio.Receita;
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
public class ReceitaDAO {
     public void salvar(Receita receita) throws SQLException{
                Connection con = ConnectionFactory.getConexao();
        PreparedStatement stm = null;
        
  
        try {
            stm = con.prepareStatement("INSERT INTO `receita`(`ID`,`nome`, `ingredientes`, `modo_preparo`) VALUES (?,?,?,?)");
            stm.setInt(1, receita.getId());
            stm.setString(2, receita.getNome());
            stm.setString(3,receita.getIngredientes());
            stm.setString(4,receita.getModopreparo());
            stm.execute();
            
                    
                  JOptionPane.showMessageDialog(null,"Registrado com sucesso");
                  
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "erro: "+ex);
                    }
     

        
        
    }
     public List<Receita> read(){
       
       Connection con = ConnectionFactory.getConexao();
       PreparedStatement stmt = null;
       ResultSet rs = null;
       
       
       List<Receita> receitas = new ArrayList();
       
       try{
           stmt = con.prepareStatement("SELECT * FROM receita");
          rs = stmt.executeQuery();
          
          while(rs.next()){
              
              Receita r = new Receita();
              r.setId(rs.getInt("ID"));
            r.setNome(rs.getString("nome"));
            r.setIngredientes(rs.getString("ingredientes"));
            r.setModopreparo(rs.getString("modo_preparo"));
              receitas.add(r);
              
          }
       }catch (SQLException ex){
           Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE,null,ex);
           
       
       } 
        return receitas;
       
       
       
   
    
    
    
}
      public List<Receita> readForNome(String nome){
       
       Connection con = ConnectionFactory.getConexao();
       PreparedStatement stmt = null;
       ResultSet rs = null;
       
       
       List<Receita> receitas = new ArrayList();
       
       try{
           stmt = con.prepareStatement("SELECT * FROM receita WHERE nome LIKE ?");
          stmt.setString(1, "%"+nome+"%");
           rs = stmt.executeQuery();
          
          while(rs.next()){
              
           Receita r = new Receita();
           r.setNome(rs.getString("nome"));
           r.setId(rs.getInt("id"));
           r.setIngredientes(rs.getString("ingredientes"));
           r.setModopreparo(rs.getString("modo_preparo"));
              receitas.add(r);
              
          }
       }catch (SQLException ex){
           Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE,null,ex);
           
       
       } 
        return receitas;
       
       
       
   
    
    }
         public void apagar (Receita receita){
                Connection con = ConnectionFactory.getConexao();
        PreparedStatement stm = null;
        
  
        try {
            stm = con.prepareStatement("DELETE FROM `receita` WHERE ID = ?");
            
            stm.setInt(1, receita.getId());
            
            
            stm.executeUpdate();
                    
                  JOptionPane.showMessageDialog(null,"Excluído com sucesso.");
                  
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "erro ao excluir: " +ex);
                    }
     

        
        
     }
}
