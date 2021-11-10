package onlineShopping;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class PremiumAccount extends Account {
    HashMap<Product, float[]> products = new HashMap<>();
    public PremiumAccount(String id, Address billing_address, Customer customer) {
        super(id, billing_address, customer);
    }

    public Product containProducts(String p){
        for (Product pr: this.products.keySet()) {
            if(pr.getName() == p){
                return pr;
            }
        }
        return null;
    }

    public void addNewProduct(Product p,float price, float q){
        this.products.put(p,new float[]{price, q});
    }

    public void deleteProduct(String name) {
        for (Product pr: this.products.keySet()) {
            if(pr.getName() == name){
                this.products.remove(pr);
            }
        }
    }
}
