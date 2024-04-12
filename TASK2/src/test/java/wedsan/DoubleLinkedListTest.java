import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wedsan.DoubleLinkedList;
import wedsan.Node;
import wedsan.Exception.MiddleElementNotFoundException;

public class DoubleLinkedListTest {

    private DoubleLinkedList doubleLinkedList;

    @BeforeEach
    public void setUp() {
        doubleLinkedList = new DoubleLinkedList();
    }

    @Test
    public void testAddElement() {
        Node node1 = new Node("batman");
        Node node2 = new Node("joker");
        doubleLinkedList.addElement(node1);
        doubleLinkedList.addElement(node2);
        Assertions.assertEquals(node1, doubleLinkedList.getFirstElement());
        Assertions.assertEquals(node2, doubleLinkedList.getLastElement());
        Assertions.assertEquals(2, doubleLinkedList.getSize());
    }



    // Add more tests for other methods as needed
}
