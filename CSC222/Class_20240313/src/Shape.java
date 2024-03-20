import java.util.Objects;

abstract class Shape {

    String type;

    int width;
    int height;

    public void display() {};

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return type.equals(shape.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
