class test1 extends Thread {
    public void fun() {
        try {
            System.out.println("threading is making");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class test2 extends Thread {
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(500);
                System.out.println("thread will be print 5 times" + (i + 1));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
class test3 extends Thread{
    public void run(){
        try{
            System.out.println("threading is in test3 ");
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
class test4 extends Thread{
    public void run(){
        try{
            System.out.println("thread is in 4 state ");
            Thread.sleep(1200);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
public class Threadingexample {
    public static void main(String[] args) throws InterruptedException {

//
//       test1 t1 = new test1();
//        test2 t2 = new test2();
//        test3 t3 = new test3();
//        test4 t4 = new test4();
//        t1.start();
//        t1.join();
//        t2.start();
//        t2.join();
//        t3.start();
//        t3.join();
//        t1.start();
//        t1.join();
//        t4.start();;
//        t4.join();

Thread[] threads = {
       new test1(),new test2(),new test3(),new test1(),new test4()
};
for(Thread thread :threads){
    thread.start();
    thread.join();
}
    }
}