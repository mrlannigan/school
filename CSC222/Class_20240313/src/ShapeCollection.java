import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class ShapeCollection {
    private ArrayList<Shape> shapes = new ArrayList<>();

    ShapeCollection(int numberOfShapes) {
        Random random = new Random();

        for (int i = 0; i < numberOfShapes; i++) {
            int number = random.nextInt(2);
            switch (number) {
                case 0:
                    Rectangle rectangle = new Rectangle(random.nextInt(10), random.nextInt(10));
                    shapes.add(rectangle);
                    break;
                case 1:
                    Triangle triangle = new Triangle(random.nextInt(10));
                    shapes.add(triangle);
                    break;
            }
        }
    }

    void display() {
        for (Shape shape : shapes) {
            shape.display();
            System.out.println(shape);
        }
    }

    void compare() {
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = i + 1; j < shapes.size(); j++) {
                if (shapes.get(i).equals(shapes.get(j))) {
                    System.out.printf("Shape %d and %d are both %ss", i, j, shapes.get(i).type);
                }

            }
        }
    }
}
