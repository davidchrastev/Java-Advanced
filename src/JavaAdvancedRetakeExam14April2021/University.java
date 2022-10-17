package JavaAdvancedRetakeExam14April2021;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getData() {
        return students;
    }
    public int getStudentCount() {
        return students.size();
    }
    public String registerStudent(Student student) {
        if (students.contains(student)) {
            return "Student is already in the university";

        }
        if (students.size() < capacity) {
            students.add(student);
            return "Added student " + student.getFirstName() + " " + student.getLastName();
        } else {
            return "No seats in the university";
        }

    }
    public String dismissStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
            return "Removed student " + student.getFirstName() + " " + student.getLastName();
        } else {
            return "Student not found";
        }
    }
    public Student getStudent(String firstName,String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }
    public String getStatistics()  {
        StringBuilder stringBuilder = new StringBuilder();
        //==Student: First Name = Anna, Last Name = Cameron, Best Subject = Geometry
        for (Student student : students) {
            stringBuilder
                    .append("==Student: First Name = ")
                    .append(student.getFirstName())
                    .append(", Last Name = ")
                    .append(student.getLastName())
                    .append(", Best Subject = ")
                    .append(student.getBestSubject());
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
