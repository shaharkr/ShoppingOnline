package onlineShopping;

import java.util.ArrayList;
import java.util.Date;

public class PremiumAccount extends Account {
    ArrayList<Product> products;
    public PremiumAccount(String id, String billing_address, boolean is_closed, Date open, Date close, Customer customer, ShoppingCart shop_cart, int balance) {
        super(id, billing_address, is_closed, open, close, customer, shop_cart, balance);
    }
}
