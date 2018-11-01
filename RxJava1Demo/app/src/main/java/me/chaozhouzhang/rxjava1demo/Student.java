package me.chaozhouzhang.rxjava1demo;

import java.util.List;

/**
 * Created on 2018/10/24 17:50
 *
 * @author zhangchaozhou
 */
public class Student {
    private String name;

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    private List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public Student setCourses(List<Course> courses) {
        this.courses = courses;
        return this;
    }
}
