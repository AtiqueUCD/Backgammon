import java.util.Random;

public class Dice {

    private Random random;

    public void roll() {
        random = new Random();
        // Rolling two dice and returning the values of each dice
        int[] diceValues = new int[2];
        diceValues[0] = random.nextInt(6) + 1; // Value of the first dice
        diceValues[1] = random.nextInt(6) + 1; // Value of the second dice

        // return diceValues;
        System.out.println(diceValues[0]);
        System.out.println(diceValues[1]);
    }

}
