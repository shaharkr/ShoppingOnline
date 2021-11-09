package onlineShopping;

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

}
