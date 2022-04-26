package pro.sky.lesson;

import org.springframework.stereotype.Service;
import pro.sky.lesson.Exception.EmployeeBookOverFlowException;
import pro.sky.lesson.Exception.EmployeeNotFoundException;
import pro.sky.lesson.Interface.EmployeeServ;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeServ {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        employees = new HashMap<>();
    }


    @Override
    public Employee add(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        if (employees.containsKey(createKey(firstName, lastName))) {
            throw new EmployeeBookOverFlowException();
        }
        employees.put(createKey(firstName, lastName), newEmployee);
        return newEmployee;

    }

    @Override
    public Employee remove(String firstName, String lastName) {
        if (!employees.containsKey(createKey(firstName, lastName))) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(createKey(firstName, lastName));
    }

    @Override
    public Employee find(String firstName, String lastName) {
        if (!employees.containsKey(firstName + lastName)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(createKey(firstName, lastName));

    }

    @Override
    public Collection<Employee> findAll() {
        return employees.values();
    }

    @Override
    public String createKey(String firstName, String lastName) {
        return firstName + lastName;

    }
}
