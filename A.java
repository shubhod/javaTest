import java.time.LocalDate;
import java.util.*;
import java.io.*;
class A
{
    void r() throws Exception
    {
            System.out.println("this is A");
    }
}
class B 
{       
    void r()  {
            int y=8;
                try
                    {
                        int x=10/0;
                        throw new Exception();
                    }
                catch(Exception e)
                    {
                                y=0;
                                System.out.println("hello");
                                //throw new Exception();
                    }
                finally{
                    System.out.println("hello"+y);
                }

                 
        }
}
// interface Y
// {
//     default void x(){
//         System.out.println("hello this Y");
//     };
// }
// }
// interface Z
// {
//     default void x(){
//         System.out.println("hello this X");
//     };
// }
// interface X extends Y,Z 
// {   
//     default void x(){
//         System.out.println("hello this is X");
//         Z.super.x();
//         Y.super.x();
//     };
// }
// class D implements X
// {
//        public  void x()
//             {
//                 System.out.println("hello");
//                 X.super.x();
//             }
// }
class  Y
    {
       static void r()
            {
                System.out.println("X");
            }
    }
class X extends Y
    {

    }
class c {
    public static void main(String[] args){
        int y=2;
      B b=new B();
      try
        {   
            b.r();
            System.out.println("try");
            y=9;
        }
        catch(Exception e)
            {
                System.out.println("handeled"+y);
            }
      

    }
}


