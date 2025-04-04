interface Camera {
    void capturephotos();

    void recordvedios();

}
interface Musicplayer{
    void playmusic();
    void stopmusic();
}
class Phone implements Camera,Musicplayer{

    @Override
    public void capturephotos() {
        System.out.println("capturing photos");
    }

    @Override
    public void recordvedios() {
        System.out.println("recording vedios");
    }

    @Override
    public void playmusic() {
        System.out.println("music is playing ");

    }

    @Override
    public void stopmusic() {
        System.out.println("stopping music ");
    }
}

public class Multipleinherit {
    public static void main(String[] args) {
        Phone p1 = new Phone();
        p1.capturephotos();

    }
}
