import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class ScoreTest {
    
    private Score score;
    private Player playerOne;

    @BeforeEach
    void setUp()
    {
        score = new Score();
        playerOne = new Player("Ender");
        score.setMatchength(11);
        score.setScore(playerOne);
        score.setTurnInprogress();
    }

    @Test
    @DisplayName("Validates the match length set")
    void testMatchLength()
    {
        assertEquals(11, score.getMatchLength());
    }

    @Test
    @DisplayName("Checks if after the match over, score is being assigned to the winner")
    void testScore()
    {
        assertEquals(1,score.getScore(playerOne));
    }

    @Test
    @DisplayName("Checks the current player turn status")
    void testCurrentTurnStatus()
    {
        assertEquals(true,score.getTurnStatus());
    }
}
