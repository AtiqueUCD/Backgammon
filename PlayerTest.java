import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.*;

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
    void testName()
    {
        assertEquals("Sam Winchester", PlayerOne.getName());
        assertEquals("Dean Winchester", PlayerTwo.getName());
    }

    @Test
    void testNumCheckers()
    {
        assertEquals(100, PlayerOne.getNumCheckers());
        assertEquals(234, PlayerTwo.getNumCheckers());
    }

    @Test
    void testScore()
    {
        assertEquals(70, PlayerOne.getScore());
        assertEquals(69, PlayerTwo.getScore());
    }

    @Test
    void testTurnStatus()
    {
        assertEquals(true, PlayerOne.isTurn());
        assertEquals(false, PlayerTwo.isTurn());
    }

    @Test
    void testBlockedMove()
    {
        assertEquals(true,PlayerOne.getmoveBlocked());
        assertEquals(false,PlayerTwo.getmoveBlocked());
    }

    @Test
    void testTurnClass()
    {
        assertEquals(false,turn.getBlockedmove(PlayerOne, PlayerTwo));
        assertEquals(PlayerTwo,turn.getCurrentPlayer(PlayerOne, PlayerTwo));
        assertEquals(Checker.BLACK,turn.getCurrentPlayerColor());
    }

    @Test
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
