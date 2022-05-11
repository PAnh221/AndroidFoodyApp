package hcmute.spkt.nhom01.foodyapp.models;

public class DiaDiem {
    private String TenDiaDiem;
    private String DiaChi;
    private int imgDiaDiem;
    private String TenBoSuuTap;

    public String getDiaChi() {
        return DiaChi;
    }

    public DiaDiem(String tenDiaDiem, String diaChi, int imgDiaDiem, String tenBoSuuTap) {
        TenDiaDiem = tenDiaDiem;
        DiaChi = diaChi;
        this.imgDiaDiem = imgDiaDiem;
        TenBoSuuTap = tenBoSuuTap;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getTenDiaDiem() {
        return TenDiaDiem;
    }

    public void setTenDiaDiem(String tenDiaDiem) {
        TenDiaDiem = tenDiaDiem;
    }

    public int getImgDiaDiem() {
        return imgDiaDiem;
    }


    public void setImgDiaDiem(int imgDiaDiem) {
        this.imgDiaDiem = imgDiaDiem;
    }

    public String getTenBoSuuTap() {
        return TenBoSuuTap;
    }

    public void setTenBoSuuTap(String tenBoSuuTap) {
        TenBoSuuTap = tenBoSuuTap;
    }
}
