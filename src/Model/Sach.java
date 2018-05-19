/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Sach extends SanPham {
    private Date namPhatHanh;
    private String tenTacGia;
    private String nhaXB;

    public Sach(Date namPhatHanh, String tenTacGia, String nhaXB, String maSP, String tenSP, String loaiSP, double giaMua, double giaBan, int soLuong) {
        super(maSP, tenSP, loaiSP, giaMua, giaBan, soLuong);
        this.namPhatHanh = namPhatHanh;
        this.tenTacGia = tenTacGia;
        this.nhaXB = nhaXB;
    }

    public Date getNamPhatHanh() {
        return namPhatHanh;
    }

    public void setNamPhatHanh(Date namPhatHanh) {
        this.namPhatHanh = namPhatHanh;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getNhaXB() {
        return nhaXB;
    }

    public void setNhaXB(String nhaXB) {
        this.nhaXB = nhaXB;
    }
    
    
}
