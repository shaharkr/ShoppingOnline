package onlineShopping;

import java.util.Date;

public class Account {
    String id;
    String billing_address;
    boolean is_closed;
    Date open;
    Date close;
    onlineShopping.Customer customer;
    ShoppingCart shopCart;
    int balance;

    public Account(String id, Address billing_address, Customer customer) {
        this.id = id;
        this.billing_address = billing_address.toString();
        this.is_closed = false;
        this.open = new Date(System.currentTimeMillis());
        this.close = null;
        this.customer = customer;
        this.shopCart = new ShoppingCart(customer.getUser(), this);
        this.balance = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBilling_address() {
        return billing_address;
    }

    public void setBilling_address(String billing_address) {
        this.billing_address = billing_address;
    }

    public boolean isIs_closed() {
        return is_closed;
    }

    public void setIs_closed(boolean is_closed) {
        this.is_closed = is_closed;
    }

    public Date getOpen() {
        return open;
    }

    public void setOpen(Date open) {
        this.open = open;
    }

    public Date getClose() {
        return close;
    }

    public void setClose(Date close) {
        this.close = close;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ShoppingCart getShopCart() {
        return shopCart;
    }

    public void setShopCart(ShoppingCart shopCart) {
        this.shopCart = shopCart;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
