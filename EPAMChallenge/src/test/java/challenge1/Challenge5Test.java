package challenge1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Challenge5Test {

    @Test
    public void convertBinaryArrayToInt() throws Exception {

        assertEquals(1, Challenge5.ConvertBinaryArrayToInt(new ArrayList<>(Arrays.asList(0,0,0,1))));
        assertEquals(15, Challenge5.ConvertBinaryArrayToInt(new ArrayList<>(Arrays.asList(1,1,1,1))));
        assertEquals(6, Challenge5.ConvertBinaryArrayToInt(new ArrayList<>(Arrays.asList(0,1,1,0))));
        assertEquals(9, Challenge5.ConvertBinaryArrayToInt(new ArrayList<>(Arrays.asList(1,0,0,1))));


    }

}