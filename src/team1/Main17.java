package team1;

import team1.aditya.Reporter14;
import team1.gaurav.Repository11;
import team1.kings.ObserverPlotter16;
import team1.nagarjun.Grader13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Main17 class for making connections between multiple components of this project
 *
 * @author Shwetank Bhardwaj
 * @version 1.0
 * @since 10-25-2020
 */


public class Main17 extends JFrame {

    private Repository11 repository11;

    private Grader13 grader13;
    private Reporter14 reporter14;

//    private ObserverTable15 observerTable15;
    private ObserverPlotter16 observerPlotter16;

    public static void main(String[] args) {
        Main17 main17 = new Main17();
        main17.createUI();
    }

    public Main17() {
        repository11 = Repository11.getInstance();

        grader13 = new Grader13(repository11);
        reporter14 = new Reporter14(repository11);

//        observerTable15 = new ObserverTable15(repository11);

        observerPlotter16 = new ObserverPlotter16(repository11);

//        repository11.addObserver(observerTable15);
        repository11.addObserver(observerPlotter16);
    }

    private void createUI() {

        setTitle("Team 1 Project");
        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel menuPanel = getMenuPanel();
        mainPanel.add(menuPanel, BorderLayout.NORTH);

        JPanel innerPanel = new JPanel(new BorderLayout());
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));

//        innerPanel.add(observerTable15);
        innerPanel.add(observerPlotter16);

        mainPanel.add(innerPanel);
        add(mainPanel);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel getMenuPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton repositoryButton = getRepositoryButton();
        panel.add(repositoryButton);
        JButton gradesButton = getGradesButton();
        panel.add(gradesButton);
        JButton attendanceButton = getAttendanceButton();
        panel.add(attendanceButton);

        return panel;
    }

    public JButton getRepositoryButton() {
        JButton repoButton = new JButton("Open Student File");
        add(repoButton);
        repoButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = selectFile();
                repository11.loadRoster(filePath);
            }
        });
        return repoButton;
    }

    public JButton getGradesButton() {
        JButton gradeButton = new JButton("Open Grade File");
        add(gradeButton);
        gradeButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = selectFile();
                try {
                    grader13.loadGrades(filePath);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });
        return gradeButton;
    }

    public JButton getAttendanceButton() {
        JButton attendanceButton = new JButton("Open Attendance File");
        add(attendanceButton);
        attendanceButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = selectFile();
                try {
                    reporter14.loadAttendance(filePath);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        return attendanceButton;
    }

    public String selectFile() {
        JFileChooser mFileChooser = new JFileChooser();
        if (mFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File f = mFileChooser.getSelectedFile();
            if (f == null) {
                return "";
            }
            return f.toString();
        }
        return "";
    }

}

