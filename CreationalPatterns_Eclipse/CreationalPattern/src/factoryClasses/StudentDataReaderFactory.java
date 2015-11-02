package factoryClasses;

import singleton.reader.StudentDataJSONReader;
import singleton.reader.StudentDataXMLReader;
import abstractClasses.IStudentDataReader;

public class StudentDataReaderFactory {
	public static IStudentDataReader StudentDataReaderFactoryMethod(String filePath) {
		String extension = "";
		if(filePath.endsWith(".json")){
			extension = "json";
		}else if(filePath.endsWith(".xml")){
			extension = "xml";
		}
		IStudentDataReader reader = null;
		switch (extension) {
		case "xml":
			reader = StudentDataXMLReader.getInstance();
			break;
		case "json":
			reader = StudentDataJSONReader.getInstance();
			break;
		default:
			break;
		}
		return reader;
	}
}
