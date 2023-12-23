import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class CheckerTest {
    
    private Checker checker;
    @BeforeEach
    void setUp()
    {
        checker = new Checker(Checker.BLACK, 2, 3);
        checker.setPosition(3);
        checker.moveChecker(5);
        checker.setStatus("IN");
    }

    @Test
    @DisplayName("Checkes if color has been set")
    void testGetColor()
    {
        assertEquals(Checker.BLACK, checker.getColor());
    }

    @Test
    @DisplayName("Checks the position of checkers on the board is valid")
    void testGetPosition()
    {
        assertEquals(8, checker.getPosition());
    }

    @Test
    @DisplayName("Checks wether the checker is on the board")
    void testStatus()
    {
        assertEquals("IN", checker.getStatus());
    }

}
