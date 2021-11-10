package onlineShopping;

import java.util.ArrayList;
import java.util.Objects;

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


    public PremiumAccount getPremAcc(PremiumAccount premAcc) {
        return this.premAcc;
    }


    public void deleteProduct() {
        this.supplier.deleteProduct(this.name);
        if(this.premAcc != null){this.premAcc.deleteProduct(this.name);}
        for (LineItem li: this.lineItems
             ) {
            li.deleteLineItem();
        }
    }
}
