package peaksoft.service.serviceimpl;

import org.hibernate.HibernateException;
import peaksoft.Repository.RepositoruyImpl.InstructorRepositoryImpl;
import peaksoft.model.Instructor;
import peaksoft.service.InstructorService;

import java.util.List;

public class InstructorServiceImpl implements InstructorService {
    private InstructorRepositoryImpl instructorDao = new InstructorRepositoryImpl();

    @Override
    public void saveInstructor(Instructor instructor) {
        try {
            instructorDao.saveInstructor(instructor);
            System.out.println("Instructor saved successfully!");
        } catch(HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {
        try {
            instructorDao.updateInstructor(id, instructor);
            System.out.println("Instructor updated successfully!");
        } catch(HibernateException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Instructor getInstructorById(Long id) {
        try {
            return instructorDao.getInstructorById(id);
        } catch(HibernateException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Instructor> getInstructorsByCourseId(Long course_id) {
        try {
            return instructorDao.getInstructorsByCourseId(course_id);
        } catch(HibernateException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteInstructorById(Long id) {
        try {
            instructorDao.getInstructorsByCourseId(id);
            System.out.println("Instructor deleted successfully!");
        } catch(HibernateException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void assignInstructorToCourse(Long instructor_id, Long course_id) {
        try {
            instructorDao.assignInstructorToCourse(instructor_id, course_id);
            System.out.println("Instructor and course assigned successfully!");
        } catch(HibernateException e) {
            throw new RuntimeException();
        }
    }
}
