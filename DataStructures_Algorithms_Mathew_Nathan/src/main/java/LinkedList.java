
import org.w3c.dom.Node;

public class LinkedList<T extends Comparable> {
    Node head;

    class Node {
        T data;
        Node next;

        Node(T a) {
            data = a;
            next = null;
        }
    }

    public void insertLast(T data) {
        Node nodeInsert = new Node(data);

        //Check that list's head is not empty
        if (this.head == null) {
            this.head = nodeInsert;
            return;
        }

        //Otherwise find last node and get its pointer. Check all nodes from head
        Node lastNode = this.head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = nodeInsert;
    }

    //Return node at specified index. (Index starts from 0)
    public Node getNodeAtLocation(int index) {
        if (index < 0) {throw new IllegalArgumentException("Index cannot be negative");}

        //Traverse through the LinkedList
        Node lastNode = this.head;

        for (int i = 0; i < index; i++) {
            if (lastNode == null) {throw new IllegalArgumentException("Index out of bounds");}
            lastNode = lastNode.next;
        }

        return lastNode;
    }

    public void insertAtLocation(int index, T data) {
        if (index < 0) {throw new IllegalArgumentException("Index cannot be negative");}
        Node nodeInsert = new Node(data);

        //Traverse through the LinkedList
        Node lastNode = this.head;

        for (int i = 0; i < index - 1; i++) {
            if (lastNode == null) {throw new IllegalArgumentException("Index out of bounds");}
            lastNode = lastNode.next;
        }

        //Make new node head of the list if insertion is required at index 0
        if (index == 0) {
            nodeInsert.next = lastNode;
            this.head = nodeInsert;
        } else {
            nodeInsert.next = lastNode.next;
            lastNode.next = nodeInsert;
        }

    }

    public void removeAtLocation(int index) {
        if (index < 0) {throw new IllegalArgumentException("Index cannot be negative");}

        //Traverse through the LinkedList
        Node currentNode = this.head;

        //Find Node 1 position before the node to be removed
        for (int i = 0; i < index - 1; i++) {
            if (currentNode == null) {throw new IllegalArgumentException("Index out of bounds");}
            currentNode = currentNode.next;
        }

        Node tempNode = currentNode;
        //Save pointer of the node to be removed
        currentNode = currentNode.next;
        Node pointerNext = currentNode.next;
        //Set pointer of Node at index-1 to index+1
        tempNode.next = pointerNext;
    }

    public int size() {
        int counter = 0;

        if (this.head == null) {
            return counter;
        }

        Node lastNode = this.head;
        while (lastNode != null) {
            lastNode = lastNode.next;
            counter++;
        }

        return counter;
    }





}
