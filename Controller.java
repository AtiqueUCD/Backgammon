import java.util.*;

public class Controller {
    public static void main(String[] args)
    {
        Board newBoard = new Board();
        Player playerOne = new Player("Atique");
        Player playerTwo = new Player("Jimmy");
        newBoard.initializeBoard();
        // Presenter.viewSpike(newBoard, 1);

        Presenter.displaySpikes(newBoard);
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the first player name : ");
        playerOne.setName(in.nextLine());
        System.out.print("Enter the second player name : ");
        playerTwo.setName(in.nextLine());

        //Displays the play board
        Presenter.displayPlayArea(playerOne,playerTwo);
        Presenter.displayCommandPrompt();
        String command = in.nextLine();


        /*
         * Super loop to play the game. Accpet the command from the user.
         */
        while(!(command.equals("Q") || command.equals("q")))
        {
            Command.acceptCommand(command);
            int[] temp = new int[2];
            temp = Command.getDiceRoll();
            System.out.println("1st Dice: " + temp[0]);
            System.out.println("2nd Dice: " + temp[1]);
            Presenter.displayPlayArea(playerOne,playerTwo);
            Presenter.displayCommandPrompt();
            command = in.nextLine();
        }
    }
}
