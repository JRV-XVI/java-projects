import java.util.ArrayDeque;
import java.util.Deque;

public class PrinterQueue {

    private final Deque<Document> queue = new ArrayDeque<>();

    // Normal document (FIFO)
    public void submit(Document document) {
        queue.addLast(document);
        System.out.println("Submitted: " + document);
    }

    // Urgent document (insert to front)
    public void submitUrgent(Document document) {
        queue.addFirst(document);
        System.out.println("URGENT submitted: " + document);
    }

    // Process next document
    public Document printNext() {
        if (queue.isEmpty()) {
            System.out.println("No documents to print.");
            return null;
        }

        Document next = queue.pollFirst();
        System.out.println("Printing: " + next);
        return next;
    }

    // Cancel last submitted document
    public Document cancelLast() {
        if (queue.isEmpty()) {
            System.out.println("No documents to cancel.");
            return null;
        }

        Document removed = queue.removeLast();
        System.out.println("Cancelled: " + removed);
        return removed;
    }

    // Check pending documents count
    public int getPendingCount() {
        return queue.size();
    }

    // Show current queue state
    public void showQueue() {
        System.out.println("\nCurrent queue:");
        queue.forEach(System.out::println);
        System.out.println("Pending: " + getPendingCount());
        System.out.println();
    }
}