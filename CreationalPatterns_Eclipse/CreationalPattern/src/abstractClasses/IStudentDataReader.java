package abstractClasses;

import java.util.List;
import java.util.Map;

import concreateClasses.Student;

public abstract class IStudentDataReader {
	
	public static IStudentDataReader getInstance() {
		return null;
	}
	protected String filePath;
	public abstract List<Student> readStudentData();
	public abstract String readClass();
	public abstract void setFilePath(String string);
	public abstract String getFilePath();
	public abstract Map<String, String> readGradingSchema();
}
