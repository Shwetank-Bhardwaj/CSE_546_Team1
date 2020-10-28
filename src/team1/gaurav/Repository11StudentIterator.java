package team1.gaurav;

import team1.sukhpreet.Decorator12Interface;

import java.util.Map;

public class Repository11StudentIterator implements Repository11Iterator {

    private int index = 0;
    private Map<String, Decorator12Interface> studentList;

    public Repository11StudentIterator(Map<String, Decorator12Interface> studentList) {
        this.studentList = studentList;
    }

    @Override
    public boolean hasNext() {
        if (index < studentList.keySet().toArray().length) {
            return true;
        }
        return false;
    }

    @Override
    public Decorator12Interface next() {
        Object key = studentList.keySet().toArray()[index++];
        if (!this.hasNext() && key == null) {
            return null;
        }
        return studentList.get(key);
    }

}