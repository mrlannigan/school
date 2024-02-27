import java.util.Random;

public class Employee {
    private double pay;
    private String name;
    private String id;
    private String title;
    private int efficiency;

    public static int numOfEmployees;
    public static double totalPay;

    private int[] hours = new int[5];

    public Employee() {
        for (int i = 0; i < this.hours.length; i++) {
            setHours(i, new Random().nextInt(40));
        }
    }

    public Employee(double pay, String name, String id, String title, int efficiency) {
        this.pay = pay;
        this.name = name;
        this.id = id;
        this.title = title;
        this.efficiency = efficiency;
        numOfEmployees++;
        totalPay += pay;

        for (int i = 0; i < this.hours.length; i++) {
            setHours(i, new Random().nextInt(40));
        }
    }

    //Method
    public void display(){
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.printf("Pay: $%.2f\n" ,pay);
        System.out.println("Efficiency: " + efficiency);
        System.out.print("Hours: ");
        for (int i = 0; i < hours.length; i++) {
            System.out.print(hours[i] + " ");
        }
        System.out.println();
    }

    public void setName(String n){
        name = n;
    }
    public String getName(){
        return name;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(int efficiency) {
        this.efficiency = efficiency;
    }

    public int getHours(int index) {
        return hours[index];
    }

    public void setHours(int index, int hour) {
        this.hours[index] = hour;
    }
}