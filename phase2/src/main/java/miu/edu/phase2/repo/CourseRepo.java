package miu.edu.phase2.repo;

import miu.edu.phase2.dto.CourseDto;
import miu.edu.phase2.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    private static List<CourseDto> courses = new ArrayList<>();

    public CourseRepo() {
        Course c1 = new Course(1, "WAA", "CS545");
        Course c2 = new Course(2, "WAP", "CS472");

        courses.add(c1);
        courses.add(c2);
    }

    public List<CourseDto> findAll() {
        return courses;
    }

    public CourseDto findOne(int id) {
        return courses.stream().filter(crs -> crs.getId() == id).findFirst().get();
    }
    public void create(CourseDto c) {
        courses.add(c);
    }

    public void update(CourseDto c, int id) {
        for(int i=0; i<courses.size(); i++) {
            if(courses.get(i).getId() == id) {
                var course = courses.get(i);
                course.setId(c.getId());
                course.setCode(c.getCode());
                course.setName(c.getName());
                System.out.println("Course "+ c.getName() + "updated successfully");
            }
            else {
                System.out.println("Course not found");
            }
        }

    }

    public void delete(int id) {
        for(int i=0; i<courses.size(); i++) {
            if(courses.get(i).getId() == id) {
                courses.remove(courses.get(i));
                System.out.println("Course deleted successfully");
            }else {
                System.out.println("Course not found");
            }
        }
    }
}
