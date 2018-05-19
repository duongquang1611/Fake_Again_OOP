/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public interface InterfaceControl {
    public void load_ds_sach();
    public void load_ds_diaPhim();
    public void load_ds_diaNhac();
    public void load_ds_SP(String tableName);
    public void showSoLuong();
}
