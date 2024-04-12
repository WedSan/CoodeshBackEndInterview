package wedsan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

    @Test
    public void testRemoveMiddleElement() throws MiddleElementNotFoundException {
        Node node1 = new Node("batman");
        Node node2 = new Node("joker");
        Node node3 = new Node("penguin");
        doubleLinkedList.addElement(node1);
        doubleLinkedList.addElement(node2);
        doubleLinkedList.addElement(node3);
        doubleLinkedList.removeMiddleElement();
        Assertions.assertEquals(node1, doubleLinkedList.getFirstElement());
        Assertions.assertEquals(node3, doubleLinkedList.getLastElement());
        Assertions.assertEquals(2, doubleLinkedList.getSize());
    }



    // Add more tests for other methods as needed
}
