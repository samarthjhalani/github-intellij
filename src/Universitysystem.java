import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class studentt {
    String name;
    int rollno;
    double gpa;


    public studentt(String name, int rollno, double gpa) {
        this.name = name;
        this.rollno = rollno;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "studentt{" +
                "name='" + name + '\'' +
                ", rollno=" + rollno +
                ", gpa=" + gpa +
                '}';
    }
}


public class Universitysystem {
    public static void main(String[] args) {


        Map<String, List<studentt>> sa = new HashMap<>();

        sa.put("computer science", new ArrayList<>(List.of(
                new studentt("samarth", 23, 8.9),
                new studentt("sarthak", 45, 9.0),
                new studentt("arcahan", 56, 9.6)
        )));


        Predicate<studentt> sw = s -> s.gpa >= 8;
        Consumer<studentt> qw = s -> System.out.println("topper" + s);
        System.out.println("top performer");
        sa.values().stream().flatMap(List::stream).filter(sw).forEach(qw);
    }
}
