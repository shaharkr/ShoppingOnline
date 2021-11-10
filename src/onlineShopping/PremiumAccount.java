package onlineShopping;

import java.util.ArrayList;
import java.util.Date;

public class PremiumAccount extends Account {
    ArrayList<Product> products;
    public PremiumAccount(String id, Address billing_address, Customer customer) {
        super(id, billing_address, customer);
    }

    public Product containProducts(String p){
        for (Product pr: this.products) {
            if(pr.getName() == p){
                return pr;
            }
        }
        return null;
    }

}
