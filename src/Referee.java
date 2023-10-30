import java.util.Random;
import java.util.Scanner;
public class Referee {
    private Board myBoard;

    public Referee() {
        myBoard = new Board();
        System.out.println(myBoard);
    }

    public Board getMyBoard() {
        return myBoard;
    }

    public int[] pickNRandom() {
        int[] randomRolls = new int[2];
        randomRolls[0] = (int) Math.round((Math.random() * 5.5) + 1);
        randomRolls[1] = (int) Math.round((Math.random() * 5.5) + 1);
        return randomRolls;

    }

    public void askForMovements(int[] rolls, int player) {
        System.out.println(rolls[0] + ", " + rolls[1]);
        if (rolls[0] == 5) {
            Scanner myScanner = new Scanner(System.in);
            System.out.println("Do you want to leave home?");
            String playerDecision = myScanner.nextLine();
            System.out.println("Player decisions: " + playerDecision);
            if (playerDecision.equals("yes")) {
                myBoard.checkSafePath(-10,17*player,player);
                // move one player from home to board
            }
            if (rolls[0] == rolls[1]) {
                System.out.println("Do you want to leave home with your other 5?");
                playerDecision = myScanner.nextLine();
                System.out.println("Player decisions: " + playerDecision);
                if (playerDecision.equals("yes")) {
                    myBoard.checkSafePath(-10, 17*player, player);
                    // move one player from home to board
                }
            }
        }
    }

    public void playGame() {
        for (int playerNumb = 0; playerNumb<=3; playerNumb++){
            askForMovements(pickNRandom(), playerNumb);
        }
    }
}

