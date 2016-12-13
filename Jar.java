import java.util.Random;

public class Jar {
  
    private String itemName;
    private int maxNum;

public Jar(String itemName, int maxNum) {
      this.itemName = itemName;
      this.maxNum = maxNum;
  }
  

    public static int fill(int randomNumber) {
      Random random = new Random();
      int someNumber = random.nextInt(randomNumber);
      System.out.println("This is your random number " + someNumber);
      return someNumber;
  }
  
  
  public String getItemName() {
      return itemName;
  }
  
  public int getMaxNum() {
      return maxNum;
  }
}