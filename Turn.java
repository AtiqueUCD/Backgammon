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

        System.out.println("AT-> Toggling turn" + playerTurn);
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
        if(getTurn() == true)
        {
            return playerOne.getmoveBlocked();
        }
        else //if(getTurn() == true)
        {
            return playerTwo.getmoveBlocked();
        }
    }

    public void setBlockedmove(Player playerOne, Player playerTwo)
    {
        if(getTurn() == true)//block the other person
        {
            playerTwo.setMoveBlock();
        }
        else //if(getTurn() == true)
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
        else //if(getTurn() == true)
        {
            playerTwo.resetMoveBlock();
        }
    }
}
