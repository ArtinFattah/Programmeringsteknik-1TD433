import java.util.Scanner;

public class Stack {
  
  private int [] stack; // För att lagra värdena
  private int top;      // Antal lagrade värden tillika index för första lediga plats
  
  /** Skapa en stack med plats för n värden */
  public Stack(int n) {
    stack = new int[n];
    top = 0;
  }
  
  /** Lagra ett nytt värde överst på stacken */
  public void push(int v) {
    if (top==stack.length)
      System.out.println("Stack overflow!");
    else
      stack[top++] = v;
  }
  
  /** Lagra ett värde övesrt på stacken. Utöka arrayen vid behov */
  public void safePush(int v) {
    if (top==stack.length) {
      System.out.println("Extending stack to size = " + 2*stack.length);
      int[] newStack = new int[2*stack.length];
      for (int i=0; i<stack.length; i++)
        newStack[i] = stack[i];
      stack = newStack;
    }
    push(v);
  }
  
  /** Hämta översta värdet från stacken och ta bort det */
  public int pop() {
    if (top==0) {
      System.out.println("pop from empty stack!");
      return 0;
    } else {
      return stack[--top];
    }
  }
  
  public String toString() {
    String ret = "";
    for (int i= 0; i<top; i++)
      ret = ret + stack[i] + " ";
    return "[ " + ret + "]";
  }
  
  /** Returnera antalet lagrade element */
  public int size() {
    return top;
  }
  
  public static void main(String[] arg) {
    Scanner sc = new Scanner(System.in);
    Stack s = new Stack(8);  // Se bild 1
    
    s.push(3); 
    System.out.println("Efter en push           : " + s);  // Se bild 2
    s.push(7); s.push(5); s.push(8);
    System.out.println("Efter ytterligare 3 push: " + s);  // Se bild 3
    System.out.println("Första pop ger värdet   : " + s.pop());
    System.out.println("och stackutseendet      : " + s);
  
    System.out.print("Poppa resten: ");
    while (s.size()>0)
      System.out.print(s.pop() + " ");
    System.out.println();
  }
}

/** Output:
  
Efter en push           : [ 3 ]
Efter ytterligare 3 push: [ 3 7 5 8 ]
Första pop ger värdet   : 8
och stackutseendet      : [ 3 7 5 ]
Poppa resten: 5 7 3 

*/

  
  
  