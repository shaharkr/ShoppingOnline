package onlineShopping;

import java.util.Date;

public class Account {
    String id;
    String billing_address;
    boolean is_closed;
    Date open;
    Date close;
    onlineShopping.Customer customer;
    ShoppingCart shop_cart;
    int balance;

    public Account(String id, String billing_address, boolean is_closed,
                   Date open, Date close, Customer customer,
                   ShoppingCart shop_cart, int balance) {
        this.id = id;
        this.billing_address = billing_address;
        this.is_closed = is_closed;
        this.open = open;
        this.close = close;
        this.customer = customer;
        this.shop_cart = shop_cart;
        this.balance = balance;
    }
}
