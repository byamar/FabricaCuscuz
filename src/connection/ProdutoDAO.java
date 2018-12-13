/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;


import fabricacuscuz.dominio.Funcionario;
import fabricacuscuz.dominio.Produto;
import fabricacuscuz.dominio.itemSaida;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
            stm = con.prepareStatement("INSERT INTO `produto`( `funcionario`, `Descricao`, `preco`, `quantidade`, `categoria`, `fabricante`) VALUES (?,?,?,?,?,?)");
            
            stm.setString(1, produto.getFuncionario());
            stm.setString(2,produto.getDescricao());     
            stm.setDouble(3, produto.getPreco());
            stm.setInt(4, produto.getQuantidade());
            stm.setString(5, produto.getCategoria());
            stm.setString(6, produto.getFabricante());
            stm.execute();
                    
                  JOptionPane.showMessageDialog(null,"Salvo com sucesso");
                  
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "erro: "+ex);
                    }
     

        
        
    }
     public void alterar (Produto produto){
             Connection con = ConnectionFactory.getConexao();
        PreparedStatement stm = null;
        
  
        try {
            stm = con.prepareStatement("UPDATE `produto` SET `funcionario`= ?,`Descricao`= ?,`preco`= ?,`quantidade`= ?,`categoria`= ?,`fabricante`= ? WHERE ID = ?");
            
            stm.setString(1, produto.getFuncionario());
            stm.setString(2,produto.getDescricao());     
            stm.setDouble(3, produto.getPreco());
             stm.setInt(4,produto.getQuantidade());
             stm.setString(5,produto.getCategoria());
             stm.setString(6, produto.getFabricante());
            stm.setInt(7, produto.getId());
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
              p.setFuncionario(rs.getString("funcionario"));
              p.setDescricao(rs.getString("Descricao"));
              p.setPreco(rs.getDouble("preco"));
              p.setQuantidade(rs.getInt("quantidade"));
              p.setCategoria(rs.getString("categoria"));
              p.setFabricante(rs.getString("fabricante"));
              produtos.add(p);
              
          }
       }catch (SQLException ex){
           Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE,null,ex);
           
       
       } 
        return produtos;
       
       
       
   
    
    
    
}
    public void apagar (Produto produto){
                Connection con = ConnectionFactory.getConexao();
        PreparedStatement stm = null;
        
  
        try {
            stm = con.prepareStatement("DELETE FROM `produto` WHERE ID = ?");
            
            stm.setInt(1, produto.getId());
            
            
            stm.executeUpdate();
                    
                  JOptionPane.showMessageDialog(null,"Excluído com sucesso.");
                  
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "erro ao excluir: " +ex);
                    }
     

        
        
     }
    public List<Produto> readForDesc(String desc){
       
       Connection con = ConnectionFactory.getConexao();
       PreparedStatement stmt = null;
       ResultSet rs = null;
       
       
       List<Produto> produtos = new ArrayList();
       
       try{
           stmt = con.prepareStatement("SELECT * FROM produto WHERE Descricao LIKE ?");
          stmt.setString(1, "%"+desc+"%");
           rs = stmt.executeQuery();
          
          while(rs.next()){
              
              Produto p = new Produto();
              p.setId(rs.getInt("ID"));
              p.setFuncionario(rs.getString("funcionario"));
              p.setDescricao(rs.getString("Descricao"));
              p.setPreco(rs.getDouble("preco"));
              p.setQuantidade(rs.getInt("quantidade"));
              p.setCategoria(rs.getString("categoria"));
              p.setFabricante(rs.getString("fabricante"));
              produtos.add(p);
              
          }
       }catch (SQLException ex){
           Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE,null,ex);
           
       
       } 
        return produtos;
       
       
       
   
    
    }
     public void registrarVenda(itemSaida item) throws SQLException{
                Connection con = ConnectionFactory.getConexao();
        PreparedStatement stm = null;
        
  
        try {
            stm = con.prepareStatement("INSERT INTO `registro_venda`(`id`,`vendedor`, `quantidade`, `preco`, `distribuidora`, `data_validade`, `data_venda`, `prazo_entrega`) VALUES (?,?,?,?,?,?,?,?)");
            stm.setInt(1, item.getId());
            stm.setString(2, item.getVendedor());
            stm.setInt(3,item.getQuantidade());     
            stm.setDouble(4, item.getPreco());
            stm.setString(5, item.getDistribuidora());
            stm.setDate(6, (Date) item.getDataValidade());
            stm.setDate(7, (Date) item.getDataVenda());
            stm.setDate(8, (Date) item.getDataEntrega());
            
      
            stm.execute();
                    
                  JOptionPane.showMessageDialog(null,"Registrado com sucesso");
                  
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "erro ao registrar: "+ex);
                    }
     

        
     }
     
     public List<itemSaida> readVenda(){
       
       Connection con = ConnectionFactory.getConexao();
       PreparedStatement stmt = null;
       ResultSet rs = null;
       
       
       List<itemSaida> saidas = new ArrayList();
       
       try{
           stmt = con.prepareStatement("SELECT * FROM registro_venda");
          rs = stmt.executeQuery();
          
          while(rs.next()){
              
              itemSaida i = new itemSaida();
              i.setVendedor(rs.getString("vendedor"));
             i.setDataEntrega(rs.getDate("prazo_entrega"));
              i.setDataValidade(rs.getDate("data_validade"));
              i.setDataVenda(rs.getDate("data_venda"));
              i.setDistribuidora(rs.getString("distribuidora"));
              
              i.setPreco(rs.getDouble("preco"));
              i.setQuantidade(rs.getInt("quantidade"));
             
            
              saidas.add(i);
              
          }
       }catch (SQLException ex){
           Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE,null,ex);
           
       
       } 
        return saidas;
       
       
       
   
    
    
    
}
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
     
} 