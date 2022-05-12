package hcmute.spkt.nhom01.foodyapp.models;

public class FavoriteFood {
    int Id;
    String UserName;
    int ProductID;

    public int getId() {
        return Id;
    }

    public String getUserName() {
        return UserName;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }
}
