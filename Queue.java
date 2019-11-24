import java.util.*;

public class Queue<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of queue
    private Node<Item> last;     // end of queue
    private int n;               // number of elements on queue

    private static class Node<Item> { // helper linked list class
        private Item item;
        private Node<Item> next;
    }

    public Queue() { //Initializes an empty queue.
        first = null;
        last  = null;
        n = 0;
    }

    public boolean isEmpty() { // Returns true if this queue is empty.
        return first == null;
    }

    public int size() { //Returns the number of items in this queue.
        return n;
    }

    public Item peek() { //Returns the item least recently added to this queue.
        if (isEmpty()){
            throw new NoSuchElementException("Queue underflow");
        }
        return first.item;
    }

    public void enqueue(Item item) { //Adds the item to this queue.
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
    }

    public Item dequeue() { //Removes and returns the item on this queue that was least recently added.
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }

    public String toString() { //Returns a string representation of this queue.
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    public Iterator<Item> iterator()  {
        return new QueueIterator(first);
    }

    private class QueueIterator implements Iterator<Item> {
        private Node<Item> current;

        public QueueIterator(Node<Item> first) {
            current = first;
        }
        public boolean hasNext(){
            return current != null;
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
