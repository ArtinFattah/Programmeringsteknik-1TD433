import java.util.*;
public class Tentamen {
  private int maxpo�ng;     // maxpo�ng p� tentan
  private int[] resultat;   // array med po�ngfrekvens
                            // dvs i element 0 finns
                            // antal personer med noll po�ng
                            // i element 1 antal personer 
                            // med 1 po�ng osv upp 
                            // till maxpo�ng. Arrayen
                            // ska allts� inneh�lla
                            // maxpo�ng+1 element.

  public Tentamen(int max) {
      maxpo�ng = max;
      resultat = new int[max+1];
  }

  public void lagraResultat(int po�ng) {

      // rimlighetstest SKA finns h�r

      if (po�ng >= 0 && po�ng <= maxpo�ng)
	  resultat[po�ng]++;
      else
	  System.out.println("lagraReultat: felaktigt po�ngtal");
  }

  public void statistik(int godk�nd) {

      // inget krav p� test h�r

      if (godk�nd < 0 || godk�nd > maxpo�ng)
	  System.out.println("statistik: felaktigt po�ngtal");
      else {
	  int antal = 0;
	  for (int i = 0; i < godk�nd; i++)
	      antal += resultat[i];
	  System.out.println("Antal underk�nda: " + antal);

      }
      
  }

  public static void main(String [] args) {
      Tentamen t = new Tentamen(40);
      Scanner sc = new Scanner(System.in);
      for (int i = 1; i <= 10; i++) {
	  System.out.print("Ge ett po�ngtal i [0,40]: ");

	  // inget krav p� test h�r egentligen

	  int p;
	  do {
	      p = sc.nextInt();
	      if (p < 0 || p > 40) 
		  System.out.println("Felaktig inmatning, f�rs�k igen: ");
	  } while (p < 0 || p > 40);
	  t.lagraResultat(p);
      }
      System.out.print("Ge godk�nd gr�ns :");
      int g = sc.nextInt();
      t.statistik(g);
  }
}