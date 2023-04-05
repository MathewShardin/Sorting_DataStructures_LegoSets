
import org.w3c.dom.Node;

import java.util.Collections;

public class LinkedList<T extends Comparable> implements Swappable {
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

    @Override
    public void swap(int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        Node prevNode1 = null;
        Node currNode1 = head;
        int count1 = 0;
        while (currNode1 != null && count1 != index1) {
            prevNode1 = currNode1;
            currNode1 = currNode1.next;
            count1++;
        }
        Node prevNode2 = null;
        Node currNode2 = head;
        int count2 = 0;
        while (currNode2 != null && count2 != index2) {
            prevNode2 = currNode2;
            currNode2 = currNode2.next;
            count2++;
        }
        if (currNode1 == null || currNode2 == null) {
            return;
        }
        if (prevNode1 != null) {
            prevNode1.next = currNode2;
        } else {
            head = currNode2;
        }
        if (prevNode2 != null) {
            prevNode2.next = currNode1;
        } else {
            head = currNode1;
        }
        Node temp = currNode1.next;
        currNode1.next = currNode2.next;
        currNode2.next = temp;
    }





}
