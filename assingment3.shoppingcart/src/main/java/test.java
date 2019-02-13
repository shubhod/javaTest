import static java.lang.Thread.sleep;

class a{
    private  int i=0;
    boolean flag=false;
    public  synchronized  void get()
    {
        while (!flag)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag=false;
        System.out.println("get"+this.i);
        notify();
    }
    public synchronized  void set(int i)
    {
        System.out.println("setter running..");
        while(flag)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag=true;
        System.out.println("set"+this.i);
        this.i=i;
        notify();
    }

}
class getter implements Runnable{
    a a1;
    getter(a a1)
    {
        this.a1=a1;
    }
    public void run() {
        System.out.println("getter running..");
        while(true)
        {
            a1.get();
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
};
class setter implements Runnable{

    a a1;
    setter(a a1){
        this.a1=a1;
    }
    public void run()
    {
        System.out.println("setter  running..");
            int i=0;
            while(true)
            {
                a1.set(i);
                ++i;
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}
        public class test {
            public static  void main(String []args)
            {   a a1=new a();
                Thread t1=new Thread(new getter(a1));
                Thread t2=new Thread(new setter(a1));
                t2.start();
                t1.start();

            }
        }


