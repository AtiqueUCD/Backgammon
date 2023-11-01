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
        System.out.println("1");

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
        System.out.println("24");
    }

    public static void viewSpike(Board boardObj, int spikePosition)
    {
        // System.out.println(boardObj.getSpike(spikePosition));
        viewBoard();
    }
}