import java.util.Scanner;

interface chocolate {
    String dairymilk();
    String kitkat();

    static void a() {
        System.out.println("good morning peeps");
    }
}

interface chips {
    String lays();
    String kurkure();
}

class items implements chips, chocolate {

    @Override
    public String lays() {
        return "Lays is for 25";
    }

    @Override
    public String kurkure() {
        return "Kurkure is for 78";
    }

    @Override
    public String dairymilk() {
        return "Dairymilk is for 50";
    }

    @Override
    public String kitkat() {
        return "Kitkat is for 30";
    }

    public void displayMenu() {
        System.out.println("\n=== Snack Menu ===");
        System.out.println("1. " + lays());
        System.out.println("2. " + kurkure());
        System.out.println("3. " + dairymilk());
        System.out.println("4. " + kitkat());
    }
}

public class Items {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        items snackItem = new items();

        chocolate.a();

        System.out.println("Enter the snack name (lays, kurkure, dairymilk, kitkat):");
        String choice = sc.nextLine();

        switch (choice.toLowerCase()) {
            case "lays":
                System.out.println(snackItem.lays());
                break;
            case "kurkure":
                System.out.println(snackItem.kurkure());
                break;
            case "dairymilk":
                System.out.println(snackItem.dairymilk());
                break;
            case "kitkat":
                System.out.println(snackItem.kitkat());
                break;
            default:
                System.out.println("Invalid choice. Please select from the menu below:");
                snackItem.displayMenu();
        }
    }
}
