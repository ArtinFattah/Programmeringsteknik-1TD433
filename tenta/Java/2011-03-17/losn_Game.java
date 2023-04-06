import java.util.*;             // f�r Scanner
public class Game {
        private int talet;      // det tal datorn t�nker p�

        // Konstruktor som f�r datorn att v�lja ett
        // pseudoslumptal i intervallet [1,9]

        public Game() {     
           talet = (int) (Math.random() * 9 + 1);
        }           

        // metod som anv�nds n�r du gissar ett tal.
        // parametern minGissning �r det tal du gissat
        //
        // Din gissning j�mf�rs med det tal datorn best�mt
        // och metoden returnerar -1, 0 resp 1 beroende p�
        // om du gissat f�r l�gt, r�tt eller f�r h�gt.
    
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
		  System.out.println("F�r liten");
	      else if (test > 0)
		  System.out.println("F�r stort");
	      else {
		  System.out.println("*R�tt*, " + count + " gissningar kr�vdes");
		  korrekt = true;
	      }
	  }
	}
}
