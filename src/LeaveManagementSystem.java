import java.util.*;

class Employeee {
    private String username;
    private String password;
    private String role;
    private int leaveBalance;
    private Map<String, Integer> leaveTypeBalance;
    private List<String> leaveHistory;

    public Employeee(String username, String password, String role, int leaveBalance) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.leaveBalance = leaveBalance;
        this.leaveTypeBalance = new HashMap<>();
        this.leaveHistory = new ArrayList<>();
        leaveTypeBalance.put("Sick", 3);
        leaveTypeBalance.put("Casual", 5);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public int getLeaveBalance() {
        return leaveBalance;
    }

    public void viewLeaveTypes() {
        System.out.println("Leave Balances by Type:");
        for (Map.Entry<String, Integer> entry : leaveTypeBalance.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void applyLeave(String type, int days) {
        if (!leaveTypeBalance.containsKey(type)) {
            System.out.println("Invalid leave type!");
            return;
        }
        int balance = leaveTypeBalance.get(type);
        if (days <= 0) {
            System.out.println("Invalid number of leave days.");
            return;
        }
        if (days <= balance) {
            leaveTypeBalance.put(type, balance - days);
            leaveBalance -= days;
            leaveHistory.add(type + " leave for " + days + " day(s)");
            System.out.println("Leave approved. Remaining " + type + " leaves: " + leaveTypeBalance.get(type));
            if (leaveBalance < 3) {
                System.out.println("Warning: Low total leave balance!");
            }
        } else {
            System.out.println("Insufficient " + type + " leave balance.");
        }
    }

    public void viewTotalLeaveBalance() {
        System.out.println("Total Leave Balance: " + leaveBalance);
    }

    public void viewLeaveHistory() {
        System.out.println("Leave History:");
        if (leaveHistory.isEmpty()) {
            System.out.println("No leave applications yet.");
        } else {
            for (String record : leaveHistory) {
                System.out.println(record);
            }
        }
    }
}

public class LeaveManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Employeee> users = new HashMap<>();

        users.put("admin", new Employeee("admin", "admin123", "admin", 15));
        users.put("samarth", new Employeee("samarth", "pass123", "employee", 8));

        System.out.println("=== Welcome to Leave Management System ===");
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if (!users.containsKey(username) || !users.get(username).getPassword().equals(password)) {
            System.out.println("Invalid credentials!");
            return;
        }

        Employeee loggedInUser = users.get(username);
        System.out.println("\nLogin successful! Welcome " + loggedInUser.getUsername() + " (" + loggedInUser.getRole() + ")");

        if (loggedInUser.getRole().equals("admin")) {
            System.out.println("\n--- Admin Panel ---");
            System.out.println("All Employee Details:");
            for (Employeee emp : users.values()) {
                System.out.println("User: " + emp.getUsername());
                emp.viewLeaveTypes();
                emp.viewTotalLeaveBalance();
                System.out.println();
            }
        } else {
            while (true) {
                System.out.println("\n--- Employee Menu ---");
                System.out.println("1. View Leave Balance");
                System.out.println("2. Apply for Leave");
                System.out.println("3. View Leave History");
                System.out.println("4. Logout");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        loggedInUser.viewTotalLeaveBalance();
                        loggedInUser.viewLeaveTypes();
                        break;
                    case 2:
                        System.out.print("Enter leave type (Sick/Casual): ");
                        String type = sc.nextLine();
                        System.out.print("Enter number of days: ");
                        int days = sc.nextInt();
                        sc.nextLine();
                        loggedInUser.applyLeave(type, days);
                        break;
                    case 3:
                        loggedInUser.viewLeaveHistory();
                        break;
                    case 4:
                        System.out.println("Logged out.");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }
        sc.close();
    }
}

