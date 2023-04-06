public class Container {
  private int[] box;   // Stores the numbers
  private int n;       // Number of stored numbers
  
  public Container(int size) {
    box = new int[size];
    n = 0;
  }
  
  public String toString() {
    String s = "";
    for (int i= 0; i<n; i++)
      s = s + " " + box[i];
    return "{" + s + "}";
  }
  
  public void put(int v) {  // Stores the value v (if possible)
    if (n>box.length) {
      System.out.println("Container overflow");
    } else {
      box[n++] = v;
    }
  }
  
  public boolean contains(int v) { // true if v is in, else false
    int ret = 0;
    for (int i=0; i<n; i++) {
      if (v==box[i]) {
        return true;
      }
    }
    return false;
  }
  
  public void remove(int v) { // removes the value v 
    int ind=0;
    while (ind<n && box[ind]!=v) {
      ind++;
    }
    if (ind>=n) {
      System.out.println("Could not remove " + v + ". Not found");
      return;
    } 
    if (ind < n-1){
      box[ind] = box[n-1];
    }
    n--;
  } 
  
  public int smallest() { // Returns the smallest value
    if (n<0) {
      System.out.println("Empty container");
      return 0;
    } else {
      int i = 0;
      for (int j=1; j<n; j++) {
        if (box[j] < box[i])
          i = j;
      }
      return box[i];
    }
  }
              
  
  public static void main(String[] a) {  // Test program
    Container c = new Container(5);
    System.out.println(c);
    c.put(2);
    System.out.println(c);
    c.put(1); 
    c.put(4); 
    c.put(7);
    System.out.println(c);
    c.remove(1); 
    c.remove(7);
    System.out.println(c);
    System.out.println("Smallest : " + c.smallest());
    c.remove(8);
    c.remove(2);
    c.remove(4);
    System.out.println(c);
    c.remove(42);
  }
}
