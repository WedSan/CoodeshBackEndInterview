package wedsan;

/**
 * This class represents a node in a double linked list.
 */
public class Node {

    private String dataValue;

    private Node prev;

    private Node Next;

    public Node() {
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    public Node (String dataValue){
        this.dataValue = dataValue;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return Next;
    }

    public void setNext(Node next) {
        Next = next;
    }
}
