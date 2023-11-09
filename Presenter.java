import java.util.*;

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
                spikeOutline();
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
                spikeOutline();
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

    /*
     * To be modified
     */
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

    public static void displayCommandPrompt()
    {
        System.out.print("Please enter 'R/r' to roll the dice or 'Q/q' to Quit: ");
    }
    public static void displayPlayArea(Player player_one, Player player_two)
    {
        displayPlayerDetails(player_one,player_two);
        viewBoard();
    }

    public static void displaySpikes(Board obj)
    {
        // for(int i = 0; i<obj.getTotalNoOfSpikes(); i++)
        // {
        //     for(int j = 0; j < obj.size(); j++)
        //     {
        //         // if(!obj.getSpike(j).isEmpty())
        //         System.out.print(obj.getSpike(j).getPosition()+ " ");
        //         // obj.getCheckers(j);
        //     }
        //     System.out.println("");
        // }

        for(int i = 0; i < 8; i++)
        {
            // for(int j = 0; j < obj.size(); j++)
            // {
                // if(!obj.getSpike(j).isEmpty())
                // System.out.print("Size of the Checkers: " + obj.getSpike(i).size()+ " ");
                // System.out.print("ID of the checkers: " + obj.getSpike(i).get(1).getID());
                // System.out.println(" color of the checkers: " + obj.getSpike(i).get(1).toString());
                // obj.getCheckers(j);
            // }
            int totalNoCheckers = obj.getSpike(i).size();
            for(int j = 0; j < totalNoCheckers; j++)
            {
                //print the color
                System.out.println(obj.getSpike(i).get(j).getColor() + Checker.RESET);
            }
            System.out.println("");
        }
    }

    /*Not in use */
    public static void startGame(Player player_one, Player player_two)
    {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter the first player name : ");
            player_one.setName(in.nextLine());
            System.out.print("Enter the second player name : ");
            player_two.setName(in.nextLine());
        }
        
    }
}