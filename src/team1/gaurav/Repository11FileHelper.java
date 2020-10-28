package team1.gaurav;

/**
 * gaurav.Repository11FileHelper is the helper class to read the csv file and build the StudentRepository
 *
 * @author Gaurav Ainapur
 * @version 1.0
 * @since 10-25-2020
 */

import team1.sukhpreet.Decorator12;

import java.io.BufferedReader;
import java.util.HashMap;

public class Repository11FileHelper {

	public static final String DELIMITER = ",";

	public static final int studentIdIDX = 0;
	public static final int firstNameIDX = 1;
	public static final int lastNameIDX = 2;
	public static final int programPlanIDX = 3;
	public static final int academicLevelIDX = 4;
	public static final int asuriteIdIDX = 5;

	public static HashMap<String, Decorator12> readCSV(String filePath) {

		BufferedReader fileReader;
		HashMap<String, Decorator12> studentList = new HashMap<String, Decorator12>();

		try {
			String fileRow ="";
			System.out.println(filePath);
			fileReader = new BufferedReader(new java.io.FileReader(filePath));
			fileReader.readLine();
			while((fileRow = fileReader.readLine()) != null) {
				String[] tokens = fileRow.split(DELIMITER);
				if(tokens.length == 6){
					Decorator12 student = new Decorator12(tokens[studentIdIDX], (tokens[firstNameIDX]+" "+tokens[lastNameIDX]), tokens[programPlanIDX], tokens[academicLevelIDX], tokens[asuriteIdIDX]);
					studentList.put(tokens[asuriteIdIDX],student);
				}
			}
			fileReader.close();
			return studentList;

		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return studentList;
	}
}
