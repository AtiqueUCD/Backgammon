public class TestSpike {

    public static void main(String[] args) {
        Spike spike = new Spike(1);

        System.out.println("Initial Spike: " + spike);

        Checker redChecker1 = new Checker("RED", 1);
        Checker redChecker2 = new Checker("RED", 1);
        Checker blackChecker1 = new Checker("BLACK", 1);
        Checker blackChecker2 = new Checker("BLACK", 1);

        spike.addChecker(redChecker1);
        System.out.println("After adding first red checker: " + spike);

        spike.addChecker(blackChecker1);
        System.out.println("After adding first black checker: " + spike);

        spike.addChecker(redChecker2);
        System.out.println("After adding second red checker: " + spike);

        spike.addChecker(blackChecker2);
        System.out.println("After adding second black checker: " + spike);

        spike.deleteChecker(redChecker1);
        System.out.println("After deleting a red checker: " + spike);

        spike.deleteChecker(blackChecker1);
        System.out.println("After deleting a black checker: " + spike);
    }
}
