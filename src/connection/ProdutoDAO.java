/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;


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
public class ProdutoDAO extends GeralDAO{
    
    public void salvar(Produto produto) throws SQLException{
                Connection con = ConnectionFactory.getConexao();
        PreparedStatement stm = null;
        
  
        try {
            stm = con.prepareStatement("INSERT INTO `produto`( `Nome`, `Descricao`, `preco`, `quantidade`, `categoria`) VALUES (?,?,?,?,?)");
            
            stm.setString(1, produto.getNome());
            stm.setString(2,produto.getDescricao());     
            stm.setInt(3, produto.getQuantidade());
            stm.setDouble(4, produto.getPreco());
            stm.setString(5, produto.getCategoria());
            
            stm.execute();
                    
                  JOptionPane.showMessageDialog(null,"Salvo com sucesso");
                  
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "erro: "+ex);
                    }
     

        
        
    }
     public void update (Produto produto){
                Connection con = ConnectionFactory.getConexao();
        PreparedStatement stm = null;
        
  
        try {
            stm = con.prepareStatement("UPDATE `produto` SET `Nome`= ?,`Descricao`= ?,`preco`= ?,`quantidade`= ? `ID` = ?  WHERE ID = ?");
            
            stm.setString(1, produto.getNome());
            stm.setString(2,produto.getDescricao());     
            stm.setInt(3, produto.getQuantidade());
            stm.setDouble(4, produto.getPreco());
            stm.setInt(5, produto.getId());
            stm.executeUpdate();
                    
                  JOptionPane.showMessageDialog(null,"Atualizado com sucesso");
                  
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "erro ao atualizar: "+ex);
                    }
     

        
        
     }
    
   public List<Produto> read(){
       
       Connection con = ConnectionFactory.getConexao();
       PreparedStatement stmt = null;
       ResultSet rs = null;
       
       
       List<Produto> produtos = new ArrayList();
       
       try{
           stmt = con.prepareStatement("SELECT * FROM produto");
          rs = stmt.executeQuery();
          
          while(rs.next()){
              
              Produto p = new Produto();
              p.setId(rs.getInt("ID"));
              p.setNome(rs.getString("Nome"));
              p.setDescricao(rs.getString("Descricao"));
              p.setPreco(rs.getDouble("preco"));
              p.setQuantidade(rs.getInt("quantidade"));
              produtos.add(p);
              
          }
       }catch (SQLException ex){
           Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE,null,ex);
           
       
       } 
        return produtos;
       
       
       
   
    
    
    
}
}