package lab_extra_arraylist;

import java.io.IOException;

import java.util.Comparator;

public class TestCase {
	public static void main(String[] args) {

		Clazz clazz = new Clazz("SE", "2017");
		try {
			clazz.loadStudents("src//asset//students.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Comparator<Student> idComparator = (a, b) -> Integer.parseInt(a.getId()) - Integer.parseInt(b.getId());
		clazz.sortStudents(idComparator);
		clazz.display();

		for (Student student : clazz.getTopNStudents(3)) {
			System.out.println(student);
		}
		for (Student student : clazz.getRandomNStudents(3)) {
			System.out.println(student);
		}

		clazz.removeStudent("18130006");
		clazz.display();

	}
}
