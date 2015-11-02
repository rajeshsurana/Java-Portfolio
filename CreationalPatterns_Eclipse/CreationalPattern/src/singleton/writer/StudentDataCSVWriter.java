package singleton.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import concreateClasses.GradedWork;
import concreateClasses.Student;
import abstractClasses.IStudentDataWriter;

public class StudentDataCSVWriter extends IStudentDataWriter {

	protected static IStudentDataWriter uniqueInstanceCSV = null;
	// Private constructor
	private StudentDataCSVWriter(){}
	
	// Return already created unique instance
	public static IStudentDataWriter getInstance() {
		if(uniqueInstanceCSV == null){
			uniqueInstanceCSV = new StudentDataCSVWriter();
		}
		return uniqueInstanceCSV;
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
			file = "csvFinalGradesData.csv";
			writer = new FileWriter(file);
			
			// Student Name and Id
			writer.append("Name");
			writer.append(",");
			writer.append("ID");
			writer.append(",");
			
			// Print graded work headers
			for(String header: headers){
				writer.append(header);
			    writer.append(',');
			}
			// Final grade
			writer.append("Grade");
			writer.append(",");
			writer.append("\n");
			
			// Write Student data
			for(Student s: studentData){
				
				// student Name and Id
				String studentName = s.getName();
				writer.append(studentName);
				writer.append(",");
				String studentId = s.getId();
				writer.append(studentId);
				writer.append(",");
				
				// student graded marks
				assignedWork = s.getAssignedWork();
				for(String gradedItem: assignedWork.keySet()){
					List<GradedWork> gradedWorkList = assignedWork.get(gradedItem);
					for(int i=0; i < gradedWorkList.size(); i++){
						GradedWork gradedWork = gradedWorkList.get(i);
						writer.append(gradedWork.getGrade());
						writer.append(",");
					}
				}
				
				// student final grade
				String finalGrade = s.getFinalGrade();
				writer.append(finalGrade);
				writer.append(",");
				writer.append("\n");
			}
			writer.flush();
		    writer.close();
			
		}catch(Exception e){
			e.printStackTrace();
		    try {
		    	writer.flush();
				writer.close();
				return "";
			} catch (IOException e1) {
				e1.printStackTrace();
				return "";
			}
		}
		return (new File(file).getAbsolutePath());
	}
}
