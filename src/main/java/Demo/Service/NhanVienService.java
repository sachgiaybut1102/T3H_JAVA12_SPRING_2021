package Demo.Service;

import Demo.Model.NhanVien;
import Demo.ViewModel.NhanVienViewModel;
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
    public List<NhanVienViewModel> getAll() {
        paramters = new ArrayList<>();
        List<NhanVienViewModel> nhanViens = new ArrayList<>();

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
    public List<NhanVienViewModel> getByPage(int pageNumber, int pageSize) {
        paramters = new ArrayList<>();
        List<NhanVienViewModel> nhanViens = new ArrayList<>();

        query = "execute SP_NhanVien_Select_ByPage ?, ?";

        paramters.add(Integer.toString(pageNumber));
        paramters.add(Integer.toString(pageSize));

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
    public int getCountPage(int pageSize) {
        int counttPage = 1;

        paramters = new ArrayList<>();
        paramters.add(Integer.toString(pageSize));

        query = "Execute SP_NhanVien_GetCountPage ?";

        try {
            ResultSet resultSet = db.getTable(query, paramters);

            while (resultSet.next()) {
                counttPage = resultSet.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        db.closeConnection();

        return counttPage;
    }

    @Override
    public NhanVienViewModel getByID(String id) {
        paramters = new ArrayList<>();

        NhanVienViewModel nhanVienViewModel = new NhanVienViewModel();

        query = "execute SP_NhanVien_Select_SingleByID ?";

        paramters.add(id);

        try {
            ResultSet resultSet = db.getTable(query, paramters);

            InitInfo initInfo = new InitInfo();

            while (resultSet.next()) {
                nhanVienViewModel = initInfo.initNhanVien(resultSet);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return nhanVienViewModel;
    }

    @Override
    public List<NhanVienViewModel> getByKeyword(String keyword) {
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
        paramters = new ArrayList<>();

        query = "execute SP_NhanVien_Update ?, ?, ?, ?, ?, ?, ?";

        paramters.add(Integer.toString(info.getMaNv()));
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
    public boolean delete(NhanVien info) {
        return false;
    }
}
