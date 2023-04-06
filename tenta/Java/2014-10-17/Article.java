public class Article {
   private int id;             // artikelkod
   private int number;         // antal i lager
   private double price;       // pris
   
   public Article(int id, int number, double price) {
      this.id = id;
      this.number = number;
      this.price = price;     
   }
   
   public Article(int id, double price) {
      this.id = id;
      this.number = 0;
      this.price = price;
   }
   
   public int getId() {
      return id;
   }
   
   public int getNumber() {
      return number;
   }
   
   public double getPrice() {
      return price;
   }
   
   public void setPrice(double newPrice) {
      price = newPrice;
   }
   
   public void addNumber(int n) {
      number += n;
   }
   
   public String toString() {
      return "<" + id + ", " + number + ", " + price + ">";
   }
   
   public boolean equals(Article a) {
      return this.id == a.id;
   }
   
   public static void main(String[] args) {
      Article a = new Article(2526, 10, 5.52);
      Article b = new Article(1357, 100, 565.25);
      Article c = new Article(1357, 44, 489);
      System.out.println("a: " + a);
      System.out.println("b: " + b);
      System.out.println("c: " + c);
      
      a.addNumber(5);
      System.out.println("a: " + a);
      
      System.out.println("a.equals(b): " + a.equals(b));
      System.out.println("a.equals(c): " + a.equals(c));
      System.out.println("b.equals(c): " + b.equals(c));
      
      a.setPrice(a.getPrice()*2); // Double the price 
      System.out.println("a: " + a);
   }
}