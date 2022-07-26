package challenge1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Challenge4Test{

    @Test
    public void evenTests() {
        assertEquals("es", Challenge4.getMiddle("test"));
        assertEquals("dd", Challenge4.getMiddle("middle"));
    }

    @Test
    public void oddTests() {
        assertEquals("t", Challenge4.getMiddle("testing"));
        assertEquals("A", Challenge4.getMiddle("A"));
    }

}