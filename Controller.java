public class Controller {
    public static void main(String[] args)
    {
        Board newBoard = new Board();
        newBoard.initializeBoard();
        // Presenter.viewSpike(newBoard, 1);
        // Presenter.viewBoard();
        Presenter.displayPlayArea();
    }
}
