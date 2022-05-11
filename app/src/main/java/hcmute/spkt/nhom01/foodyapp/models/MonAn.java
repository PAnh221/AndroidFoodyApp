package hcmute.spkt.nhom01.foodyapp.models;

public class MonAn {
    private String TenMon;
    private String DiaChi;
    private int imgMonAn;
    private String TenBoSuuTap;

    public String getDiaChi() {
        return DiaChi;
    }

    public MonAn(String tenDiaDiem, String diaChi, int imgDiaDiem, String tenBoSuuTap) {
        TenMon = tenDiaDiem;
        DiaChi = diaChi;
        this.imgMonAn = imgDiaDiem;
        TenBoSuuTap = tenBoSuuTap;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getTenDiaDiem() {
        return TenMon;
    }

    public void setTenDiaDiem(String tenDiaDiem) {
        TenMon = tenDiaDiem;
    }

    public int getImgDiaDiem() {
        return imgMonAn;
    }


    public void setImgDiaDiem(int imgDiaDiem) {
        this.imgMonAn = imgDiaDiem;
    }

    public String getTenBoSuuTap() {
        return TenBoSuuTap;
    }

    public void setTenBoSuuTap(String tenBoSuuTap) {
        TenBoSuuTap = tenBoSuuTap;
    }
}
