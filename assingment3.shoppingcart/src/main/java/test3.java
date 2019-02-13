import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;


class  l{
    static Map<Integer,Integer> m1=new ConcurrentHashMap<Integer, Integer>(10);
}
public class test3 {

    public static void main(String []args)
    {
        for (int i=0; i<10;i++)
    {
        l.m1.put(i,i);
    }

        ExecutorService es = Executors.newFixedThreadPool(10);

        for(int i=0;i<5;i++)
        {
            es.submit(new task());


        }
    }
}
class  task implements Runnable
{

    static  int i=0;

    public void run() {

        for (Map.Entry<Integer, Integer> entry : l.m1.entrySet())
        {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(currentThread().getName()+"acessing segment"+entry);
            entry.setValue(i+1);
            System.out.println(currentThread().getName()+"changed"+entry);
            i++;

        }
    }
}