import java.util.*;

public class Presenter {

    private static void outine() {
        System.out.print("---");
    }

    private static void spikeOutline() {
        System.out.print("|");
    }

    private static void barOutline() {
        System.out.print("  BAR  ");
    }

    public static void viewBoard() {

        /* This is for the main board play area */
        System.out.print("12");
        for (int j = 0; j < 6; j++) {
            System.out.print("\t");
        }
        System.out.println("1    OFF");

        /* This is for the top of the board with spikes */
        for (int i = 1; i <= 12; i++) {
            if (i % 6 == 0 && i < 12) {
                spikeOutline();
                barOutline();
            } else {
                spikeOutline();
                if (i != 12)
                    outine();
            }

        }
        System.out.println("");
        for (int i = 1; i <= 10; i++) {
            /* For the partition between the two horizontal halfs */
            if (i == 5) {
                for (int x = 0; x < 12; x++) {
                    System.out.print("----");
                }
                System.out.println();
            } else {
                /* This is for the main board play area */
                System.out.print("(");
                for (int j = 0; j < 6; j++) {
                    System.out.print("\t");
                }
                System.out.println(")");
            }

        }

        /* This is for the bottom of the board with spikes */
        for (int i = 1; i <= 12; i++) {
            if (i % 6 == 0 && i < 12) {
                spikeOutline();
                barOutline();
            } else {
                spikeOutline();
                if (i != 12)
                    outine();
            }

        }
        System.out.println();
        /* This is for the main board play area */
        System.out.print("13");
        for (int j = 0; j < 6; j++) {
            System.out.print("\t");
        }
        System.out.println("24   OFF");
    }

    /*
     * To be modified
     */
    public static void viewSpike(Board boardObj, int spikePosition) {
        // System.out.println(boardObj.getSpike(spikePosition));
        // viewBoard();
    }

    private static void displayPlayerDetails(Player player_one, Player player_two) {
        System.out.println("Player 1 : " + player_one.getName());
        System.out.println("Player 2 : " + player_two.getName());
    }

    public static void displayCommandPrompt() {
        System.out.print("Please enter 'R/r' to roll the dice or 'Q/q' to Quit: ");
    }

    public static void displayPlayArea(Player player_one, Player player_two) {
        displayPlayerDetails(player_one, player_two);
        viewBoard();
    }

    public static void displaySpikes(Board obj) {
        // for(int i = 0; i < 26; i++)
        // {
        // System.out.print(i + " ");
        // if(i == 6 || i == 19)
        // {
        // System.out.print("BAR");
        // }
        // int totalNoCheckers = obj.getSpike(i).size();
        // for(int j = 0; j < totalNoCheckers; j++)
        // {
        // //print the color
        // System.out.print(obj.getSpike(i).get(j).getColor() + " ");
        // }
        // System.out.println("");
        // }

        int itemsPerColumn = 13;
        int total = 26;

        for (int i = 0; i < itemsPerColumn; i++) {
            int test = total - 1 - i;
            if (i < 10) {
                System.out.print(i + "   ");
            } else {
                System.out.print(i + "  ");
            }

            int totalNoCheckers1 = obj.getSpike(i).size();
            int totalNoCheckers2 = obj.getSpike(25 - i).size();
            int temp = 50 - (4 * totalNoCheckers1);
            // Print the items from the second column, if available
            if (totalNoCheckers1 > 0) {

                for (int j = 0; j < totalNoCheckers1; j++) {
                    // print the color
                    System.out.printf(obj.getSpike(i).get(j).getColor() + " ");
                }

            }
            // System.out.print(obj.getSpike(i).size());
            System.out.printf("%-" + temp + "s", "");

            if (25 - i < total) {

                if (totalNoCheckers2 > 0) {

                    // System.out.printf("%50s", " ");
                    for (int j = 0; j < totalNoCheckers2; j++) {
                        // print the color
                        System.out.printf(obj.getSpike(25 - i).get(j).getColor() + " ");
                    }

                }
                System.out.print(" " + test);

            }

            System.out.println();
        }
    }

    /* Not in use */
    public static void startGame(Player player_one, Player player_two) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter the first player name : ");
            player_one.setName(in.nextLine());
            System.out.print("Enter the second player name : ");
            player_two.setName(in.nextLine());
        }

    }
}