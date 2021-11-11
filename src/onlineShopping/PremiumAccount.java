package onlineShopping;

import java.util.HashMap;

public class PremiumAccount extends Account {
    HashMap<Product, float[]> products = new HashMap<>();
    public PremiumAccount(String id, Address billing_address, Customer customer) {
        super(id, billing_address, customer);
    }

    public Product containProducts(String p){
        for (Product pr: this.products.keySet()) {
            if(pr.getName().equals(p)){
                return pr;
            }
        }
        return null;
    }

    public void addNewProduct(Product p,float price, float q){
        this.products.put(p,new float[]{price, q});
        p.setPremAcc(this);
    }

    public void removeProduct(String name) {
        for (Product pr: this.products.keySet()) {
            if(pr.getName().equals(name)){
                this.products.remove(pr);
            }
        }
    }

    public void deleteAccount() {
        for (Product p: this.products.keySet()
             ) {
            p.removePremiumAccount();
        }
        super.deleteAccount();
        this.products = null;
    }

    public void findObject(String id) {
        super.findObject(id);
        if(this.id.equals(id)){
            if(this.products.size()>0){
                System.out.println("All products of the premium user:");
                for (Product p: this.products.keySet()
                ) {
                    System.out.println(String.format("Product id: %s", p.getId()));
                }
            }

        }
    }

    public float getProductPrice(Product product) {
        return this.products.get(product)[0];
    }
}
