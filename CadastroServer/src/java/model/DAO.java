/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author muangala Jr
 */
public class DAO {
    private String  driver = "com.mysql.cj.jdbc.Driver";
    //private String url = "jdbc:mysql://127.0.0.1:3306/loja?";
    private String url = "jdbc:mysql://127.0.0.1:3306/loja?usetimezone=true&serverTimezone=UTC";

    private String user = "root";
    private String password = "";
    
    //Método de Conexão
    private Connection conectar(){
        Connection con = null;
        
        try {
        Class.forName(driver);
        return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage(), e);
        }
    }
    
    
}
