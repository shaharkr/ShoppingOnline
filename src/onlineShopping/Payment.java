package onlineShopping;

import java.util.Date;

public abstract class Payment {
    String id;
    Date paid;
    float total;
    String details;
    Order order;
    Account account;
}
