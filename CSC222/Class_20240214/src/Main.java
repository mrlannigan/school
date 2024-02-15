public class Main {
    public static void main(String[] args) {
        Employee owner = new Employee();
        owner.id = "1";
        owner.name = "John Smith";
        owner.pay = 40;
        owner.title = "Owner";
        owner.efficiency = 0.9;

        owner.output();
    }
}
