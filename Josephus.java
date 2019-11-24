import edu.princeton.cs.algs4.*;


public class Josephus {
    public static void main(String[] args) {
        StdOut.println("Where must Josephus sit to survive?");

        StdOut.print("Enter the number of people in the circle: ");
        int people = StdIn.readInt();
        StdOut.print("Enter the number of people skipped each time: ");
        int skipped = StdIn.readInt();

        StdOut.println("\nQueue indices of people killed: ");
        Stopwatch queueStopwatch = new Stopwatch(); //problem using queue
        int queueSolution = josephusQueue(people, skipped);
        StdOut.println("\n\nQueue solving time: " + queueStopwatch.elapsedTime() + " s");
        StdOut.println("To survive elimination, Josephus must sit at index: " + queueSolution);

    }

    /* queue for Josephus problem */
    private static int josephusQueue(int p, int s) { //solved Josephus problem using queue

        Queue<Integer> people = new Queue<>(); // enqueues all people
        for (int i = 1; i < p + 1; i++){
            people.enqueue(i);
        }

        while (people.size() > 1) {
            for (int i = 0; i < s - 1; i++){ // remove and add people traversed (not killed)
                people.enqueue(people.dequeue());
            }
            StdOut.print(people.dequeue() + " "); //kill person
        }

        return people.dequeue(); //last man standing
    }

}

