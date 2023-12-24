import java.util.ArrayList;

public class Board extends Spike{

    final static private int TOTAL_BAR_NUMBER = 2;
    final static private int TOTAL_NUMBER_OF_SPIKES = 24;// + TOTAL_BAR_NUMBER;
    final static private int SPIKE_ONE = 0;
    final static private int SPIKE_SIX = 5;
    final static private int SPIKE_EIGHT = 7;
    final static private int SPIKE_TWELVE = 11;
    final static private int SPIKE_THRETEEN = 12;
    final static private int SPIKE_SEVENTEEN = 16;
    final static private int SPIKE_NINETEEN = 18;
    final static private int SPIKE_TWENTY_FOUR = 23;

    //add bar
    final static public int BAR_SIPKE_FIRST_HALF = 6;
    final static public int BAR_SIPKE_SECOND_HALF = 19;

    ArrayList<Spike> spikes = new ArrayList<>();
    int tempIndex = 0;
    String color = Checker.BLACK;

    /*
     * 2-D array of spikes
     */
    ArrayList<Spike[]> arrayOfSpikes = new ArrayList<>();
    
    //Single array for the checkers
    ArrayList<Spike> arrayForBar = new ArrayList<>();
    
    private void initializeSpikes()
    {
        int index = -1;
        int ID = 0;

        for(int spike = 0; spike < TOTAL_NUMBER_OF_SPIKES; spike++)
        {
            switch(spike)
            {
                case SPIKE_ONE:
                    /*Add two checkers */
                    tempIndex = 2;
                    color = Checker.RED;
                    index++;
                break;

                case SPIKE_TWENTY_FOUR:
                    /*Add two checkers */
                    tempIndex = 2;
                    color = Checker.BLACK;
                    index++;
                break;

                case SPIKE_SIX:
                    /*Add five checkers */
                    tempIndex = 5;
                    color = Checker.BLACK;
                    index++;
                break;

                case SPIKE_THRETEEN:
                    /*Add five checkers */
                    tempIndex = 5;
                    color = Checker.RED;
                    index++;
                break;
                
                case SPIKE_TWELVE:
                    /*Add five checkers */
                    tempIndex = 5;
                    color = Checker.BLACK;
                    index++;
                break;

                case SPIKE_NINETEEN:
                    /*Add five checkers */
                    tempIndex = 5;
                    color = Checker.RED;
                    index++;
                break;

                case SPIKE_EIGHT:
                    /*Add three checkers */
                    tempIndex = 3;
                    color = Checker.RED;
                    index++;
                break;

                case SPIKE_SEVENTEEN:
                    /*Add three checkers */
                    tempIndex = 3;
                    color = Checker.BLACK;
                    index++;
                break;

                // case BAR_SIPKE_FIRST_HALF:
                // case BAR_SIPKE_SECOND_HALF:
                //     System.out.println("Adding bar!");
                //     break;
                default:
                    tempIndex = 0;
                break;
            }
            /*
             * Add checkers to the spike array
             */            
            spikes.add(spike,new Spike());
            //System.out.print("Spike no: " + spike + " ");//debug

            for(int checkers = 0; checkers < tempIndex; checkers++,ID++)
            {
                spikes.get(spike).addChecker(new Checker(color, spike, ID));
                //System.out.print("A ");//debug
            }
            //Debug
            //System.out.println("No of checkers in current spike: "+ spikes.get(index).size());

            
        }
        //Debug
        // System.out.println("Total number of spikes:" + spikes.size());
        // System.out.println("No of checkers in 1st spike: "+ spikes.get(0).size());
        // System.out.println("No of checkers in 1st spike: "+ spikes.get(1).size());
        // System.out.println("No of checkers in 1st spike: "+ spikes.get(2).size());

        //Initialize the bar
        arrayForBar.add(0,new Spike());//For player one
        arrayForBar.add(1,new Spike());//For player two
    }

    public void initializeBoard()
    {
        spikes.clear();
        initializeSpikes();
    }

    public int getTotalNoOfSpikes()
    {
        return TOTAL_NUMBER_OF_SPIKES;
    }

    public Spike getSpike(int spikePosition)
    {
        return spikes.get(spikePosition);
    }

    public void addCheckersToSpike(Checker checker, int position)
    {
        spikes.get(position).add(spikes.get(position).size(), checker);
    }

    public int getnoCheckersFromCurrentBar(boolean turnObj)
    {
        int size = 0;
        if(turnObj)
        {
            //Red checkers bar
            size = arrayForBar.get(1).size();
        }
        else{
            //Black checkers bar
            size = arrayForBar.get(0).size();
        }

        return size;
    }

    /*
     * killed black checkers go to bar[0]
     * killed red checkers go to bar[1]
     */
    public void addCheckToBar(Checker checker, boolean turnObj)
    {
        if(turnObj)
        {
            arrayForBar.get(0).add(checker);
        }
        else{
            arrayForBar.get(1).add(checker);
        }
    }

    /*
     * Black checkers will be retrived from bar[0]
     * Red checkers will be retrived from bar[1]
     */
    public Checker removeCheckerFromBar(boolean turnObj)
    {
        Checker tempChecker;
        if(turnObj)
        {
            tempChecker = arrayForBar.get(1).remove(arrayForBar.get(1).size()-1);
        }
        else{
            tempChecker = arrayForBar.get(0).remove(arrayForBar.get(0).size()-1);
        }

        return tempChecker;
    }

    /*
     * Gets the total checker count of a perticular color on the board
     */
    public int getCheckerCount(String color)
    {
        int spike = 0;
        int count = 0;

        for(spike = 0; spike < 24; spike++)
        {
            Spike tempSpike = getSpike(spike);
            if(tempSpike.isEmpty())
            {
                continue;
            }
            boolean compare = color.equals(tempSpike.getCheckers(tempSpike.size()-1).getColor());
            if(compare == true)
            {
                count += tempSpike.size();
            }
        }
        return count;
    }

    /*
     * Returns true is there are checkers on the board, else returns false
     */
    public boolean areCheckersOnBoard(String color)
    {
        if(getCheckerCount(color) > 0)
        {
            return true;
        }

        return false;
    }
}
