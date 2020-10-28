package team1.gaurav;

/**
 * gaurav.Repository11 is the repository class which holds the data of Decorator12 type
 * which is also extends Repository11Observable and implements Repository11Container in order to be observed
 * and to generate iterator respectively
 *
 * @author  Gaurav Ainapur
 * @version 1.0
 * @since   10-25-2020
 */

import team1.sukhpreet.Decorator12;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Observable;

public class Repository11 extends Observable implements Repository11Container {

	private String filePath;
	HashMap<String, Decorator12> studentList = new HashMap<String, Decorator12>();

	public void updateStudent(String key, Decorator12 newStudent) {
		studentList.put(key, newStudent);
		setChanged();
		notifyAll();
	}
	
		
	public void loadRoster(String filePath) {
		this.filePath = filePath;
		this.studentList = studentList = Repository11FileHelper.readCSV(filePath);
	}



	public HashMap<String, Decorator12> getStudentList() {
		return studentList;
	}

	@Override
	public Repository11Iterator getIterator() {
		return new Student11Iterator();
	}

	public class Student11Iterator implements Repository11Iterator {
	
		int index = 0;
		@Override
		public boolean hasNext() {
			if(index < studentList.keySet().toArray().length) {
				return true;
			}
			return false;
		}
	
		@Override
		public Object next() {
			Object key = studentList.keySet().toArray()[index++];
			System.out.println(key);
			System.out.println(studentList.get(key));
			if(!this.hasNext() && key == null) {
				return null;
			}
			return studentList.get(key);
		}
	
	}

}

