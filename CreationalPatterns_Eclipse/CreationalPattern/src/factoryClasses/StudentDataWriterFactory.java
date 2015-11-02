package factoryClasses;

import singleton.writer.StudentDataCSVWriter;
import singleton.writer.StudentDataHTMLWriter;
import singleton.writer.StudentDataXMLWriter;
import abstractClasses.IStudentDataWriter;

public class StudentDataWriterFactory {
	public static IStudentDataWriter StudentDataWriterFactoryMethod(String extension) {
		
		extension = extension.toLowerCase();
		IStudentDataWriter writer = null;
		switch (extension) {
		case "csv":
			writer = StudentDataCSVWriter.getInstance();
			break;
		case "html":
			writer = StudentDataHTMLWriter.getInstance();
			break;
		case "xml":
			writer = StudentDataXMLWriter.getInstance();
			break;
		default:
			break;
		}
		return writer;
	}
}
