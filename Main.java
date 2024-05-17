import java.util.ArrayList;
import java.util.List;

import company.abstracts.Employee;
import company.models.Manager;
import company.models.Worker;

public class Main {
    public static void main(String[] args) {
        Worker worker1 = new Worker("Alice", 3000, 1, "2022-01-15", "Worker");
        Worker worker2 = new Worker("Bob", 3200, 2, "2022-02-20", "Worker");
        Worker worker3 = new Worker("Charlie", 3100, 3, "2022-03-10", "Worker");
        Worker worker4 = new Worker("Diana", 3050, 4, "2022-04-05", "Worker");

        Manager manager = new Manager("Edward", 5000, 5, "2021-05-01", "Manager");

        List<Employee> employees = new ArrayList<>();
        employees.add(worker1);
        employees.add(worker2);
        employees.add(worker3);
        employees.add(worker4);
        employees.add(manager);

        for (Employee employee : employees) {
            employee.work();
            System.out.println("- " + employee.getName() + " (ID: " + employee.hashCode() + ", Position: " + employee.getPosition() + ", Hire date: " + employee.getHireDate() + ", Salary: " + employee.getSalary() + ")");
        }
    }
}
