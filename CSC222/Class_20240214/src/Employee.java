public class Employee {
    public double pay;
    public String name;
    public String id;
    public String title;
    public double efficiency;

    public void output() {
        System.out.println("Name:       " + name);
        System.out.println("ID:         " + id);
        System.out.println("Title:      " + title);
        System.out.println("Pay:        $" + pay);
        System.out.println("Efficiency: " + efficiency);
    }
}
