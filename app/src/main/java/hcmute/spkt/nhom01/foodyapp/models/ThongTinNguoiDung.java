package hcmute.spkt.nhom01.foodyapp.models;

public class ThongTinNguoiDung {
    private String tenNguoiDung;
    private String emailNguoiDung;
    private String diaChiNguoiDung;
    private String soDienThoaiNguoiDung;
    private int imgNguoiDung;

    public ThongTinNguoiDung(String tenNguoiDung, String emailNguoiDung, String diaChiNguoiDung, String soDienThoaiNguoiDung, int imgNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
        this.emailNguoiDung = emailNguoiDung;
        this.diaChiNguoiDung = diaChiNguoiDung;
        this.soDienThoaiNguoiDung = soDienThoaiNguoiDung;
        this.imgNguoiDung = imgNguoiDung;
    }

    public int getImgNguoiDung() {
        return imgNguoiDung;
    }

    public void setImgNguoiDung(int imgNguoiDung) {
        this.imgNguoiDung = imgNguoiDung;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getEmailNguoiDung() {
        return emailNguoiDung;
    }

    public void setEmailNguoiDung(String emailNguoiDung) {
        this.emailNguoiDung = emailNguoiDung;
    }

    public String getDiaChiNguoiDung() {
        return diaChiNguoiDung;
    }

    public void setDiaChiNguoiDung(String diaChiNguoiDung) {
        this.diaChiNguoiDung = diaChiNguoiDung;
    }

    public String getSoDienThoaiNguoiDung() {
        return soDienThoaiNguoiDung;
    }

    public void setSoDienThoaiNguoiDung(String soDienThoaiNguoiDung) {
        this.soDienThoaiNguoiDung = soDienThoaiNguoiDung;
    }
}
