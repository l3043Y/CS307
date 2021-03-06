package org.sustcDB2019.controller;

import java.sql.SQLOutput;
import java.util.Scanner;

import org.sustcDB2019.entity.Customer;
import org.sustcDB2019.entity.User;
import org.sustcDB2019.service.*;
import org.sustcDB2019.controller.*;

import javax.crypto.Mac;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainController {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        UserService userService = new UserService();
        System.out.println("Welcome to Newly Retailing Chain Store!\nPlease log in or sign up.");
        boolean flag1 = true;
        do {
            System.out.println("1. Log in\n2. Sign up\n3. Exit");
            int option = in.nextInt();
            int back = 1;
            if(option==1){
                User user = new User();
                do{
                    System.out.print("Username: ");
                    String name = in.next();
                    System.out.print("Password: ");
                    String password = in.next();
                    back = userService.signIn(name, password);
                    switch (back){
                        case 2:
                            ManagerService managerService = (ManagerService) userService;
                            //manager
                            System.out.println("Log in successfully!");
                            ManageController.ManagerView(managerService);
                            break;
                        case 4:
                            // cashier
                            break;
                        case 6:
                            //deliverer
                            System.out.println("Log in successfully!");
                            break;
                        case 30:
                            System.out.println("Log in successfully!");
                            CustomerService customerService = (CustomerService) userService;
                            AdminController.CustomerView(customerService);
                            // customer
                            break;
                        case -1:
                            System.out.println("Your username or password is wrong, please input again.");
                            break;
                    }
                } while(back==-1);
            } else if(option==2){
                Customer customer = new Customer();
                int repite = 0;
                String name;
                do {
                    System.out.print("Please set your username: ");
                    customer.setUserName(in.next());
                    if (repite==1){
                        System.out.println("The username repeated, please input again.");
                    }
                } while (repite==1);
                System.out.print("Please set your password: ");
                customer.setPassword(in.next());
                System.out.print("Please set your phone number: ");
                customer.setPhoneNumber(in.next());
                System.out.print("Please set your address: ");
                customer.setAddress(in.next());
                // 传入字符串
                System.out.println("Sign up successfully.");
            } else if(option==3){
                flag1 = false;
            } else {
                System.out.println("Your input is wrong, please input again.");
            }
        } while (flag1);
        System.out.println("Thank you for your visit. Welcome to come again.");
    }

}
