package onlineShopping;

import java.util.Date;

public abstract class Payment {
    String id;
    Date paid;
    float total;
    String details;
    Order order;
    Account account;
    //todo: init of the class


    public void deletePaymentFromAccount(){
        this.account = null;
    }

    public void showPayment(){
        System.out.println(String.format("Payment id: {0}", this.getId()));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getPaid() {
        return paid;
    }

    public void setPaid(Date paid) {
        this.paid = paid;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void findObject(String id){
        if(this.id == id){
            System.out.println(String.format("Payment id: {0}", this.id));
            System.out.println(String.format("Payment paid: {0}", this.paid));
            System.out.println(String.format("Payment total: {0}", this.total));
            System.out.println(String.format("Payment details: {0}", this.details));
            System.out.println(String.format("Payment connect to account: {0}", this.account.getId()));
            System.out.println(String.format("Payment order number: {0}", this.order.number));
        }
    }
}
