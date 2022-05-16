package hcmute.spkt.nhom01.foodyapp.models;

public class MonAn {
//    private String TenMon;
//    private String DiaChi;
//    private int imgMonAn;
//    private String TenBoSuuTap;

    int ProID;
    String Name, Description, Category, ShopName;
    Float Price;
    int Quantity;
    byte[] Image;

    public MonAn(int proID, String name, String description, String category, String shopName, Float price, int quantity, byte[] image) {
        ProID = proID;
        Name = name;
        Description = description;
        Category = category;
        ShopName = shopName;
        Price = price;
        Quantity = quantity;
        Image = image;
    }

    public int getProID() {
        return ProID;
    }

    public void setProID(int proID) {
        ProID = proID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String shopName) {
        ShopName = shopName;
    }

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float price) {
        Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] image) {
        Image = image;
    }
}
