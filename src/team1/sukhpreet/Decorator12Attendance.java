package team1.sukhpreet;
/**
 * sukhpreet.Decorator12Attendance is the concrete decorator subclass extending
 * sukhpreet.Decorator12Decorator and is responsible for adding student attendance
 * information to the Student object along with the core data
 * as a part of the Decorator design pattern
 *
 * @author  Sukhpreet Anand
 * @version 1.0
 * @since   10-25-2020
 */

public class Decorator12Attendance extends Decorator12Decorator {
	
	private String date;
	private float minutes;

	public Decorator12Attendance(String date, float minutes) {
		this.date = date;
		this.minutes = minutes;
	}

	@Override
	public void add(Decorator12Interface student) {
		super.add(student);
		student.attendance.add(new Decorator12SingleAttendance(date, minutes));

	}
}
