import java.util.*;

public class Stack<Item> implements Iterable<Item>{
    private Node<Item> first;     // top of stack
    private int n;                // size of the stack

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Stack() { //Initializes an empty stack.
        first = null;
        n = 0;
    }

    public boolean isEmpty() { //Returns true if this stack is empty, false otherwise
        return first == null;
    }

    public int size() { //returns number of items in this stack
        return n;
    }

    public void push(Item item) { //Adds the item to this stack
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    public Item pop() { //Removes and returns the item most recently added to this stack
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        return item;                   // return the saved item
    }

    public Item peek() { //Returns (but does not remove) the item most recently added to this stack.
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    public String toString() { //returns string representation
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    public Iterator<Item> iterator() {
        return new StackIterator(first);
    }

    private class StackIterator implements Iterator<Item> {
        private Node<Item> current;

        public StackIterator(Node<Item> first) {
            current = first;
        }
        public boolean hasNext() {
            return current != null;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
        public Item next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
