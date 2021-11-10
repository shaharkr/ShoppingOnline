package onlineShopping;

import java.util.ArrayList;
import java.util.Date;

public class ShoppingCart {
    Date created;
    onlineShopping.User user;
    ArrayList<LineItem> lineItems;
    Account account;

    public ShoppingCart(User user, Account account) {
        assert(user.shoppingCartIsNull());
        user.setShop_cart(this);
        this.created = new Date(System.currentTimeMillis());
        this.account = account;

    }

    public void removeLineItem(LineItem lineItem) {
        for (LineItem li: this.lineItems
        ) {
            if(li == lineItem){
                this.lineItems.remove(li);
            }
        }
    }

    public void deleteShopCartFromAccount() {
        this.account = null;
        this.lineItems = null;
    }
}
