package com.vdab.services;


import com.vdab.domain.Category;
import com.vdab.domain.Products;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Delhaize {
    private Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    private AddingToDBService addingToDatabaseService = new AddingToDBService();
    private ProductService productService= new ProductService();
    private DeletingFromDBService deletingFromDBService = new DeletingFromDBService();


    public static void main(String[] args) {
        Delhaize delhaize = new Delhaize();
        delhaize.showInitialOptions();
    }

    private void showInitialOptions() {
        System.out.println("Please select an option" +
                "\n0. Quit" +
                "\n2. Fill up Database" +
                "\n3. Remove from " +
                "\n3. Remove from Database");

                String choice = scanner.next();
                switch (choice) {
                    case "0":
                        System.exit();
                    case"1":
                        addProduct();

                    case "2":
                        chooseClassToAdd();
                        break;

                    case "3":
                        chooseClassToDelet();
                }
    }

    private void addProduct() {   System.out.println("Please select a category" +
            "\n1. Food" +
            "\n2. Cleaning" +
            "\n3. Personal Care" +
            "\n4. Drinks" +
            "\n5. Pet Food");
        Category category = addingToDatabaseService.getCategoryById(scanner.nextInt());
        System.out.println("What is the name of the product?");
        String name = scanner.next();
        System.out.println("Type in the description of the product");
        scanner.nextLine();
        String description = scanner.nextLine();
        System.out.println("What price do you want to sell the product for");
        double price = scanner.nextDouble();
        Products product = Products.builder()
                .productName(name)
                .price(price)
                .description(description)
                .category(category)
                .build();
        addingToDatabaseService.addProductToDB(product);
    }

    private void chooseClassToDelet() {
        List<Products> productList = productService.listOfProducts();
        for(Products p : productList){
            System.out.println(p.getId() + "\t" + p.getProductName());
        }
        System.out.println("Enter the id of the product you want to delete");
        deletingFromDBService.deleteProductById(scanner.nextInt());
    }

    private void chooseClassToAdd() {
        System.out.println("Please select class object to add to database\n" +
                "0. Go Back \n" +
                "1. Products\n" +
                "1. Products\n"
        );
        String choice = scanner.next();
        switch (choice) {
            case "0":
                showInitialOptions();
            case "1":
                addProduct();
        }
    }

}

