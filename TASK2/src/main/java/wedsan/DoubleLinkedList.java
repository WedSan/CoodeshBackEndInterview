package wedsan;

import wedsan.Exception.MiddleElementNotFoundException;

/**
 * This class represents a double linked list data structure.
 */
public class DoubleLinkedList {
    private Node firstElement;

    private Node lastElement;

    private int size;

    public DoubleLinkedList() {
        this.firstElement = null;
        this.lastElement = null;
        size = 0;
    }

    /**
     * Adds a new node to the linked list.
     *
     * @param newNode The node to be added to the list.
     */
    public void addElement(Node newNode){

        if(firstElement == null){
            firstElement = newNode;
            lastElement = newNode;
        }
        else{
            lastElement.setNext(newNode);
            newNode.setPrev(lastElement);
            lastElement = newNode;
        }

        size++;
    }

    /**
     * Removes the middle element from the linked list.
     *
     * @throws MiddleElementNotFoundException If the list is empty or not odd, indicating no middle element.
     */
    public void removeMiddleElement() throws MiddleElementNotFoundException{
        if(firstElement == null){
            throw new MiddleElementNotFoundException("The list is empty");
        }
        if(size%2 == 0){
            throw new MiddleElementNotFoundException("The list is not odd");
        }

        int middleElementIndex = (size+1)/2;

        Node currentElement = firstElement;

        for(int i = 0; i <= middleElementIndex -2; i++){
            currentElement = currentElement.getNext();
        }

        currentElement.getPrev().setNext(currentElement.getNext());
        currentElement.getNext().setPrev(currentElement.getPrev());

        size--;
    }

    /**
     * Removes the element at the specified index from the linked list.
     *
     * @param index The index of the element to be removed.
     */
    public void removeElement(int index){

        if(index == 0){
            firstElement = null;
            return;
        }
        if(index == size -1){
            lastElement = null;
        }

        Node element = findElement(index);

        element.getPrev().setNext(element.getNext());
        element.getNext().setPrev(element.getPrev());

    }

    /**
     * Finds and returns the node at the specified index in the linked list.
     *
     * @param index The index of the node to be found.
     * @return The node at the specified index.
     * @throws IndexOutOfBoundsException If the index is out of bounds or the list is empty.
     */
    public Node findElement(int index){
        if(firstElement == null){
            throw new IndexOutOfBoundsException("The list is empty");
        }
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node currentElement = firstElement;

        for(int i = 0; i <= index; i++){
            currentElement = currentElement.getNext();
        }

        return currentElement;
    }

    /**
     * Method to print the elements of the linked list.
     * @throws IndexOutOfBoundsException if the list is empty.
     */
    public void printElements(){
        if (firstElement == null){
            throw new IndexOutOfBoundsException("The list is empty");
        }

        Node currentElement = firstElement;

        for(int i = 0; i <= size -1; i++){
           System.out.println(currentElement.getDataValue());
           if(currentElement.getNext() != null){
               currentElement = currentElement.getNext();
           }
        }
    }

    public Node getFirstElement() {
        return firstElement;
    }

    public Node getLastElement() {
        return lastElement;
    }

    public int getSize() {
        return size;
    }

}
