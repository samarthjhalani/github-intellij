class Employee {
    String empName;
    int empId;

    public Employee(String empName, int empId) {
        this.empName = empName;
        this.empId = empId;
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + empName);
    }
}

class LeaveManager extends Employee {
    int leaveBalance;

    public LeaveManager(String empName, int empId, int leaveBalance) {
        super(empName, empId);
        this.leaveBalance = leaveBalance;
    }

    public void applyLeave(int days) {
        if (days <= leaveBalance) {
            leaveBalance -= days;
            System.out.println("Leave Approved! Remaining Leave Balance: " + leaveBalance);
        } else {
            System.out.println("Insufficient Leave Balance!");
        }
    }
}

public class singleinheritence {
    public static void main(String[] args) {
        LeaveManager emp = new LeaveManager("John Doe", 101, 10);
        emp.displayEmployeeDetails();
        emp.applyLeave(5);
        emp.applyLeave(6);
    }
}
