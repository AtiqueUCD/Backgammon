public class Controller {
    public static void main(String[] args)
    {
        Board newBoard = new Board();
        Player playerOne = new Player("Atique");
        Player playerTwo = new Player("Jimmy");
        newBoard.initializeBoard();
        // Presenter.viewSpike(newBoard, 1);
        // Presenter.viewBoard();
        Presenter.startGame(playerOne, playerTwo);
        Presenter.displayPlayArea(playerOne,playerTwo);
        Command.acceptCommand();
        int[] temp = new int[2];
        temp = Command.getDiceRoll();
        System.out.println(temp[0]);
        System.out.println(temp[1]);
    }
}
