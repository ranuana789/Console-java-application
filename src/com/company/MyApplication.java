package com.company;
import com.company.ProductController;
import com.company.IProductRepository;
import java.util.Scanner;

public class MyApplication {
    private final ProductController controller;
    private final Scanner scanner;
    public MyApplication(IProductRepository userRepository){
        controller = new ProductController(userRepository);
        scanner = new Scanner(System.in);
    }
    public void start(){
        while(true){
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option: ");
            System.out.println("1. -Purchase products");
            System.out.println("2. - See my orders");
            System.out.println("3. -Other menu of your own");
            System.out.println("4. -Exit");
            System.out.println();
            try{
                System.out.println("Enter option (1-4): ");
                int option = scanner.nextInt();
                if(option ==1){
                    getAllProducts();
                } else if(option ==2){
                    getUsersProductsByID();
                } else if(option ==3){
                    createProduct();
                } else{
                    break;
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            System.out.println("**********************");
        }
    }
    //
    public void getAllProducts(){
        System.out.println("**********************");
        System.out.println("Here is all products:");
        String response = controller.getAllProducts();
        System.out.println(response);
    }
    public void getUsersProductsByID(){
        System.out.println("**********************");
        System.out.println("Please enter id: ");

        int id = scanner.nextInt();
        String response = controller.getProduct(id);
        System.out.println(response);
    }
    public void createProduct() {
        System.out.println("**********************");
        System.out.println("Please enter name of the Product");
        String name = scanner.next();
        System.out.println("Please enter details of the Menu");
        String details = scanner.next();


        String response = controller.createProduct(name, details);
        System.out.println(response);

    }

}
