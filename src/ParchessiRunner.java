import java.sql.Ref;

public class ParchessiRunner
{

    public static void main(String[] args)
    {
        Referee ref = new Referee();
        boolean testingMode = false;
        if (testingMode)
        {
            System.out.println("Start tests");
//            for (int i  = 0; i < 50; i ++) {
//                System.out.println(ref.pickNRandom()[0]);
//            }
            System.out.println(ref.getMyBoard());
            // enter test code here.
            System.out.println("End tests");
        }
        else
        {
            System.out.println("Start game");
            ref.playGame();
            System.out.println("End game");
        }
    }
}
