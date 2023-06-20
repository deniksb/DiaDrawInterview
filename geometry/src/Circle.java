public class Circle implements Shape{

    private final double radius;

    public Circle(double radius) throws InvalidShapeException {
        if(!isValidCircle(radius)){
            throw new InvalidShapeException();
        }

        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    private static boolean isValidCircle(final double radius)
    {
        return radius > 0;
    }
}
