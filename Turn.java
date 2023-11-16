public class Turn {
    private boolean playerTurn;

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
}
