public class Triangle extends Shape {
    protected String type = "Triangle";
    private int width;

    public Triangle(int width) {
        this.width = width;

        this.type = "Triangle";
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Triangle: " + getWidth();
    }
}
