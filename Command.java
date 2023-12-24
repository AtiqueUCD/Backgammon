import java.util.*;

public class Command extends Dice{
    
    static int[] diceRoll = new int[2];
    private static boolean gameStart = false;
    private static ArrayList<int[]> moveList = new ArrayList<>();

    public static ArrayList<String> testCommands = new ArrayList<>();
    public static int TestCommandSize = 0;

    /*These colors are only used for display messages and not to be used for checkers! */
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String BLACK = "\u001B[30m";

    private static int doubleStake = 1;

    public static ArrayList<int[]> getMoveList()
    {
        return moveList;
    }

    public static boolean acceptCommand(String command, Board boardObj, Turn turnObj, Player playerOne, Player playerTwo, Score score)
    {
        boolean returnState = false;
        boolean playerTurn = turnObj.getTurn();
        //System.out.println(playerTurn);

        
        int d1 = 0;
        int d2 = 0;
        
        // Handle double roll
        if (diceRoll[0] == diceRoll[1] && diceRoll[0]!=0 && diceRoll[1]!=0) {
            System.out.println("You rolled a double " + diceRoll[0] + "! You can make four moves.");
            for (int k = 0; k < 4; k++) {
                prediction(diceRoll[0], diceRoll[1], playerTurn, boardObj, 1);

                Scanner scanner = new Scanner(System.in);
                System.out.println("Select your move: ");
                int commandIndex = scanner.nextInt(); // Get player's move choice

                if (commandIndex >= 0 && commandIndex < moveList.size()) {
                    int source = moveList.get(commandIndex)[0];
                    int dest = moveList.get(commandIndex)[1];
                    moveChecker(source, dest, boardObj, turnObj, playerOne, playerTwo);

                    moveList.clear();
                } else {
                    System.out.println("Invalid move selection. Please try again.");
                    k--; // Decrement counter to retry the move
                    continue;
                }
            }
            return true;
        }

        if(command.matches("[0-9]+") && turnObj.getTurnStatus())
        {
            int nd1 = diceRoll[0];
            int nd2 = diceRoll[1];

            int commandIndex = Integer.parseInt(command);
            System.out.println(moveList.get(commandIndex)[0]);
            
            int source = moveList.get(commandIndex)[0];
            int dest = moveList.get(commandIndex)[1];

            // //Check is the move is blocked or not
            // if(turnObj.getBlockedmove(playerOne, playerTwo) == true)
            // {
            //     moveChckersFromBar(source, dest, boardObj, turnObj, playerOne, playerTwo);
            // }
            // //perform move
            // else{
            // moveChecker(source, dest, boardObj, turnObj, playerOne, playerTwo);//.getTurn());
            // }
            //perform move
            moveChecker(source, dest, boardObj, turnObj, playerOne, playerTwo);
            /*
             * Math.abs() function
             */
            if(Math.abs(dest-source) == diceRoll[0]){
                diceRoll[0] = 0;
                nd1 = 0;

                System.out.println("dn1 = 0");
            }
            if(Math.abs(dest-source) == diceRoll[1]){
                diceRoll[1] = 0;
                nd2 = 0;
                System.out.println("dn2 = 0");
            }
            if(Math.abs(dest-source) == ( diceRoll[0]+ diceRoll[1])){
                diceRoll[0] = 0;
                diceRoll[1] = 0;
                nd1 = 0;
                nd2 = 0;
            }
            moveList.clear();

            if(diceRoll[0] != 0 || diceRoll[1] != 0){
                prediction(diceRoll[0], diceRoll[1], playerTurn, boardObj, 1);
            
            }else{
                /*Check for the game over conditions */
                Player currentPLayer = turnObj.getCurrentPlayer(playerOne, playerTwo);
                
                /*1. Check the non zero checker condition for the current player */
                if(!boardObj.areCheckersOnBoard(turnObj.getCurrentPlayerColor()))
                {
                    //No checkers are on the board
                    score.setScore(currentPLayer);  //increment the score of the winning player
                    
                    //Match over
                    System.out.println("Match over!!!");
                    System.out.println("New match");
                    System.out.println("Reseting the board...");

                    //Reset the board
                    boardObj.initializeBoard();
                    

                    //Check if the score has reached the match length
                    if(score.compareMatchLength(currentPLayer))
                    {
                        System.out.println("Current player has won!!");
                        System.out.println("Game over!!!");
                    }
                }
   
                System.out.println("New roll!");
                turnObj.resetTurnInprogress();
                System.out.println("Toggle turn!!");
                turnObj.toggleTurn(playerOne,playerTwo);

            }
            return true;

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
                if(!turnObj.getTurnStatus()&& !turnObj.getBlockedmove(playerOne, playerTwo))
                {
                    turnObj.setTurnInprogress();
                    /* Roll the dice */
                    // diceRoll = roll();
                    diceRoll[0] = d1;
                    diceRoll[1] = d2;
                    //Show possible moves
                    prediction(diceRoll[0],diceRoll[1],playerTurn,boardObj, 1);
                    // turnObj.toggleTurn(playerOne,playerTwo);
                    turnObj.displayTurn(playerOne, playerTwo);
                }else if(!turnObj.getTurnStatus() && turnObj.getBlockedmove(playerOne, playerTwo)){
                    System.out.println("Need to get off the bar first");
                    
                    //Date:- 21-12-23 - ver 1.0.0
                    turnObj.setTurnInprogress();//bug fix
                    
                    
                    diceRoll[0] = d1;
                    diceRoll[1] = d2;
                    //need to get of the bar
                    gettingOfBarPrediction(diceRoll[0],diceRoll[1], playerOne, playerTwo, turnObj, boardObj);
                }
                
                else
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
                if(!turnObj.getTurnStatus() && !turnObj.getBlockedmove(playerOne, playerTwo))//there should be no blocked moves and current player turn is not over yet
                {
                    turnObj.setTurnInprogress();
                    /* Roll the dice */
                    diceRoll = roll();
                    //Show possible moves
                    prediction(diceRoll[0],diceRoll[1],playerTurn,boardObj,1);
                    // turnObj.toggleTurn(playerOne,playerTwo);
                    turnObj.displayTurn(playerOne, playerTwo);
                }else if(!turnObj.getTurnStatus() && turnObj.getBlockedmove(playerOne, playerTwo)){
                    System.out.println("Need to get off the bar first");
                    //Bug fix
                    turnObj.setTurnInprogress();
                    /* Roll the dice */
                    diceRoll = roll();
                    //need to get of the bar
                    gettingOfBarPrediction(diceRoll[0],diceRoll[1], playerOne, playerTwo, turnObj, boardObj);
                }
                else
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
                    System.out.println("5. Testrun to run command file");
                    System.out.println("6. Matchlength to see the match length");
                    System.out.println("7. double : offer a double to your opponent.");
                }else
                {
                    System.out.println("3. Start to initiate the game");
                    System.out.println("4. Testrun to run command file");
                    System.out.println("5. Matchlength to see the match length");
                }
                System.out.println("==============================");
            break;

            case "start":
                Presenter.displayPlayArea(boardObj,playerOne,playerTwo,score);
                startGame();
                turnObj.displayTurn(playerOne, playerTwo);
            break;

            case "show":
                if(getGameState())
                {
                    turnObj.displayTurn(playerOne, playerTwo);
                    Presenter.displayPlayArea(boardObj,playerOne,playerTwo, score);
                }else
                {
                    System.out.println(RED+ "WARN:" + RESET + " Game is not yet started! Enter START to initiate the game.");
                }
                break;

            case "moves":
                if(getMovesLength()>0)
                {
                    turnObj.displayTurn(playerOne, playerTwo);
                    turnObj.displayTurn(playerOne, playerTwo);
                    printMoves(moveList);
                }else
                {
                    System.out.println(RED+ "WARN:" + RESET + "Roll the dice to show possible moves. Enter 'R / r' to roll.");
                }
            break;
            
            case "matchlength":
                System.out.println("Match length set is : " + score.getMatchLength());
            break;

            case "testrun":
                System.out.println("Enter the file name: ");
                Scanner tempin = new Scanner(System.in);
                String filename = tempin.nextLine();
                testCommands = TestCommand.readTestCommandFile(filename);
                TestCommandSize = testCommands.size();
                int i = 0;
                while(TestCommandSize-- > 0)
                {
                    acceptCommand(testCommands.get(i++), boardObj, turnObj, playerOne, playerTwo, score);
                }
            break;

            case "double":
                if (!getGameState()) {
                    System.out.println(RED + "WARN:" + RESET + " Game is not yet started! Enter START to initiate the game.");
                    break;
                }
                if (turnObj.getTurnStatus()) {
                    System.out.println("You cannot offer a double now. It's not your turn.");
                    break;
                }
                System.out.println("Player " + (playerTurn ? "One" : "Two") + " offers a double. Accept? (yes/no)");
                Scanner in = new Scanner(System.in);
                String response = in.nextLine();
                if (response.equalsIgnoreCase("yes")) {
                    doubleStake *= 2;
                    System.out.println("Double accepted! Current stake: " + doubleStake);
                    // toggling after accepting double
                    turnObj.toggleTurn(playerOne, playerTwo); 
                    turnObj.displayTurn(playerOne, playerTwo);
                } else {
                    System.out.println("Double declined. Player " + (!playerTurn ? "One" : "Two") + " wins the game!");
                    
                    // updating the score for the winning player
                    Player winningPlayer = playerTurn ? playerTwo : playerOne;
                    for (int k = 0; k < doubleStake; k++) {
                        score.setScore(winningPlayer);  // increment the score of the winning player by the double stake
                    }

                    int updatedScore = score.getScore(winningPlayer);
                    System.out.println("The score for Player " + (!playerTurn ? "One" : "Two") + " is now: " + updatedScore);

                    // game Over Message
                    System.out.println("Game Over! Player " + (!playerTurn ? "One" : "Two") + " wins the match!");

                    // quitting the game
                    System.exit(0);  // this will terminate the Java virtual machine
                }
                break;


            default:
                System.out.println(RED+ "WARN:" + RESET + " Invalid command!! Enter 'Hint' to see the command pallet.");
                break;
        }
        returnState = true;
        return returnState;
    }

    public static int[] getDiceRoll()
    {
        return diceRoll;
    }



    static public void gettingOfBarPrediction(int nd1, int nd2,Player playerOne, Player playerTwo, Turn turnObj, Board boardObj)
    {
        boolean turn = turnObj.getTurn();
        String colorOfCheckers = "", compareColor = "";
        int start = 0, end = 0;
        int src = 0, dest = 0;
        int noOfCheckers = 0;
        int[] arr = new int[2];

        if(turn == true)
        {
            System.out.println("RED move blocked!!");
            //for player one "RED" 
            //placing in 0 - 5
            start = 0;
            end = 5;
            compareColor = Checker.RED;
            src = 30;//for index zero

            arr[0] = 6 - diceRoll[0];
            arr[1] = 6 - diceRoll[1];
        }
        {
            System.out.println("BLACK move blocked!!");
            //Black - player two
            //placing in 18-23
            start = 18;
            end = 23;

            src = 31;//for index one

            arr[0] = 24 - diceRoll[0];
            arr[1] = 24 - diceRoll[1];

            compareColor = Checker.BLACK;
            
        }

        start = arr[0];
        int index = 0;
        System.out.println("Possible moves = " + arr[0] + ", " + arr[1]);
        for(int pos = arr[0]; index < 2; index++)
        {
            pos = arr[index];
            // dest = pos;
            //check is the spike is empty
            if(boardObj.getSpike(pos).isEmpty() == true)
            {
                //current spike is empty
                moveList.add(new int[]{src, pos});
                continue;
            }
            colorOfCheckers = boardObj.getSpike(pos).get(boardObj.getSpike(pos).size()-1).getColor();//bug:- when the spike is empty then throws error
            noOfCheckers = boardObj.getSpike(pos).size();
            
            if(colorOfCheckers.equals(compareColor) || noOfCheckers == 0)
            {
                // dest = pos;
                //add to moves list
                moveList.add(new int[]{src, pos});
            }
            //killing
            else if(noOfCheckers == 1 && colorOfCheckers.equals(compareColor))
            {
                moveList.add(new int[]{src, pos});
            }
            
        }


        //if there are no possible moved left
        if(moveList.isEmpty())
        {
            System.out.println("No possible places to get off!!!!");
            //return false;
        }    
        printMoves(moveList);

    }

//original
/* 
    static public void gettingOfBarPrediction(int nd1, int nd2,Player playerOne, Player playerTwo, Turn turnObj, Board boardObj)
    {
        boolean turn = turnObj.getTurn();
        String colorOfCheckers = "", compareColor = "";
        int start = 0, end = 0;
        int src = 0, dest = 0;
        int noOfCheckers = 0;

        if(turn == true)
        {
            System.out.println("RED move blocked!!");
            //for player one "RED" 
            //placing in 0 - 5
            start = 0;
            end = 5;
            compareColor = Checker.RED;
            src = 30;//for index zero
        }
        {
            System.out.println("BLACK move blocked!!");
            //Black - player two
            //placing in 18-23
            start = 18;
            end = 23;
            compareColor = Checker.BLACK;
            src = 31;//for index one
        }

        for(int pos = start; pos <= end; pos++)
        {

            dest = pos;
            //check is the spike is empty
            if(boardObj.getSpike(pos).isEmpty() == true)
            {
                //current spike is empty
                moveList.add(new int[]{src, dest});
                continue;
            }
            colorOfCheckers = boardObj.getSpike(pos).get(boardObj.getSpike(pos).size()-1).getColor();//bug:- when the spike is empty then throws error
            noOfCheckers = boardObj.getSpike(pos).size();
            
            if(colorOfCheckers.equals(compareColor) || noOfCheckers == 0)
            {
                // dest = pos;
                //add to moves list
                moveList.add(new int[]{src, dest});
            }
            //killing
            else if(noOfCheckers == 1 && colorOfCheckers.equals(compareColor))
            {
                moveList.add(new int[]{src, dest});
            }
            
        }


        //if there are no possible moved left
        if(moveList.isEmpty())
        {
            System.out.println("No possible places to get off!!!!");
            //return false;
        }    
        printMoves(moveList);

    }
*/


    static public void prediction(int nd1, int nd2, boolean turnPlayer, Board board, int movesAllowed) {
        String playerColor = (turnPlayer == true) ? Checker.RED : Checker.BLACK;
        
        moveList.clear();
        if(nd1==nd2){
            for (int indexSpike = 0; indexSpike < 24; indexSpike++) {
                Spike tempSpike = board.getSpike(indexSpike);
                if (!tempSpike.isEmpty() && playerColor.equals(tempSpike.get(tempSpike.size() - 1).getColor())) {
                    int source = indexSpike;
                    int destination = turnPlayer ? source + nd1 : source - nd1;

                    if (isValidMove(destination, board, playerColor) && !isDuplicateMove(source, destination)) {
                        moveList.add(new int[]{source, destination});
                    }
                }
        }}else{

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
            }}

        printMoves(moveList);
    }

    static private boolean isDuplicateMove(int source, int destination) {
        for (int[] move : moveList) {
            if (move[0] == source && move[1] == destination) {
                return true;
            }
        }
        return false;
}

    static private void checkAndAddMove(List<int[]> moveList, int source, int steps, Board board, String playerColor, boolean playerTurn) {
    int dest = playerTurn ? source + steps : source - steps;

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

    public static void moveChckersFromBar(int source, int dest, Board board, Turn turnObj, Player playerOne, Player playerTwo)
    {
        int noOfCheckers = 0;
        boolean turn = turnObj.getTurn();
        boolean resetBlockMove = false;

        System.out.println("Player turn =  " + turn);

        source -= 30;



        //Check for kill
        if(turn == false)//We want the opposit players checkers to kill
        {
            //Chance for the black checkers to kill the red
            noOfCheckers = board.spikes.get(dest).nbColoredChecker(Checker.RED);
            System.out.println("Red number = " + noOfCheckers);

            //Kill RED checkers
        }
        else{
            //chance for the red checkers to kill the black
            noOfCheckers = board.spikes.get(dest).nbColoredChecker(Checker.BLACK);
            System.out.println("Black number = " + noOfCheckers);

            //Kill BLACK checker
        }
        if(noOfCheckers == 1)
        {
            Checker sourceChecker = board.removeCheckerFromBar(turn);//remove the checkers from the Bar
            //Kill RED checker
            board.addCheckToBar(board.getSpike(dest).remove(board.getSpike(dest).size()-1), turn);
            board.addCheckersToSpike(sourceChecker, dest);
            
            //Blocks the turn, untill the respective player does not removes it from the block
            turnObj.setBlockedmove(playerOne, playerTwo);

            // turnObj.toggleTurn(playerOne, playerTwo);
            turnObj.displayTurn(playerOne, playerTwo);
            resetBlockMove = true;
        }
        else
        {
            Checker sourceChecker = board.getSpike(source).get(board.getSpike(source).size()-1);
            board.getSpike(source).remove(board.getSpike(source).size()-1);

            board.addCheckersToSpike(sourceChecker, dest);
            resetBlockMove = true;
        }

        //resets the blocked move
        if(resetBlockMove == true)
        {
            turnObj.resetBlockedmove(playerOne, playerTwo);
            //Blocked move reset
        }

    }
    public static void moveChecker(int source, int dest, Board board, Turn turnObj, Player playerOne, Player playerTwo)//Boolean turn)
    {
        int noOfCheckers = 0;
        boolean turn = turnObj.getTurn();//
        System.out.println("Player turn =  " + turn);
        //Check for kill
        if(turn == false)//We want the opposit players checkers to kill
        {
            //Chance for the black checkers to kill the red
            noOfCheckers = board.spikes.get(dest).nbColoredChecker(Checker.RED);
            System.out.println("Red number = " + noOfCheckers);

            //Kill RED checkers
        }
        else{
            //chance for the red checkers to kill the black
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
            
            //Blocks the turn, untill the respective player does not removes it from the block
            turnObj.setBlockedmove(playerOne, playerTwo);
        }
        else
        {
            //check the source address of the spike if greater than 24
            if(source > 24)
            {
                //Removing the checkers from the bar
                System.out.println("Removing the checkers from the bar.");
                Checker sourceChecker = board.removeCheckerFromBar(turnObj.getTurn());
                board.addCheckersToSpike(sourceChecker, dest);

                //need to check the number od checkers on the bar
                int noCheckeronBar = board.getnoCheckersFromCurrentBar(turn);
                
                //if the number of checers on the bar is zero then reset the blocked move
                if(noCheckeronBar == 0)
                {
                    //reset the blocked moves
                    turnObj.resetBlockedmove(playerOne, playerTwo);

                    //exhaust the dice roll used
                    int temp = 0;
                    if(dest > 6)
                    {
                        temp = 24 - dest;//for placing the black checkers
                    }else{
                        temp = dest - 1;//for placing the red checkers
                    }

                    if(diceRoll[0] == temp)
                    {
                        diceRoll[0] = 0;
                    }else
                    {
                        diceRoll[1] = 0;
                    }

                }
                //if the number of checkers on the bar is non zero then do no reset the blocked move
            }
            else
            {
                //Standard transaction
                System.out.println("Normal transaction.");
                Checker sourceChecker = board.getSpike(source).get(board.getSpike(source).size()-1);
                board.getSpike(source).remove(board.getSpike(source).size()-1);
                board.addCheckersToSpike(sourceChecker, dest);

                // return new int[]{dest,source};
            }

        }

    }


}
