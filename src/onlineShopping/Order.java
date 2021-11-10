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

    public void deleteLineItem(LineItem lineItem) {
        for (LineItem li: this.lineItems
             ) {
            if(li == lineItem){
                this.lineItems.remove(li);
            }
        }
    }
}
