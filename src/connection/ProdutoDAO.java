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
            stm = con.prepareStatement("INSERT INTO `produto`(`ID`, `Nome`, `Descricao`, `preco`, `quantidade`) VALUES (?,?,?,?,?)");
            stm.setInt(1, produto.getId());
            stm.setString(2, produto.getNome());
            stm.setString(3,produto.getDescricao());     
            stm.setInt(4, produto.getQuantidade());
            stm.setDouble(5, produto.getPreco());
            
            stm.execute();
                    
                  JOptionPane.showMessageDialog(null,"Salvo com sucesso");
                  
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "erro: "+ex);
                    }
     

        
        
    }
    
    public List<Produto> listar() throws SQLException{
        String sql = "select ID,Nome from produto";
        ResultSet resultSet = consultar(sql);
        List<Produto> produtos = new ArrayList();
        while (resultSet.next()){
            produtos.add(popularProduto(resultSet));
        }
        return produtos;
    }
    
    private Produto popularProduto(ResultSet resultSet) throws SQLException{
        Produto produto = new Produto();
        produto.setId(resultSet.getInt("ID"));
        produto.setNome(resultSet.getString("Nome"));
        return produto;
    }
    
}