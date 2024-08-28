
package edu.iuh.fit;

/**
 * @description: This class represents a bank with many bank accounts
 * @author: Phuc, Le Minh
 * @version: 1.0
 * @created: 8/28/2024 7:00 PM
 */


import java.util.Comparator;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CourseList {
    private static Course[] courses; // Array to store the courses
    public static int count = 0; // Number of courses currently in the list

    public CourseList(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Length of the array must be greater than 0.");
        }
        courses = new Course[n];
    }

    public static boolean addCourse(Course course) {
        if (course == null) {
            return false;
        }
        if (isExists(course)) {
            return false;
        }
        if (count < courses.length) {
            courses[count++] = course;
            return true;
        }
        return false;
    }

    public Course[] getCourses() {
        return courses;
    }

    public static boolean isExists(Course course) {
        for (int i = 0; i < count; i++) {
            Course temp = courses[i];
            if (temp != null && temp.getId().equals(course.getId())) {
                return true;
            }
        }
        return false;
    }

    public Course findCourseById(String id) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equals(id)) {
                return courses[i];
            }
        }
        return null;
    }

    public Course[] findCourseByTitle(String title) {
        Course[] tempResults = new Course[count];
        int resultCount = 0;

        for (int i = 0; i < count; i++) {
            if (courses[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
                tempResults[resultCount++] = courses[i];
            }
        }
        if (resultCount == 0) {
            return null;
        }
        Course[] results = new Course[resultCount];
        System.arraycopy(tempResults, 0, results, 0, resultCount);
        return results;
    }

    public Course[] findCoursesByDepartment(String department) {
        Course[] tempResults = new Course[count];
        int resultCount = 0;

        for (int i = 0; i < count; i++) {
            if (courses[i].getDepartment().equalsIgnoreCase(department)) {
                tempResults[resultCount++] = courses[i];
            }
        }
        if (resultCount == 0) {
            return null;
        }
        Course[] results = new Course[resultCount];
        System.arraycopy(tempResults, 0, results, 0, resultCount);
        return results;
    }

    public int findCourseIndexById(String id) {
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeCourse(String id) {
        int index = findCourseIndexById(id);
        if (index == -1) {
            return false;
        }
        for (int i = index; i < count - 1; i++) {
            courses[i] = courses[i + 1];
        }
        courses[--count] = null;
        return true;
    }

    public Course[] sortCoursesByTitle() {
        Course[] sortedCourses = Arrays.copyOf(courses, count);
        Arrays.sort(sortedCourses, new Comparator<Course>() {
            @Override
            public int compare(Course c1, Course c2) {
                return c1.getTitle().compareToIgnoreCase(c2.getTitle());
            }
        });
        return sortedCourses;
    }

    public Course[] findCourseWithMaxCredits() {
        if (count == 0) {
            return new Course[0];
        }
        int maxCredit = courses[0].getCredit();
        for (int i = 1; i < count; i++) {
            if (courses[i].getCredit() > maxCredit) {
                maxCredit = courses[i].getCredit();
            }
        }
        Course[] tempResult = new Course[count];
        int resultCount = 0;
        for (int i = 0; i < count; i++) {
            if (courses[i].getCredit() == maxCredit) {
                tempResult[resultCount++] = courses[i];
            }
        }
        return Arrays.copyOf(tempResult, resultCount);
    }

    public String findDepartmentWithMostCourses() {
        if (count == 0) {
            return null;
        }
        HashMap<String, Integer> departmentCountMap = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String department = courses[i].getDepartment();
            departmentCountMap.put(department, departmentCountMap.getOrDefault(department, 0) + 1);
        }
        String maxDepartment = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : departmentCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxDepartment = entry.getKey();
            }
        }
        return maxDepartment;
    }
}