package wedsan;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ListRandomText {

    @Test
    public void testCreateRandomStringList_ListSize() {
        ListRandom listRandom = new ListRandom();
        List<String> randomList = listRandom.createRandomStringList();

        // Test if the list size is between the expected range (200-500 elements)
        assertTrue(randomList.size() >= 200 && randomList.size() <= 500,
                "List size should be between 200 and 500 elements");
    }

    @Test
    public void testCreateRandomStringList_ListContent() {
        ListRandom listRandom = new ListRandom();
        List<String> randomList = listRandom.createRandomStringList();

        // Test if each element in the list has a length of 2 characters
        for (String element : randomList) {
            assertEquals(2, element.length(), "Each element should have a length of 2 characters");
        }

        // Test if each element only contains lowercase letters (a-z)
        for (String element : randomList) {
            assertTrue(element.matches("[a-z]+"), "Each element should only contain lowercase letters");
        }
    }
}
