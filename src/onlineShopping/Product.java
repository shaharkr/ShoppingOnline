package onlineShopping;

public class Product {
    onlineShopping.Supplier supplier;
    String id;
    String name;

    public Product(Supplier supplier, String id, String name) {
        this.supplier = supplier;
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
