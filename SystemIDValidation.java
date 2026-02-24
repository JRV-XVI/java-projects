import java.util.LinkedHashSet;

public class SystemIDValidation {
    LinkedHashSet<String> ids = new LinkedHashSet<>();

    SystemIDValidation() {
        System.out.println("New System");
    }

    public boolean addID(String StudentId) {
        return ids.add(StudentId);
    }

    public boolean checkID(String StudentId) {
        return ids.contains(StudentId);
    }

    public static void main(String[] args) {
        SystemIDValidation system = new SystemIDValidation();

        System.out.println("Adding student A001. It's added? ->" + system.addID("A001"));
        System.out.println("Adding student A002. It's added? ->" + system.addID("A002"));
        System.out.println("Adding student A003. It's added? ->" + system.addID("A003"));
        System.out.println("Adding student A001. It's added? ->" + system.addID("A001")); // Ducplicado, se ignora.

        System.out.println("The student A001 exist? ->" + system.checkID("A001")); // Si existe = true
        System.out.println("The student A999 exist? ->" + system.checkID("A999")); // No existe = false
        System.out.println("Total IDs: " + system.ids.size());
    }
}
