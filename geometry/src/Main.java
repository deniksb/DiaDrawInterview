import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

            final Scanner reader = new Scanner(System.in);

            System.out.println("Choose a shape: \n a.Square \n b.Triangle \n c.Circle");

            final String input = reader.nextLine();

            final Shape shape = ShapeFactory.createShape(input, reader);

            if (shape == null)
            {
                System.out.println("Invalid input. Please follow the steps written on the screen. ");

                return;
            }

            System.out.println("Perimeter: " + shape.calculatePerimeter());
            System.out.println("Area: " + shape.calculateArea());
    }
}