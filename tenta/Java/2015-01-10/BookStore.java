public class BookStore {
  
  private String name;       
  private Book[] books;     
  private int numberOfBookTitles; 
  
  public BookStore(String name, int n) {
    this.name = name;
    this.books = new Book[n];
    this.numberOfBookTitles=0;
  }
  
  // Uppgift
  // Böckerna sorteras ej
  public void addBook(Book b) {
    if (this.numberOfBookTitles<this.books.length)  {
      this.books[this.numberOfBookTitles]=b;
      this.numberOfBookTitles++;
    }
  }
  
  // Uppgift 
  // Prisändring i procent för alla böcker 
  public void changePrices(double priceChange)  {
    for (int i=0; i<this.numberOfBookTitles; i++) {
      double price = this.books[i].getPrice();
      this.books[i].setPrice( price*(1+priceChange/100.0));
    }
  }
  
  public String toString() {
    String s=this.name + ":";
    for (int i=0; i<this.numberOfBookTitles; i++) {
      s = s + this.books[i];
    }
    return s;
  }
  
  public static void main(String[] arg) {
    BookStore bs = new BookStore("Bokhandeln",20);
    // Bok med identiteten 999-91-7000-150-5, antal ex 14, priset 500 kr 
    Book b = new Book("999-91-7000-150-5",14,500.00); 
    bs.addBook(b);
    System.out.println(bs);
     // Bok med identiteten 888-88-7000-150-7, antal ex 5, priset 400 kr 
    b = new Book("888-88-7000-150-7",5,400.00); 
    bs.addBook(b);
    System.out.println(bs);
//    bs.removeBook("8266144038438");
//    System.out.println(bs);  
    
    // Prisändring -10% (dvs prissänkning)
    double priceChange = -10.0;
    bs.changePrices(priceChange);
    System.out.println("Prisändring " + priceChange + "%");
    System.out.println(bs);
  }
}