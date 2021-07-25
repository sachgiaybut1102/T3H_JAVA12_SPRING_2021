package Demo.Service;

import Demo.Model.NhanVien;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NhanVienService extends BaseService implements INhanVien {
    @Override
    public List<NhanVien> getAll() {
        paramters = new ArrayList<>();
        List<NhanVien> nhanViens = new ArrayList<>();

        query = "execute SP_NhanVien_Select_All";

        try {
            ResultSet resultSet = db.getTable(query, paramters);

            InitInfo initInfo = new InitInfo();

            while (resultSet.next()) {
                nhanViens.add(initInfo.initNhanVien(resultSet));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        db.closeConnection();
        return nhanViens;
    }

    @Override
    public NhanVien getByID(String id) {
        return null;
    }

    @Override
    public List<NhanVien> getByKeyword(String keyword) {
        return null;
    }

    @Override
    public boolean add(NhanVien info) {
        paramters = new ArrayList<>();

        query = "execute SP_NhanVien_Insert ?, ?, ?, ?, ?, ?";
        paramters.add(info.getTenNv());
        paramters.add(new SimpleDateFormat("yyyy-MM-dd").format(info.getNgaySinh()));
        paramters.add(info.isGioiTinh() ? "true" : "false");
        paramters.add(info.getSdt());
        paramters.add(info.getDiaChi());
        paramters.add(info.getEmail());

        boolean result = db.executeNonQuery(query, paramters);

        db.closeConnection();

        return result;
    }

    @Override
    public boolean update(NhanVien info) {
        return false;
    }

    @Override
    public boolean delete(NhanVien info) {
        return false;
    }
}
