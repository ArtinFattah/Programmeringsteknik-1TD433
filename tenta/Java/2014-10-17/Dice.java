public class Dice {
   private int numberOfSides;
   private int value;
   
   Dice(int nos) {
      int numberOfSides = nos;                                             //numberOfSides = nos;
      this.roll();            // random initial value
   }
   
   public void roll() {
      this.value = Math.random()*this.numberOfSides + 1;                 //value = (int)(Math.random()*numberOfSides) + 1;
   }
   
   public int getValue() {
      return this.value;
   }
   
   public static void main(String[] args) {
      Dice d = new Dice(7);
      System.out.println("Dice with " + 7 +" sides:");
      for (int i=1; i<=20; i++) {
         d.roll();
         System.out.print(d.getValue() + ", ");
         if (i%10 = 0) {    // line break after 10 values
            System.out.println();
         }
      }
   }
}

