package team1;

import team1.aditya.Reporter14;
import team1.gaurav.Repository11;
import team1.nagarjun.Grader13;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Main17Controller {

    private Repository11 repository11;
    private Grader13 grader13;
    private Reporter14 reporter14;

    public ActionListener repositoryListener = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String filePath = selectFile();
            repository11.loadRoster(filePath);
        }
    };

    public ActionListener gradesListener = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String filePath = selectFile();
            grader13.loadGrades(filePath);
        }
    };

    public AbstractAction attendanceListener = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String filePath = selectFile();
            reporter14.loadAttendance(filePath);
        }
    };

    public void Main12Controller() {
        repository11 = Repository11.getInstance();
        grader13 = new Grader13(repository11);
        reporter14 = new Reporter14(repository11);
    }


    public String selectFile() {
        JFileChooser mFileChooser = new JFileChooser();
        if (mFileChooser.showOpenDialog() == JFileChooser.APPROVE_OPTION) {
            File f = mFileChooser.getSelectedFile();
            if (f == null) {
                return "";
            }
            return f.toString();
        }
        return "";
    }

    public Repository11 getRepo() {
        return repository11;
    }
}
