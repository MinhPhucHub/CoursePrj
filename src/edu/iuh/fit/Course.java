package edu.iuh.fit;

/**
 * @description: This class represents a bank with many bank accounts
 * @author: Phuc, Le Minh
 * @version: 1.0
 * @created: 8/28/2024 7:00 PM
 */


public class Course {
    private String id;
    private String title;
    private int credit;
    private String department;

    public Course() {
        this.id = "";
        this.title = "";
        this.credit = 0;
        this.department = "";
    }

    public Course(String id, String title, int credit, String department) {
        this.id = id;
        this.title = title;
        this.credit = credit;
        this.department = department;
    }

    public String getTitle() {
        return this.title;
    }

    public int getCredit() {
        return this.credit;
    }

    public String getDepartment() {
        return this.department;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        if (id == null || id.length() < 3)
            throw new IllegalArgumentException("ID must have at least 3 characters");
        for (int i = 0; i < id.length(); i++) {
            if (!Character.isLetterOrDigit(id.charAt(i)))
                throw new IllegalArgumentException("ID must contain only letters or digits");
        }
        this.id = id;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty())
            throw new IllegalArgumentException("Title must not be empty");
        this.title = title;
    }

    public void setCredit(int credit) {
        if (credit < 0)
            throw new IllegalArgumentException("Credit must be greater than 0");
        this.credit = credit;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-30s %5d  %-15s", id, title, credit, department);
    }
}