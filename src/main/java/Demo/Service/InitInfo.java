package Demo.Service;

import Demo.Model.NhanVien;

import java.sql.ResultSet;

public class InitInfo {
    NhanVien initNhanVien(ResultSet resultSet) {
        NhanVien nhanVien = new NhanVien();

        try {
            nhanVien.setMaNv(resultSet.getInt("MaNV"));
            nhanVien.setTenNv(resultSet.getString("TenNV"));
            nhanVien.setNgaySinh(resultSet.getDate("NgaySinh"));
            nhanVien.setGioiTinh(resultSet.getBoolean("GioiTinh"));
            nhanVien.setSdt(resultSet.getString("SDT"));
            nhanVien.setDiaChi(resultSet.getString("DiaChi"));
            nhanVien.setEmail(resultSet.getString("EMail"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return nhanVien;
    }

    ///Các object còn lại làm tương tự
}
