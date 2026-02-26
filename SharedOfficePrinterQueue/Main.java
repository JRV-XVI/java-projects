package SharedOfficePrinterQueue;
public class Main {
    public static void main(String[] args) {

        PrinterQueue printer = new PrinterQueue();

        System.out.println();

        printer.submit(new Document("Report Q1", "Finance"));
        printer.showQueue();
        printer.submit(new Document("Employee List", "HR"));
        printer.showQueue();

        printer.submitUrgent(new Document("CEO Contract", "Executive"));
        printer.showQueue();

        printer.printNext();
        printer.printNext();

        printer.cancelLast();

        printer.showQueue();
    }
}
