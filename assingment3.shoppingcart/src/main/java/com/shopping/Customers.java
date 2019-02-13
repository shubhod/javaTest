package com.shopping;

import java.io.IOException;
import java.util.Random;
import static java.lang.Thread.currentThread;

class Customers implements  Runnable
{
    static Random random=new Random();
    int index=random.nextInt(4);
    private ProductManager productManager;
    Customers(ProductManager productManager)
    {
        this.productManager=productManager;
    }
    public void run()  {

        try {
            productManager.productList.get(index).getProduct(currentThread().getName());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }
}