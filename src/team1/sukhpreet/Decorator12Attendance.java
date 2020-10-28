package team1.sukhpreet; /**
 * sukhpreet.Decorator12Attendance is the concrete decorator subclass extending
 * sukhpreet.Decorator12Decorator and is responsible for adding student attendance
 * information to the Student object along with the core data
 * as a part of the Decorator design pattern
 *
 * @author  Sukhpreet Anand
 * @version 1.0
 * @since   10-25-2020
 */


import java.util.List;

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
	}

	@Override
	public List<Decorator12SingleGrade> getGrades() {
		return super.getGrades();
	}

	@Override
	public List<Decorator12SingleAttendance> getAttendance() {
		List<Decorator12SingleAttendance> list = super.getAttendance();
		list.add(new Decorator12SingleAttendance(date, minutes));
		return list;
	}

}
