package hcmute.spkt.nhom01.foodyapp.models;

public class Account {
    String Username;
    String Password;
    String Phone;
    String Email;
    String Address;
    String Role;

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public String getPhone() {
        return Phone;
    }

    public String getEmail() {
        return Email;
    }

    public String getAddress() {
        return Address;
    }

    public String getRole() {
        return Role;
    }



    public void setUsername(String username) {
        Username = username;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setRole(String role) {
        Role = role;
    }

}
