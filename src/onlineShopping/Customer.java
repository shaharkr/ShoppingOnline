package onlineShopping;

import java.util.Date;

public class Customer {
    private String id;
    private Address address;
    private String phone;
    private String email;
    private User user;
    private Account account;

    public Customer(String id, Address address, String phone, String email, User user, int premium) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.user = user;
        if (premium==1){
            this.account = new PremiumAccount(id, address, this);
        }
        else{
            this.account = new Account(id, address, this);
        }
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

    public void deleteCustomer() {
        this.account.deleteAccount();
        this.account = null;
    }
}
