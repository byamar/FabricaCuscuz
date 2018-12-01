/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Beatriz
 */
public class ConnectionFactory {
    
      private static Connection connection;

    ConnectionFactory() {

    }

    public static Connection getConexao() {
        if (connection == null) {
            try {
                connection
                        = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadastro_produto",
                                "root",
                                "");
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }

        return connection;
    }

}
