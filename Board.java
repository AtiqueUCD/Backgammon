import java.util.ArrayList;

public class Board extends Spike{

    final static private int TOTAL_NUMBER_OF_SPIKES = 24;
    final static private int SPIKE_ONE = 1;
    final static private int SPIKE_SIX = 6;
    final static private int SPIKE_EIGHT = 8;
    final static private int SPIKE_TWELVE = 12;
    final static private int SPIKE_THRETEEN = 13;
    final static private int SPIKE_SEVENTEEN = 17;
    final static private int SPIKE_NINETEEN = 19;
    final static private int SPIKE_TWENTY_FOUR = 24;

    Spike[] spikes = new Spike[TOTAL_NUMBER_OF_SPIKES];
    int tempIndex = 0;
    // boolean color = false;
    String color = Checker.BLACK;

    /*
     * 2-D array of spikes
     */
    // ArrayList<ArrayList<Spike>> arrayOfSpikes = new ArrayList<>();
    ArrayList<Spike[]> arrayOfSpikes = new ArrayList<>();
    
    private void initializeSpikes()
    {
        // Spike[] spikes = new Spike[TOTAL_NUMBER_OF_SPIKES];
        // int tempIndex = 0;
        // boolean color = false;

        for(int spike = 0; spike < TOTAL_NUMBER_OF_SPIKES; spike++)
        {
            switch(spike)
            {
                case SPIKE_ONE:
                    /*Add two checkers */
                    tempIndex = 2;
                break;

                case SPIKE_TWENTY_FOUR:
                    /*Add two checkers */
                    tempIndex = 2;
                    color = Checker.RED;//RED
                break;

                case SPIKE_SIX:
                case SPIKE_THRETEEN:
                    /*Add five checkers */
                    tempIndex = 5;
                break;
                
                case SPIKE_TWELVE:
                case SPIKE_NINETEEN:
                    /*Add five checkers */
                    tempIndex = 5;
                    color = Checker.RED;;
                break;

                case SPIKE_EIGHT:
                    /*Add three checkers */
                    tempIndex = 3;
                break;

                case SPIKE_SEVENTEEN:
                    /*Add three checkers */
                    tempIndex = 3;
                    color = Checker.RED;
                break;

                default:
                break;
            }
            /*
             * Add checkers to the spike array
             */
            for(int checkers = 0; checkers < tempIndex; checkers++)
            {
                // spikes[spike].insertChecker(new Checker(color, spike));
                // arrayOfSpikes.add(spikes);
            }
            
        }
    }

    public void initializeBoard()
    {
        initializeSpikes();
    }

    public int getTotalNoOfSpikes()
    {
        return TOTAL_NUMBER_OF_SPIKES;
    }

    public Spike[] getSpike(int spikePosition)
    {
        return arrayOfSpikes.get(spikePosition);
    }
}
