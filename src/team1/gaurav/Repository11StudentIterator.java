package team1.gaurav;

import team1.sukhpreet.Decorator12;

import java.util.HashMap;
import java.util.Map;

public class Repository11StudentIterator implements Repository11Iterator {

    private int index = 0;
    private Map<String, Decorator12> studentList;

    public Repository11StudentIterator(Map<String, Decorator12> studentList) {

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
    public Object next() {
        Object key = studentList.keySet().toArray()[index++];
        System.out.println(key);
        System.out.println(studentList.get(key));
        if (!this.hasNext() && key == null) {
            return null;
        }
        return studentList.get(key);
    }

}