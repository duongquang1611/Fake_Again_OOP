/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Admin
 */
public class DiaPhim extends SanPham {

    private String tenDaoDien;
    private String hangSX;
    private String dienVienChinh;

    public DiaPhim(String tenDaoDien, String hangSX, String dienVienChinh, String maSP, String tenSP, String loaiSP, double giaMua, double giaBan, int soLuong) {
        super(maSP, tenSP, loaiSP, giaMua, giaBan, soLuong);
        this.tenDaoDien = tenDaoDien;
        this.hangSX = hangSX;
        this.dienVienChinh = dienVienChinh;
    }

    public String getTenDaoDien() {
        return tenDaoDien;
    }

    public void setTenDaoDien(String tenDaoDien) {
        this.tenDaoDien = tenDaoDien;
    }

    public String getHangSX() {
        return hangSX;
    }

    public void setHangSX(String hangSX) {
        this.hangSX = hangSX;
    }

    public String getDienVienChinh() {
        return dienVienChinh;
    }

    public void setDienVienChinh(String dienVienChinh) {
        this.dienVienChinh = dienVienChinh;
    }

}
