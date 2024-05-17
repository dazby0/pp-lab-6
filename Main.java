import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import company.abstracts.Employee;
import company.models.Manager;
import company.models.Worker;

public class Main {
    public static void main(String[] args) {
        Worker worker1 = new Worker("Alice", 3000, 1, "2022-01-15", "Worker");
        Worker worker2 = new Worker("Bob", 3200, 1, "2022-02-20", "Worker");
        Worker worker3 = new Worker("Charlie", 3100, 3, "2022-03-10", "Worker");
        Worker worker4 = new Worker("Diana", 3050, 1, "2022-04-05", "Worker");

        Manager manager1 = new Manager("Edward", 5000, 5, "2021-05-01", "Manager");
        Manager manager2 = new Manager("Fiona", 5200, 3, "2021-06-01", "Manager");

        List<Employee> employees = new ArrayList<>();
        employees.add(worker1);
        employees.add(worker2);
        employees.add(worker3);
        employees.add(worker4);
        employees.add(manager1);
        employees.add(manager2);

        double totalSalary = calculateTotalSalary(employees);
        double totalManagerSalary = calculateTotalManagerSalary(employees);
        double totalWorkerSalary = calculateTotalWorkerSalary(employees);

        System.out.println("Total salary of all employees: " + totalSalary);
        System.out.println("Total salary of all managers: " + totalManagerSalary);
        System.out.println("Total salary of all workers: " + totalWorkerSalary);

        displayDuplicateEmployees(employees);
    }

    private static double calculateTotalSalary(List<Employee> employees) {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        return totalSalary;
    }

    private static double calculateTotalManagerSalary(List<Employee> employees) {
        double totalManagerSalary = 0;
        for (Employee employee : employees) {
            if (employee instanceof Manager) {
                totalManagerSalary += employee.getSalary();
            }
        }
        return totalManagerSalary;
    }

    private static double calculateTotalWorkerSalary(List<Employee> employees) {
        double totalWorkerSalary = 0;
        for (Employee employee : employees) {
            if (employee instanceof Worker) {
                totalWorkerSalary += employee.getSalary();
            }
        }
        return totalWorkerSalary;
    }

    private static void displayDuplicateEmployees(List<Employee> employees) {
        System.out.println("\nEmployees with duplicate IDs:");
        Map<Integer, List<Employee>> employeeMap = new HashMap<>();
    
        for (Employee employee : employees) {
            employeeMap.computeIfAbsent(employee.hashCode(), k -> new ArrayList<>()).add(employee);
        }
    
        for (List<Employee> employeeList : employeeMap.values()) {
            if (employeeList.size() > 1) {
                System.out.print(employeeList.get(0).getName() + " (ID: " + employeeList.get(0).hashCode() + ")");
                for (int i = 1; i < employeeList.size(); i++) {
                    System.out.print(", " + employeeList.get(i).getName() + " (ID: " + employeeList.get(i).hashCode() + ")");
                }
                System.out.println(" have the same ID.");
            }
        }
    }
}