package team1.sukhpreet;

/**
 * sukhpreet.Decorator12Grades is the concrete decorator subclass extending
 * sukhpreet.Decorator12Decorator and is responsible for adding student grade
 * information to the Student object along with the core data
 * as a part of the Decorator design pattern
 *
 * @author Sukhpreet Anand
 * @version 1.0
 * @since 10-25-2020
 */


public class Decorator12Grades extends Decorator12Decorator {

    private String assignmentName;
    private float score;
    private float maxScore;

    public Decorator12Grades(String assignmentName, float score, float maxScore) {
        this.assignmentName = assignmentName;
        this.maxScore = maxScore;
        this.score = score;
    }

    @Override
    public void add(Decorator12Interface student) {
        super.add(student);
        student.grades.add(new Decorator12SingleGrade(assignmentName, score / maxScore * 100));
    }
}
