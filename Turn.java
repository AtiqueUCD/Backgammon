public class Turn {
    private boolean playerTurn;
    private boolean currentPlayStatus;//If true then new roll command will not be accepted, after every play this 
                                      //variable will be set to false

    /*
     * TRUE - RED
     * FALSE - BLACK
     */
    public Turn()
    {
        playerTurn = false;
    }
    public void toggleTurn(Player playerOne, Player playerTwo)
    {
        playerTurn = playerTurn == false ? true : false;

        playerOne.setTurn(playerTurn);
        playerTwo.setTurn(!playerTurn);
    }

    /*
     * Returns the current player who is playing.
     */
    public Player getCurrentPlayer(Player player_one, Player player_two)
    {
        return getTurn() == true ? player_one : player_two;
    }

    public String getCurrentPlayerColor()
    {
        return getTurn() == true ? Checker.RED : Checker.BLACK;
    }


    public boolean getTurn()
    {
        return playerTurn;
    }

    public void displayTurn(Player playerOne, Player playerTwo)
    {
        if(playerOne.isTurn() == true)
            System.out.println("Current turn: " + playerOne.getName());
        else
            System.out.println("Current turn: " + playerTwo.getName());
    }

    public void setTurnInprogress()
    {
        currentPlayStatus = true;
    }
    
    public void resetTurnInprogress()
    {
        currentPlayStatus = false;
    }

    public boolean getTurnStatus()
    {
        return currentPlayStatus;
    }

    public boolean getBlockedmove(Player playerOne, Player playerTwo)
    {
        /*
        if(getTurn() == true)
        {
            return playerOne.getmoveBlocked();
        }
        else
        {
            return playerTwo.getmoveBlocked();
        }
        */
        return getCurrentPlayer(playerOne,playerTwo).getmoveBlocked();
    }

    public void setBlockedmove(Player playerOne, Player playerTwo)
    {
        if(getTurn() == true)//block the other person
        {
            playerTwo.setMoveBlock();
        }
        else
        {
            playerOne.setMoveBlock();
        }
    }

    public void resetBlockedmove(Player playerOne, Player playerTwo)
    {
        if(getTurn() == true)
        {
            playerOne.resetMoveBlock();
        }
        else
        {
            playerTwo.resetMoveBlock();
        }
    }
}
