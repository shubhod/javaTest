
class  Aobj  {

    int i=0;
    String name;
    private Aobj()
    {


    }
    private static  class Helper
    {
        static Aobj inst=new Aobj();
    }
    void setName(String name){
        this.name=name;
    }
    Aobj getInst(){

        return  Helper.inst;

    }

}
class consumer1 implements Runnable{

    public void run() {
        System.out.println(Thread.currentThread().getName());

    }
}
public class test2 {
    public static void main(String []args)
    {

            for (int i=0; i<10;i++)
            {  Thread t=new Thread(new consumer1());
                t.setPriority(i);
                t.start();

            }

    }

}