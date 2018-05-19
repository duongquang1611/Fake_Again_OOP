/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.DiaNhac;
import Model.DiaPhim;
import Model.Sach;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quang
 */
public class Connect {

    private static String className = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost/fakeoop";
    private static String user = "root";
    private static String password = "duongquang";

    private String sql;

    public static Connection connection;
    private ResultSet rs = null;
    private Statement st;
    private PreparedStatement pst = null;

    public void connect() {
        try {
            Class.forName(className);
            connection = DriverManager.getConnection(url, user, password);

            System.out.println("Connect success");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found");
        } catch (SQLException ex) {
            System.out.println("Error connect");
        }
    }

//     get data chung qua tung bang
    public ResultSet getData(String table) {
        sql = "select * from " + table;

        try {
            st = connection.createStatement();
//            pst.setString(1, table);
            rs = st.executeQuery(sql);

        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
//    public ResultSet getData() {
//        sql = "select * from sach";
//
//        try {
//            st = connection.createStatement();
//          
//            rs = st.executeQuery(sql);
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return rs;
//    }

}
