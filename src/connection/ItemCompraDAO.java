/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import fabricacuscuz.dominio.Produto;
import fabricacuscuz.dominio.itemCompra;
import fabricacuscuz.dominio.itemSaida;
import java.sql.Connection;
import java.sql.Date;
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
public class ItemCompraDAO {
     public void salvar(itemCompra item) throws SQLException{
                Connection con = ConnectionFactory.getConexao();
        PreparedStatement stm = null;
        
  
        try {
            stm = con.prepareStatement("INSERT INTO `compra`( `funcionario`, `descricao`, `quantidade`, `preco`, `data_compra`, `categoria`, `fornecedor`) VALUES (?,?,?,?,?,?,?)");
            
            
            stm.setString(1, item.getFuncionario());
            stm.setString(2, item.getDescricao());
            stm.setInt(3, item.getQuantidade());
            stm.setDouble(4, item.getPreco());
            stm.setDate(5, (Date) item.getDataCompra());
stm.setString(6, item.getCategoria());
stm.setString(7, item.getFornecedor());
            
            stm.execute();
                    
                  JOptionPane.showMessageDialog(null,"Registrado com sucesso");
                  
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "erro: "+ex);
                    }
     

        
        
}
     public List<itemCompra> readCompra(){
       
       Connection con = ConnectionFactory.getConexao();
       PreparedStatement stmt = null;
       ResultSet rs = null;
       
       
       List<itemCompra> compras = new ArrayList();
       
       try{
           stmt = con.prepareStatement("SELECT * FROM `compra`");
          rs = stmt.executeQuery();
          
          while(rs.next()){
              
              itemCompra i = new itemCompra();
              i.setId(rs.getInt("ID"));
              i.setFuncionario(rs.getString("funcionario"));
            i.setDescricao(rs.getString("descricao"));
            i.setCategoria(rs.getString("categoria"));
            i.setFornecedor(rs.getString("fornecedor"));
            i.setDataCompra(rs.getDate("data_compra"));
            
              
              i.setPreco(rs.getDouble("preco"));
              i.setQuantidade(rs.getInt("quantidade"));
             
            
              compras.add(i);
              
          }
       }catch (SQLException ex){
           Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE,null,ex);
           
       
       } 
        return compras;
       
       
       
}
       public void apagar (itemCompra item){
                Connection con = ConnectionFactory.getConexao();
        PreparedStatement stm = null;
        
  
        try {
            stm = con.prepareStatement("DELETE FROM `compra` WHERE ID = ?");
            
            stm.setInt(1, item.getId());
            
            
            stm.executeUpdate();
                    
                  JOptionPane.showMessageDialog(null,"Excluído com sucesso.");
                  
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "erro ao excluir: " +ex);
                    }
}
}
