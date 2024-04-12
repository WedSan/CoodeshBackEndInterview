package wedsan;

import java.util.ArrayList;
/*
*
*
* This class generates a random list of strings;
 */
public class ListRandom {

    public ListRandom() {
    }

    /**
     * Generates a list of random strings with a length of 2 characters each.
     * The list size will be a random number between 200 and 500.
     *
     * @return An ArrayList containing the randomly generated strings.
     */
    public ArrayList<String> createRandomStringList(){
        ArrayList<String> stringList = new ArrayList<String>();

        int randomNumberOfElements = (int) (Math.random() * (500 - 200 + 1)) + 200;

        for(int i = 0; i < randomNumberOfElements; i++){
            stringList.add(generateRandomString());
        }

        return stringList;
    }

    /**
     * Generates a random string of length 2 containing only lowercase letters (a-z).
     *
     * @return A random string of length 2.
     */
    private String generateRandomString(){

        String randomString = "";

        for(int i = 0; i <= 1; i++){
            char character = (char)  ('a' + Math.random() * ('z' - 'a' +1 ));
            randomString += character;
        }
        return randomString.toString();
    }
}
