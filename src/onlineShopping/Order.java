package onlineShopping;

import javax.xml.stream.events.DTD;
import java.util.ArrayList;
import java.util.Date;

public class Order {
    String number;
    Date ordered;
    Date shipped;
    Address ship_to;
    OrderStatus status;
    float total;
    Account account;
    ArrayList<LineItem> lineItems;
    ArrayList<Payment> payments;

    public Order(Address ship_to, Account account) {
        this.ship_to = ship_to;
        this.account = account;
        this.number = ((Integer)this.account.getNextAvailableOrderId()).toString() ;
        this.ordered = new Date(System.currentTimeMillis());
        this.status = OrderStatus.New;
        this.lineItems = new ArrayList<>();
        this.payments = new ArrayList<>();
        this.total = 0;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getOrdered() {
        return ordered;
    }

    public void setOrdered(Date ordered) {
        this.ordered = ordered;
    }

    public Date getShipped() {
        return shipped;
    }

    public void setShipped(Date shipped) {
        this.shipped = shipped;
    }

    public Address getShip_to() {
        return ship_to;
    }

    public void setShip_to(Address ship_to) {
        this.ship_to = ship_to;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public ArrayList<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(ArrayList<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }

    public void setPayments(ArrayList<Payment> payments) {
        this.payments = payments;
    }

    public void addLineItem(LineItem lineItem) {
        this.lineItems.add(lineItem);
    }

    public void removeLineItem(LineItem lineItem) {
        for (LineItem li: this.lineItems
             ) {
            if(li == lineItem){
                this.lineItems.remove(li);
            }
        }
    }

    public void deleteOrderFromAccount() {
        for (LineItem li: this.lineItems
             ) {
            li.deleteLineItemFromOrder();
        }
        this.account = null;
    }

    public void showOrder() {
        System.out.println(String.format("Order id: {0}", this.getNumber()));
        for (LineItem li: this.lineItems
             ) {
            li.showLineItem();
        }
        for (Payment p: this.payments
        ) {
            p.showPayment();
        }
    }

    public void findObject(String id) {
        if(this.number != id){
            for (Payment p: this.payments
            ) {
                p.findObject(id);
            }
        }
        else{
            System.out.println(String.format("Order number: {0}", this.number));
            System.out.println(String.format("Order address: {0}", this.ship_to.address));
            System.out.println(String.format("Order status: {0}", this.status));
            System.out.println(String.format("Order ordered date: {0}", this.ordered));
            System.out.println(String.format("Order shipped date: {0}", this.shipped));
            System.out.println(String.format("Order total: {0}", this.total));
            System.out.println(String.format("Order account id: {0}", this.account.getId()));
            System.out.println("All payments that are connected to this order:");
            for (Payment p: this.payments
            ) {
                System.out.println(String.format("Payment id: {0}", p.getId()));
            }
            System.out.println("All lineItems that are connected to this order:");
            for (LineItem li: this.lineItems
            ) {
                System.out.println(String.format("LineItem id: {0}", li.getPrice()));
            }
        }
    }
}
