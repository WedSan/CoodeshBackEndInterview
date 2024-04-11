package wedsan;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromeCheckerTest {

    @Test
    public void testIsPalindrome() {
        PalindromeChecker checker = new PalindromeChecker();

        // Testing palindromes
        assertTrue(checker.isPalindrome("madam"));
        assertTrue(checker.isPalindrome("racecar"));
        assertTrue(checker.isPalindrome("level"));

        // Testing non-palindromes
        assertFalse(checker.isPalindrome("hello"));
        assertFalse(checker.isPalindrome("world"));
        assertFalse(checker.isPalindrome("java"));
    }

}