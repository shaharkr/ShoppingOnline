package onlineShopping;

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingSystem {
    ArrayList<User> users = new ArrayList<>();
    User activeUser = null;
    boolean isUserLoggedIn = false;
    Scanner scanner = new Scanner(System.in);

    public void addUser(){
        String[] outputDetails = new String[]{"Insert userID",
                                        "Insert password",
                                        "Insert address",
                                        "Insert phone number",
                                        "Insert email",
                                        "Upgrade to premium? enter Y/n"};
        String[] inputDetails = new String[outputDetails.length];
        String input = null;
        for (int i = 0; i < outputDetails.length; i++) {
            java.lang.System.out.println(outputDetails[i]);
            input = scanner.nextLine();
            inputDetails[i] = input;
        }
        Address address = new Address(inputDetails[2]);
        User user = new User(inputDetails[0],inputDetails[1],address,inputDetails[3],inputDetails[4],
                inputDetails[5]=="Y"?1:0);
        users.add(user);
        System.out.println("User created successfully");
    }

    public void removeUser(){
        System.out.println("In order to remove please insert userID");
        String input = scanner.nextLine();
        int index = -1 ;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getLogin_id() == input) {
                index = i;
                break;
            }
        }
        if (index != -1){
            users.remove(index);
            System.out.println("user removed successfully");
        }
        else{
            System.out.println("User not found");
        }
    }

    public void Login(){
        if(isUserLoggedIn){
            System.out.println("ShoppingSystem is occupied by another user, please try later.");
        }
        else{
            System.out.println("In order to login please insert UserId");
            String inputLogin = scanner.nextLine();
            System.out.println("In order to login please insert Password");
            String inputPassword = scanner.nextLine();
            for (User user: users) {
                if(user.getLogin_id() == inputLogin && user.getPassword() == inputPassword){
                    user.state = UserState.Active;
                    isUserLoggedIn = true;
                    activeUser = user;
                    System.out.println("The user login to the system");
                    return;
                }
            }
            System.out.println("user not exist");
        }
    }

    public void Logout(){
        System.out.println("In order to logout please insert UserId");
        String inputLogin = scanner.nextLine();
        if(activeUser.getLogin_id() == inputLogin){
            //todo:activeUser.state = State
            activeUser = null;
            isUserLoggedIn = false;
        }
        else{
            System.out.println("requested user is not logged in");
        }

    }

    public void CreateNewOrder(){
        if(!this.isUserLoggedIn){
            System.out.println("To create an order, login to your user");
            return;
        }
        System.out.println("Please insert delivery address");
        String inputLogin = scanner.nextLine();
        Account account = activeUser.getCustomer().getAccount();
        Order order = new Order(new Address(inputLogin), account);
        account.addOrder(order);
        System.out.println(String.format("New order created successfully./nThe order number is: {0}",
                                        order.getNumber().toString()));
    }

    public void addProductToOrder(){
        if(!this.isUserLoggedIn){
            System.out.println("To create an order, login to your user");
            return;
        }
        System.out.println("Please insert login id");
        String loginId = scanner.nextLine();
        PremiumAccount prem_acc = null;
        for (User user: users) {
            if((user.getLogin_id() == loginId) && (user.getCustomer().getAccount() instanceof PremiumAccount)){
                prem_acc = ((PremiumAccount)user.getCustomer().getAccount());
                break;
            }
        }
        if(prem_acc != null){
            System.out.println("User id does not exist");
            return;
        }
        System.out.println("Please insert order id");
        String orderId = scanner.nextLine();
        int flag = 0;
        for (Order order: this.activeUser.getCustomer().getAccount().getOrders()) {
            if(order.getNumber() == orderId){
                flag++;
                break;
            }
        }
        if(flag == 1){
            System.out.println("Order id does not exist.\nFirst create new order");
            return;
        }
        System.out.println("Please insert product name");
        String productName = scanner.nextLine();
        Product product = prem_acc.containProducts(productName);
        if(product != null){
            System.out.println("The product does not exist");
            return;
        }
        this.activeUser.getCustomer().getAccount().addProductToOrder(orderId, product);
        // todo: how determines the price?
    }

    public void displayOrder(){
        if(!this.isUserLoggedIn){
            System.out.println("To create an order, login to your user");
            return;
        }
        Order order = this.activeUser.getCustomer().getAccount().getLatlestOrder();
        if(order == null){
            System.out.println("No orders have been placed yet");
            return;
        }
        String[] details = new String[]{String.format("order number: {0}", order.getNumber()),
                                                        String.format("ordered: {0}",order.getOrdered()),
                                                        String.format("shipping date: {0}", order.getShipped()),
                                                        String.format("shipped to: {0}", order.getShip_to().address),
                                                        String.format("status: {0}",order.getStatus()),
                                                        String.format("total price: {0}", order.getTotal())};
        for (String str: details
             ) {
            System.out.println(str);
        }
    }


}