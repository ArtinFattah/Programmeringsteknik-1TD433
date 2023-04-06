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
     * Skapar en String-representation av kunden (kundnummer f�ljt av
     * personinformation)
     * @return Referens till String-objektet
     */
    public String toString() {
	return this.customerNumber + "  " + person.toString();
    }
  
    /**
     * Meny f�r kundhantering
     */
    public void handle() {...}
  
    /**
     * Ber�knar en kunds nettotillbeh�llning
     * @return  Kundens nettoneh�llning (negativ om skuld) 
     */
    public double totalBalance() {...}
  
}

 