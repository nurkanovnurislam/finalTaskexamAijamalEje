package peaksoft.Repository.RepositoruyImpl;

import jakarta.persistence.EntityManager;
import peaksoft.Repository.TaskRepository;
import peaksoft.configuration.HibernateConfiguration;
import peaksoft.model.Lesson;
import peaksoft.model.Task;

import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {
    private final EntityManager entityManager = HibernateConfiguration.getEntityManager();

    @Override
    public void saveTask(Task task, Long lesson_id) {
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, lesson_id);
        lesson.getTasks().add(task);
        task.setLesson(lesson);
        entityManager.persist(task);
        entityManager.persist(lesson);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateTask(Long id, Task task) {
        entityManager.getTransaction().begin();
        Task task1 = entityManager.find(Task.class, id);
        task1.setName(task.getName());
        task1.setDeadLina(task.getDeadLina());
        task1.setTask(task.getTask());
        entityManager.refresh(task1);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Task> getAllTaskByLessonId(Long lesson_id) {
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, lesson_id);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Get all tasks successfully!");
        return lesson.getTasks();
    }

    @Override
    public void deleteTaskById(Long id) {
        entityManager.getTransaction().begin();
        Task task = entityManager.find(Task.class, id);
        entityManager.remove(task);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
