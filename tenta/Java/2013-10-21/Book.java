import java.util.ArrayList;
import java.util.Scanner;

public class Book {
  private String title;
  private ArrayList<String> authors;
  
  public Book(String title) {                    // Uppgift             
    this.title = title;
    this.authors = new ArrayList<String>();
  }
  
  public Book(String title, String author){      // Uppgift
    this(title);
    authors.add(author);
  }
  
  public Book(String title, String[] authors) {  // Uppgift
    this(title);
    for (String a: authors) {
      this.authors.add(a);
    } 
  }
  
  public Book(String title, ArrayList<String> authors) { // Uppgift 
    this(title);
    this.authors = authors;
  }
  
  public static Book load(Scanner sc) {  // Uppgift (bara "teori"-fr�gor?
    if ( !sc.hasNextLine() ) {
      return null;
    } else {
      String title = sc.nextLine();
      Book b = new Book(title);
      String author = sc.nextLine();
      while(!author.equals(";")) {
        b.authors.add(author);
        author = sc.nextLine();
      }
      return b;
    }
  }
  
  public String toString() {               // Uppgift  
    return '"' + title + '"' + " by " + authors;
  }
  
  public String getTitle() {
    return title;
  }
  
  public boolean isAuthor(String name) {   // Uppgift
    for (String s: authors) {
       if (s.equals(name))
         return true;
    }
    return false;
  }
  
  /** 
   * Test program
   */
  public static void main(String[] args) {
    Book[] books = new Book[4];
    books[0] = new Book("Havamal");                  // Without author
    books[1] = new Book("Kallocain",  "Boye");       // With one author      
    String[] authors = {"Anders", "Olle", "Urban"};  // Array with authors
    books[2] = new Book("Klassisk latin", authors);
    ArrayList<String> authorList = 
      new ArrayList<String>();                       // ArrayList with authors  
    authorList.add("Lisa");
    authorList.add("Anna");
    books[3] = new Book("Modern latin", authorList);
    
    for (int i=0; i<books.length; i++) {
      System.out.println(books[i].toString());
    }
    

    authors[2] = "Ivan";
    authorList.remove("Anna");
    System.out.println("\nWhat will be printed below?");
    System.out.println(books[2]);
    System.out.println(books[3]);                    
  }
}

/* Output from the main method

"Havamal" by []
"Kallocain" by [Boye]
"Klassisk latin" by [Anders, Olle, Urban]
"Modern latin" by [Lisa, Anna]

What will be printed below?



 */

