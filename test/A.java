import java.util.*;

class a {
    void r() {
        System.out.println("class a");
    }
}

class b extends a {
    void r() {
        System.out.println("class b");
    }
}

class z extends b {
    void r() {
        System.out.println("class c");
    }
}
class f{
    void r() {
        System.out.println("class f");
    }
}

class c
{
    public static void main(String[] args){

       f f1=new f(){
           public void r() { System.out.println("class c");} 
       };
       f1.r();
        // a z1 = new z();
        // a b1 = new b();
        // a a1 = new a();

        // z z1 = new z();
        // b b1 = new b();
        // a a1 = new a();
        // c c1 = new c();
        // c1.print(z1);
        // c1.print(b1);
        // c1.print(a1);
        // String x= "1234";
        // System.out.println((int)x.charAt(0));  
        // int a[]=new int[5];
        // Integer i=new Integer(4);
        // //System.out.println(i+2);
        // new Timer().scheduleAtFixedRate(new TimerTask(){
        //     public void run(){
        //             i=i+1;
        //     }
        // },0,60000*60*24*30);
        }
}




    



    
        
      
    
    
