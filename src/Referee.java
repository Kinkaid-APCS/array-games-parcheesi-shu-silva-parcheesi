import java.util.Random;
import java.util.Scanner;
public class Referee
{
    private Board myBoard;

    public Referee()
    {
        myBoard = new Board();
        System.out.println(myBoard);
    }

    public static int[] pickNRandom() {
        int[] randomRolls = new int[2];
        randomRolls[0] = (int)Math.round((Math.random() * 5.5)+1);
        randomRolls[1] = (int)Math.round((Math.random() * 5.5)+1);
        return randomRolls;

    }
    public void askForMovements(int[] rolls){
        if (rolls[0] == 5){
            Scanner myScanner = new Scanner(System.in);
            System.out.println("Do you want to leave home?" );
            String playerDecision = myScanner.nextLine();
            System.out.println("Player decisions: " + playerDecision);
            if (playerDecision == "yes"){

            }

        }



    }

    public void playGame()
    {
        askForMovements(pickNRandom());
    }
}
