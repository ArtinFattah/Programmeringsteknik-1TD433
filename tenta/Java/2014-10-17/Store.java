import java.util.ArrayList;

public class Store {
   private String name;
   private ArrayList<Article> storage;
   
   public Store(String name) {
      this.name = name;
      this.storage = new ArrayList<Article>();
   }
   
   public void print() {
      System.out.println("\nContents of " + name);
      for (Article a: storage) {
         System.out.println(a);
      }
   }
     
   private int searchIndex(int id) {
      for (int i=0; i<storage.size(); i++) {
         if (storage.get(i).getId()==id) {
            return i;
         }
      }
      return -1;
   }
   
   public Article search(int id) {
      int index = searchIndex(id);   // Use the method above
      if (index == -1) {
         return null;
      } else {
         return storage.get(index);
      }
   }
   
   public boolean addNewArticle(int id, int number, double price) {
      Article article = search(id);
      if (article!=null) {
         System.out.println("*** Already in storage: " + id);
         return false;
      } else {
         storage.add(new Article(id, number, price));
         return true;
      }                 
   }

   public int getNumber(int id) {
      Article art = search(id);
      if (art!=null) {
         return art.getNumber();
      } else {
         return 0;
      }
   }  
   
   public double getPrice(int id) {
      Article art = search(id);
      if (art!=null) {
         return art.getPrice();
      } else {
         return 0;
      }
   }
   
   public void updatePrice(int id, double newPrice) {
      int index = searchIndex(id);
      if (index < 0) {
         System.out.println("No such article in store:");
      } else {
         storage.get(index).setPrice(newPrice);
      }      
   }
   
   public double totalValue() {
      double sum = 0;
      for (Article a: storage) {
         sum += a.getPrice()*a.getNumber();
      }
      return sum;
   }
   
   public void insertNewArticle(int id, int number, double price) {
      // Find the position
      int i = 0;
      while (i<storage.size() && id>storage.get(i).getId()) {
         i++;
      }
      if (i==storage.size() || id<storage.get(i).getId()) {
         storage.add(i, new Article(id, number, price));  
      } else {
         System.out.println("*** Already in storage: " + id);
      }
   }
   
 
   public Store order() {
      Store orderedStore = new Store(this.name);
      for (Article a: storage) {
         orderedStore.insertNewArticle(a.getId(), a.getNumber(), a.getPrice());
      }
      return orderedStore;
   }
   
   public static void main(String[] args) {
      Store store1 = new Store("Lisas livs");
      store1.addNewArticle(256, 3, 54.);
      store1.addNewArticle(213, 7, 126.);
      store1.addNewArticle(156, 18, 17.70);
      store1.print();
      store1.addNewArticle(256, 30, 25);
      store1.print();
      System.out.println("Article 156: " + 
                         store1.search(156));
      System.out.println("213 is at index " + 
                         store1.searchIndex(213));
      System.out.println("Total value: " + 
                         store1.totalValue());
      
      // Test the "add in order" method
      System.out.println("\nBuilding Arnes store");
      Store store2 = new Store("Arnes livs");
      store2.insertNewArticle(5, 3, 25.50);
      store2.insertNewArticle(2, 7, 126.);
      store2.insertNewArticle(6, 18, 17.70);
      store2.insertNewArticle(1, 30, 25);
      store2.insertNewArticle(3, 9, 9);
      store2.print();    

      store2.insertNewArticle(3, 9, 9);
      store2.print();
      System.out.println("\nRearranging Lisas store");
      Store store3 = store1.order();
      store3.print();
   }
   
}


