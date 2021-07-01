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
        Student s = findStudent(student.getNic());
        int index = studentDB.indexOf(s);
        studentDB.set(index, student);
    }

    public void deleteStudent(String nic){
        Student student = findStudent(nic);
        studentDB.remove(student);
    }

    public static List<Student> findAllStudents(){
        return studentDB;
    }

    public Student findStudent(String nic){
        for(Student student : studentDB){
            if(student.getNic().equals(nic)){
                return student;
            }
        }
        return null;
    }

    public List<Student> findStudents(String query){
        List<Student> result = new ArrayList<>();

        for (Student student : studentDB){

            if(student.getNic().contains(query)|| student.getName().contains(query) || student.getEmail().contains(query) || student.getContactNo().contains(query)){
                result.add(student);
            }
        }
        return result;
    }
}