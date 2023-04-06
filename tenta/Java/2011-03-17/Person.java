/**
 * Representerar information om en person
 */
import java.util.Scanner;

public class Person {
    /**
     * Parameterlös konstruktor
     */
    public Person() {...}
    
  
    /**
     * Skapar person med angivet namn
     * @param name Personens namn
     */
    public Person(String name) {...}

    /**
     * Tar fram en persons namn
     * @return Personens namn
     */
    public String getName() {...}
  
    /**
     * Tar fram en persons adress
     * @return Personens adress
     */
    public String getAddress() {...}
  
    /**
     * Returnerar en String-representation av personobjektet
     */
    public String toString() {...}
   
    /**
     * Skapar en person.
     * Läser namn och adress från standard input
     * @return Referens till det skapade personobjektet
     */
    public static Person makePerson() {...}
}