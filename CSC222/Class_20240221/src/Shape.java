import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Shape {
    private int length;
    private int width;

    public static void main(String[] args) {
        Random random = new Random();

        ArrayList<Shape> shapes = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Shape shape = new Shape(random.nextInt(1,10), random.nextInt(1, 10));
            shapes.add(shape);
        }

        for (Shape shape : shapes) {
            System.out.printf("Dimensions: %dx%d\n", shape.getWidth(), shape.getLength());
            System.out.printf("Area: %d\n", shape.calcArea());
            System.out.printf("Perimeter: %d\n", shape.calcPerimeter());
            shape.display();
            System.out.println();
        }
    }

    public Shape(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int calcArea() {
        return getLength() * getWidth();
    }

    public int calcPerimeter() {
        return 2 * (getWidth() + getLength());
    }

    public void display() {
        for (int i = 0; i < getLength(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                System.out.print(".");
            }
            System.out.println();
        }
    }
}
