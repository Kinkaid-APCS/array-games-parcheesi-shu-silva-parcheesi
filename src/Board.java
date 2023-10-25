import java.util.Arrays;

public class Board
{

    // "clever" hint about the Parcheesi board:
    // If you divide the number of a square by 17 and look at the remainder, you can get important
    // information about that square. For example...
    //      if the remainder is zero, this is a safe space.
    //      if the remainder is seven, this is a safe space.
    //      if the remainder is twelve, this is a safe space.
    //      if the remainder is zero, this is the starting position for one of the players (int)(squareNum/17)...
    //      if the remainder is twelve, this is the start of a home row for one of the players (I'll let you figure out
    //             which one.)

    private Space[] mainLoop;
    private Space[][] safePaths; // see note, below.

    private int[] safeSpaces = {0, 7, 12, 17, 24, 29, 34, 41, 46, 51, 58, 63};
    private int[] numChipsInStartingPointsPerPlayer = {4,4,4,4};
    private int[] numChipsInHomePerPlayer = {0,0,0,0};

    public Board()
    {
        mainLoop = new Space[68];
        safePaths = new Space[4][6];  // this makes four 6-element arrays of Spaces. Technically, this is a 2-d array we
                                      // haven't covered yet. Just think of it as an array of arrays.
            safePaths[0] = new Space[6];
            safePaths[1] = new Space[6];
            safePaths[2] = new Space[6];
            safePaths[3] = new Space[6];
        // ------------------------------
        // TODO: initialize all these spaces in both the main loop and the safe paths. Make sure you set the appropriate squares to safe!
        for (int i = 0; i < mainLoop.length; i ++){
            mainLoop[i] = new Space();
            for (int j = 0; j < safeSpaces.length; j ++){
                if (safeSpaces[j] == i){
                    mainLoop[i].setSafe(true);
                }
            }
        }
        for (int i = 0; i < safePaths.length; i ++){
            for (int j = 0; j < safePaths[i].length; j ++){
                safePaths[i][j] = new Space();
                safePaths[i][j].setSafe(true);
            }
        }

        // ------------------------------

    }

    public void movePlaces(int startPos, int endPos){
        mainLoop[startPos].setWhoIsHere(mainLoop[startPos].getWhoIsHere()-1);
        mainLoop[endPos].setWhoIsHere(mainLoop[endPos].getWhoIsHere()+1);
    }

    public boolean checkSafePath(int position){
        if(mainLoop[position].isSafe() || mainLoop[position].getNumPieces() == 2){
            return false;
        }
        else{
            return true;
        }
    }

    public String toString()
    {
//        for (int i = 0; i < mainLoop.length; i++){
//            System.out.print(i);
//            System.out.println(mainLoop[i]);
//        }
        String result = "";
        int path = 0;
        // -------------------------------
        // TODO: in a loop, keep appending information to "result" so that result winds up being a string that you can print to see the whole board
        for (int i = 0; i < mainLoop.length; i ++){
            result += mainLoop[i];
            if (i%17 == 12){
                for (int j = 0; j < safePaths[path].length; j++){
                    result += safePaths[path][j];
                }
                path ++;
            }
            result += "\n";
        }
        // suggestion: start by just printing the row numbers, a tab, and the squares themselves.
        // then you can get fancy by printing information about the various players' starting positions.
        // then you can get fancy by adding in the safe rows to the goal for the various players.

        // -------------------------------

        return result;
    }

}
