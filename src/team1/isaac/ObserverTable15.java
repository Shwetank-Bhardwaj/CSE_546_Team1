package team1.isaac;

import team1.gaurav.Repository11;
import team1.gaurav.Repository11Iterator;
import team1.sukhpreet.Decorator12;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


public class ObserverTable15 extends JPanel implements Observer {
    private Repository11 repository;
    private String[][] blankData = {{"", "", "", "", "", ""}};
    private String[] colHeaders = {"id", "first name", "last name", "program", "level", "asurite"};
    private JTable table = new JTable(blankData, colHeaders);
    private JScrollPane scrollPane;

    public ObserverTable15(Repository11 repository) {
        this.repository = repository;
        refreshPanel(blankData);
    }

    private static final long serialVersionUID = 1L;
    ArrayList<String[]> data = new ArrayList<String[]>();

    public void refreshPanel(String[][] tableContent) {
        table = new JTable(tableContent, colHeaders);
        scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        this.add(scrollPane);
        this.revalidate();
        this.repaint();
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        this.remove(scrollPane);
        data.clear();
        Repository11Iterator iterator = repository.getIterator();
        while (iterator.hasNext()) {
            Decorator12 student = iterator.next();
            String[] studentData = {student.getID(), student.getFirstName(), student.getLastName(), student.getProgram(), student.getLevel(), student.getAsurite()};
            data.add(studentData);
        }
        String[][] tableContent = new String[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            tableContent[i] = data.get(i);
        }
        refreshPanel(tableContent);
    }

}