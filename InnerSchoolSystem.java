import java.util.ArrayList;
import java.util.List;

/**
 * InnerSchoolSystem
 */
public class InnerSchoolSystem {
	private List<String> students = new ArrayList<>();

	InnerSchoolSystem() {
		System.out.println("New system");
	}

	public void addStudent(String name) {
		students.add(name);
	}

	public List<String> getList() {
		return students;
	}

	public String getStudent(int index) {
		return students.get(index);
	}

	public static void main(String[] args) {
		InnerSchoolSystem schoolSystem = new InnerSchoolSystem();
		System.out.println(schoolSystem.getList());
		schoolSystem.addStudent("John");
		System.out.println(schoolSystem.getList());
		schoolSystem.addStudent("Martin");
		System.out.println(schoolSystem.getList());
		System.out.println("Consulting student at index 0");
		System.out.println(schoolSystem.getStudent(0));
	}
}
