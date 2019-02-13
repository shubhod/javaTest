package com.shopping;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * this class will be used as product that the  customer will buy which is a shred resource
 */

public class  Products
{
    public static int totalQuantity;
    private int quantity;
    private Random randomNumber;
    private String productName;
    private int randomNumberPayment;
    private int getRandomNumberPaymentMethod;
    private FileWriter fileWriter;
    private String PaymentMode;
    Products(String productName,int quantity,FileWriter fileWriter)
    {
        this.quantity=quantity;
        this.productName=productName;
        randomNumber=new Random();
        this.fileWriter=fileWriter;
    }

    /**
     * @param name
     * @throws IOException
     * using this method the customer can get access to product resource and do operations like read and update
     */
    void   getProduct(String customerName) throws IOException {
        randomNumberPayment=randomNumber.nextInt(2);
        getRandomNumberPaymentMethod=randomNumber.nextInt(2);
        System.out.println(randomNumberPayment);
        System.out.println(customerName+" "+"trying to  buy the "+" "+productName+" available quantity "+quantity);

        // this particular block has been synchronized  because this block is updating the resource
        synchronized (this)
        {
            if(totalQuantity>0)
            {
                if(quantity>0)
                {
                    if(randomNumberPayment==1)
                    {

                        quantity--;
                        System.out.println(customerName+" "+"bought"+productName);
                        if(getRandomNumberPaymentMethod==1)
                        {
                            System.out.println("transaction  successfull payment by card");
                            PaymentMode="card";
                        }
                        else
                        {
                            System.out.println("transaction successfull cash on delivery");
                            PaymentMode="COD";

                        }
                        fileWriter.write("customer Name:"+customerName+"\n"+"productName:"+productName+"\ntransaction:sucessfull\n"+"PaymentMode:"+PaymentMode+"\n\n");
                    }
                    else
                    {
                        System.out.println("transaction unsuccessfull");
                        fileWriter.write("customer Name:"+customerName+"\n"+"productName:"+productName+"\ntransaction:failed\n\n");
                    }

                }
                else
                {
                    System.out.println("sorry quantity of product +"+productName+"has finished"+"for customer "+customerName);
                }

                totalQuantity--;
                System.out.println();
                System.out.println("Total products available"+" "+totalQuantity);

            }
            else
            {
                System.out.println("market closed");
                fileWriter.close();
                System.exit(1);
            }
        }

    }
}