package Demo.Service;

import Demo.Model.NhanVien;
import Demo.ViewModel.NhanVienViewModel;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class InitInfo {
    NhanVienViewModel initNhanVien(ResultSet resultSet) {
        NhanVienViewModel nhanVien = new NhanVienViewModel();

        try {
            nhanVien.setMaNv(resultSet.getInt("MaNV"));
            nhanVien.setTenNv(resultSet.getString("TenNV"));
            nhanVien.setNgaySinh(resultSet.getDate("NgaySinh"));
            nhanVien.setGioiTinh(resultSet.getBoolean("GioiTinh"));
            nhanVien.setSdt(resultSet.getString("SDT"));
            nhanVien.setDiaChi(resultSet.getString("DiaChi"));
            nhanVien.setEmail(resultSet.getString("EMail"));

            //add data to model property
            nhanVien.setViewNgaySinh(new SimpleDateFormat("dd/MM/yyyy").format(nhanVien.getNgaySinh()).toString());
            nhanVien.setViewGioiTinh(nhanVien.isGioiTinh() == true ? "Nam" : "Nữ");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return nhanVien;
    }

    ///Các object còn lại làm tương tự
}
