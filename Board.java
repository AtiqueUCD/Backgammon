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
        int index = -1;
        int ID = 0;

        for(int spike = 0; spike < TOTAL_NUMBER_OF_SPIKES; spike++)
        {
            switch(spike)
            {
                case SPIKE_ONE:
                    /*Add two checkers */
                    tempIndex = 2;
                    index++;
                break;

                case SPIKE_TWENTY_FOUR:
                    /*Add two checkers */
                    tempIndex = 2;
                    color = Checker.RED;//RED
                    index++;
                break;

                case SPIKE_SIX:
                case SPIKE_THRETEEN:
                    /*Add five checkers */
                    tempIndex = 5;
                    index++;
                break;
                
                case SPIKE_TWELVE:
                case SPIKE_NINETEEN:
                    /*Add five checkers */
                    tempIndex = 5;
                    color = Checker.RED;
                    index++;
                break;

                case SPIKE_EIGHT:
                    /*Add three checkers */
                    tempIndex = 3;
                    index++;
                break;

                case SPIKE_SEVENTEEN:
                    /*Add three checkers */
                    tempIndex = 3;
                    color = Checker.RED;
                    index++;
                break;

                default:
                    tempIndex = 0;
                break;
            }
            /*
             * Add checkers to the spike array
             */
            if(tempIndex > 0)
            {
                System.out.println("New checkers no: " + tempIndex);
                spikes.add(index,new Spike());
            }
            
            for(int checkers = 0; checkers < tempIndex; checkers++,ID++)
            {
                System.out.println("index: "+ index);//debug
                spikes.get(index).addChecker(new Checker(color, spike, ID));
            }
            System.out.println("No of checkers in current spike: "+ spikes.get(index).size());
            //Debug
            // if(tempIndex > 0)
            //     System.out.println(Integer.toString(index) + spikes.get(index).getID());
            
        }
        System.out.println("Total number of spikes:" + spikes.size());
        System.out.println("No of checkers in 1st spike: "+ spikes.get(0).size());
        System.out.println("No of checkers in 1st spike: "+ spikes.get(1).size());
        System.out.println("No of checkers in 1st spike: "+ spikes.get(2).size());
    }

    public void initializeBoard()
    {
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
}
