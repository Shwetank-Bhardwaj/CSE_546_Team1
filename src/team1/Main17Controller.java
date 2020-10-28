package team1;

import team1.aditya.Reporter14;
import team1.gaurav.Repository11;
import team1.isaac.ObserverTable15;
import team1.kings.ObserverPlotter16;
import team1.nagarjun.Grader13;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Main17Controller {

    private Repository11 repository11;
    private Grader13 grader13;
    private Reporter14 reporter14;
    private final ObserverTable15 observerTable15;
    private final ObserverPlotter16 observerPlotter16;

    public Main17Controller(Repository11 repository11, Grader13 grader13, Reporter14 reporter14, ObserverTable15 observerTable15, ObserverPlotter16 observerPlotter16) {
        this.repository11 = repository11;
        this.grader13 = grader13;
        this.reporter14 = reporter14;
        this.observerTable15 = observerTable15;
        this.observerPlotter16 = observerPlotter16;
    }

    public Repository11 getRepo() {
        return repository11;
    }

    public void loadRoster(Component component) {
        String filePath = selectFile(component);
        repository11.loadRoster(filePath);
    }
    public void loadGrades(Component component) {
        String filePath = selectFile(component);
        grader13.loadGrades(filePath);
    }
    public void loadAttendance(Component component) {
        String filePath = selectFile(component);
        reporter14.loadAttendance(filePath);
    }

    public String selectFile(Component component) {
        JFileChooser mFileChooser = new JFileChooser();
        if (mFileChooser.showOpenDialog(component) == JFileChooser.APPROVE_OPTION) {
            File f = mFileChooser.getSelectedFile();
            if (f == null) {
                return "";
            }
            return f.toString();
        }
        return "";
    }

    public JPanel getStudentTable() {
        return observerTable15;
    }

    public JPanel getGradePlotter() {
        return observerPlotter16;
    }
}
