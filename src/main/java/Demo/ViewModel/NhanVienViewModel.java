package Demo.ViewModel;

import Demo.Model.NhanVien;
import org.codehaus.jackson.annotate.JsonProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NhanVienViewModel extends NhanVien {
    @JsonProperty
    private String viewGioiTinh;
    @JsonProperty
    private String viewNgaySinh;

    public String getViewGioiTinh() {
        return viewGioiTinh;
    }

    public void setViewGioiTinh(String viewGioiTinh) {
        this.viewGioiTinh = viewGioiTinh;
    }

    public String getViewNgaySinh() {
        return viewNgaySinh;
    }

    public void setViewNgaySinh(String viewNgaySinh) {
        this.viewNgaySinh = viewNgaySinh;
    }
}
