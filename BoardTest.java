import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class BoardTest {
    private Board board;

    @BeforeEach
    void setUp()
    {
        board = new Board();
        board.initializeBoard();
    }

    @Test
    @DisplayName("Validates the total number of spikes on the board")
    void testNoOfSpike()
    {
        assertEquals(24,board.getTotalNoOfSpikes());
    }

    @Test
    @DisplayName("Validates the total number of checkers on the board")
    void testNoOfCheckers()
    {
        assertEquals(15,board.getCheckerCount(Checker.RED));
    }

    @Test
    @DisplayName("Checks if the board is empty or not")
    void testEmptyBoard()
    {
        assertEquals(true,board.areCheckersOnBoard(Checker.RED));
    }
}
