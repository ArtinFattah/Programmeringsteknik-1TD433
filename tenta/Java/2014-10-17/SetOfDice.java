public class SetOfDice {
   private Dice[] theDice;
        
   public SetOfDice(int numberOfDice) {
      this.theDice = new Dice[numberOfDice];
   }
   
   public String toString() {
      String theString = "";
      for (int i=0; i<numberOfDice; i++) {
         theString = theString + this.theDice[i].getValue();  
         if (i<this.theDice.length-1) {
            theString +=", ";
         }
      }
      return "(" + theString + ")";
   }

   public static void main(String[] args) {
      SetOfDice sod = new SetOfDice(10);
      System.out.println(sod);
   }   
}

