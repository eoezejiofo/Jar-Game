import java.util.Scanner;
import java.util.Random;

public class Prompter{
    private Jar mJar;
    private int count;
    private int guessCount;
    private int randomNumberCount;
  
   Scanner scanner = new Scanner(System.in);
  
  public void startGame() {
      administrator();
      System.out.println();
      player(mJar.getItemName(), mJar.getMaxNum());
  }
  
  public void administrator() {
      System.out.println("ADMINISTRATOR SETUP");
      System.out.println("=======================");
      System.out.println("What type of item is in the Jar");
      String itemName = scanner.next();
      System.out.println("How many " + itemName + " are in the Jar?");
      int maxNum = scanner.nextInt();
      mJar = new Jar(itemName, maxNum);
  }
  
  public int fill(int randomNumber) {
      Random random = new Random();
      int someNumber = random.nextInt(randomNumber) + 1;
      //System.out.println("This is your random number " + someNumber);
      return someNumber;
  }
  
  public void player(String itemName, int maxNum) {
      System.out.println("PLAYER GAME");
      System.out.println("========================");
      System.out.println("How many " + itemName + " are in the jar?" 
                         + " Pick a number between 1 and " + maxNum);
      randomNumberCount = fill(maxNum);
    do{
        System.out.println("Guess:");
        guessCount = scanner.nextInt();
        count++;
        guessValidation(guessCount,randomNumberCount);
        if(count >= 5) {
            System.out.println("The game has ended the random number was " + randomNumberCount);
          System.exit(0);
        }
        
    }while(guessCount != randomNumberCount);
        if(count == 1) {
          System.out.println("You guessed there were " + randomNumberCount + " " +itemName+ " in the Jar. It took you "+ count + " attempt");
        } else {
            System.out.println("You guessed there were " + randomNumberCount + " " +itemName+ " in the Jar. It took you "+ count + " attempt(s)");
        }
      }
  public void guessValidation(int guessValue, int guessAnswer) {
    try {
      if(guessValue > mJar.getMaxNum()) {
          throw new IllegalArgumentException("You must be less than " + mJar.getMaxNum());
      }
      
      if(guessValue > guessAnswer) {
          throw new IllegalArgumentException("Your guess is to high.");
      }
      
      if(guessValue < guessAnswer) {
          throw new IllegalArgumentException("Your guess is to low.");
      }
    } catch (IllegalArgumentException iae) {
        System.out.println(iae.getMessage());
      }
  }
  
}