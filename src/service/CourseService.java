package service;

import model.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private static List<Course> courseDB= new ArrayList<>();

    public static void addNewCourse(Course course){
        courseDB.add(course);
    }

    public static void updateCourse(Course course){
        Course c = findCourse(course.getId());
        int index = courseDB.indexOf(c);
        courseDB.set(index,course);
    }


    public static void deleteCourse(String id){
        Course course = findCourse(id);
        courseDB.remove(course);
    }

    public static Course findCourse(String id) {
        for (Course course: courseDB) {
            if(course.getId().equals(id)){
                return course;
            }
        }
        return null;
    }

    public static List<Course> findCourses(String query){
        List<Course> result = new ArrayList<>();
        for (Course course: courseDB) {
            if(course.getId().contains(query) || course.getName().contains(query)){
                result.add(course);
                return result;
            }
        }
        return null;
    }

    public static List<Course> findAllCourses(){
        return courseDB;
    }
}
