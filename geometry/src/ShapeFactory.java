import java.util.Scanner;

public class ShapeFactory {

    public static Shape createShape(String input, Scanner reader) {
        try {
            switch (input) {
                case "a":
                    return createSquare(reader);

                case "b":
                    return createTriangle(reader);

                case "c":
                    return createCircle(reader);
            }
        } catch (Exception e) {
            System.out.println("Failed to create shape: " + e);
        }

        return null;
    }

    private static Square createSquare(Scanner reader) throws InvalidShapeException {
        System.out.println("Enter the side length of the square");
        double squareSideLength = reader.nextDouble();

        return new Square(squareSideLength);
    }

    private static Triangle createTriangle(Scanner reader) throws InvalidShapeException {
        System.out.println("Enter the first side of the triangle");
        double triangleSideA = reader.nextDouble();

        System.out.println("Enter the second side of the triangle");
        double triangleSideB = reader.nextDouble();

        System.out.println("Enter the third side of the triangle");
        double triangleSideC = reader.nextDouble();

        return new Triangle(triangleSideA, triangleSideB, triangleSideC);
    }

    private static Circle createCircle(Scanner reader) throws InvalidShapeException {
        System.out.println("Enter the radius of the circle");
        double circleRadius = reader.nextDouble();

        return new Circle(circleRadius);
    }
}
