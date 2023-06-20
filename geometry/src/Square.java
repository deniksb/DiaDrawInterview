
public class Square implements Shape{

    private final double sideLength;

    public Square(double sideLength) throws InvalidShapeException {
        if(!isValidSquare(sideLength)) {
            throw new InvalidShapeException();
        }
        this.sideLength = sideLength;
    }

    @Override
    public double calculateArea() {
        return sideLength * sideLength;
    }

    @Override
    public double calculatePerimeter() {
        return sideLength * 4;
    }

    private static boolean isValidSquare(final double sideLength)
    {
        return sideLength > 0;
    }
}
