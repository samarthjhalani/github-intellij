class animal {
    public void animals() {
        System.out.println("u are seeing animals sound ");
    }

    public void sound() {
        System.out.println("animal make sound");
    }
}

class dog extends animal {
    @Override
    public void sound() {
        System.out.println("dog barks");
    }
}


class cat extends animal {
    @Override
    public void sound() {
        System.out.println("cat meow");
    }
}

public class AnimalMain {
    public static void main(String[] args) {


        animal d1 = new dog();
        animal c1 = new cat();
        d1.animals();
        d1.sound();
        c1.animals();
        c1.sound();
    }
}
