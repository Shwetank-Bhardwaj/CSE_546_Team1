package team1;

import team1.aditya.Reporter14;
import team1.gaurav.Repository11;
import team1.isaac.ObserverTable15;
import team1.nagarjun.Grader13;

import javax.swing.*;
import java.awt.*;

import team1.kings.ObserverPlotter16;

/**
 * Main17 class for making connections between multiple components of this project
 *
 * @author Shwetank Bhardwaj
 * @version 1.0
 * @since 10-25-2020
 */


public class Main17 extends JFrame {

    private Main17Controller main17Controller;

    public static void main(String[] args) {
        Repository11 repository11 = Repository11.getInstance();
        Grader13 grader13 = new Grader13(repository11);
        Reporter14 reporter14 = new Reporter14(repository11);
        ObserverTable15 observerTable15 = new ObserverTable15(repository11);
        ObserverPlotter16 observerPlotter16 = new ObserverPlotter16(repository11);

        repository11.addObserver(observerTable15);
        repository11.addObserver(observerPlotter16);

        Main17Controller main17Controller = new Main17Controller(repository11, grader13, reporter14, observerTable15, observerPlotter16);
        Main17 main17 = new Main17(main17Controller);
    }

    public Main17(Main17Controller main17Controller) {
        this.main17Controller = main17Controller;

        setTitle("Team 1 Project");
        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel menuPanel = getMenuPanel();
        mainPanel.add(menuPanel, BorderLayout.NORTH);

        JPanel innerPanel = new JPanel(new BorderLayout());
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));

        innerPanel.add(main17Controller.getStudentTable());
        innerPanel.add(main17Controller.getGradePlotter());

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
        repoButton.addActionListener(it -> {
            main17Controller.loadRoster(this);
        });
        return repoButton;
    }

    public JButton getGradesButton() {
        JButton gradeButton = new JButton("Open Grade File");
        gradeButton.addActionListener(it -> {
            main17Controller.loadGrades(this);
        });
        return gradeButton;
    }

    public JButton getAttendanceButton() {
        JButton attendanceButton = new JButton("Open Attendance File");
        attendanceButton.addActionListener(it -> {
            main17Controller.loadAttendance(this);
        });
        return attendanceButton;
    }


}

