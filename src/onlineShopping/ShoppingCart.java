package onlineShopping;

import java.util.ArrayList;
import java.util.Date;

public class ShoppingCart {
    Date created;
    onlineShopping.User user;
    ArrayList<LineItem> lineItems;
    Account account;

    public ShoppingCart(User user) {
        assert(user.shoppingCartIsNull());
        user.setShop_cart(this);
        this.created = new Date(System.currentTimeMillis());
    }
}
