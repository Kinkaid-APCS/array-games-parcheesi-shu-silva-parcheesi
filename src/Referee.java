import java.util.Random;
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

    public void playGame()
    {
        ;
    }
}
