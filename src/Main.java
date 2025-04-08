import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class mains {
    String name;
    int age;

    public mains(String name,int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                        ", age=" + age
                ;
    }}

class sam implements Comparator<mains>{

    @Override
    public int compare(mains o1, mains o2) {
        return o2.name.compareTo(o1.name);
    }
}
public class Main{
    public static void main(String[] args) {
        List<mains> as = new ArrayList<>();
        as.add(new mains("samertg",45));
        as.add(new mains("sarthaek",534));
        as.add(new mains("vivek",345));
        as.add(new mains("namam",342));

        Collections.sort(as,new sam());
        System.out.println(as);
        List<mains> sa = as.stream().sorted(Comparator.comparing(p->p.age)).collect(Collectors.toList());
        System.out.println(sa);
    }
}