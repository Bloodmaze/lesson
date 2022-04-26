package pro.sky.lesson.Interface;

import pro.sky.lesson.Employee;

import java.util.Collection;


public interface EmployeeServ {
    Employee add(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lasName);

    Collection<Employee> findAll();

    String createKey(String firstName, String lastName);
}
