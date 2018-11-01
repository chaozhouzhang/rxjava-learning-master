package me.chaozhouzhang.rxjava1demo;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created on 2018/10/24 17:46
 *
 * @author zhangchaozhou
 */
public class Test3 {

    public static void main(String[] args) {

        Course course = new Course();
        course.setName("物理");
        Course course1 = new Course();
        course1.setName("化学");


        List<Course> courses = new ArrayList<>();
        courses.add(course);


        List<Course> courses1 = new ArrayList<>();
        courses1.add(course);
        courses1.add(course1);


        Student student = new Student();
        student.setName("张三");
        student.setCourses(courses);


        Student student1 = new Student();
        student1.setName("李四");
        student1.setCourses(courses1);

        Student[] students = new Student[]{student, student1};
        Subscriber<Course> subscriber = new Subscriber<Course>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {

                System.err.println(e.getMessage());
            }

            @Override
            public void onNext(Course course) {
                System.out.println(course.getName());
            }
        };
        Observable.from(students)
                .flatMap(new Func1<Student, Observable<Course>>() {
                    @Override
                    public Observable<Course> call(Student student) {
                        System.out.println(student.getName());
                        /**
                         * 将事件对象Student转化为Observable对象Observable<Course>，对应Subscriber对象Subscriber<Course>
                         */
                        return Observable.from(student.getCourses());
                    }
                })
                .subscribe(subscriber);

    }
}
