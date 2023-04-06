public class Car {
  private int bornTime;
  
  public Car(int born) {
    this.bornTime = born;
  }
  
  public String toString() {
    return "" + bornTime;
  }
  
  public int getBorn() {
    return bornTime;
  }
}