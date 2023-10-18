import java.util.Random;
public class Referee
{
    private Board myBoard;

    public Referee()
    {
        myBoard = new Board();
        System.out.println(myBoard);
    }

    public static int[] pickNRandom(int[] array, int n) {
        int[] rollDice = {1, 2, 3, 4, 5, 6};
        int[] randomRolls = pickNRandom(rollDice,2);
        return randomRolls;

    }

    public void playGame()
    {
        ;
    }
}
