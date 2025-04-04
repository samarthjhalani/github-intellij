import java.util.*;

class studentdetails {
    String studentName;
    int marks;
    int rollno;

    public studentdetails(String studentName, int marks, int rollno) {
        this.studentName = studentName;
        this.marks = marks;
        this.rollno = rollno;
    }

    @Override
    public String toString() {
        return "studentdetails{" +
                "studentname='" + studentName + '\'' +
                ", marks=" + marks +
                ", rollno=" + rollno +
                '}';
    }
}

class studnesort implements Comparator<studentdetails> {

    @Override
    public int compare(studentdetails o1, studentdetails o2) {
        return o2.studentName.compareTo(o1.studentName);
    }
}

public class StudentMangement {
    public static void main(String[] args) {
        List<studentdetails> sc = new ArrayList<>();
        sc.add(new studentdetails("samarthjhalani",23,234));
        sc.add(new studentdetails("anjali",24,765));
        sc.add(new studentdetails("harsh",89,9));




        Collections.sort(sc, new studnesort() );
        sc.forEach(System.out::println);
    }
}

