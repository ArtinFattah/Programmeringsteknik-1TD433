import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class BookList {
  private ArrayList<Book> theBooks;
  
  public BookList() {
    theBooks = new ArrayList<Book>();  
  }
  
  public void add(Book b) {
     theBooks.add(b);  
  }
 
  public void load(String fileName) throws FileNotFoundException {
    Scanner sc = new Scanner(new File(fileName));
    Book b = Book.load(sc);
    while (b!=null) { 
      int i = 0;                                                    // Uppgift
      while( i < theBooks.size() &&
            b.getTitle().compareTo(theBooks.get(i).getTitle())>0) {
        i++;
      }
      theBooks.add(i, b);
      b = Book.load(sc);
    }
  }
 
  public void print() {
    for (Book b:theBooks) {
      System.out.println(b);
    }
  }
  
  public BookList byAuthor(String name) {   // Uppgift
    BookList retur = new BookList();
    for (Book b: theBooks) {
      if (b.isAuthor(name)) {
        retur.add(b);
      }
    }
    return retur;
  }
  
  public static void main(String[] args) throws FileNotFoundException {
    BookList theList = new BookList();
    theList.load("store.txt");
    theList.print();
   
    System.out.println("\nBooks by Knuth:");
    theList.byAuthor("Knuth").print();
  }
  
}
/* Output:
"Java Direkt" by [Skansholm]
"Java Software Solutions" by [Lewis, Loftus]
"Introduction to Computing" by [Ericson, Guzidal]
"Kallocain" by [unknown, Boye]
"Liftarens guide till galaxen" by [Adams]
"Restaurangen vid slutet av universum" by [Adams]
"The Art of Computer Programming, vol 1" by [Knuth]
"Structure and Interpretation of Computer Programs" by [Abelson, Sussman]
"Concrete Mathematics" by [Graham, Knuth, Patashinik]
"TheTeXbook" by [Knuth]

Books by Knuth:
"The Art of Computer Programming, vol 1" by [Knuth]
"Concrete Mathematics" by [Graham, Knuth, Patashinik]
"TheTeXbook" by [Knuth]
 */