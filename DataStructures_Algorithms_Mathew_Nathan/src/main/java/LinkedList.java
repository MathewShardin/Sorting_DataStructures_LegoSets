
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

    //Swaps two elements Nodes of the linked list places
//    @Override
//    public void swap(int firstIndex, int secondIndex) {
//        if (firstIndex < 0 || secondIndex < 0) {throw new IllegalArgumentException("Index cannot be negative");}
//        if (firstIndex == secondIndex) {return;}
//
//        //Find node previous to firstIndex node
//        Node nodeBeforeFirst = this.head;
//        Node firstIndexNode = null;
//        if (firstIndex != 0) {
//            for (int i = 0; i < firstIndex - 1; i++) {
//                if (nodeBeforeFirst == null) {throw new IllegalArgumentException("Index out of bounds");}
//                nodeBeforeFirst = nodeBeforeFirst.next;
//            }
//            firstIndexNode = nodeBeforeFirst.next;
//        } else {
//            firstIndexNode = nodeBeforeFirst;
//        }
//
//        //Find node previous to secondIndex node
//        Node nodeBeforeSecond = this.head;
//        Node secondIndexNode = null;
//        if (secondIndex != 0) {
//            for (int i = 0; i < secondIndex - 1; i++) {
//                if (nodeBeforeSecond == null) {throw new IllegalArgumentException("Index out of bounds");}
//                nodeBeforeSecond = nodeBeforeSecond.next;
//            }
//            secondIndexNode = nodeBeforeSecond.next;
//        } else {
//            secondIndexNode = nodeBeforeSecond;
//        }
//
//        //Swap connection on the firstIndex and secondIndex nodes
//        Node nodeTemp = firstIndexNode.next;
//        firstIndexNode.next = secondIndexNode.next;
//        secondIndexNode.next = nodeTemp;
//
//        //Swap connection on nodes previous to firstIndex and secondIndex
//        nodeTemp = nodeBeforeFirst.next;
//        nodeBeforeFirst.next = nodeBeforeSecond.next;
//        nodeBeforeSecond.next = nodeTemp;
//    }

    //Swaps two elements Nodes of the linked list places
    @Override
    public void swap(int firstIndex, int secondIndex) {
        //Validate arguments
        if (firstIndex < 0 || secondIndex < 0) {throw new IllegalArgumentException("Index cannot be negative");}
        if (firstIndex == secondIndex) {return;}

        //Swap two adjacent elements places
        if (secondIndex - firstIndex == 1 || firstIndex - secondIndex == 1) {

        }



        //Find node previous to firstIndex node
        Node nodeBeforeFirst = this.head;
        Node firstIndexNode = null;
        for (int i = 0; i < firstIndex - 1; i++) {
            if (nodeBeforeFirst == null) {throw new IllegalArgumentException("Index out of bounds");}
            nodeBeforeFirst = nodeBeforeFirst.next;
        }
        firstIndexNode = nodeBeforeFirst.next;

        //Find node previous to secondIndex node
        Node nodeBeforeSecond = this.head;
        Node secondIndexNode = null;
        for (int i = 0; i < secondIndex - 1; i++) {
            if (nodeBeforeSecond == null) {throw new IllegalArgumentException("Index out of bounds");}
            nodeBeforeSecond = nodeBeforeSecond.next;
        }
        secondIndexNode = nodeBeforeSecond.next;

        //Swap connection on the firstIndex and secondIndex nodes
        Node nodeTemp = firstIndexNode.next;
        firstIndexNode.next = secondIndexNode.next;
        secondIndexNode.next = nodeTemp;

        //Swap connection on nodes previous to firstIndex and secondIndex
        nodeTemp = nodeBeforeFirst.next;
        nodeBeforeFirst.next = nodeBeforeSecond.next;
        nodeBeforeSecond.next = nodeTemp;
    }





}
