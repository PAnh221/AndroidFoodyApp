package hcmute.spkt.nhom01.foodyapp.models;

import java.util.List;

public class DiaDiem {
//    private String TenDiaDiem;
//    private String DiaChi;
//    private int imgDiaDiem;
//
//    private List<MonAn> dsMonAn;

    int ShopID;
    String Name, Address, Phone;
    byte[] Image;


    public DiaDiem(int shopID, String name, String address, String phone, byte[] image) {
        ShopID = shopID;
        Name = name;
        Address = address;
        Phone = phone;
        Image = image;
    }

    public int getShopID() {
        return ShopID;
    }

    public void setShopID(int shopID) {
        ShopID = shopID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] image) {
        Image = image;
    }
}
