package service;

import model.Course;
import service.exception.DuplicateEntryException;
import service.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private static List<Course> courseDB= new ArrayList<>();

    public static void addNewCourse(Course course) throws DuplicateEntryException {
        if(isExists(course.getId())){
            throw new DuplicateEntryException();
        }
        courseDB.add(course);
    }

    public static void updateCourse(Course course) throws NotFoundException {

        Course c = findCourse(course.getId());
        int index = courseDB.indexOf(c);
        courseDB.set(index,course);
    }


    public static void deleteCourse(String id) throws NotFoundException {
        Course course = findCourse(id);
        courseDB.remove(course);
    }

    public static Course findCourse(String id) throws NotFoundException {
        for (Course course: courseDB) {
            if(course.getId().equals(id)){
                return course;
            }
        }
        throw new NotFoundException();
    }

    private static boolean isExists(String id){
        for (Course course: courseDB) {
            if(course.getId().equals(id)){
                return true;
            }
        }
        return false;
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

    public static Course findCourseByName(String name){
        Course result;
        for (Course course: courseDB) {
            if(course.getName().equals(name)){
                return course;
            }
        }
        return null;
    }

    public static List<Course> findAllCourses(){
        return courseDB;
    }
}
