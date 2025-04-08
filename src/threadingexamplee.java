import java.io.InterruptedIOException;
import java.security.PublicKey;

class claculation extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) ;
        System.out.println("thread running ");
        try {
            Thread.sleep(12221);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class calculation1 implements Runnable {
    public void run(){
        System.out.println("thread is not running ");
        try{
            Thread.sleep(23421);
        }catch(InterruptedException e){
            throw new RuntimeException(e);

        }
    }
}
public class threadingexamplee {
    public static void main(String[] args) {
        claculation c1 = new claculation();
        calculation1 c2 = new calculation1();
        c1.start();
        c2.run();

    }
}
