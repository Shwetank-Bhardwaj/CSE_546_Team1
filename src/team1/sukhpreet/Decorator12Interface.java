package team1.sukhpreet; /**
 * sukhpreet.Decorator12Interface is the interface for fetching Student details
 * as a part of the Decorator design pattern
 *
 * @author  Sukhpreet Anand
 * @version 1.0
 * @since   10-25-2020
 */

import java.util.ArrayList;
import java.util.List;

abstract class Decorator12Interface {

	protected String id;
	protected String firstName;
	protected String lastName;
	protected String program;
	protected String level;
	protected String asurite;
	protected List<Decorator12SingleGrade> grades = new ArrayList<>();
	protected List<Decorator12SingleAttendance> attendance = new ArrayList<>();

	public abstract String getID();
	public abstract String getFirstName();
	public abstract String getLastName();
	public abstract String getProgram();
	public abstract String getLevel();
	public abstract String getAsurite();
	public abstract List<Decorator12SingleGrade> getGrades();
	public abstract List<Decorator12SingleAttendance> getAttendance();

	public String toString() {
		return String.format("ID: " + id + ", Name: " + firstName + " " + lastName + ", Program: " + program + ", Level: " + level + ", ASURITE: " + asurite + ", Grades: " + grades + ", Attendance: " + attendance);
	}
}

