package Sem_4;

import java.util.ArrayList;
import java.util.List;

public class EmployeeActions {

    List<Employee> directory = new ArrayList<>();

    public List<Employee> addEmployee(Employee employee) {
        directory.add(employee);
        return this.directory.stream().toList();
    }

    public List<Employee> findById(int id) {
        return this.directory.stream().filter(employee -> employee.id == id).toList();
    }

    public List<Employee> findByExperience(int experience) {
        return this.directory.stream().filter(employee -> employee.getExperience() == experience).toList();
    }

    public List<String> showPhoneByName(String name) {
        List<String> result = new ArrayList<>();
        this.directory.forEach(employee -> {
            if (employee.getName().equals(name)) {
                result.add(employee.getPhone());
            }
        });
        return result;
    }

}
