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

    private static void displayPlayerDetails(Player player_one, Player player_two, Score scoreObj)
    {
        System.out.println("Player 1 : " + player_one.getName() + " Score: " + scoreObj.getScore(player_one));
        System.out.println("Player 2 : " + player_two.getName() + " Score: " + scoreObj.getScore(player_two));
        // System.out.println("Player 2 : " + player_two.getName());
        // System.out.println("Score Player 1 : " + scoreObj.getScore(player_one)+", Score Player 2 : " + scoreObj.getScore(player_two));
    }

    public static void displayCommandPrompt()
    {
        System.out.print("Please enter command (\"HINT\" for command pallet): ");
    }
    public static void displayPlayArea(Board boardObj, Player player_one, Player player_two, Score score)
    {
        displayPlayerDetails(player_one,player_two,score);
        // viewBoard();
        displaySpikes(boardObj);
    }

    public static void displaySpikes(Board obj)
    {
        int k = 0;
        for(int i = 0; i < 26; i++,k++)
        {
            if(i == 6 || i == 19)
            {
                System.out.print("BAR");
                k -= 1;
                System.out.println("");
                continue;
            }

            System.out.print(k + " ");

            // int totalNoCheckers = obj.getSpike(i).size();
            int totalNoCheckers = obj.getSpike(k).size();
            for(int j = 0; j < totalNoCheckers; j++)
            {
                //print the color
                // System.out.print(obj.getSpike(i).get(j).getColor() + " ");
                System.out.print(obj.getSpike(k).get(j).getColor() + " ");
            }
            System.out.println("");
        }

        //Display bar for now
        for(int i = 0; i < obj.arrayForBar.get(0).size();i++)
        {
            System.out.println("Bar RED: ");
            System.out.println(obj.arrayForBar.get(0).get(i).getColor());
        }
        for(int i = 0; i < obj.arrayForBar.get(1).size();i++)
        {
            System.out.println("Bar BLACK: ");
            System.out.println(obj.arrayForBar.get(1).get(i).getColor());
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