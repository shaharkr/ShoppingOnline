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

    public void showSupplier(){
        System.out.println(String.format("Suppplier id: {0}", this.getId()));
    }

    public void findObject(String id) {
        if (this.id == id) {
            System.out.println(String.format("Supplier id: {0}", this.id));
            System.out.println(String.format("Supplier name: {0}", this.name));
            System.out.println("All products that are connected to this supplier:");
            for (Product p : this.products
                 ) {
                System.out.println(String.format("Product id: {0}", p.getId()));
            }
        }
    }

}
