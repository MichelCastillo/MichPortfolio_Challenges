package challenge1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

import junit.framework.TestCase;

public class Challenge1Test {

    @Test
    public void staticTests() {
        assertEquals("no one likes this", Challenge1.whoLikesIt());
        assertEquals("Peter likes this", Challenge1.whoLikesIt("Peter"));
        assertEquals("Jacob and Alex like this", Challenge1.whoLikesIt("Jacob", "Alex"));
        assertEquals("Max, John and Mark like this", Challenge1.whoLikesIt("Max", "John", "Mark"));
        assertEquals("Alex, Jacob and 2 others like this", Challenge1.whoLikesIt("Alex", "Jacob", "Mark", "Max"));
    }

}