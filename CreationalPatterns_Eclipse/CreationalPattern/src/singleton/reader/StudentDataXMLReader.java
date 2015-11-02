package singleton.reader;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import concreateClasses.GradedWork;
import concreateClasses.Student;
import abstractClasses.IStudentDataReader;

public class StudentDataXMLReader extends IStudentDataReader {

	private Document doc;
	private static IStudentDataReader uniqueInstanceXML = null;

	// Private Constructor to create Singleton pattern
	private StudentDataXMLReader() {
	}

	// Return already created unique instance
	public static IStudentDataReader getInstance() {
		if(uniqueInstanceXML == null){
			uniqueInstanceXML = new StudentDataXMLReader();
		}
		return uniqueInstanceXML;
	}
	
	
	@Override
	public void setFilePath(String filePath) {
		this.filePath = filePath;
		try{
    		File fXmlFile = new File(filePath);
	    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    	this.doc = dBuilder.parse(fXmlFile);		
	    	this.doc.getDocumentElement().normalize();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
	}

	@Override
	public String getFilePath() {
		return filePath;
	}
	
	@Override
	public String readClass() {
		Element gradebook = doc.getDocumentElement();
		String className = gradebook.getAttribute("class");
		return className;
	}

	@Override
	public Map<String, String> readGradingSchema() {
		Map<String, String> gradedItemList = new LinkedHashMap<String, String>();
		NodeList gradItemNodeList = doc.getElementsByTagName("GradeItem");

		for (int i = 0; i < gradItemNodeList.getLength(); i++) {
			Node gradedItem = gradItemNodeList.item(i);
			Element eElement = (Element)gradedItem;
			String category = eElement.getElementsByTagName("Category").item(0).getTextContent(); 
			String percentage = eElement.getElementsByTagName("Percentage").item(0).getTextContent(); 
			gradedItemList.put(category, percentage);
		}
		return gradedItemList;
	}
	
	@Override
	public List<Student> readStudentData() {
		List<Student> studentList = new ArrayList<Student>();
		NodeList studentNodeList = doc.getElementsByTagName("Student");
		for(int i=0; i < studentNodeList.getLength(); i++){
			Student s = new Student();
			Element studentNode = (Element)studentNodeList.item(i);
			// Set student name
			String studentName = studentNode.getElementsByTagName("Name").item(0).getTextContent();
			s.setName(studentName);

			// Set student id
			String studentId = studentNode.getElementsByTagName("ID").item(0).getTextContent();
			s.setId(studentId);
			
			Map<String, List<GradedWork>> assignedWork = new LinkedHashMap<String, List<GradedWork>>();
			NodeList assignedWorkList = studentNode.getElementsByTagName("AssignedWork");
			for(int j=0; j < assignedWorkList.getLength(); j++){
				Element assignedWorkNode = (Element) assignedWorkList.item(j);
				String assignedWorkCategory = assignedWorkNode.getAttribute("category");
				NodeList gradedWorkNodeList = assignedWorkNode.getElementsByTagName("GradedWork");
				List<GradedWork> gradedWorkList = new ArrayList<GradedWork>();
				for(int k =0; k < gradedWorkNodeList.getLength(); k++){
					GradedWork gradedWork = new GradedWork();
					Element gradedWorkElement = (Element) gradedWorkNodeList.item(k);
					String nameGradedWork = gradedWorkElement.getElementsByTagName("Name").item(0).getTextContent();
					gradedWork.setName(nameGradedWork);
					String gradeGradedWork = gradedWorkElement.getElementsByTagName("Grade").item(0).getTextContent();
					gradedWork.setGrade(gradeGradedWork);
					gradedWorkList.add(gradedWork);
				}
				assignedWork.put(assignedWorkCategory, gradedWorkList);
			}
			s.setAssignedWork(assignedWork);
			studentList.add(s);
		}
		return studentList;
	}
}
