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
}
