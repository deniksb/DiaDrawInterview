public class Triangle implements Shape{

    private final double sideA;

    private final double sideB;

    private final double sideC;

    public Triangle(double sideA, double sideB, double sideC) throws InvalidShapeException {
        if(!isValidTriangle(sideA, sideB, sideC)) {
            throw new InvalidShapeException();
        }

        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double calculateArea() {
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    public static boolean isValidTriangle(double sideA, double sideB, double sideC)
    {
        if(sideA <= 0 || sideB <= 0 || sideC <= 0)
        {
            return false;
        }

        return sideA + sideB > sideC && sideB + sideC > sideA && sideC + sideA > sideB;
    }
}
