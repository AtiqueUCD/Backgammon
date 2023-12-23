// import java.util.Scanner;

// public class doublecube {
// private int currentValue = 1;

// public DoubleCube() {
// this.currentValue = 1;
// }

// public int getCurrentValue() {
// return currentValue;
// }

// public int offerCube() {
// Scanner scanner = new Scanner(System.in);
// System.out.println("The current cube value is: " + currentValue);
// System.out.print("Do you accept the cube? (yes/no): ");
// String response = scanner.nextLine().toLowerCase();

// if (response.equals("yes")) {
// currentValue *= 2;
// if (currentValue > 128) {
// System.out.println("Cube value reached the maximum of 128.");
// return currentValue / 2; // Return the previous value
// }
// } else if (response.equals("no")) {
// System.out.println("You rejected the cube.");
// return 0; // Player rejected the cube
// } else {
// System.out.println("Invalid response. Please enter 'yes' or 'no'.");
// }

// return offerCube(); // Recursive call until a valid response is received
// }

// public int doublecuberesult() {
// int result = offerCube();
// if (result > 0) {
// System.out.println("Cube accepted. New value: " + result);
// } else {
// System.out.println("Game continues without doubling the cube.");
// }

// return result;

// }

// // public static void main(String[] args) {
// // doublecube doubleCube = new doublecube();
// // int result = doubleCube.doublecuberesult();
// // System.out.println(result);

// // }

// }
