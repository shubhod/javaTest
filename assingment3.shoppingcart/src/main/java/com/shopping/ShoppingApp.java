package com.shopping;

import java.util.*;

//public class ShoppingApp {
//
//    private Random randomGenerator;
//    private int noOfProducts;
//    private int Totalquantity;
//    private Products products;
//    public List<String> productsList;
//    public ShoppingApp()
//    {
//        randomGenerator = new Random();
//    }
//
//    /**
//     * this method takes input as no of products and quantity of products
//     * after taking the input it will create object of products according to the user and push into the list
//     */
//    public void generateProducts(int noOfProducts,int quantity)
//    {
//         String productName;
//         this.noOfProducts=noOfProducts;
//         this.Totalquantity=noOfProducts*quantity;
//         productsMap=new HashMap<String,Boolean>(Totalquantity);
//         for (int i=0;i<noOfProducts;i++)
//         {   productName="product"+i;
//             this.productsMap.put(productName,true);
//         }
//          this.products=Products.getInstance();
//          this.products.setProductsMap(this.productsMap);
//    }
//
//    /**
//     * this method will randomly generate customers
//     */
//    public void generateCustomers()
//    {

//        int noOfCustomers=(this.Totalquantity)+randomGenerator.nextInt(5);
//        Customers customers=new Customers(products);
//        customers.run();
////        for (int i=0;i<noOfCustomers;i++)
////        {
////                    //Thread customer=new Thread(new Customers(Products.getInstance()));
////        }
//
//    }



//}
