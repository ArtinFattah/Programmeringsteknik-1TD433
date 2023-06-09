/**
 *  Klassen representerar en bank. 
 */
import java.util.Scanner;

public class Bank {
    private Customer[] customers;      // Kundf�rteckning
    private int numberOfCustomers;     // Aktuellt antal kunder
    private int globalCustomerNumber;  // Globalt kundnummer
      
    public Bank() {
	customers = new Customer[3];
	numberOfCustomers = 0;
	globalCustomerNumber = 1;
    }
  
    /**
     * Skapar ett Bank-objekt och s�tter ig�ng menyhanteringen
     */
    public static void main(String [] args) {
	Bank theBank = new Bank();
	theBank.mainMenue();
    }
  
    /**
     * Huvudmeny f�r bankhantering
     */
    public void mainMenue() {
	Scanner sc = new Scanner(System.in);
	int choice;
	boolean goOn = true;
	System.out.println("V�lkommen till Ebbe R�ds bank");
	while (goOn) {
	    System.out.println("\n== Huvudmeny ==");
	    System.out.println(" (0) Avsluta");
	    System.out.println(" (1) Lista kunder");
	    System.out.println(" (2) Hantera kund");
	    System.out.println(" (3) Skapa kund");
	    System.out.println(" (4) Avsluta kund");
	    System.out.print("Ditt val: ");
	    if (sc.hasNextInt()) {
		choice = sc.nextInt();
	    } else {
		choice = 999;
	    }
	    sc.nextLine();
	    switch (choice) {
	    case 0:
		System.out.print("S�kert att du vill avsluta? ");
		if (sc.nextLine()=="ja") { // Uppgift 4a
		    goOn = false;
		}
		break;
	    case 1:
		listCustomers();
		break;
	    case 2: 
		handleCustomer();
		break;
	    case 3:
		createCustomer();
		break;
	    case 4:
		deleteCustomer();
		break;
	    default:
		System.out.println("*** Ogiltigt val!");
	    }
	}
	System.out.println("Tack f�r denna g�ng!");
	return;
    }
  
    /**
     * Skapar en ny kund med inl�sta personuppgifter.
     * Kundarrayen �kas automatiskt vid behov.
     */
    public void createCustomer() {
	// Uppgift 4 c
    }

    /**
     * F�rintar en kund. Reglerar skuld eller fordran.
     */
    public void deleteCustomer() {...}

    /**
     * Skriver en f�rteckning �ver kunderna
     */
    public void listCustomers() {
	// Uppgift 4 b
    }
  
    /**
     * L�ter anv�ndaren v�lja en kund
     * @return index f�r kunden
     */
    private int chooseCustomer() {...}

    /**
     * V�ljer ut en enskild kund och anropar 
     * hanteringsmenyn f�r denna kund
     */
    public void handleCustomer() {...} 
}
