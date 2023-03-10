package peaksoft.service.serviceimpl;

import org.hibernate.HibernateException;
import peaksoft.Repository.RepositoruyImpl.CourseRepositoryImpl;
import peaksoft.model.Course;
import peaksoft.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    private CourseRepositoryImpl courseDao = new CourseRepositoryImpl();

    @Override
    public void saveCourse(Course course) {
        try {
            courseDao.saveCourse(course);
            System.out.println("Course saved successfully!");
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Course getCourseById(Long id) {
        try {
            return courseDao.getCourseById(id);
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Course> getAllCourse() {
        try {
            return courseDao.getAllCourse();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCourse(Long id, Course course) {
        try {
            courseDao.updateCourse(id, course);
            System.out.println("Course updated successfully!");
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCourseById(Long id) {
        try {
            courseDao.deleteCourseById(id);
            System.out.println("Course deleted successfully!");
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Course getCourseByName(String name) {
        try {
            return courseDao.getCourseByName(name);
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
