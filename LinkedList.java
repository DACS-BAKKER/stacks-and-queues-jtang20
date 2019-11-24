import java.util.*;

public class LinkedList<Item> implements Iterable<Item>{ // generic linked list

    private Node first; //top
    private int size; //size

    public LinkedList() {
        first = null;
        size = 0;
    }

    public void add(Item item) {
        if (first == null) {
            first = new Node();
            first.item = item;
        } else {
            Node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node();
            temp.next.item = item;
        }
        size++;
    }

    public Item get(int index) {
        if (size() - 1 < index) {
            System.out.println("Out of bounds.");
        } else {
            Node temp = first;
            for (int i = 0; i < index; i++)
                temp = temp.next;
            return temp.item;
        }
        return null;
    }

    public void set(int index, Item item) {
        if (size() - 1 < index) {
            System.out.println("Out of bounds.");
        } else {
            Node temp = first;
            for (int i = 0; i < index; i++)
                temp = temp.next;
            temp.item = item;
        }
    }

    public void clear() {
        first = null;
    }

    public int size() {
        return size;
    }

    public Boolean isEmpty() {
        return first == null;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node temp = first;

        public boolean hasNext() {
            return temp != null;
        }

        public void remove() { // for iterator
        }

        public Item next() {
            Item item = temp.item;
            temp = temp.next;
            return item;
        }
    }

    public void recursivelyReverse() {
        first = recursivelyReverse(first);
    } //wrapper

    public void iterativelyReverse() {
        first = iterativelyReverse(first);
    } //wrapper

    private Node iterativelyReverse(Node current) {
        Node previous = null;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    private Node recursivelyReverse(Node n) {
        if (n != null && n.next == null)
            return n;
        else if (n != null) {
            Node temp = recursivelyReverse(n.next);
            n.next.next = n;
            n.next = null;
            return temp;
        }
        return null;
    }

    public String toString() {
        String returned = "";
        Node temp = first;
        while (temp != null) {
            returned += temp.item + " ";
            temp = temp.next;
        }
        return returned;
    }

    private class Node {
        Item item;
        Node next;
    }
}
