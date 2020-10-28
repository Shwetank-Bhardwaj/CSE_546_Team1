package team1;

import team1.isaac.ObserverTable15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import team1.kings.ObserverPlotter16;

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
        Main17Controller main17Controller = new Main17Controller();
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

        ObserverTable15 observerTable15 = new ObserverTable15(main17Controller.getRepo());
        main17Controller.getRepo().addObserver(observerTable15);

//        ObserverPlotter16 observerPlotter16 = new ObserverPlotter16(main17Controller.getRepo());
//        main17Controller.getRepo().addObserver(observerPlotter16);

        innerPanel.add(observerTable15);
//        innerPanel.add(observerPlotter16);

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
        repoButton.addActionListener(main17Controller.repositoryListener);
        return repoButton;
    }

    public JButton getGradesButton() {
        JButton gradeButton = new JButton("Open Grade File");
        gradeButton.addActionListener(main17Controller.gradesListener);
        return gradeButton;
    }

    public JButton getAttendanceButton() {
        JButton attendanceButton = new JButton("Open Attendance File");
        attendanceButton.addActionListener(main17Controller.attendanceListener);
        return attendanceButton;
    }


}

