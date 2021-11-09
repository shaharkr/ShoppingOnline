package onlineShopping;

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
        this.account = account;
    }
}
