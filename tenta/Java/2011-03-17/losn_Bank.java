/**
 *  Klassen representerar en bank. 
 */
import java.util.Scanner;

public class Bank {
    private Customer[] customers;      // Kundförteckning
    private int numberOfCustomers;     // Aktuellt antal kunder
    private int globalCustomerNumber;  // Globalt kundnummer
      
    public Bank() {
	customers = new Customer[3];
	numberOfCustomers = 0;
	globalCustomerNumber = 1;
    }
  
    /**
     * Skapar ett Bank-objekt och sätter igång menyhanteringen
     */
    public static void main(String [] args) {
	Bank theBank = new Bank();
	theBank.mainMenue();
    }
  
    /**
     * Huvudmeny för bankhantering
     */
    public void mainMenue() {
	Scanner sc = new Scanner(System.in);
	int choice;
	boolean goOn = true;
	System.out.println("Välkommen till Ebbe Röds bank");
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
		System.out.print("Säkert att du vill avsluta? ");
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
	System.out.println("Tack för denna gång!");
	return;
    }
  
    /**
     * Skapar en ny kund med inlästa personuppgifter.
     * Kundarrayen ökas automatiskt vid behov.
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
     * Förintar en kund. Reglerar skuld eller fordran.
     */
    public void deleteCustomer() {
	int index = chooseCustomer();
	if (index<0) {
	    return;
	}
	System.out.println("\nFörintar " + customers[index]);
	double total = customers[index].totalBalance();
	if (total<0) {
	    System.out.println("Kunden skall betala in " + 
			       String.format("%.2f", total) + " kronor");
	} else if (total>0) {
	    System.out.println("Kunden skall erhålla " +
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
     * Skriver en förteckning över kunderna
     * 
     */
    public void listCustomers() {             // <<<<<<<<<<<<<<<< 4b
	if (numberOfCustomers==0) {
	    System.out.println("\nBanken har för närvarande inga kunder");
	} else {
	    System.out.println("\nKunder:");
	    for (int i = 1; i<=numberOfCustomers; i++) {
		System.out.println(" (" + i + ")  " + 
			  customers[i-1]); //ELLER customers[i-1].toString()
	    }         
	}
    }
  
    /**
     * Låter användaren välja en kund
     * @return index för kunden
     */
    private int chooseCustomer() {
	Scanner sc = new Scanner(System.in);
	int cust;
	listCustomers();
	while (true) {
	    System.out.print("Välj kund (0 för att avbryta): ");
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
     * Väljer ut en enskild kund och anropar 
     * hanteringsmenyn för denna kund
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
