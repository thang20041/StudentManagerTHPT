package manager;

import model.Student;

import java.util.ArrayList;

public class StudentManager implements iManager<Student> {
    ArrayList<Student> list;

    public StudentManager() {
        this.list = new ArrayList<>();
    }

    public Student getInformation(int index) {
        return list.get(index);
    }

    public ArrayList<Student> getMaxAvg() {
        ArrayList<Student> students = new ArrayList<>();
        double max = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAvg() > max) {
                max = list.get(i).getAvg();
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAvg() == max) {
                students.add(list.get(i));
            }
        }
        return students;

    }

    @Override
    public void add(Student st) {
        list.add(st);
    }

    @Override
    public void delete(int id) {
        int index = findIndexById(id);
        list.remove(index);
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void update(int id, Student student) {
        int index = findIndexById(id);
        list.set(index, student);
    }


    @Override
    public ArrayList<Student> findAll() {
        return list;
    }

    @Override
    public ArrayList<Student> searchByName(String name) {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                students.add(list.get(i));
            }
        }
        return students;
    }
}