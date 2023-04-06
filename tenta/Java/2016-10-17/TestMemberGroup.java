// Tentamen 2016-10-17
// Given mainmetod till uppgift B2

public class TestMemberGroup {
  
  public static void main (String[] arg ) {
    
    MemberGroup g = new MemberGroup("Pollax");
    
    Member m;
    int [] p1 = {5,1,3,1,8}; m = new Member("kim.nilsson@pollax.se",p1); g.add(m);
    int [] p2 = {4,6,4,5,3}; m = new Member("fia.jonsson@pollax.se",p2); g.add(m);
    int [] p3 = {3,9,1,1,4}; m = new Member("my.ehn@pollax.se",p3); g.add(m);
    int [] p4 = {5,7,3,8,2}; m = new Member("ida.lonn@pollax.se",p4); g.add(m);
    
    System.out.println("Antal medlemmar i gruppen " + g.getIdentity()+ ":" + g.getAntal() );
    System.out.println(g);
    
    System.out.println("Alla medlemmars matchningsv�rden:");
    g.printMatchValues();
    
    // Ber�kna det par som matchar b�st
    Member [] best = g.bestMatchPair();
    int matchValue = best[0].matchValue(best[1]);
    System.out.println("\nB�sta match:" + best[0].getIdentity() + " och " + best[1].getIdentity() + ":Matchv�rde = "+matchValue);
    
    // Ta bort b�sta paret om matchningsv�rdet �r <=20
    if (matchValue<=20) {
      g.deleteMember(best[0]);
      g.deleteMember(best[1]);
      System.out.println(best[0].getIdentity()+ " och " + best[1].getIdentity() + " �r bortagna fr�n gruppen");
    }
    
    System.out.println("Antal medlemmar i gruppen " + g.getIdentity()+ ":" + g.getAntal() );
    System.out.println(g);
    
  }  // main
  
} // TestMemberGroup