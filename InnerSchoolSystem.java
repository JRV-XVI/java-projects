import java.util.ArrayList;
import java.util.List;

/**
 * InnerSchoolSystem
 */
public class InnerSchoolSystem {
	private List<String> students = new ArrayList<>();

	InnerSchoolSystem(ArrayList<String> students) {
		this.students = students;
	}

	public void addStudent(String name) {
		students.add(name);
	}

	public static void main(String[] args) {
		ArrayList<String> initialArrayList = new ArrayList<>();
		initialArrayList.add("Joe");
		InnerSchoolSystem schoolSystem = new InnerSchoolSystem(initialArrayList);
		schoolSystem.addStudent("Halo");
		schoolSystem.addStudent("Damm");
		System.out.println(initialArrayList);
	}
}
