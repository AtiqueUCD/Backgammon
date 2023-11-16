import java.util.*;

public class Command extends Dice{
    
    static int[] diceRoll = new int[2];

    public static void acceptCommand(String command, Board boardObj, Turn turnObj)
    {
        switch (command.toLowerCase()) {
            case "r":
                /* Roll the dice */
                diceRoll = roll();
                //Show possible moves
                prediction(diceRoll[0],diceRoll[1],turnObj.getTurn(),boardObj);
                turnObj.toggleTurn();
                // printMoves(moveList);
                break;
            case "hint":
                System.out.println("==============================");
                System.out.println("Commands to play:");
                System.out.println("1. R/r to roll");
                System.out.println("2. Q/q to quit");
                System.out.println("==============================");
            break;
            default:
                System.out.println("Invalid command. Please enter 'R/r' to roll the dice or 'Q/q' to Quit");
                break;
        }

    }

    public static int[] getDiceRoll()
    {
        return diceRoll;
    }

    static public void prediction(int nd1, int nd2, boolean turnPlayer, Board board) {
        String playerColor = (turnPlayer == true) ? Checker.BLACK : Checker.RED;
        ArrayList<int[]> moveList = new ArrayList<>();
        // ArrayList<int> CurrentTurnSpikeList = new ArrayList<>();


        //for (Spike spike : board.getSpike().getTotalNoOfSpikes()) {
        for(int indexSpike = 0; indexSpike < 26; indexSpike++)
        {
            Spike temp = new Spike();
            temp = board.getSpike(indexSpike);
            //debug
            // System.out.println(indexSpike + ". " + temp.size());

            if(!temp.isEmpty())
            {

                int indexCheckers = temp.size() - 1;
                if(playerColor.equals(temp.getCheckers(indexCheckers).getColor()))
                {
                    System.out.println("Spike no: " + indexSpike + " " + playerColor);
                    // CurrentTurnSpikeList.add(indexCheckers);
                    int source = temp.getCheckers(indexCheckers).getPosition();
                    checkAndAddMove(moveList, source, nd1, board, playerColor);
                    checkAndAddMove(moveList, source, nd2, board, playerColor);
                    checkAndAddMove(moveList, source, nd1 + nd2, board, playerColor);
                }
            }

            // if (!temp.isEmpty() && temp.get(temp.size() - 1).getColor().equals(playerColor)) //bug
            // {
            //     int source = temp.getPosition();

                // checkAndAddMove(moveList, source, nd1, board, playerColor);
                // checkAndAddMove(moveList, source, nd2, board, playerColor);
                // checkAndAddMove(moveList, source, nd1 + nd2, board, playerColor);
            // }
        }

        printMoves(moveList);
    }

    static private void checkAndAddMove(List<int[]> moveList, int source, int steps, Board board, String playerColor) {
        int dest = source + steps;
        if (isValidMove(dest, board, playerColor)) {
            moveList.add(new int[] {source, dest});
        }
    }

    static private boolean isValidMove(int dest, Board board, String playerColor) {
        if (dest < 0 || dest >= board.getTotalNoOfSpikes()) {
            return false;
        }

        String opponentColor = playerColor.equals(Checker.RED) ? Checker.BLACK : Checker.RED;
        Spike destinationSpike = board.getSpike(dest);
        return destinationSpike.nbColoredChecker(opponentColor) <= 1;
    }

    static private void printMoves(List<int[]> moveList) {
        for (int[] move : moveList) {
            System.out.println("Checker " + move[0] + ":");
            System.out.println("Move possible from " + move[0] + " to " + move[1]);
        }
    }

}
