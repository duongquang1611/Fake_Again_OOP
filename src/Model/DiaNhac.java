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
public class DiaNhac extends SanPham {

    private String tenTacGia;
    private String caSi;
    private Date ngayPhatHanh;

    public DiaNhac(String tenTacGia, String caSi, Date ngayPhatHanh, String maSP, String tenSP, String loaiSP, double giaMua, double giaBan, int soLuong) {
        super(maSP, tenSP, loaiSP, giaMua, giaBan, soLuong);
        this.tenTacGia = tenTacGia;
        this.caSi = caSi;
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getCaSi() {
        return caSi;
    }

    public void setCaSi(String caSi) {
        this.caSi = caSi;
    }

    public Date getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(Date ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }

}
