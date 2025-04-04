class student {
    private String name;
    private int rollnumber;
    private double marks;

    public student(int rollnumber, String name, double marks) {
        this.rollnumber = rollnumber;
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollnumber() {
        return rollnumber;
    }

    public void setRollnumber(int rollnumber) {
        this.rollnumber = rollnumber;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
        if (marks >= 0 && marks <= 100) {
            this.marks = marks;
        } else {
            System.out.println("Invalid marks! Enter marks between 0 and 100.");
        }
    }
}


public class encapsulationexample {
    public static void main(String[] args) {
        student s1 = new student(101, "alice", 99);
        new student(23,"samarth",12);
        System.out.println(s1.getMarks());
        System.out.println(s1.getName());
        System.out.println(s1.getRollnumber());
        s1.setMarks(23);
        s1.setName("samrthjha");
        System.out.println(s1.getRollnumber());
    }
}
