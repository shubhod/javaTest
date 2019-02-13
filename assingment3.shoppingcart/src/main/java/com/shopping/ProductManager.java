package com.shopping;

import java.io.FileWriter;
import java.io.IOException;


public class ProductManager
{
    private FileWriter fileWriter;
    List<resource> productList;
    ProductManager()
    {

        productList= new ArrayList<resource>(5);
        resource.totalQuantity=10;
        try {
            fileWriter = new FileWriter("transaction.txt",true);
        } catch (IOException e) {
            e.printStackTrace();
            throw  new RuntimeException();
        }
        for (int i=0;i<5;i++)
        {
            productList.add(new Products("product"+i,2,fileWriter));
        }

    }


}