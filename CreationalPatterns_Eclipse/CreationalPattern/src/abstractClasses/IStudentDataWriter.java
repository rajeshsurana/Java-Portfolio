package abstractClasses;

import java.util.List;

import concreateClasses.Student;

public abstract class IStudentDataWriter {
	
	public static IStudentDataWriter getInstance() {
		return null;
	}
	public abstract String writeStudentData(List<Student> studentData);
}
