public class WithoutThread {
    public static void main(String[] args) {
        calculate();    // CPU-intensive task
        getInput();     // Waits for user input (Blocking)
    }

    static void calculate() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Calculating: " + i);
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
        }
    }

    static void getInput() {
        System.out.println("Enter your name: ");
        try {
            Thread.sleep(5000);  // Simulating user input delay
        } catch (InterruptedException e) {}
        System.out.println("User entered the name.");
    }
}
