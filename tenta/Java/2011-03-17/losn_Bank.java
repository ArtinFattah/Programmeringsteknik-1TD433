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
		if (sc.nextLine().equals("ja")) { // <<<<<< 4a 
		// if (sc.nextLine()=="ja") {
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
    public void createCustomer() {                   // <<<<<<<<< 4c
	if (numberOfCustomers==customers.length) {
	    Customer [] newcst = new Customer[2*customers.length];
	    System.arraycopy(customers, 0, newcst, 0, customers.length);
	    customers = newcst;
	}
	Person p = Person.makePerson();
	customers[numberOfCustomers] = 
	    new Customer(p, globalCustomerNumber, this);
	numberOfCustomers++;
	globalCustomerNumber++;
    }

    /**
     * F�rintar en kund. Reglerar skuld eller fordran.
     */
    public void deleteCustomer() {
	int index = chooseCustomer();
	if (index<0) {
	    return;
	}
	System.out.println("\nF�rintar " + customers[index]);
	double total = customers[index].totalBalance();
	if (total<0) {
	    System.out.println("Kunden skall betala in " + 
			       String.format("%.2f", total) + " kronor");
	} else if (total>0) {
	    System.out.println("Kunden skall erh�lla " +
			       String.format("%.2f", total) + " kronor"); 
	}
	for (int i= index; i<numberOfCustomers-1; i++) {
	    customers[i] = customers[i+1];
	}
	numberOfCustomers--;
	if (numberOfCustomers>0) {
	    customers[numberOfCustomers] = null;
	}
    }

    /**
     * Skriver en f�rteckning �ver kunderna
     * 
     */
    public void listCustomers() {             // <<<<<<<<<<<<<<<< 4b
	if (numberOfCustomers==0) {
	    System.out.println("\nBanken har f�r n�rvarande inga kunder");
	} else {
	    System.out.println("\nKunder:");
	    for (int i = 1; i<=numberOfCustomers; i++) {
		System.out.println(" (" + i + ")  " + 
			  customers[i-1]); //ELLER customers[i-1].toString()
	    }         
	}
    }
  
    /**
     * L�ter anv�ndaren v�lja en kund
     * @return index f�r kunden
     */
    private int chooseCustomer() {
	Scanner sc = new Scanner(System.in);
	int cust;
	listCustomers();
	while (true) {
	    System.out.print("V�lj kund (0 f�r att avbryta): ");
	    if (sc.hasNextInt()) {
		cust = sc.nextInt();
	    } else {
		cust = -1;
		sc.nextLine();
	    }
	    if(cust>=0 && cust<=numberOfCustomers) {
		break;
	    }
	    System.out.println("Ogiltigt val!");
	    listCustomers();
	}
	return cust-1;
    }

    /**
     * V�ljer ut en enskild kund och anropar 
     * hanteringsmenyn f�r denna kund
     */
    public void handleCustomer() {
	int cust = chooseCustomer();
	if (cust<0) {
	    System.out.println("Avbrutet");
	    return;
	} else {
	    customers[cust].handle();
	}
    }
  
}
