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
}
