/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Beatriz
 */
public class teste {
    public static void main(String[] args) throws SQLException {
        Connection c = ConnectionFactory.getConexao();
        System.out.println("Funcionando");
        
        c.close();
    }
}
