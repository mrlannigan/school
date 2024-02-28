import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Person step4Person = new Person(); // step 4
        step4Person.setAge(30); // step 5;

        ArrayList<Person> people = new ArrayList<>(); // step 6
        people.add(new Person()); // step 7
        people.get(0).Walk(); // step 8
    }
}
