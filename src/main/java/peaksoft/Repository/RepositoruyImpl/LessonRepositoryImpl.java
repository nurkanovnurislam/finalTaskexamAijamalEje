package peaksoft.Repository.RepositoruyImpl;

import jakarta.persistence.EntityManager;
import peaksoft.Repository.LessonRepository;
import peaksoft.configuration.HibernateConfiguration;
import peaksoft.model.Course;
import peaksoft.model.Lesson;

import java.util.List;

public class LessonRepositoryImpl implements LessonRepository {
    private final EntityManager entityManager = HibernateConfiguration.getEntityManager();
    @Override
    public void saveLesson(Lesson lesson, Long course_id) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, course_id);
        course.getLessons().add(lesson);
        lesson.setCourse(course);
        entityManager.persist(course);
        entityManager.persist(lesson);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateLesson(Long id, Lesson lesson) {
        entityManager.getTransaction().begin();
        Lesson lesson1 = entityManager.find(Lesson.class, id);
        lesson1.setName(lesson.getName());
        lesson1.setVideoLink(lesson.getVideoLink());
        entityManager.refresh(lesson1);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Lesson getLessonById(Long id) {
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Get lesson by id successfully!");
        return lesson;
    }

    @Override
    public List<Lesson> getLessonsByCourseId(Long course_id) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, course_id);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Get all lessons by course id successfully!");
        return course.getLessons();
    }

}
