import java.util.*;

class Student {
    int rollNo;
    String name;
    double marks;
    String branch;

    public Student(int rollNo, String name, double marks, String branch) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Marks: " + marks + ", Branch: " + branch;
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            try {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();

                System.out.print("Enter roll number: ");
                int rollNo = scanner.nextInt();

                System.out.print("Enter marks: ");
                double marks = scanner.nextDouble();

                if (marks < 0 || marks > 100) {
                    System.out.println("Invalid marks. Please enter a value between 0 and 100.");
                    i--;
                    scanner.nextLine();
                    continue;
                }

                scanner.nextLine();
                System.out.print("Enter branch (Engineering/Medical): ");
                String branch = scanner.nextLine();

                students.add(new Student(rollNo, name, marks, branch));
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter correct data types.");
                scanner.nextLine();
                i--;
            }
        }

        students.sort(Comparator.comparing(s -> s.name));
        System.out.println("\nSorted by Name:");
        students.forEach(System.out::println);

        students.sort((s1, s2) -> Double.compare(s2.marks, s1.marks));
        System.out.println("\nSorted by Marks Descending:");
        students.forEach(System.out::println);

        students.sort(Comparator.comparingInt(s -> s.rollNo));
        System.out.println("\nSorted by Roll Number:");
        students.forEach(System.out::println);

        double topMarks = students.stream().mapToDouble(s -> s.marks).max().orElse(0);
        System.out.println("\nTopper(s):");
        students.stream().filter(s -> s.marks == topMarks).forEach(System.out::println);

        Map<String, List<Student>> branchGroups = new HashMap<>();
        for (Student s : students) {
            branchGroups.computeIfAbsent(s.branch, k -> new ArrayList<>()).add(s);
        }

        System.out.println("\nStudents by Branch:");
        for (String branch : branchGroups.keySet()) {
            System.out.println("Branch: " + branch);
            branchGroups.get(branch).forEach(System.out::println);
        }

        scanner.close();
    }
}
