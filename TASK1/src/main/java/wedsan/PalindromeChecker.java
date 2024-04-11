package wedsan;

public class PalindromeChecker {

    public PalindromeChecker() {
    }

    /**
     * Checks if given string is a palindrome.
     *
     * @param stringToCheck The input to be checked.
     * @return True if the value is a palindrome, false otherwise.
     */
    public boolean isPalindrome(String stringToCheck) {
        stringToCheck = stringToCheck.toLowerCase();

        String stringReversed = reverseString(stringToCheck);

        if(stringReversed.equals(stringToCheck)){
            return true;
        }

        return false;
    }

    /**
     * This method reverses a given input string.
     *
     * @param inputString The string to be reversed.
     * @return The reversed string.
     */
    private String reverseString(String inputString) {
        char[] characters = inputString.toCharArray();

        String reversedString = "";
        for(int i= characters.length -1; i>=0; i--){
            reversedString += characters[i];
        }

        return reversedString;
    }
}