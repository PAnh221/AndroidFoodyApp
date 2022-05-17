package hcmute.spkt.nhom01.foodyapp.models;

public class Product {
    int ProID;
    String Name, Description;
    Float Price;
    int Quantity;
    String Category;
    int ShopID;
    byte[] Image;

    public Product(int proID, String name, String description, Float price, int quantity, String category, int shopID, byte[] image) {
        ProID = proID;
        Name = name;
        Description = description;
        Price = price;
        Quantity = quantity;
        Category = category;
        ShopID = shopID;
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

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public int getShopID() {
        return ShopID;
    }

    public void setShopID(int shopID) {
        ShopID = shopID;
    }

    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] image) {
        Image = image;
    }
}
