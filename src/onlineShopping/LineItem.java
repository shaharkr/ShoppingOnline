package onlineShopping;

public class LineItem {
    int quantity;
    float price;
    ShoppingCart shop_cart;
    Order order;
    Product product;

    public LineItem(ShoppingCart shop_cart, Order order, Product product) {
        this.shop_cart = shop_cart;
        this.order = order;
        this.product = product;
        this.product.addLineItem(this);
        this.quantity = 1;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ShoppingCart getShop_cart() {
        return shop_cart;
    }

    public void setShop_cart(ShoppingCart shop_cart) {
        this.shop_cart = shop_cart;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public String getProductName() {
        return product.getName();
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void deleteLineItemFromProduct() {
        this.order.removeLineItem(this);
        this.shop_cart.removeLineItem(this);
    }

    public void deleteLineItemFromOrder() {
        this.product.removeLineItem(this);
        this.shop_cart.removeLineItem(this);
        this.product = null;
        this.shop_cart = null;
    }

    public void showLineItem() {
        System.out.println(String.format("LineItem price: %s", this.getPrice()));
    }
}
