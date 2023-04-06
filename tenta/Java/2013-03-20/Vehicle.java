/**
 * Represent a vehicle with an id-tag (String) and a born-time
 */

public class Vehicle {
   private String id;
   private int born;
   
   public Vehicle(String id, int born) {
     this.id = id;
     this.born = born;
   }
   
   public String toString() {
     return "<" + id + " " + born + ">";
   }
   
   public int getBorn() {
     return born;
   }
}