import java.util.ArrayList;

public class Spike extends ArrayList<Checker>{
    private int position;

    // public Spike(String color, int position){
    //     super();
    //     this.position = position;
    // }

    public int getPosition(){
        return position;
    }

    public int nbColoredChecker(String color){
        int nbColored = 0;
        for(int i=0; i<this.size(); i++){
            if(this.get(i).getColor().equals(color)){
                nbColored++;
            }
        }
        return nbColored;
    }

    public boolean addChecker(Checker checker){
        boolean isAdded = false;
        String OppositeColor = "RESET";
        if(checker.getColor().equals("RED")){
            OppositeColor = "BLACK";
        }
        else if(checker.getColor().equals("BLACK")){
            OppositeColor = "RED";
        }

        if(nbColoredChecker(OppositeColor)<2){
            this.add(checker);
            isAdded=true;
        }else{
            System.out.println("The move is invalid");
        }
        return isAdded;
    }

    public boolean deleteChecker(Checker checker){
        boolean isDeleted=false;
        if(!this.isEmpty()){
            if(nbColoredChecker(checker.getColor())>0){
                int index =0;
                for(int i=0; i<this.size(); i++){
                    if(this.get(i).getColor().equals(checker.getColor())){
                        index = i;
                    }
                }
                this.remove(index);
                isDeleted=true;
            }
        }
        return isDeleted;
    }

    public Checker getCheckers(int position)
    {
        return this.get(position);
    }



}
