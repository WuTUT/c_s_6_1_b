import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static OffByOne offByOne = new OffByOne();
    static OffByN offByN = new OffByN(2);
    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome(){
        assertFalse(palindrome.isPalindrome("car"));
        assertTrue(palindrome.isPalindrome("adda"));
        assertTrue(palindrome.isPalindrome("aba"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
    }

    @Test
    public void testIsPalindrome2(){
        assertTrue(palindrome.isPalindrome("abb",offByOne));
        assertTrue(palindrome.isPalindrome("aabb",offByOne));
        assertTrue(palindrome.isPalindrome("aacc",offByN));
    }
}
