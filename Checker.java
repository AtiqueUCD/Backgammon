
public class Checker {
    private String color; // Color of the checker
    private int position; // position on the game board
    private String status; // Status of the checker
    private int ID; // ID of the checkers

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m" + "\u25A0" + RESET;
    public static final String BLACK = "\u001B[30m" + "\u25A0" + RESET;
    

    public static final String ON = "ON_BOARD";
    public static final String OBar = "ON_BAR";
    public static final String OFF = "OFF_BOARD";

    private final static int TOTAL_SPIKES = 26; //24 checkers and 2 for bar

    public Checker(String color, int position, String status) {
        this.color = color;
        this.position = position;   
        this.status = status;
    }

    public Checker(String color, int position, int ID) {
        this.color = color;
        this.position = position;
        status = ON;
        this.ID = ID;
    }

    public int getID()
    {
        return ID;
    }
    
    public String getColor() {
        return (color);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void moveChecker(int steps)
    {
        int position = getPosition() + steps;
        if(position <= TOTAL_SPIKES)
        {
            setPosition(position);
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Checker [Color: " + color + ", Position: " + position + " status: " + status + "]";
    }

}
