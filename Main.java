import java.util.ArrayList;
import java.util.List;

import company.models.Manager;
import company.models.Worker;

public class Main {
    public static void main(String[] args) {
        List<Worker> workers = new ArrayList<>();
        workers.add(new Worker("Alice", 3600, 1));
        workers.add(new Worker("Bob", 3200, 2));
        workers.add(new Worker("Charlie", 3100, 3));
        workers.add(new Worker("Diana", 4050, 4));

        Manager manager = new Manager("Edward", 5000, 5);

        for (Worker worker : workers) {
            System.out.println("Salary: " + worker.getSalary());
            worker.work();
        }

        System.out.println("Salary: " + manager.getSalary());
        manager.work();
    }
}
