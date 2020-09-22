package Test;

import java.lang.reflect.Method;

/**
 * @author Mckay
 * @create 2020-09-13
 * @description
 **/
public class Constructors {
    public static void main(String[] args) {
        Class<Student> studentClass = Student.class;
        studentClass.getConstructors();
        for (Method method : studentClass.getMethods()) {
        }
        System.out.println(studentClass.getClassLoader());
        System.out.println(studentClass);
    }
}
