/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.Connect.connection;
import Model.NhanVien;
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
public class ControlLogin {

    private Statement st = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    private String sql = "";

    private Connect con = new Connect();

    public ControlLogin() {
        con.connect();
    }

    public NhanVien chucVuTaiKhoanDangNhap(String username, String password) {
        System.out.println("Check chức vụ đăng nhập");
        sql = "SELECT * FROM nhanvien WHERE taiKhoan = ? AND matKhau = ?";
        NhanVien nv = new NhanVien();
        try {
            pst = connection.prepareStatement(sql);

            pst.setString(1, username);
            pst.setString(2, password);

            rs = pst.executeQuery();

            while (rs.next()) {
                if (rs.getString("chucVu").equals("Nhân Viên")) {
                    getNhanVienByRs(nv, rs);
                    break;
                } else {
                    getNhanVienByRs(nv, rs);
                    break;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControlLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nv;
    }

    // tra ve 1 doi tuong nhan vien khi biet result set
    public void getNhanVienByRs(NhanVien nv, ResultSet rs) {
        try {
            
            //column result set chạy tư 1
            nv.setMaNV(rs.getString(1));
            nv.setTenNV(rs.getString(2));
            nv.setChucVu(rs.getString(3));
            nv.setGioiTinh(rs.getString(4));
            nv.setNgaySinh(rs.getDate(5));
            nv.setDiaChi(rs.getString(6));
            nv.setSdt(rs.getString(7));
            nv.setEmail(rs.getString(8));
            nv.setLuong(rs.getDouble(9));
            nv.setTaiKhoan(rs.getString(10));
            nv.setMatKhau(rs.getString(11));
        } catch (SQLException ex) {
            Logger.getLogger(ControlLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
