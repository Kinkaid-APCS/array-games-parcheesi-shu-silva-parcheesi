import java.util.Random;
public class Referee
{
    private Board myBoard;

    public Referee()
    {
        myBoard = new Board();
        System.out.println(myBoard);
    }

    public int rollDice() {
        final String[] roll_dice = {"1", "2", "3", "4", "5", "6"};
        Random random = new Random();
        int index = random.nextInt(roll_dice.length);
        System.out.println(roll_dice[index]);
    }

    public void playGame()
    {
        ;
    }
}
