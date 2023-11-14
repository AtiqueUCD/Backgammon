import java.util.ArrayList;

import javax.lang.model.type.NullType;

public class Board extends Spike{

    final static private int TOTAL_BAR_NUMBER = 2;
    final static private int TOTAL_NUMBER_OF_SPIKES = 24 + TOTAL_BAR_NUMBER;
    final static private int SPIKE_ONE = 0;
    final static private int SPIKE_SIX = 5;
    final static private int SPIKE_EIGHT = 8;//7;
    final static private int SPIKE_TWELVE = 12;//11;
    final static private int SPIKE_THRETEEN = 13;//12;
    final static private int SPIKE_SEVENTEEN = 17;//16;
    final static private int SPIKE_NINETEEN = 20;//18;
    final static private int SPIKE_TWENTY_FOUR = 25;//23;

    //add bar
    final static private int BAR_SIPKE_FIRST_HALF = 6;
    final static private int BAR_SIPKE_SECOND_HALF = 19;

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
