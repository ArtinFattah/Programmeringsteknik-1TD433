import java.util.*;
public class Tentamen {
  private int maxpoäng;     // maxpoäng på tentan
  private int[] resultat;   // array med poängfrekvens
                            // dvs i element 0 finns
                            // antal personer med noll poäng
                            // i element 1 antal personer 
                            // med 1 poäng osv upp 
                            // till maxpoäng. Arrayen
                            // ska alltså innehålla
                            // maxpoäng+1 element.

  public Tentamen(int max) {
      maxpoäng = max;
      resultat = new int[max+1];
  }

  public void lagraResultat(int poäng) {

      // rimlighetstest SKA finns här

      if (poäng >= 0 && poäng <= maxpoäng)
	  resultat[poäng]++;
      else
	  System.out.println("lagraReultat: felaktigt poängtal");
  }

  public void statistik(int godkänd) {

      // inget krav på test här

      if (godkänd < 0 || godkänd > maxpoäng)
	  System.out.println("statistik: felaktigt poängtal");
      else {
	  int antal = 0;
	  for (int i = 0; i < godkänd; i++)
	      antal += resultat[i];
	  System.out.println("Antal underkända: " + antal);

      }
      
  }

  public static void main(String [] args) {
      Tentamen t = new Tentamen(40);
      Scanner sc = new Scanner(System.in);
      for (int i = 1; i <= 10; i++) {
	  System.out.print("Ge ett poängtal i [0,40]: ");

	  // inget krav på test här egentligen

	  int p;
	  do {
	      p = sc.nextInt();
	      if (p < 0 || p > 40) 
		  System.out.println("Felaktig inmatning, försök igen: ");
	  } while (p < 0 || p > 40);
	  t.lagraResultat(p);
      }
      System.out.print("Ge godkänd gräns :");
      int g = sc.nextInt();
      t.statistik(g);
  }
}