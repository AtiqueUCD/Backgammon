import java.util.Scanner;

public class Presenter{

    private static void outine()
    {
        System.out.print("---");
    }

    private static void spikeOutline()
    {
        System.out.print("|");
    }

    private static void barOutline()
    {
        System.out.print("  BAR  ");
    }
    
    public static void viewBoard()
    {

        /*This is for the main board play area */
        System.out.print("12");
        for(int j = 0; j < 6;j++)
        {
            System.out.print("\t");
        }
        System.out.println("1    OFF");

        /*This is for the top of the board with spikes */
        for(int i = 1; i <= 12; i++)
        {
            if(i%6==0 && i<12)
            {
                barOutline();
            }else{
                spikeOutline();
                if(i!=12)
                    outine();
            }

        }
        System.out.println("");
        for(int i = 1; i <= 10; i++)
        {
            /*For the partition between the two horizontal halfs */
            if(i == 5)
            {
                for(int x = 0; x< 12;x++)
                {
                    System.out.print("----");
                }
                System.out.println();
            }else{
            /*This is for the main board play area */
            System.out.print("(");
            for(int j = 0; j < 6;j++)
            {
                System.out.print("\t");
            }
            System.out.println(")");
        }
            
        }

        /*This is for the bottom of the board with spikes */
        for(int i = 1; i <= 12; i++)
        {
            if(i%6==0 && i<12)
            {
                barOutline();
            }else{
                spikeOutline();
                if(i!=12)
                    outine();
            }

        }
        System.out.println();
        /*This is for the main board play area */
        System.out.print("13");
        for(int j = 0; j < 6;j++)
        {
            System.out.print("\t");
        }
        System.out.println("24   OFF");
    }

    public static void viewSpike(Board boardObj, int spikePosition)
    {
        // System.out.println(boardObj.getSpike(spikePosition));
        // viewBoard();
    }

    private static void displayPlayerDetails(Player player_one, Player player_two)
    {
        System.out.println("Player 1 : " + player_one.getName());
        System.out.println("Player 2 : " + player_two.getName());
    }

    private static void displayCommandPrompt()
    {
        System.out.println("Enter your command here: ");
    }
    public static void displayPlayArea(Player player_one, Player player_two)
    {
        displayPlayerDetails(player_one,player_two);
        viewBoard();
        displayCommandPrompt();
    }

    public static void startGame(Player player_one, Player player_two)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the first player name : ");
        player_one.setName(in.nextLine());
        System.out.print("Enter the second player name : ");
        player_two.setName(in.nextLine());
    }
}