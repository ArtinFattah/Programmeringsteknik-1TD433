import java.util.Scanner;

public class Customer {

    /**
     * Skapar ett kundobjekt
     * @param person Referens till kunden Person-objekt 
     * @param customerNumber Kundnummer
     * @param bank Referens till bank-objektet som skapat denna kund 
     */
    public Customer(Person person, int customerNumber, Bank bank) {
	...
    }
  
    /**
     * Skapar en String-representation av kunden (kundnummer följt av
     * personinformation)
     * @return Referens till String-objektet
     */
    public String toString() {
	return this.customerNumber + "  " + person.toString();
    }
  
    /**
     * Meny för kundhantering
     */
    public void handle() {...}
  
    /**
     * Beräknar en kunds nettotillbehållning
     * @return  Kundens nettonehållning (negativ om skuld) 
     */
    public double totalBalance() {...}
  
}

 