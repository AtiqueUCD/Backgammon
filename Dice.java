import java.util.Random;

public class Dice {

    static Random random = new Random();

    // public Dice() {
    //     random = new Random();
    // }

    public static int[] roll() {

        int[] diceValues = new int[2];
        diceValues[0] = random.nextInt(6) + 1; // Value of the first dice
        diceValues[1] = random.nextInt(6) + 1; // Value of the second dice

        return diceValues;

    }

}
