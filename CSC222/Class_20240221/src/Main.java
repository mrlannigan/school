import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee();
        Employee emp2 = new Employee();

        updateEmployee(emp1);


        ArrayList<Employee> employees = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Employee e = new Employee();
            updateEmployee(e);
            employees.add(e);
        }

        for (int i = 0; i < employees.size(); i++) {
            employees.get(i).display();
        }
    }

    public static void updateEmployee(Employee e) {
        e.setName("Frank");
        e.setEfficiency(new Random().nextInt(100));
        e.setId("12345");
        e.setTitle("Owner");
        e.setPay(30);
    }
}
