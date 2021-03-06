/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Beatriz
 */
public class GeralDAO {
      
   /* Executar comandos SQL do tipo: SELECT  */
   public ResultSet consultar(String sql, Object ... parametros) throws SQLException{
       PreparedStatement pstm = 
               ConnectionFactory.getConexao().prepareStatement(sql);
       for (int i=0;i<parametros.length;i++){
           pstm.setObject(i+1, parametros[i]);
       }
       return pstm.executeQuery();
   }
   
   /* Executar comandos SQL do tipo: INSERT, UPDATE e DELETE  */
   public void executar(String sql, Object ... parametros) throws SQLException{
       PreparedStatement pstm = 
               ConnectionFactory.getConexao().prepareStatement(sql);
       for (int i=0;i<parametros.length;i++){
           pstm.setObject(i+1, parametros[i]);
       }
       pstm.executeUpdate();
   }
   
}
