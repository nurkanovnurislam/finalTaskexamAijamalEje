package peaksoft;

import peaksoft.model.Course;
import peaksoft.model.Instructor;
import peaksoft.model.Lesson;
import peaksoft.model.Task;
import peaksoft.service.serviceimpl.CourseServiceImpl;
import peaksoft.service.serviceimpl.InstructorServiceImpl;
import peaksoft.service.serviceimpl.LessonServiceImpl;
import peaksoft.service.serviceimpl.TaskServiceImpl;

import java.time.LocalDate;

public class App {
    public static void main( String[] args ) {
        CourseServiceImpl courseService = new CourseServiceImpl();
        InstructorServiceImpl instructorService = new InstructorServiceImpl();
        LessonServiceImpl lessonService = new LessonServiceImpl();
        TaskServiceImpl taskService = new TaskServiceImpl();

        Course course = new Course("Peaksoft", 9, LocalDate.of(2020, 1, 31),
        "https://webcache.googleusercontent.com/search?q=cache:fh0NFm2ejIkJ:https://peaksoft.house/&cd=1&hl=ru&ct=clnk&gl=kg",
        "PeakSoft House - бул PeakSoft IT компаниясынын онлайн жана офлайн окутуу курстары. " +
        "Биз талап кылынган Back-end (Java) жана Front-end (JavaScript), " +
        "IT адистерин online - offline даярдайбыз. Нолдон баштап биринчи жумуш күнүнө чейин.");
        Course course1 = new Course("ItAcademy", 6, LocalDate.of(2020, 1, 31),
                "Aisalka", "Jashoo keremet kyrgyzstan obondoru!");


        Instructor instructor = new Instructor("Mukhamed",
                "Alanov", "alanovMukhamed@gmail.com", 555_55_65_75);
        Instructor instructor1 = new Instructor("Zhanarbek",
                "Abdyrasulov", "zhanarbek@gmail.com", 202_00_02_01);

        Lesson lesson = new Lesson("Java",
                "https://www.youtube.com/watch?v=fYwViar9eMY");
        Lesson lesson1 = new Lesson("JS",
                "Figma");

        Task task = new Task("Array", "three day", "project relation ship");
        Task task1 = new Task("OOP", "one day", "project oop task");



//        courseService.saveCourse(course1);

//        instructorService.saveInstructor(instructor1);

//        instructorService.assignInstructorToCourse(2L, 1L);

//        lessonService.saveLesson(lesson1, 1L);

//        taskService.saveTask(task1, 1L);

    }
}
