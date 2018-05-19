/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import static Control.Connect.connection;
import Model.DiaNhac;
import Model.DiaPhim;
import Model.Sach;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quang
 */
public class QuanLySanPham {

    private Statement st = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    private String sql = "";
    private int preSTT = 0;
    private Connect con = new Connect();

    public QuanLySanPham() {
        con.connect();
    }

    // get data qua maSP tung bang
    public ResultSet getDataSPId(String table, String maSP) {

        sql = "select * from " + table + " where maSP = ?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, maSP);
            rs = pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    //get maSP cuoi cung
    public int getMaSP_FINAL_ROW(String table) {
        int maMAX = 0;
        String maSP_FINAL;
        sql = "SELECT maSP FROM " + table;

        try {
            pst = connection.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs == null) {
                maMAX = 0;
            } else {
                while (rs.next()) {
                    maSP_FINAL = rs.getString(1);
                    maMAX = checkMaSP(maSP_FINAL);

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maMAX;
    }

    private int checkMaSP(String maSP_FINAL) {
        String[] listSTT;
        // phan tach maSP thanh mang: VD: DN_3 thi mang listSTT = {"DN", "3"}

        listSTT = maSP_FINAL.split("_");
        int STT = Integer.parseInt(listSTT[1]);

        if (STT > preSTT) {
            preSTT = STT;
        }

        return preSTT;
    }

    public String getMASP_FROM_TABLE(String table) {
        String maSP_MAX = "";
        int STT = getMaSP_FINAL_ROW(table) + 1;

        if (table.equalsIgnoreCase("sach")) {
            maSP_MAX = "S_" + STT;
        } else if (table.equalsIgnoreCase("dianhac")) {
            maSP_MAX = "DN_" + STT;
        } else {
            maSP_MAX = "DP_" + STT;
        }

        return maSP_MAX;
    }

//    private Date convertDateYear(Date date, String type) {
//
//        // khong can dung ham nay nua
//        SimpleDateFormat sdf = null;
//        if (type.equals("Year")) {
//            sdf = new SimpleDateFormat("yyyy");
//        }
//        if (type.equals("dmy")) {
//            sdf = new SimpleDateFormat("yyyy/mm/dd");
//        }
//
//        String dateYear = sdf.format(date);
//        System.out.println(dateYear);
//        Date yearDate = null;
//        try {
//            yearDate = sdf.parse(dateYear);
//        } catch (ParseException ex) {
//            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return yearDate;
//    }
//    private String convert_UTILDATE_to_STRING(Date date) {
//        
//        
//        String dateString = "";
//        SimpleDateFormat sdf = new SimpleDateFormat();
//        
//        // convert java.util.Date to string
//        dateString = sdf.format(date);
//        
//        return dateString;
//    }
    private java.sql.Date convert_STRING_to_SQLDATE(String dateString) {
        java.sql.Date sqlDate = null;
        System.out.println("convert_STRING_to_SQLDATE : " + dateString);
        // convert string to java.sql.Date
        sqlDate = java.sql.Date.valueOf(dateString);

        return sqlDate;
    }

    // them SP
    public void Them_Sach(Sach s) {
        // insert vao sach
        sql = "insert into sach value(?,?,?,?,?,?,?,?,?)";

        try {
            pst = connection.prepareStatement(sql);

            pst.setString(1, s.getMaSP());
            pst.setString(2, s.getTenSP());
            pst.setString(3, s.getLoaiSP());
            pst.setDouble(4, s.getGiaMua());
            pst.setDouble(5, s.getGiaBan());
            pst.setInt(6, s.getSoLuong());
            pst.setDate(7, s.getNamPhatHanh());
            pst.setString(8, s.getTenTacGia());
            pst.setString(9, s.getNhaXB());

            if (pst.executeUpdate() > 0) {
                // doi voi insert va delete, tra ve > 0 neu lenh thuc hien dc
                System.out.println("Insert thanh cong");
            } else {
                System.out.println("Insert loi !!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Them_DiaNhac(DiaNhac dn) {
        // insert vao dia nhac
        sql = "insert into dianhac values(?,?,?,?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);

            pst.setString(1, dn.getMaSP());
            pst.setString(2, dn.getTenSP());
            pst.setString(3, dn.getLoaiSP());
            pst.setDouble(4, dn.getGiaMua());
            pst.setDouble(5, dn.getGiaBan());
            pst.setInt(6, dn.getSoLuong());
            pst.setString(7, dn.getTenTacGia());
            pst.setString(8, dn.getCaSi());
            pst.setDate(9, dn.getNgayPhatHanh());

            if (pst.executeUpdate() > 0) {
                // doi voi insert va delete, tra ve > 0 neu lenh thuc hien dc
                System.out.println("Insert thanh cong");
            } else {
                System.out.println("Insert loi !!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Them_DiaPhim(DiaPhim dp) {
        //   insert vao dia phim
        sql = "insert into diaphim values(?,?,?,?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);

            pst.setString(1, dp.getMaSP());
            pst.setString(2, dp.getTenSP());
            pst.setString(3, dp.getLoaiSP());
            pst.setDouble(4, dp.getGiaMua());
            pst.setDouble(5, dp.getGiaBan());
            pst.setInt(6, dp.getSoLuong());
            pst.setString(7, dp.getTenDaoDien());
            pst.setString(8, dp.getHangSX());
            pst.setString(9, dp.getDienVienChinh());

            if (pst.executeUpdate() > 0) {
                // doi voi insert va delete, tra ve > 0 neu lenh thuc hien dc
                System.out.println("Insert thanh cong");
            } else {
                System.out.println("Insert loi !!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // delete hang o bang qua maSP
    public void XoaId(String table, String maSP) {
        sql = "delete from " + table + " where maSP = ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, maSP);
            if (pst.executeUpdate() > 0) {
                // doi voi insert va delete, tra ve > 0 neu lenh thuc hien dc
                System.out.println("Xoa thanh cong");
            } else {
                System.out.println("Xoa loi !!!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // update qua maSP
    public void CapNhatSachId(Sach s, String maSP) {
        sql = "UPDATE sach "
                + "SET tenSP = ?, loaiSP = ?, giaMua = ?, giaBan = ?, soLuong = ?, namPhatHanh = ?, tenTacGia = ?, nhaXB = ?"
                + " WHERE maSP = ?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, s.getTenSP());
            pst.setString(2, s.getLoaiSP());
            pst.setDouble(3, s.getGiaMua());
            pst.setDouble(4, s.getGiaBan());
            pst.setInt(5, s.getSoLuong());
            pst.setDate(6, s.getNamPhatHanh());
            pst.setString(7, s.getTenTacGia());
            pst.setString(8, s.getNhaXB());
            pst.setString(9, s.getMaSP());

            if (pst.executeUpdate() > 0) {
                // doi voi insert va delete, tra ve > 0 neu lenh thuc hien dc
                System.out.println("Update thanh cong");
            } else {
                System.out.println("Update loi !!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CapNhatDiaNhacId(DiaNhac dn, String maSP) {
        sql = "UPDATE dianhac "
                + "SET tenSP = ?, loaiSP = ?, giaMua = ?, giaBan = ?, soLuong = ?, tenTacGia = ?, caSi = ?, ngayPhatHanh = ?"
                + " WHERE maSP = ?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, dn.getTenSP());
            pst.setString(2, dn.getLoaiSP());
            pst.setDouble(3, dn.getGiaMua());
            pst.setDouble(4, dn.getGiaBan());
            pst.setInt(5, dn.getSoLuong());
            pst.setString(6, dn.getTenTacGia());
            pst.setString(7, dn.getCaSi());
            pst.setDate(8, dn.getNgayPhatHanh());
            pst.setString(9, dn.getMaSP());

            if (pst.executeUpdate() > 0) {
                // doi voi insert va delete, tra ve > 0 neu lenh thuc hien dc
                System.out.println("Update thanh cong");
            } else {
                System.out.println("Update loi !!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CapNhatDiaPhimId(DiaPhim dp, String maSP) {
        sql = "UPDATE sach "
                + "SET tenSP = ?, loaiSP = ?, giaMua = ?, giaBan = ?, soLuong = ?, tenDaoDien = ?, hangSX = ?, dienVienChinh = ?"
                + " WHERE maSP = ?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, dp.getTenSP());
            pst.setString(2, dp.getLoaiSP());
            pst.setDouble(3, dp.getGiaMua());
            pst.setDouble(4, dp.getGiaBan());
            pst.setInt(5, dp.getSoLuong());
            pst.setString(6, dp.getTenDaoDien());
            pst.setString(7, dp.getHangSX());
            pst.setString(8, dp.getDienVienChinh());
            pst.setString(9, dp.getMaSP());

            if (pst.executeUpdate() > 0) {
                System.out.println("Update thanh cong");
                
            } else {
                // doi voi insert va delete, tra ve > 0 neu lenh thuc hien dc
                System.out.println("Update loi !!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getSoLuongSP(String table) {
        int soLuongSP = 0;
        sql = "SELECT SUM(soLuong) FROM " + table;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                soLuongSP = Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }

        return soLuongSP;
    }
    
    public double getGiaTriSP(String table){
        double tongGT = 0;
        sql = "SELECT SUM(soLuong * giaBan) FROM "+table;
        
        try {
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                tongGT = Double.parseDouble(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tongGT;
    }
    
    // hien thi string voi so very large
    public String convertDoubleToStringWithFormat(double num) {
        String numString = "";
        //set format luong khi co qua nhieu so 0
        DecimalFormat df = new DecimalFormat("#,###,###");

        numString = df.format(num) + " VNĐ";
        return numString;
    }

}
