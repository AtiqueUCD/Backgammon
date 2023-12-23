import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class PlayerTest {
    
    private Player player;

    @BeforeEach
    void setUp()
    {
        player = new Player("Sam Winchester");
        player.setNumCheckers(100);
        player.setScore(69);
        player.setTurn(true);
        player.setMoveBlock();
        player.increaseScore();
    }

    @Test
    void testName()
    {
        assertEquals("Sam Winchester", player.getName());
    }

    @Test
    void testNumCheckers()
    {
        assertEquals(100, player.getNumCheckers());
    }

    @Test
    void testScore()
    {
        assertEquals(70, player.getScore());
    }

    @Test
    void testTurnStatus()
    {
        assertEquals(true, player.isTurn());
    }

    @Test
    void testBlockedMove()
    {
        assertEquals(true,player.getmoveBlocked());
    }
}
