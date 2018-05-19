/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.Connect.connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class QuanLyiNhanVien {
    
    private Statement st = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    private String sql = "";

    private Connect con = new Connect();

    public QuanLyiNhanVien() {
        con.connect();
    }
    
    
    
    // get data nhan vien qua maNV
    public ResultSet getDataIdNhanVien(String maNV) {
        sql = "select * from nhanvien where maNV = ?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, maNV);
            rs = pst.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

}
