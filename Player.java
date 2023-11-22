public class Player {
    private String name;
    private int score;
    private int numCheckers;
    private boolean turn;

    public Player(String name){
        this.name=name;
        this.score=0;
        this.numCheckers = 15; // default value
        // this.turn=false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumCheckers() {
        return numCheckers;
    }

    public void setNumCheckers(int numCheckers) {
        this.numCheckers = numCheckers;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public void increaseScore(){
        this.score++;
    }
    public void decreaseScore(){
        if(this.score>0){
            this.score--;
        }
    }

    public void increaseCheckers(){
        this.numCheckers++;
    }
    public void decreaseCheckers(){
        if(numCheckers>0){
            this.numCheckers--;
        }
    }

    @Override
    public String toString(){
        return "Player [Name: "+getName()+", Score: "+getScore()+", Number of Checkers: "+getNumCheckers()+", Turn: "+turn+ "]";
    }






}
