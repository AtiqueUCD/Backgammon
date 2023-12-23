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

    private static void displayPlayerDetails(Player player_one, Player player_two, Score scoreObj) {
        System.out.println("Player 1 : " + player_one.getName() + " Score: " + scoreObj.getScore(player_one));
        System.out.println("Player 2 : " + player_two.getName() + " Score: " + scoreObj.getScore(player_two));
        // System.out.println("Player 2 : " + player_two.getName());
        // System.out.println("Score Player 1 : " + scoreObj.getScore(player_one)+",
        // Score Player 2 : " + scoreObj.getScore(player_two));
    }

    public static void displayCommandPrompt() {
        System.out.print("Please enter command (\"HINT\" for command pallet): ");
    }

    public static void displayPlayArea(Board boardObj, Player player_one, Player player_two, Score score) {
        displayPlayerDetails(player_one, player_two, score);
        // viewBoard();
        displaySpikes(boardObj);
    }

    public static void _displaySpikes(Board obj) {
        int k = 0;
        for (int i = 0; i < 26; i++, k++) {
            if (i == 6 || i == 19) {
                System.out.print("BAR");
                k -= 1;
                System.out.println("");
                continue;
            }

            System.out.print(k + " ");

            // int totalNoCheckers = obj.getSpike(i).size();
            int totalNoCheckers = obj.getSpike(k).size();
            for (int j = 0; j < totalNoCheckers; j++) {
                // print the color
                // System.out.print(obj.getSpike(i).get(j).getColor() + " ");
                System.out.print(obj.getSpike(k).get(j).getColor() + " ");
            }
            System.out.println("");
        }

        // Display bar for now
        for (int i = 0; i < obj.arrayForBar.get(0).size(); i++) {
            System.out.println("Bar RED: ");
            System.out.println(obj.arrayForBar.get(0).get(i).getColor());
        }
        for (int i = 0; i < obj.arrayForBar.get(1).size(); i++) {
            System.out.println("Bar BLACK: ");
            System.out.println(obj.arrayForBar.get(1).get(i).getColor());
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

    
     public static void displaySpikes(Board obj) {
        for (int i = 0; i < 12; i++) {
            int totalNoCheckers1 = obj.getSpike(i).size();
            int totalNoCheckers2 = obj.getSpike(23 - i).size();

            ArrayList<String> temp1 = new ArrayList<String>(); // Create a new ArrayList for each iteration
            ArrayList<String> temp2 = new ArrayList<String>(); // Create a new ArrayList for each iteration

            if (totalNoCheckers1 > 0) {
                for (int j = 0; j < totalNoCheckers1; j++) {
                    // print the color
                    temp1.add(obj.getSpike(i).get(j).getColor() + "");
                }
            }

            if (totalNoCheckers2 > 0) {
                for (int j = 0; j < totalNoCheckers2; j++) { // Use totalNoCheckers2 here
                    // print the color
                    temp2.add(obj.getSpike(23 - i).get(j).getColor() + "");
                }
            }

            // Print ArrayList from the first column (index 1 to 13)
            System.out.printf("%-2s: %-40s | %40s :%2s %n",
                    (i), arrayListToString(temp1),
                    arrayListToString(temp2), (23 - i)); // Print from 26 to 14 in the second column
            

        }

        // Display bar for now
        for (int i = 0; i < obj.arrayForBar.get(0).size(); i++) {
            System.out.println("Bar RED: ");
            System.out.println(obj.arrayForBar.get(0).get(i).getColor());
        }
        for (int i = 0; i < obj.arrayForBar.get(1).size(); i++) {
            System.out.println("Bar BLACK: ");
            System.out.println(obj.arrayForBar.get(1).get(i).getColor());
        }
    }

    private static String arrayListToString(ArrayList<String> list) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            result.append(list.get(i).toString());
            if (i < list.size() - 1) {
                result.append(" ");
            }
        }
        result.append("");

        // Add ANSI escape codes for color formatting
        result.insert(0, "\u001B[30m"); // Black color
        result.append("\u001B[0m"); // Reset color

        int visibleLength = getVisibleLength(result.toString());

        // Add spaces to make the total visible length 60 characters
        int spacesToAdd = Math.max(0, 40 - visibleLength);
        for (int i = 0; i < spacesToAdd; i++) {
            result.append(" ");
        }
        return result.toString();
    }

    private static int getVisibleLength(String str) {
        boolean inEscapeCode = false;
        int length = 0;

        for (char ch : str.toCharArray()) {
            if (ch == '\u001B') {
                inEscapeCode = true;
            } else if (inEscapeCode && ch == 'm') {
                inEscapeCode = false;
            } else if (!inEscapeCode) {
                length++;
            }
        }

        return length;
    }

}