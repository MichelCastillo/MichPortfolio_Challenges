package challenge1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;


public class Challenge6Test{

    @Test
    public void exampleTest() {
        assertEquals("odd", Challenge6.oddOrEven(new int[] {2, 5, 34, 6}));
        assertEquals("even", Challenge6.oddOrEven(new int[] {0}));
    }

}