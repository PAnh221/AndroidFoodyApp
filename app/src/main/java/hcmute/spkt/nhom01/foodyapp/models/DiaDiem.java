package hcmute.spkt.nhom01.foodyapp.models;

import java.util.List;

public class DiaDiem {
    private String TenDiaDiem;
    private String DiaChi;
    private int imgDiaDiem;
    private List<MonAn> dsMonAn;


    public DiaDiem(String tenDiaDiem, String diaChi, int imgDiaDiem, List<MonAn> dsMonAn) {
        TenDiaDiem = tenDiaDiem;
        DiaChi = diaChi;
        this.imgDiaDiem = imgDiaDiem;
        this.dsMonAn = dsMonAn;
    }

    public String getTenDiaDiem() {
        return TenDiaDiem;
    }

    public void setTenDiaDiem(String tenDiaDiem) {
        TenDiaDiem = tenDiaDiem;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public int getImgDiaDiem() {
        return imgDiaDiem;
    }

    public void setImgDiaDiem(int imgDiaDiem) {
        this.imgDiaDiem = imgDiaDiem;
    }

    public List<MonAn> getDsMonAn() {
        return dsMonAn;
    }

    public void setDsMonAn(List<MonAn> dsMonAn) {
        this.dsMonAn = dsMonAn;
    }
}
