import java.util.Random;
import java.util.Scanner;
public class Referee {
    private Board myBoard;
    private boolean winner = false;

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
        Scanner myScanner = new Scanner(System.in);
        boolean roll1IsUsed = false;
        boolean roll2IsUsed = false;
        if (rolls[0] == 5) {
            System.out.println("Do you want to leave home?");
            String playerDecision = myScanner.nextLine();
            System.out.println("Player decisions: " + playerDecision);
            if (playerDecision.equals("yes")) {
                myBoard.checkSafePath(-10, 17 * player, player);
                // move one player from home to board
                roll1IsUsed = true;
                myBoard.movePlaces(-10,17 * player, player);
                System.out.println(myBoard);
                myBoard.setPlayersInStartingArea(player, myBoard.getPlayersInStartingArea(player)-1);
            }
        }
        if (rolls[1] == 5) {
            System.out.println("Do you want to leave home with your other 5?");
            String playerDecision = myScanner.nextLine();
            System.out.println("Player decisions: " + playerDecision);
            if (playerDecision.equals("yes")) {
                myBoard.checkSafePath(-10, 17*player, player);
                System.out.println(myBoard);
                // move one player from home to board
                roll2IsUsed = true;
                myBoard.movePlaces(-10,17 * player, player);
                myBoard.setPlayersInStartingArea(player, myBoard.getPlayersInStartingArea(player)-1);
            }
        }
        while ((!roll1IsUsed || !roll2IsUsed) && myBoard.getPlayersInStartingArea(player)+myBoard.getPLayersInHome(player) != 4) {
            System.out.println("Where is the piece that you want to move?");
            int playerDecisionTwo = myScanner.nextInt();
            System.out.println("Player decision: " + playerDecisionTwo);
            int startPosition = playerDecisionTwo;
            System.out.println("How far do you want to go? A = 1st roll ; B = 2nd roll ; C = combined rolls");
            myScanner.nextLine();
            String playerDecisionThree = myScanner.nextLine();
            System.out.println("Player decision: " + playerDecisionThree);
            if (playerDecisionThree.equals("A") && !roll1IsUsed) {
                myBoard.movePlaces(startPosition,rolls[0] + startPosition, player);
                myBoard.setPlayersInStartingArea(player, myBoard.getPlayersInStartingArea(player)-1);
            }
            else if (playerDecisionThree.equals("B") && !roll2IsUsed) {
                myBoard.movePlaces(startPosition,rolls[1] + startPosition, player);
                myBoard.setPlayersInStartingArea(player, myBoard.getPlayersInStartingArea(player)-1);
            }
            else if (playerDecisionThree.equals("C") && !roll1IsUsed && !roll2IsUsed) {
                myBoard.movePlaces(startPosition,rolls[0] + rolls[1] + startPosition, player);
                myBoard.setPlayersInStartingArea(player, myBoard.getPlayersInStartingArea(player)-1);
            }
        }



    }

    public void playGame() {
        while(winner == false) {
            for (int playerNumb = 0; playerNumb <= 3; playerNumb++) {
                askForMovements(pickNRandom(), playerNumb);
                if (winner == false) {
                    break;
                }
            }
        }
    }
    public void endGame(int player){
        System.out.println("Player " +player+ " wins!");
        winner = true;
    }
}