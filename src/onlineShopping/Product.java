package onlineShopping;

import java.util.ArrayList;

public class Product {
    Supplier supplier;
    String id;
    String name;
    PremiumAccount premAcc = null;
    ArrayList<LineItem> lineItems = new ArrayList<>();

    public Product(Supplier supplier, String name) {
        this.supplier = supplier;
        this.id = name;
        this.name = name;
    }

    public void addLineItem(LineItem li){
        this.lineItems.add(li);
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public void setPremAcc(PremiumAccount premAcc) {
        if(this.premAcc != null){
            this.premAcc = premAcc;
        }
    }

    public PremiumAccount getPremAcc() {
        return this.premAcc;
    }


    public void deleteProduct() {
        this.supplier.removeProduct(this.name);
        if(this.premAcc != null){this.premAcc.removeProduct(this.name);}
        for (LineItem li: this.lineItems
             ) {
            li.deleteLineItemFromProduct();
        }
        this.lineItems = null;
        this.supplier = null;
        this.premAcc = null;
    }

    public void removeLineItem(LineItem lineItem) {
        for (LineItem li: this.lineItems
        ) {
            if(li == lineItem){
                this.lineItems.remove(li);
            }
        }
    }

    public void removePremiumAccount() {
        this.premAcc = null;
    }

    public void showProduct(){
        System.out.println(String.format("Product id: {0}", this.getId()));
    }

    public void findObject(String id) {
        if(this.id == id){
            System.out.println(String.format("Product id: {0}", this.id));
            System.out.println(String.format("Product name: {0}", this.name));
            System.out.println(String.format("Product supplier id: {0}", this.supplier.getId()));
            System.out.println(String.format("Premium Account id: {0}", this.premAcc.getId()));
            System.out.println("All lineItems that are connected to this product:");
            for (LineItem li: this.lineItems
            ) {
                System.out.println(String.format("LineItem id: {0}", li.getPrice()));
            }
        }
    }
}
