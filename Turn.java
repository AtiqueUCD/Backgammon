public class Turn {
    private boolean playerTurn;

    public void toggleTurn()
    {
        playerTurn = playerTurn == false ? true : false;
    }

    public boolean getTurn()
    {
        return playerTurn;
    }
}
