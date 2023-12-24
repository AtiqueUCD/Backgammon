import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


public class SpikeTest {
    
    private Spike spike;
    private Checker ctemp;
    @BeforeEach
    void setUp()
    {
        spike = new Spike();
        ctemp = new Checker(Checker.BLACK, 0, 0);
        spike.add(new Checker(Checker.RED, 2, 3));
        spike.add(new Checker(Checker.RED, 4, 5));
        spike.add(new Checker(Checker.RED, 5, 12));

    }

    @Test
    void testCount()
    {
        assertEquals(3,spike.size());
    }

    @Test
    void testAddChecker()
    {
        assertEquals(true,spike.addChecker(ctemp));
    }
}
