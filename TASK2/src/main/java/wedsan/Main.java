package wedsan;

import wedsan.Exception.MiddleElementNotFoundException;

import java.security.spec.RSAOtherPrimeInfo;

public class Main {
    public static void main(String[] args) {

        Node node1 = new Node("batman");
        Node node2 = new Node("joker");
        Node node3 = new Node("penguin");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.addElement(node1);
        doubleLinkedList.addElement(node2);
        doubleLinkedList.addElement(node3);
        System.out.println("-- List before remove the middle element");
        doubleLinkedList.printElements();

        try {
            doubleLinkedList.removeMiddleElement();
        } catch (MiddleElementNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("-- List after removing middle element --");
        doubleLinkedList.printElements();



    }

}