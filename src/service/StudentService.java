package service;

import model.Student;
import service.exception.DuplicateEntryException;
import service.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private static List<Student> studentDB = new ArrayList<>();

    public static void saveStudent(Student student) throws DuplicateEntryException {
        if(isExist(student.getNic())){
            throw new DuplicateEntryException();
        }
        studentDB.add(student);
    }

    public static void updateStudent(Student student) throws NotFoundException{
        Student s = findStudent(student.getNic());
        int index = studentDB.indexOf(s);
        studentDB.set(index, student);
    }

    public static void deleteStudent(String nic) throws NotFoundException{
        Student student = findStudent(nic);
        studentDB.remove(student);
    }

    public static List<Student> findAllStudents(){
        return studentDB;
    }

    private static boolean isExist(String nic){

        for(Student student : studentDB){
            if(student.getNic().equals(nic)){
                return true;
            }
        }
        return false;
    }

    public static Student findStudent(String nic) throws NotFoundException{
        for(Student student : studentDB){

            if(student.getNic().equals(nic)){
                return student;
            }
        }
        throw new NotFoundException();
    }

    public static List<Student> findStudents(String query){
        List<Student> result = new ArrayList<>();

        for (Student student : studentDB){

            if(student.getNic().contains(query)|| student.getName().contains(query) || student.getEmail().contains(query) || student.getContactNo().contains(query)){
                result.add(student);
            }
        }
        return result;
    }
}
