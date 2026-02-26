package SharedOfficePrinterQueue;
import java.time.LocalDateTime;
import java.util.UUID;

// In Java, files with public class declarations must have
// the name of the class as the file name too
public class Document {
    private final String id;
    private final String name;
    private final String department;
    private final LocalDateTime submittedAt;

    public Document(String name, String department) {
        this.id = UUID.randomUUID().toString(); // Generate unique ID
        this.name = name;
        this.department = department;
        this.submittedAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    // Define custom display for document objects
    // By default it would show class name + memory address
    @Override
    public String toString() {
        return "[" + name + " | " + department + "]";
    }
}