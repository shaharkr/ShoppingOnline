package onlineShopping;

import java.util.Date;

public class Customer {
    String id;
    Address address;
    String phone;
    String email;
    User user;
    Account account;

    public Customer(String id, Address address, String phone, String email, User user) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.user = user;
        this.account = new Account(id, address, this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
