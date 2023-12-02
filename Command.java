import java.util.*;

public class Command extends Dice{
    
    static int[] diceRoll = new int[2];
    private static boolean gameStart = false;
    private static ArrayList<int[]> moveList = new ArrayList<>();

    /*These colors are only used for display messages and not to be used for checkers! */
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String BLACK = "\u001B[30m";

    public static boolean acceptCommand(String command, Board boardObj, Turn turnObj, Player playerOne, Player playerTwo)
    {
        boolean returnState = false;
        boolean playerTurn = turnObj.getTurn();
        System.out.println(playerTurn);

        
        int d1 = 0;
        int d2 = 0;
        

        if(command.matches("[0-9]+") && turnObj.getTurnStatus())
        {
            int nd1 = diceRoll[0];
            int nd2 = diceRoll[1];

            int commandIndex = Integer.parseInt(command);
            System.out.println(moveList.get(commandIndex)[0]);
            
            int source = moveList.get(commandIndex)[0];
            int dest = moveList.get(commandIndex)[1];
            //perform move
            moveChecker(source, dest, boardObj, turnObj.getTurn());

            /*
             * Math.abs() function
             */
            if(Math.abs(dest-source) == nd1){
                diceRoll[0] = 0;
                nd1 = 0;

                System.out.println("dn1 = 0");
            }
            if(Math.abs(dest-source) == nd2){
                diceRoll[1] = 0;
                nd2 = 0;
                System.out.println("dn2 = 0");
            }
            if(Math.abs(dest-source) == (nd1 + nd2)){
                diceRoll[0] = 0;
                diceRoll[1] = 0;
                nd1 = 0;
                nd2 = 0;
            }
            moveList.clear();

            if(nd1!=0 || nd2!=0){
                prediction(nd1, nd2, playerTurn, boardObj);
            
            }else{
                System.out.println("New roll!");
                turnObj.resetTurnInprogress();
                System.out.println("Toggle turn!!");
                turnObj.toggleTurn(playerOne,playerTwo);

            }
            return true;
                //check if move is done for nd1, nd2, nd1 + nd2
                //if nd1
                    //move checker
                    // nd1 = 0
            // if(nd1!=0 || nd2!=0)
                //call prediction function
                //print new move list
            //print "Play next call"

        }
        if(command.length() > 4)
        {

            String tempString = command.substring(0, 4).toLowerCase();
            if(tempString.equals("dice"))
            {
                System.out.println(tempString);
                d1 = Integer.parseInt(String.valueOf(command.substring(4,5)));
                d2 = Integer.parseInt(String.valueOf(command.substring(5)));
                System.out.println("d1: " + d1 + "d2 : " + d2);
                command = tempString;
            }
        }

        switch (command.toLowerCase()) {
            case "dice":
                if(!getGameState())
                {
                    System.out.println(RED+ "WARN:" + RESET + "Game is not yet started! Enter START to initiate the game.");
                    break;
                }
                if(!turnObj.getTurnStatus())
                {
                    turnObj.setTurnInprogress();
                    /* Roll the dice */
                    // diceRoll = roll();
                    diceRoll[0] = d1;
                    diceRoll[1] = d2;
                    //Show possible moves
                    prediction(diceRoll[0],diceRoll[1],playerTurn,boardObj);
                    // turnObj.toggleTurn(playerOne,playerTwo);
                    turnObj.displayTurn(playerOne, playerTwo);
                }else
                {
                    System.out.println(RED+ "WARN:" + RESET + " Can't place a new roll, did not made the current move.");
                }
            break;
            case "r":
                if(!getGameState())
                {
                    System.out.println(RED+ "WARN:" + RESET + "Game is not yet started! Enter START to initiate the game.");
                    break;
                }
                if(!turnObj.getTurnStatus())
                {
                    turnObj.setTurnInprogress();
                    /* Roll the dice */
                    diceRoll = roll();
                    //Show possible moves
                    prediction(diceRoll[0],diceRoll[1],playerTurn,boardObj);
                    // turnObj.toggleTurn(playerOne,playerTwo);
                    turnObj.displayTurn(playerOne, playerTwo);
                }else
                {
                    System.out.println(RED+ "WARN:" + RESET + " Can't place a new roll, did not made the current move.");
                }
                break;

            case "hint":
                System.out.println("==============================");
                System.out.println("Commands to play:");
                System.out.println("1. R/r to roll");
                System.out.println("2. Q/q to quit");
                if(getGameState())
                {
                    System.out.println("3. Show to display the board");
                    System.out.println("4. Moves to show the possible moves");
                }else
                {
                    System.out.println("3. Start to initiate the game");
                }
                System.out.println("==============================");
            break;

            case "start":
                Presenter.displayPlayArea(boardObj,playerOne,playerTwo);
                startGame();
                turnObj.displayTurn(playerOne, playerTwo);
            break;

            case "show":
                if(getGameState())
                {
                    turnObj.displayTurn(playerOne, playerTwo);
                    Presenter.displayPlayArea(boardObj,playerOne,playerTwo);
                }else
                {
                    System.out.println(RED+ "WARN:" + RESET + " Game is not yet started! Enter START to initiate the game.");
                }
                break;

            case "moves":
                if(getMovesLength()>0)
                {
                    turnObj.displayTurn(playerOne, playerTwo);
                    printMoves(moveList);
                }else
                {
                    System.out.println(RED+ "WARN:" + RESET + "Roll the dice to show possible moves. Enter 'R / r' to roll.");
                }
            break;
            
            default:
                System.out.println(RED+ "WARN:" + RESET + " Invalid command!! Enter 'Hint' to see the command pallet.");
                break;
        }

        return returnState;
    }

    public static int[] getDiceRoll()
    {
        return diceRoll;
    }

    static public void prediction(int nd1, int nd2, boolean turnPlayer, Board board) 
    {
        String playerColor = (turnPlayer == true) ? Checker.RED : Checker.BLACK;

        moveList.clear();

        for(int indexSpike = 0; indexSpike < 24; indexSpike++)
        {
            Spike temp = new Spike();
            temp = board.getSpike(indexSpike);

            if(!temp.isEmpty())
            {

                int indexCheckers = temp.size() - 1;
                if(playerColor.equals(temp.getCheckers(indexCheckers).getColor()))
                {
                    int source = temp.getCheckers(indexCheckers).getPosition();

                    /* 
                    if(nd1>0){
                        checkAndAddMove(moveList, source, nd1, board, playerColor);}
                    if(nd2>0){
                        checkAndAddMove(moveList, source, nd2, board, playerColor);}
                    if( nd1!=0 && nd2!=0){
                        checkAndAddMove(moveList, source, nd1 + nd2, board, playerColor);
                    */
                    if(nd1>0)
                    {
                        checkAndAddMove(moveList, source, nd1, board, playerColor, turnPlayer);
                    }
                    if(nd2>0){
                        checkAndAddMove(moveList, source, nd2, board, playerColor, turnPlayer);}
                    if( nd1!=0 && nd2!=0){
                        checkAndAddMove(moveList, source, nd1 + nd2, board, playerColor, turnPlayer);

                }
            }
            }
        }

        printMoves(moveList);
    }

    static private void checkAndAddMove(List<int[]> moveList, int source, int steps, Board board, String playerColor, boolean playerTurn) {
    int dest = playerTurn ? source + steps : source - steps;

     if (dest < 0 || dest >= 24 || !isValidMove(dest, board, playerColor)) {
        return; 
    }

    if (!isValidMove(dest, board, playerColor)) {
        return;
    }

    boolean moveExists = false;
    for (int[] move : moveList) {
        if (move[0] == source && move[1] == dest) {
            moveExists = true;
            break;
        }
    }

    if (!moveExists) {
        moveList.add(new int[]{source, dest});
    }
}


    static private boolean isValidMove(int dest, Board board, String playerColor) {
        if (dest < 0 || dest >= board.getTotalNoOfSpikes()) {
            return false;
        }

        String opponentColor = playerColor.equals(Checker.RED) ? Checker.BLACK : Checker.RED;
        Spike destinationSpike = board.getSpike(dest);
        if(destinationSpike.nbColoredChecker(opponentColor) == 1)
        {
            System.out.println("KILL!!!!!");
        }
        return destinationSpike.nbColoredChecker(opponentColor) <= 1;
    }

    static private void printMoves(List<int[]> moveList) {
        System.out.println("Possible Moves:");
        int possibleMoves = 0;
        for (int[] move : moveList) {
            System.out.println(possibleMoves + ") " + move[0] + " to " + move[1]);
            possibleMoves++;
        }
    }

    private static int getMovesLength()
    {
        return moveList.size();
    }

    private static void startGame()
    {
        gameStart = true;
    }

    private static boolean getGameState()
    {
        return gameStart;
    }

    public static void moveChecker(int source, int dest, Board board, Boolean turn)
    {
        int noOfCheckers = 0;
        System.out.println("Player turn =  " + turn);
        //Check for kill
        if(turn == false)//We want the opposit players checkers to kill
        {
            noOfCheckers = board.spikes.get(dest).nbColoredChecker(Checker.RED);
            System.out.println("Red number = " + noOfCheckers);

            //Kill RED checkers
        }
        else{
            noOfCheckers = board.spikes.get(dest).nbColoredChecker(Checker.BLACK);
            System.out.println("Black number = " + noOfCheckers);

            //Kill BLACK checker
        }


        if(noOfCheckers == 1)
        {
            Checker sourceChecker = board.getSpike(source).get(board.getSpike(source).size()-1);
            board.getSpike(source).remove(board.getSpike(source).size()-1);//remove the source checker
            //Kill RED checker
            board.addCheckToBar(board.getSpike(dest).remove(board.getSpike(dest).size()-1), turn);
            board.addCheckersToSpike(sourceChecker, dest);
        }
        else
        {
            Checker sourceChecker = board.getSpike(source).get(board.getSpike(source).size()-1);
            board.getSpike(source).remove(board.getSpike(source).size()-1);

            board.addCheckersToSpike(sourceChecker, dest);
        }

    }


}
