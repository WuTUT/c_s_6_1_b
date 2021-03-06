import org.junit.Test;

import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertFalse(offByOne.equalChars('a', 'c'));
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('b', 'a'));
        assertFalse(offByOne.equalChars('a', 'a'));
        assertFalse(offByOne.equalChars('A', 'b'));
        assertTrue(offByOne.equalChars((char)31,(char)32));
        assertTrue(offByOne.equalChars('&','%'));
        assertTrue(offByOne.equalChars((char)0,(char)1));
        assertTrue(offByOne.equalChars('0','1'));
        assertTrue(offByOne.equalChars('1','0'));
    }
}
