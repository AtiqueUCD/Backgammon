public class PlayerTest {

    public static void main(String[] args) {
        PlayerTest test = new PlayerTest();

        test.testInitialization();
        test.testName();
        test.testScore();
        test.testNumCheckers();
        test.testTurn();
    }

    public void testInitialization() {
        Player player = new Player("Alice");

        assert "Alice".equals(player.getName());
        assert player.getScore() == 0;
        assert player.getNumCheckers() == 15;
        assert !player.isTurn();

        System.out.println("Initialization test passed!");
    }

    public void testName() {
        Player player = new Player("Bob");
        assert "Bob".equals(player.getName());

        player.setName("Charlie");
        assert "Charlie".equals(player.getName());

        System.out.println("Name test passed!");
    }

    public void testScore() {
        Player player = new Player("David");

        player.increaseScore();
        assert player.getScore() == 1;

        player.increaseScore();
        assert player.getScore() == 2;

        player.decreaseScore();
        assert player.getScore() == 1;

        player.decreaseScore();
        assert player.getScore() == 0;

        player.decreaseScore();
        assert player.getScore() == 0;

        System.out.println("Score test passed!");
    }

    public void testNumCheckers() {
        Player player = new Player("Eve");

        player.increaseCheckers();
        assert player.getNumCheckers() == 16;

        player.decreaseCheckers();
        assert player.getNumCheckers() == 15;

        for (int i = 0; i < 15; i++) {
            player.decreaseCheckers();
        }
        assert player.getNumCheckers() == 0;

        player.decreaseCheckers();
        assert player.getNumCheckers() == 0;

        System.out.println("Number of checkers test passed!");
    }

    public void testTurn() {
        Player player = new Player("Frank");

        assert !player.isTurn(); // default value is false

        player.setTurn(true);
        assert player.isTurn();

        player.setTurn(false);
        assert !player.isTurn();

        System.out.println("Turn test passed!");
    }
}
