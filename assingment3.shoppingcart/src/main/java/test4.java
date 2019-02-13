import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static java.lang.Thread.currentThread;
public class test4 {

    public static  void main(String []args)
    {
        ExecutorService es = Executors.newFixedThreadPool(10);
        resourceManager r=new resourceManager();

        for (int i=0;i<30;i++)
        {
            es.execute(new task2(r));
        }

    }

}



