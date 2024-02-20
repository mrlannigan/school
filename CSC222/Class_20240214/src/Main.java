public class Main {
    public static void main(String[] args) {
        Employee owner = new Employee();
        owner.setId("1");
        owner.setName("John Smith");
        owner.setPay(40);
        owner.setTitle("Owner");
        owner.setEfficiency(0.9);

        owner.output();
    }
}
