package model;

import java.util.Arrays;

public class Student {
    private int id;
    private String name;
    private double[] points=new double[3];
    private String gender;
    private static int countId=1;

    public Student(String name, double[] points, String gender) {
        this.id = countId;
        this.name = name;
        this.points = points;
        this.gender = gender;
        countId++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[] getPoints() {
        return points;
    }

    public void setPoints(double[] points) {
        this.points = points;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getCountId() {
        return countId;
    }

    public void setCountId(int countId) {
        this.countId = countId;
    }
    public double getAvg(){
        double sum=0;
        for (int i = 0; i < points.length; i++) {
            sum+=points[i];
        }
        return sum/3;
    }


    @Override
    public String toString() {
        return "Sinh viên có: "  +
                "id :" + id +
                " | Tên : " + name +
                " | Giới Tính: " + gender +
                " | Điểm Toán Lý Hóa: " + Arrays.toString(points) +
                " | Điểm trung bình môn: " + getAvg() ;
    }
}
