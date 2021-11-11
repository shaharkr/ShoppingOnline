package com.company;

import onlineShopping.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ShoppingSystem shopSys = new ShoppingSystem();
        Scanner scanner = new Scanner(System.in);
        String input = null;
        while(input != "13"){
            System.out.println("(1) add new user");
            System.out.println("(2) remove user");
            System.out.println("(3) login user");
            System.out.println("(4) logout user");
            System.out.println("(5) create new order");
            System.out.println("(6) add product to order");
            System.out.println("(7) display order");
            System.out.println("(8) link product");
            System.out.println("(9) add product");
            System.out.println("(10) delete product");
            System.out.println("(11) show all objects");
            System.out.println("(12) show object id");
            System.out.println("(13) exit system");
            input = scanner.nextLine();
            switch (input){
                case "1":
                    shopSys.addUser();
                    break;
                case "2":
                    shopSys.removeUser();
                    break;
                case "3":
                    shopSys.Login();
                    break;
                case "4":
                    shopSys.Logout();
                    break;
                case "5":
                    shopSys.CreateNewOrder();
                    break;
                case "6":
                    shopSys.addProductToOrder();
                    break;
                case "7":
                    shopSys.displayOrder();
                    break;
                case "8":
                    shopSys.linkProduct();
                    break;
                case "9":
                    shopSys.addProduct();
                    break;
                case "10":
                    shopSys.deleteProduct();
                    break;
                case "11":
                    shopSys.ShowAllObjects();
                    break;
                case "12":
                    shopSys.ShowObjectId();
                    break;
                default:
                    System.exit(0);
            }
        }
	// write your code here
    }
}
