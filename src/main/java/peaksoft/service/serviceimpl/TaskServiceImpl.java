package peaksoft.service.serviceimpl;

import org.hibernate.HibernateException;
import peaksoft.Repository.RepositoruyImpl.TaskRepositoryImpl;
import peaksoft.model.Task;
import peaksoft.service.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    private TaskRepositoryImpl taskDao = new TaskRepositoryImpl();
    @Override
    public void saveTask(Task task, Long lesson_id) {
        try {
            taskDao.saveTask(task, lesson_id);
            System.out.println("Task saved successfully!");
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateTask(Long id, Task task) {
        try {
            taskDao.updateTask(id, task);
            System.out.println("Task updated successfully!");
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Task> getAllTaskByLessonId(Long lesson_id) {
        try {
            return taskDao.getAllTaskByLessonId(lesson_id);
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteTaskById(Long lesson_id) {
        try {
            taskDao.deleteTaskById(lesson_id);
            System.out.println("Task deleted successfully!");
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

}
