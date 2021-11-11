package onlineShopping;

import java.util.ArrayList;
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
    ArrayList<Order> orders;
    ArrayList<Payment> payments = new ArrayList<>();
    static int nextAvailableOrderId = 0;


    public Account(String id, Address billing_address, Customer customer) {
        this.id = id;
        this.billing_address = billing_address.toString();
        this.is_closed = false;
        this.open = new Date(System.currentTimeMillis());
        this.close = null;
        this.customer = customer;
        this.shopCart = new ShoppingCart(customer.getUser(), this);
        this.balance = 0;
        this.orders = new ArrayList<Order>();
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

    public ArrayList<Order> getOrders() { return orders; }

    public void setOrders(ArrayList<Order> orders) {this.orders = orders;}

    public void addOrder(Order order){
        this.orders.add(order);
        this.nextAvailableOrderId++;
    }

    public int getNextAvailableOrderId() {
        return this.nextAvailableOrderId;
    }

    public void addProductToOrder(String orderId, Product product, float price) {
        for (Order order: this.orders
        ) {
            if(order.getNumber().equals(orderId)){
                for (LineItem li: order.getLineItems()
                ) {
                    if(li.getProductName().equals(product.getName())){
                        li.setQuantity(li.getQuantity() + 1);
                        li.setPrice(price);
                        return;
                    }
                }
                LineItem li = new LineItem(this.shopCart,order, product);
                li.setPrice(price);
                order.addLineItem(li);
            }

        }
    }

    public Order getLatlestOrder(){
        if(this.orders.size() == 0){return null;}
        return this.orders.get(this.orders.size()-1);
    }

    public void deleteAccount() {
        for (Payment p: this.payments
             ) {
            p.deletePaymentFromAccount();
        }
        for (Order o: this.orders
        ) {
            o.deleteOrderFromAccount();
        }
        this.shopCart.deleteShopCartFromAccount();
        this.shopCart = null;
        this.payments = null;
        this.orders = null;
    }

    public void showAccount() {
        System.out.println(String.format("Account  id: %s", this.id));
        this.shopCart.showShopCart();
        for (Order o:this.orders
             ) {
            o.showOrder();
        }
    }

    public void findObject(String id) {
        if(!this.id.equals(id)){
            for (Order o: this.orders
                 ) {
                o.findObject(id);
            }
        }
        else{
            System.out.println(String.format("Account id: %s", this.id));
            System.out.println(String.format("Account billing address: %s", this.billing_address));
            System.out.println(String.format("Account isClosed: %s", this.is_closed));
            System.out.println(String.format("Account open date: %s", this.open));
            System.out.println(String.format("Account close date: %s", this.close));
            System.out.println(String.format("Account balance id: %s", this.balance));
            System.out.println(String.format("Account coustomer id: %s", this.customer.getId()));
            System.out.println(String.format("Account shopping cart open date: %s", this.shopCart.created));
        }
    }
}
