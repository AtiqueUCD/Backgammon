import java.util.Random;

public class Dice {

    private Random random;

    public Dice() {
        random = new Random();
    }

    public int[] roll() {

        int[] diceValues = new int[2];
        diceValues[0] = random.nextInt(6) + 1; // Value of the first dice
        diceValues[1] = random.nextInt(6) + 1; // Value of the second dice

        return diceValues;

    }

}
