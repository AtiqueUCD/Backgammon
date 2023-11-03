import java.util.ArrayList;

public class Board extends Spike{

    final static private int TOTAL_NUMBER_OF_SPIKES = 24;
    final static private int SPIKE_ONE = 0;
    final static private int SPIKE_SIX = 5;
    final static private int SPIKE_EIGHT = 7;
    final static private int SPIKE_TWELVE = 11;
    final static private int SPIKE_THRETEEN = 12;
    final static private int SPIKE_SEVENTEEN = 16;
    final static private int SPIKE_NINETEEN = 18;
    final static private int SPIKE_TWENTY_FOUR = 23;

    ArrayList<Spike> spikes = new ArrayList<>();
    int tempIndex = 0;
    String color = Checker.BLACK;

    /*
     * 2-D array of spikes
     */
    ArrayList<Spike[]> arrayOfSpikes = new ArrayList<>();
    
    private void initializeSpikes()
    {
        int index = 0;

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
                    tempIndex = 0;
                break;
            }
            /*
             * Add checkers to the spike array
             */
            for(int checkers = 0; checkers < tempIndex; checkers++)
            {
                spikes.add((new Spike()));
                spikes.get(index).addChecker(new Checker(color, spike));
                index++;
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
