// Lösningsförslag till tentamen 2016-10-17
// Uppgift B1

public class Member {
  
  private String identity;
  private int[] properties;
  
  public Member(String id, int[] prop) {
    this.identity=id;
    // Djupkopiering
    this.properties = new int[prop.length];
    for (int i=0; i<prop.length; i++) {
      this.properties[i]=prop[i];
    }
    // Alternativt, grundkopiering
    // this.properties = prop;
  }
  
  public String getIdentity() {
    return this.identity;
   }
  
  public int matchValue(Member other) {
    int sum=0;
    for (int i=0; i<this.properties.length; i++) {
      sum = sum + (int) (Math.pow( this.properties[i]-other.properties[i], 2));
    }
    return sum;
  }
  
  public String toString() {
    String s = "";
    for (int i=0; i<this.properties.length; i++) {
      s = s + this.properties[i] + " ";
    }
   return "<" + this.identity + " " + s + ">";
  }
  
  // Given mainmetod
  public static void main (String[] arg) {
    int [] propertiesA = {9,0,0,2,3};
    int [] propertiesB = {9,0,0,1,6};
    Member ma = new Member("A",propertiesA);
    Member mb = new Member("B",propertiesB);
    System.out.println(ma);
    System.out.println(mb);
    int match = ma.matchValue(mb);
    System.out.println("Matchningsvärdet mellan " + ma.getIdentity() + " och " + mb.getIdentity() + " : " + match);
  }
    
}