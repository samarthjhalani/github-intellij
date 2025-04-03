class test1 extends Thread{
    public void run(){
        try{
            System.out.println("threading is making");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}






public class Threadingexample {
}
