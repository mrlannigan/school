public class Employee {
    private double pay;
    private String name;
    private String id;
    private String title;
    private double efficiency;

    public Employee() {
    }

    public Employee(double pay, String name, String id, String title, double efficiency) {
        this.pay = pay;
        this.name = name;
        this.id = id;
        this.title = title;
        this.efficiency = efficiency;
    }

    public void output() {
        System.out.println("Name:       " + name);
        System.out.println("ID:         " + id);
        System.out.println("Title:      " + title);
        System.out.println("Pay:        $" + pay);
        System.out.println("Efficiency: " + efficiency);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }
}
