package peaksoft.Repository.RepositoruyImpl;

import jakarta.persistence.EntityManager;
import peaksoft.Repository.InstructorRepository;
import peaksoft.configuration.HibernateConfiguration;
import peaksoft.model.Course;
import peaksoft.model.Instructor;

import java.util.List;

public class InstructorRepositoryImpl implements InstructorRepository {
    private final EntityManager entityManager = HibernateConfiguration.getEntityManager();
    @Override
    public void saveInstructor(Instructor instructor) {
        entityManager.getTransaction().begin();
        entityManager.persist(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {
        entityManager.getTransaction().begin();
        Instructor instructor1 = entityManager.find(Instructor.class, id);
        instructor1.setFirstname(instructor.getFirstname());
        instructor1.setLastname(instructor.getLastname());
        instructor1.setEmail(instructor.getEmail());
        instructor1.setPhoneNumber(instructor.getPhoneNumber());
        entityManager.refresh(instructor1);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Instructor getInstructorById(Long id) {
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Get instructor successfully!");
        return instructor;
    }

    @Override
    public List<Instructor> getInstructorsByCourseId(Long course_id) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, course_id);
        entityManager.getTransaction().commit();
        entityManager.close();
        if (course.getInstructors() == null) {
            System.out.println("This arrayList is null!");
        }
        System.out.println("Get all instructors successfully!");
        return course.getInstructors();
    }

    @Override
    public void deleteInstructorById(Long id) {
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.remove(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void assignInstructorToCourse(Long instructor_id, Long course_id) {
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, instructor_id);
        Course course = entityManager.find(Course.class, course_id);
        instructor.getCourses().add(course);
        course.getInstructors().add(instructor);
        entityManager.persist(instructor);
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
