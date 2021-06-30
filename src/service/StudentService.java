package service;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private static List<Student> studentDB = new ArrayList<>();

    public void saveStudent(Student student){
        studentDB.add(student);
    }

    public void updateStudent(Student student){
        //findStudent(student.getNIC());
    }

    public void deleteStudent(String NIC){

    }

    public List<Student> findAllStudents(){

        return null;
    }

    public Student findStudent(String NIC){

        return null;
    }

    public List<Student> findStudents(String query){

        return null;
    }
}
