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

    @Test
    public void testThrowException(){
        DoubleLinkedList evenList = new DoubleLinkedList();

        Node node1 = new Node("batman");
        Node node2 = new Node("joker");

        evenList.addElement(node1);
        evenList.addElement(node2);
        Assertions.assertThrows(MiddleElementNotFoundException.class, ()-> evenList.removeMiddleElement());
    }

    @Test
    public void testFindElement() {
        Node node1 = new Node("batman");
        Node node2 = new Node("joker");
        Node node3 = new Node("penguin");
        doubleLinkedList.addElement(node1);
        doubleLinkedList.addElement(node2);
        doubleLinkedList.addElement(node3);

        Node foundNode = doubleLinkedList.findElement(2);
        Assertions.assertEquals("penguin", foundNode.getDataValue());

        foundNode = doubleLinkedList.findElement(1);
        Assertions.assertEquals("joker", foundNode.getDataValue());


        foundNode = doubleLinkedList.findElement(0);
        Assertions.assertEquals("batman", foundNode.getDataValue());
    }

    @Test
    public void testRemoveElement() {
        Node node1 = new Node("batman");
        Node node2 = new Node("joker");
        Node node3 = new Node("penguin");
        doubleLinkedList.addElement(node1);
        doubleLinkedList.addElement(node2);
        doubleLinkedList.addElement(node3);

        doubleLinkedList.removeElement(2);
        Assertions.assertNull(doubleLinkedList.getLastElement());
        Assertions.assertEquals(2, doubleLinkedList.getSize());

        doubleLinkedList.removeElement(0);
        Assertions.assertNull(doubleLinkedList.getFirstElement());
        Assertions.assertEquals(1, doubleLinkedList.getSize());

        doubleLinkedList.removeElement(0);
        Assertions.assertNull(doubleLinkedList.getFirstElement());
        Assertions.assertNull(doubleLinkedList.getLastElement());
        Assertions.assertEquals(0, doubleLinkedList.getSize());
    }
}
