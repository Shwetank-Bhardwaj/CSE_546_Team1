package team1.sukhpreet;

import java.util.List;

/**
 * sukhpreet.Decorator12 is the concrete subclass of sukhpreet.Decorator12Interface which
 * is in charge of storing and fetching code student information
 * as a part of the Decorator design pattern
 *
 * @author  Sukhpreet Anand
 * @version 1.0
 * @since   10-25-2020
 */

public class Decorator12 extends Decorator12Interface {
	
	public Decorator12(String id, String name, String program, String level, String asurite) {
		setID(id);
		setName(name);
		setProgram(program);
		setLevel(level);
		setAsurite(asurite);
	}

	public void setID(String id) {
		this.id = id;
	}

	public void setName(String name) {
		setFirstName(name.substring(0, name.indexOf(" ")));
		setLastName(name.substring(name.lastIndexOf(" ") + 1));
	}

	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	private void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public void setAsurite(String asurite) {
		this.asurite = asurite;
	}

	@Override
	public String getID() {
		return this.id;
	}

	@Override
	public String getFirstName() {
		return this.firstName;
	}

	@Override
	public String getLastName() {
		return this.lastName;
	}

	@Override
	public String getProgram() {
		return this.program;
	}

	@Override
	public String getLevel() {
		return this.level;
	}

	@Override
	public String getAsurite() {
		return this.asurite;
	}

	@Override
	public List<Decorator12SingleGrade> getGrades() {
		return this.grades;
	}

	@Override
	public List<Decorator12SingleAttendance> getAttendance() {
		return this.attendance;
	}
}
