package singleton.writer;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import abstractClasses.IStudentDataWriter;
import concreateClasses.GradedWork;
import concreateClasses.Student;

public class StudentDataHTMLWriter extends IStudentDataWriter {

	protected static IStudentDataWriter uniqueInstanceHTML = null;
	// Private Constructor
	private StudentDataHTMLWriter(){}
	
	// Return already created unique instance
	public static IStudentDataWriter getInstance() {
		if(uniqueInstanceHTML == null){
			uniqueInstanceHTML = new StudentDataHTMLWriter();
		}
		return uniqueInstanceHTML;
	}
	
	@Override
	public String writeStudentData(List<Student> studentData) {
		String file = null;
		FileWriter writer = null;
		// Check if list is empty
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
			file = "htmlFinalGradesData.html";
			writer = new FileWriter(file);
			
			writer.append("<!DOCTYPE html><html><head><title>Final Grades</title><style>table, th, td {  border: 1px solid black;  border-collapse: collapse;}th, td {  padding: 5px;}th {    color:white;    background-color:green;}</style></head><body><table style='width:100%'>");
			writer.append("<tr>");
			// Student Name and Id
			writer.append("<th>");
			writer.append("Name");
			writer.append("</th>");
			writer.append("<th>");
			writer.append("ID");
			writer.append("</th>");
			
			// Print graded work headers
			for(String header: headers){
				writer.append("<th>");
				writer.append(header);
				writer.append("</th>");
			}
			// Final grade
			writer.append("<th>");
			writer.append("Grade");
			writer.append("</th>");
			writer.append("</tr>");
			
			// Write Student data
			for(Student s: studentData){
				
				writer.append("<tr>");
				// student Name and Id
				String studentName = s.getName();
				writer.append("<td>");
				writer.append(studentName);
				writer.append("</td>");
				String studentId = s.getId();
				writer.append("<td>");
				writer.append(studentId);
				writer.append("</td>");
				
				// student graded marks
				assignedWork = s.getAssignedWork();
				for(String gradedItem: assignedWork.keySet()){
					List<GradedWork> gradedWorkList = assignedWork.get(gradedItem);
					for(int i=0; i < gradedWorkList.size(); i++){
						GradedWork gradedWork = gradedWorkList.get(i);
						writer.append("<td>");
						writer.append(gradedWork.getGrade());
						writer.append("</td>");
					}
				}
				
				// student final grade
				String finalGrade = s.getFinalGrade();
				writer.append("<td>");
				writer.append(finalGrade);
				writer.append("</td>");
				writer.append("</tr>");
			}
			
			writer.append("</table></body></html>");
			writer.flush();
		    writer.close();
			
		}catch(Exception e){
			e.printStackTrace();
			
		    try {
		    	writer.flush();
				writer.close();
				return "";
			} catch (Exception e1) {
				e1.printStackTrace();
				return "";
			}
		}
		return (new File(file).getAbsolutePath());
	}
}
