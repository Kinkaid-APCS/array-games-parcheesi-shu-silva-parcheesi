public class ParchessiRunner
{

    public static void main(String[] args)
    {
        boolean testingMode = true;
        if (testingMode)
        {
            System.out.println("Start tests");
            for (int i  = 0; i < 50; i ++) {
                System.out.println(Referee.pickNRandom()[0]);
                System.out.println(Referee.pickNRandom()[1]);

            }
            // enter test code here.
            System.out.println("End tests");
        }
        else
        {
            Referee ref = new Referee();
            System.out.println("Start game");
            ref.playGame();
            System.out.println("End game");
        }
    }
}
