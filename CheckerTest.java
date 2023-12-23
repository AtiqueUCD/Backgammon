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
    void testGetPosition()
    {
        assertEquals(8, checker.getPosition());
    }

    @Test
    void testStatus()
    {
        assertEquals("IN", checker.getStatus());
    }

}
