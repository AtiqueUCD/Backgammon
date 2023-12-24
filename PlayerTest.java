import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;

public class PlayerTest {
    
    private static Player PlayerOne;
    private static Player PlayerTwo;
    private static Turn turn;
    private static Board board;

    @BeforeEach
    void setUp()
    {
        PlayerOne = new Player("Sam Winchester");
        PlayerTwo = new Player("Dean Winchester");
        turn = new Turn();
        board = new Board();

        board.initializeBoard();



        PlayerOne.setNumCheckers(100);
        PlayerOne.setScore(69);
        PlayerOne.setTurn(true);
        PlayerOne.setMoveBlock();
        PlayerOne.increaseScore();

        PlayerTwo.setNumCheckers(234);
        PlayerTwo.setScore(70);
        PlayerTwo.setTurn(false);
        PlayerTwo.resetMoveBlock();
        PlayerTwo.decreaseScore();
    }

    @Test
    @DisplayName("Test the name has been assigned to the players.")
    void testName()
    {
        assertEquals("Sam Winchester", PlayerOne.getName());
        assertEquals("Dean Winchester", PlayerTwo.getName());
    }

    @Test
    @DisplayName("Counts the checkers alloted to each player")
    void testNumCheckers()
    {
        assertEquals(100, PlayerOne.getNumCheckers());
        assertEquals(234, PlayerTwo.getNumCheckers());
    }

    @Test
    @DisplayName("Reads the scores of each player")
    void testScore()
    {
        assertEquals(70, PlayerOne.getScore());
        assertEquals(69, PlayerTwo.getScore());
    }

    @Test
    @DisplayName("Checks that both player should not have turn at the same time")
    void testTurnStatus()
    {
        assertEquals(true, PlayerOne.isTurn());
        assertEquals(false, PlayerTwo.isTurn());
    }

    @Test
    @DisplayName("This is a status bit which indicates wether the checker is killed.")
    void testBlockedMove()
    {
        assertEquals(true,PlayerOne.getmoveBlocked());
        assertEquals(false,PlayerTwo.getmoveBlocked());
    }

    @Test
    @DisplayName("Properties of the player currently in play")
    void testTurnClass()
    {
        assertEquals(false,turn.getBlockedmove(PlayerOne, PlayerTwo));
        assertEquals(PlayerTwo,turn.getCurrentPlayer(PlayerOne, PlayerTwo));
        assertEquals(Checker.BLACK,turn.getCurrentPlayerColor());
    }

    @Test
    @DisplayName("Tests the possible valid moves in the checker is on the bar")
    static void testOffBar()
    {
        ArrayList<int[]> temp = new ArrayList<>();
        ArrayList<int[]> checkTemp = new ArrayList<>();
        checkTemp.add(new int[]{6,2});
        checkTemp.add(new int[]{6,3});
        Command.gettingOfBarPrediction(2,3,PlayerOne,PlayerTwo,turn,board);
        temp = Command.getMoveList();
        assertArrayEquals(checkTemp.get(0), temp.get(0));
    }
}
