package peaksoft.Repository;

import peaksoft.model.Course;

import java.util.List;

public interface CourseRepository {
    void saveCourse(Course course);
    Course getCourseById(Long id);
    List<Course> getAllCourse();
    void updateCourse(Long id, Course course);
    void deleteCourseById(Long id);
    Course getCourseByName(String name);
}
