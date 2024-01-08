/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;

import model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class db {
    private static Connection conn;
    public static Connection mycon() throws SQLException{
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/tubeskonser", "root", "");
            if(conn != null){
                System.out.println("Koneksi Berhasil");
            }
        }catch (SQLException e){
            System.err.println("Koneksi Gagal" + e.getMessage());
        }
        return conn;
    }
}
