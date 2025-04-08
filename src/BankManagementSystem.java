import java.util.*;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class Account {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }
        balance -= amount;
        System.out.println("Amount withdrawn successfully.");
    }

    @Override
    public String toString() {
        return "AccountNumber: " + accountNumber + ", Name: " + accountHolderName + ", Balance: " + balance;
    }
}

public class BankManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Account> accounts = new ArrayList<>();

        accounts.add(new Account(101, "Alice", 5000));
        accounts.add(new Account(102, "Bob", 3000));
        accounts.add(new Account(103, "Charlie", 8000));

        System.out.println("Are you a Manager or a Customer? (Enter 'manager' or 'customer'):");
        String userType = sc.nextLine().trim().toLowerCase();

        if (userType.equals("manager")) {
            Map<Integer, Runnable> managerMenu = new HashMap<>();
            managerMenu.put(1, () -> {
                accounts.sort(Comparator.comparing(Account::getAccountHolderName));
                accounts.forEach(System.out::println);
            });
            managerMenu.put(2, () -> {
                System.out.print("Enter account number to search: ");
                int searchNumber = sc.nextInt();
                Account found = findAccount(accounts, searchNumber);
                System.out.println(found != null ? found : "Account not found.");
            });
            managerMenu.put(3, () -> {
                System.out.println("Exiting Manager Panel.");
                System.exit(0);
            });

            while (true) {
                System.out.println("\n--- Manager Menu ---");
                System.out.println("1. View All Accounts (Sorted by Name)");
                System.out.println("2. Search Account");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                managerMenu.getOrDefault(choice, () -> System.out.println("Invalid choice. Try again.")).run();
            }

        } else if (userType.equals("customer")) {
            System.out.println("Do you have an account? (yes/no): ");
            String hasAccount = sc.nextLine().trim().toLowerCase();

            Account customer = null;

            if (hasAccount.equals("yes")) {
                System.out.print("Enter your account number: ");
                int custAccNum = sc.nextInt();
                sc.nextLine();
                customer = findAccount(accounts, custAccNum);
                if (customer == null) {
                    System.out.println("Account not found.");
                    return;
                }
            } else {
                System.out.print("Enter new account number: ");
                int newAccNum = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter account holder name: ");
                String newName = sc.nextLine();
                System.out.print("Enter initial balance: ");
                double newBalance = sc.nextDouble();
                customer = new Account(newAccNum, newName, newBalance);
                accounts.add(customer);
                System.out.println("Account created successfully.");
            }

            Account finalCustomer = customer;
            Map<Integer, Runnable> customerMenu = new HashMap<>();
            customerMenu.put(1, () -> System.out.println(finalCustomer));
            customerMenu.put(2, () -> {
                System.out.print("Enter amount to deposit: ");
                double depositAmount = sc.nextDouble();
                finalCustomer.deposit(depositAmount);
            });
            customerMenu.put(3, () -> {
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = sc.nextDouble();
                try {
                    finalCustomer.withdraw(withdrawAmount);
                } catch (InsufficientFundsException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            });
            customerMenu.put(4, () -> {
                System.out.println("Exiting Customer Panel.");
                System.exit(0);
            });

            while (true) {
                System.out.println("\n--- Customer Menu ---");
                System.out.println("1. View Account Details");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                customerMenu.getOrDefault(choice, () -> System.out.println("Invalid choice. Try again.")).run();
            }
        } else {
            System.out.println("Invalid user type.");
        }
    }

    public static Account findAccount(List<Account> accounts, int accountNumber) {
        return accounts.stream()
                .filter(acc -> acc.getAccountNumber() == accountNumber)
                .findFirst()
                .orElse(null);
    }
}
