package onlineShopping;

public class User {
    UserState state;
    String login_id;
    String password;
    Customer customer;
    ShoppingCart shop_cart;

    public User(String login_id, String password, Address address, String phone, String email, int premium) {
        this.state = UserState.New;
        this.login_id = login_id;
        this.password = password;
        this.customer = new Customer(login_id, address, phone, email, this, premium); //verify that this customer dosent belong to another user
        this.shop_cart = this.customer.getAccount().getShopCart();
    }

    public boolean shoppingCartIsNull(){
        return this.shop_cart == null;
    }

    public onlineShopping.UserState getState() {
        return state;
    }

    public void setState(UserState state) {
        this.state = state;
    }

    public String getLogin_id() {
        return login_id;
    }

    public void setLogin_id(String login_id) {
        this.login_id = login_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public onlineShopping.Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ShoppingCart getShop_cart() {
        return shop_cart;
    }

    public void setShop_cart(ShoppingCart shop_cart) {
        this.shop_cart = shop_cart;
    }

    public void deleteUser() {
        this.customer.deleteCustomer();
        this.customer = null;
    }

    public void showUser(){
        System.out.println(String.format("User login id: {0}", this.login_id));
        this.customer.showCustomer();
    }

    public void findObject(String id){
        if(this.login_id != id){
            this.customer.findObject(id);
        }
        else{
            System.out.println(String.format("User login id: {0}", this.login_id));
            System.out.println(String.format("User password: {0}", this.password));
            System.out.println(String.format("User state: {0}", this.state));
            System.out.println(String.format("User shoppingCart creation date: {0}", this.shop_cart.created));
            System.out.println(String.format("User customer id: {0}", this.customer.getId()));
        }
    }
}
