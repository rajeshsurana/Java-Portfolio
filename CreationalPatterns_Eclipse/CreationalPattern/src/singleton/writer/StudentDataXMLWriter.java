package singleton.writer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import concreateClasses.GradedWork;
import concreateClasses.Student;
import abstractClasses.IStudentDataWriter;

public class StudentDataXMLWriter extends IStudentDataWriter {

	protected static IStudentDataWriter uniqueInstanceXML = null;
	
	// Private Constructor
	private StudentDataXMLWriter(){}
	
	// Return already created unique instance
	public static IStudentDataWriter getInstance() {
		if(uniqueInstanceXML == null){
			uniqueInstanceXML = new StudentDataXMLWriter();
		}
		return uniqueInstanceXML;
	}
	
	@Override
	public String writeStudentData(List<Student> studentData) {
		String file = null;
		if(studentData.isEmpty()){
			return "";
		}
		
		// Get headers
		List<String> headers = new ArrayList<String>();
		Student stu = studentData.get(0);
		Map<String, List<GradedWork>> assignedWork = stu.getAssignedWork();
		for(String gradedItem: assignedWork.keySet()){
			List<GradedWork> gradedWorkList = assignedWork.get(gradedItem);
			for(int i=0; i < gradedWorkList.size(); i++){
				GradedWork gradedWork = gradedWorkList.get(i);
				headers.add(gradedWork.getName());
			}
		}
		try{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("GradeBook");
			rootElement.setAttribute("class", "CSE 598");
			doc.appendChild(rootElement);
			
			// Grades node
			Element grades = doc.createElement("Grades");
			rootElement.appendChild(grades);
			
			for(Student s: studentData){
				Element student = doc.createElement("Student");
				grades.appendChild(student);
				Element nameNode = doc.createElement("Name");
				nameNode.appendChild(doc.createTextNode(s.getName()));
				student.appendChild(nameNode);
				Element idNode = doc.createElement("ID");
				idNode.appendChild(doc.createTextNode(s.getId()));
				student.appendChild(idNode);
				// student graded marks
				assignedWork = s.getAssignedWork();
				for(String gradedItem: assignedWork.keySet()){
					Element assignedWorkNode = doc.createElement("AssignedWork");
					assignedWorkNode.setAttribute("category", gradedItem);
					student.appendChild(assignedWorkNode);
					List<GradedWork> gradedWorkList = assignedWork.get(gradedItem);
					for(int i=0; i < gradedWorkList.size(); i++){
						GradedWork gradedWork = gradedWorkList.get(i);
						Element gradedWorkNode = doc.createElement("GradedWork");
						assignedWorkNode.appendChild(gradedWorkNode);
						Element itemNameNode = doc.createElement("Name");
						itemNameNode.appendChild(doc.createTextNode(gradedWork.getName()));
						gradedWorkNode.appendChild(itemNameNode);
						Element itemGradeNode = doc.createElement("Grade");
						itemGradeNode.appendChild(doc.createTextNode(gradedWork.getGrade()));
						gradedWorkNode.appendChild(itemGradeNode);
					}
				}	
				Element letterGradeNode = doc.createElement("LetterGrade");
				letterGradeNode.appendChild(doc.createTextNode(s.getFinalGrade()));
				student.appendChild(letterGradeNode); 
			}
			
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			file = "xmlFinalGradesData.xml";
			StreamResult result = new StreamResult(new File(file));
			transformer.transform(source, result);
			
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
		return (new File(file).getAbsolutePath());
	}
}
