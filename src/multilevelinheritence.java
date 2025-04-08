class employee{
    void applyleave(){
        System.out.println("go ask manager");
    }
}
class manager extends employee{
    void approveleave(){
        System.out.println("go ask director");
    }
}
class director extends manager {
    void overrideleave(){
        System.out.println("no leave till 31 of decemeber ");
    }
}
public class multilevelinheritence{
    public static void main(String[] args) {
        director dr = new director();
        dr.applyleave();
        dr.approveleave();
        dr.overrideleave();


    }
}