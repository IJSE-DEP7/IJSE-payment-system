package service;

import model.Student;

import java.time.LocalDate;
import java.util.List;

public class StudentServiceTest {

    /*
    * Syntax of the assert
    * assert <boolean expression>; ["String message"]
    */

    public static void main(String[] args) {
        try {
            saveStudent();updateStudent();
            deleteStudent();
            findAllStudents();
            findStudents();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void saveStudent() throws Exception{
        StudentService studentService = new StudentService();
        Student s = new Student("DEP","BSc Engineering","Test","75","address", LocalDate.now(),"email","932680963V","0711713745",true);
        studentService.saveStudent(s);
        Student s2 = new Student("DEP","BSc Engineering","Test","75","address", LocalDate.now(),"email","123456789V","0718717626",true);
        studentService.saveStudent(s2);
        assert studentService.findStudent("932680963V")!=null: "my first assertion";
    }


    private static void updateStudent() throws Exception{
        StudentService studentService = new StudentService();
        Student s = new Student("DEP","BSc Engineering","New Student","75","address", LocalDate.now(),"email","932680963V","0717685593",true);
        studentService.updateStudent(s);
        assert studentService.findStudent("932680963V")!=null:"failed update test";
        assert studentService.findStudent("932680963V").getName().equals("New Student"): "failed update method";
    }

    private static void deleteStudent() throws Exception{
        StudentService studentService = new StudentService();
        studentService.deleteStudent("932680963V");
        assert studentService.findStudent("932680963V")==null: "failed delete test";
    }


    private static void findAllStudents() {
        StudentService studentService = new StudentService();
        assert studentService.findAllStudents().size() == 1: "failed findAllStudents test";
    }

    private static void findStudents() throws Exception{
        Student s3 = new Student("DEP","BSc Engineering","Dhanushka","75","address", LocalDate.now(),"email","283476987V","0775257919",true);
        Student s4 = new Student("DEP","BSc Engineering","Manoj Chandimal","75","address", LocalDate.now(),"email","932690963V","0723424678",true);
        Student s5 = new Student("DEP","BSc Engineering","Manoj Randeni","75","address", LocalDate.now(),"email","932698963V","0756767897",true);
        StudentService studentService = new StudentService();
        studentService.saveStudent(s3);
        studentService.saveStudent(s4);
        studentService.saveStudent(s5);
        List<Student> result = studentService.findStudents("Ma");
        for(Student student : result){
            System.out.println(student);
        }
        assert result.size() == 2: "failed findStudents test";
    }


}
