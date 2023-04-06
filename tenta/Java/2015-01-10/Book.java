public class Book {
  private String isbn;
  private int number;
  private double price;
  
  public Book(String isbn, int number, double price) {
    this.isbn = isbn;      // Bokens identitet
    this.number = number;  // Antal exemplar av boken
    this.price = price;    // Bokens pris
  }
  
  // Uppg 2
  public boolean buy(int n) {
    if (this.number<n) {
      return false;
    }
    this.number=this.number-n;
    return true;
  }
   
  public String toString() {
    return "["+this.isbn+","+this.number+","+this.price+"]";
  }
  
  // Uppg 3
  public double getPrice() { return this.price; }

  // Uppg 3
  public void setPrice(double newPrice) { this.price=newPrice;  }
  
  // Uppg 3 - alternativ för getPrice och setPrice
  public void changePrice(double change) {
    this.price=(1+change)*this.price;
  }
  
  public static void main (String[] arg) {
    // Boktitel med identiteten 999-91-7000-150-5, antal ex 10, priset 500 kr 
    Book b1 = new Book("999-91-7000-150-5",10,500.00);
    System.out.println(b1);
    for (int i=1; i<=3; i++) {
      if (b1.buy(4)) {     // Önskar köpa fyra exemplar av boken
        System.out.println("Köpet genomfört: " + b1);
      }
      else {
        System.out.println("Köpet gick ej att genomföra: "+ b1);
      }
    }
  }
  
}