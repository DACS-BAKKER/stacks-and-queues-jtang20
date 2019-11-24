import edu.princeton.cs.algs4.*;

public class ReverseList { //methods of reversing list are in linkedlist class
    public static void main(String[] args) {
        StdOut.println("Enter integer list size in order for it to be reversed both recursively and iteratively.");

        LinkedList<Integer> list = new LinkedList<>();

        StdOut.print("\nEnter list size to generate: "); //user input
        int size = StdIn.readInt();
        for (int i = 0; i < size; i++) {
            list.add(StdRandom.uniform(100)); //adds a number from 1-100 each loop
        }

        StdOut.println("\nOriginal: " + list.toString());

        StdOut.print("\nRecursively: "); //reverses original list using recursion
        Stopwatch recursiveStopwatch = new Stopwatch();
        list.recursivelyReverse();
        StdOut.println("\nReversed List:" + list.toString());
        StdOut.println("Time Taken: " + recursiveStopwatch.elapsedTime() + "s");

        StdOut.print("\nIteratively: ");                //reverses "recursion used reversed list" resulting in printing the original
        Stopwatch iterativeStopwatch = new Stopwatch(); //if you comment out recursive, iterative will return "true" reversed list of original
        list.iterativelyReverse();
        StdOut.println("\nReversed List:" + list.toString());
        StdOut.println("Time Taken: " + iterativeStopwatch.elapsedTime() + "s");
    }
}
