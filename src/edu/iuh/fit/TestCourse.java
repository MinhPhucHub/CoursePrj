package edu.iuh.fit;

/**
 * @description: This class represents a bank with many bank accounts
 * @author: Phuc, Le Minh
 * @version: 1.0
 * @created: 8/28/2024 7:00 PM
 */


import java.util.Scanner;

public class TestCourse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseList courseList = new CourseList(10);

        CourseList.addCourse(new Course("FIT101", "Java Programming", 3, "FIT"));
        CourseList.addCourse(new Course("FIT201", "Database Programming", 3, "FIT"));
        CourseList.addCourse(new Course("FIT301", "Java Programming", 3, "FIT"));

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Thêm khóa học");
            System.out.println("2. Xóa khóa học");
            System.out.println("3. Tìm kiếm khóa học theo mã");
            System.out.println("4. Tìm kiếm khóa học theo tên");
            System.out.println("5. Tìm kiếm khóa học theo khoa");
            System.out.println("6. Sắp xếp khóa học theo tên");
            System.out.println("7. Tìm khóa học có số tín chỉ lớn nhất");
            System.out.println("8. Tìm khoa phụ trách có nhiều khóa học nhất");
            System.out.println("9. Xem danh sách khóa học");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng (0-9): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập mã khóa học: ");
                    String id = scanner.nextLine();
                    System.out.print("Nhập tên khóa học: ");
                    String title = scanner.nextLine();
                    System.out.print("Nhập số tín chỉ: ");
                    int credit = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập tên khoa phụ trách: ");
                    String department = scanner.nextLine();
                    try {
                        Course newCourse = new Course(id, title, credit, department);
                        if (CourseList.addCourse(newCourse)) {
                            System.out.println("Thêm khóa học thành công.");
                        } else {
                            System.out.println("Khóa học đã tồn tại hoặc danh sách đầy.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Nhập mã khóa học cần xóa: ");
                    String removeId = scanner.nextLine();
                    if (courseList.removeCourse(removeId)) {
                        System.out.println("Xóa khóa học thành công.");
                    } else {
                        System.out.println("Xóa không thành công.");
                    }
                    break;

                case 3:
                    System.out.print("Nhập mã khóa học cần tìm: ");
                    String searchId = scanner.nextLine();
                    Course foundCourse = courseList.findCourseById(searchId);
                    if (foundCourse != null) {
                        System.out.println("Khóa học tìm thấy: " + foundCourse);
                    } else {
                        System.out.println("Không tìm thấy khóa học: " + searchId);
                    }
                    break;

                case 4:
                    System.out.print("Nhập tên khóa học cần tìm: ");
                    String searchTitle = scanner.nextLine();
                    Course[] foundCoursesByTitle = courseList.findCourseByTitle(searchTitle);
                    if (foundCoursesByTitle.length > 0) {
                        System.out.println("Các khóa học tìm thấy:");
                        for (Course course : foundCoursesByTitle) {
                            System.out.println(course);
                        }
                    } else {
                        System.out.println("Không tìm thấy khóa học nào với tên: " + searchTitle);
                    }
                    break;

                case 5:
                    System.out.print("Nhập tên khoa cần tìm: ");
                    String searchDepartment = scanner.nextLine();
                    Course[] foundCoursesByDepartment = courseList.findCoursesByDepartment(searchDepartment);
                    if (foundCoursesByDepartment != null) {
                        System.out.println("Các khóa học thuộc khoa " + searchDepartment + ":");
                        for (Course course : foundCoursesByDepartment) {
                            System.out.println(course);
                        }
                    } else {
                        System.out.println("Không tìm thấy khóa học nào thuộc khoa: " + searchDepartment);
                    }
                    break;


                case 6:
                    Course[] sortedCourses = courseList.sortCoursesByTitle();
                    System.out.println("Danh sách các khóa học sau khi sắp xếp theo tên:");
                    for (Course course : sortedCourses) {
                        System.out.println(course);
                    }
                    break;

                case 7:
                    Course[] maxCreditCourses = courseList.findCourseWithMaxCredits();
                    if (maxCreditCourses != null) {
                        System.out.println("Các khóa học có số tín chỉ lớn nhất:");
                        for (Course course : maxCreditCourses) {
                            System.out.println(course);
                        }
                    } else {
                        System.out.println("Danh sách khóa học rỗng.");
                    }
                    break;

                case 8:
                    String departmentWithMostCourses = courseList.findDepartmentWithMostCourses();
                    if (departmentWithMostCourses != null) {
                        System.out.println("Khoa phụ trách có nhiều khóa học nhất: " + departmentWithMostCourses);
                    } else {
                        System.out.println("Danh sách khóa học rỗng.");
                    }
                    break;

                case 9:
                    Course[] courses = courseList.getCourses();
                    System.out.println("Danh sách các khóa học:");
                    for (Course course : courses) {
                        if (course != null) {
                            System.out.println(course);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        }
    }
}