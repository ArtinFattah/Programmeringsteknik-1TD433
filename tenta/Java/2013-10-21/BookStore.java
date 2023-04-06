import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class BookStore {
  private ArrayList<Book> theBooks;
  
  public BookStore() {
    theBooks = new ArrayList<Book>();  
  }
  
  public void add(Book b) {
     theBooks.add(b);  
  }

  
  public void load(String fileName) throws FileNotFoundException {
    Scanner sc = new Scanner(new File(fileName));
    while (sc.hasNextLine()) {
      String title = sc.nextLine();
      String isbn = sc.nextLine();
      //Book b = new Book(title, isbn);
      ArrayList<String> authors = new ArrayList<String>();
      String author = sc.nextLine();
      while(!author.equals("")) {
        authors.add(author);
        author = sc.nextLine();
      }
      Book b = new Book(title, isbn, authors);
      // Find position in alfabetic order
      int i = 0;
      while( i < theBooks.size() &&
            title.compareTo(theBooks.get(i).getTitle())>0) {
        i++;
      }
      theBooks.add(i, b);
    }
  }
  
  
  public String toString() {
     return theBooks.toString(); 
  }
 
  public void print() {
    printList(theBooks);
  }
  
   
  public static void printList(ArrayList<Book> list) {
    for (Book b: list) {
      System.out.println(b);
    }
  }
  
  public static void main(String[] args) throws FileNotFoundException {
   BookStore theStore = new BookStore();
   theStore.load("store.txt");
   theStore.print();

   
  }
  
}