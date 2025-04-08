import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

class Laptop {
    String brand;
    String model;
    int yearOfPurchase;

    public Laptop(String brand, String model, int yearOfPurchase) {
        this.brand = brand;
        this.model = model;
        this.yearOfPurchase = yearOfPurchase;
    }

    public int getlaptopage() {
        return Calendar.getInstance().get(Calendar.YEAR) - yearOfPurchase;
    }

    ;

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", yearOfPurchase=" + yearOfPurchase +
                '}';
    }
}


public class LaptopManagementSystem {
    public static void main(String[] args) {
        List<Laptop> laptoplist = new ArrayList<>(Arrays.asList(
                new Laptop("hp","hp333",2020),
                new Laptop("dell","dell113-f",2013),
                new Laptop("mac","macbook",2024)
        ));
        Predicate<Laptop> isoutdated = s->s.getlaptopage()>3;
        Predicate<Laptop> isnotoutdated= s->s.getlaptopage()<3;
        Consumer<Laptop> laptoplistt=s-> System.out.println(s);
        Supplier<Laptop> newlaptop= ()->new Laptop("asus","asusdra12",2025);

        System.out.println("is out dated laptop");
        laptoplist.stream().filter(isoutdated).forEach(laptoplistt);
        System.out.println("is not outdated");
        laptoplist.stream().filter(isnotoutdated).forEach(laptoplistt);
        Laptop laptop = newlaptop.get();
        System.out.println("new laptop added ");
        laptoplistt.accept(laptop);

    }
}
