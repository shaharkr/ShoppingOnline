package onlineShopping;

import java.util.ArrayList;

public class Supplier {
    String id;
    String name;
    ArrayList<Product> products;

    public Supplier(String id, String name,ArrayList<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public Supplier(String id, String name) {
        this.id = id;
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}


    public void removeProduct(String name) {
        for (Product pr: this.products) {
            if(pr.getName() == name){
                this.products.remove(pr);
            }
        }
    }
}
