package challenge1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Challenge2Test{

    @Test
    public void Test() {
        assertEquals("Should return true", true, Challenge2.isValid(new char[] {'n','s','n','s','n','s','n','s','n','s'}));
        assertEquals("Should return false", false, Challenge2.isValid(new char[] {'w','e','w','e','w','e','w','e','w','e','w','e'}));
        assertEquals("Should return false", false, Challenge2.isValid(new char[] {'w'}));
        assertEquals("Should return false", false, Challenge2.isValid(new char[] {'n','n','n','s','n','s','n','s','n','s'}));
    }

}