import java.util.*;             // för Scanner
public class Game {
        private int talet;      // det tal datorn tänker på

        // Konstruktor som får datorn att välja ett
        // pseudoslumptal i intervallet [1,9]

        public Game() {     
           talet = (int) (Math.random() * 9 + 1);
        }           

        // metod som används när du gissar ett tal.
        // parametern minGissning är det tal du gissat
        //
        // Din gissning jämförs med det tal datorn bestämt
        // och metoden returnerar -1, 0 resp 1 beroende på
        // om du gissat för lågt, rätt eller för högt.
    
        public int compare(int myGuess) {
          if (myGuess > talet) return 1;
          else if (myGuess < talet) return -1;
          else return 0;
        }    

        public static void main(String [] args) {
          Game g = new Game();
          System.out.println("Gissa ett tal i intervallet [1,9]");
          Scanner sc = new Scanner(System.in);
          boolean korrekt = false;
	  int count = 0;
          while (!korrekt) {
	      int guess = sc.nextInt();
	      count++;
	      System.out.println("Din gissning: " + guess);
	      int test = g.compare(guess);
	      if (test < 0 )
		  System.out.println("För liten");
	      else if (test > 0)
		  System.out.println("För stort");
	      else {
		  System.out.println("*Rätt*, " + count + " gissningar krävdes");
		  korrekt = true;
	      }
	  }
	}
}
