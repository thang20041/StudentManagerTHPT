package view;

import manager.StudentManager;
import model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuStudent {
    StudentManager studentManager = new StudentManager();
    Scanner inputInt = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);

    Student st1 = new Student("Lan", new double[]{8, 9, 1}, "nu");
    Student st2 = new Student("Long", new double[]{9, 9, 9}, "nam");
    Student st3 = new Student("Ling", new double[]{10, 8.5, 10}, "nu");


    public void showMainMenu() {
        studentManager.add(st1);
        studentManager.add(st2);
        studentManager.add(st3);
        int choice;
        do {
            System.out.println("---Quản Lý Học Sinh---");
            System.out.println("1.Thêm mới học sinh. ");
            System.out.println("2.Xóa học sinh.");
            System.out.println("3.Sửa thông tin học sinh.");
            System.out.println("4.Tìm kiếm học sinh theo Id.");
            System.out.println("5.Tìm kiếm học sinh theo từ khóa. ");
            System.out.println("6.Học sinh có điểm trung bình lớn nhất.");
            System.out.println("7.Hiển thị tất cả danh sách học sinh.");
            System.out.println("0.Thoát ứng dụng.");
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = inputInt.nextInt();
            switch (choice) {
                case 1:
                    showAdd();
                    break;
                case 2:
                    showDelete();
                    break;
                case 3:
                    showUpdate();
                    break;
                case 4:
                    searchById();
                    break;
                case 5:
                    searchByName();
                    break;
                case 6:
                    getMaxAvg();
                    break;
                case 7:
                    showAll();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Bạn hãy nhập đúng số lựa chọn bên trên!");
            }
        } while (choice != 0);
    }

    public void showAdd() {
        System.out.println("---Thêm học sinh mới---");
        System.out.println("Nhập tên:");
        String name = inputString.nextLine();
        System.out.println("Nhập điểm:");
        double[] points = new double[3];
        int numberPoints = 0;
        while (numberPoints < points.length) {
            System.out.println("Nhiểm điểm " + (numberPoints + 1) + " : ");
            points[numberPoints] = inputInt.nextDouble();
            numberPoints++;
        }
        System.out.println("Nhập giới tính : ");
        String gender = inputString.nextLine();
        studentManager.add(new Student(name, points, gender));
        System.out.println("Bạn đã thêm học sinh mới thành công !");
    }

    public void showAll() {
        System.out.println("Danh sách học sinh hiện tại là:");
        ArrayList<Student> list = studentManager.findAll();
        for (Student student : list) {
            System.out.println(student);
        }
    }

    public void showDelete() {
        System.out.println("---Xóa Học Sinh Khỏi Danh Sách---");
        System.out.println("Trước khi xóa bạn hãy kiểm tra và xác nhận rõ học sinh cần xóa! ");
        System.out.println("Bạn hãy nhập id của hoc sinh cần xóa:");
        int idDelete = inputInt.nextInt();
        studentManager.delete(idDelete);
        System.out.println("Bạn đã xóa thành công học sinh có id: " + idDelete);
    }

    public void showUpdate() {
        System.out.println("---Sửa Học Sinh Trong Danh Sách---");
        System.out.println("Bạn hãy nhập id của hoc sinh cần sửa:");
        int idEdit = inputInt.nextInt();
        System.out.println("Nhập tên:");
        String nameEdit = inputString.nextLine();
        System.out.println("Nhập điểm:");
        double[] pointsEdit = new double[3];
        int numberPoints = 0;
        while (numberPoints < pointsEdit.length) {
            System.out.println("Nhiểm điểm " + (numberPoints + 1) + " : ");
            pointsEdit[numberPoints] = inputInt.nextDouble();
            numberPoints++;
        }
        System.out.println("Nhập giới tính : ");
        String genderEdit = inputString.nextLine();
        studentManager.update(idEdit, new Student(nameEdit, pointsEdit, genderEdit));
        System.out.println("Bạn đã sửa thành công thông tin học sinh có id: " + idEdit);
    }

    public void searchById() {
        System.out.println("---Tim Kiếm Học Sinh Theo ID---");
        System.out.println("Bạn hãy nhập id của học sinh cần tìm kiếm:");
        int idSearch = inputInt.nextInt();
        int index = studentManager.findIndexById(idSearch);
        if (index != -1) {
            System.out.println("Học sinh có id:" + idSearch + " cần tìm là: ");
            System.out.println(studentManager.getInformation(index));
        } else {
            System.out.println("Không tìm thấy sinh viên có id là: " + idSearch);
        }
    }

    public void searchByName() {
        System.out.println("---Tim Kiếm Học Sinh Theo Tên---");
        System.out.println("Bạn hãy nhập tên của học sinh cần tìm kiếm:");
        String nameSearch = inputString.nextLine();
        System.out.println("Danh sách học sinh có tên " + nameSearch + " là :");
        System.out.println(studentManager.searchByName(nameSearch));
    }

    public void getMaxAvg() {
        System.out.println("---Học Sinh Có Điểm Trung Bình Môn Cao Nhất---");
        System.out.println(studentManager.getMaxAvg());
    }


}
