public class InvalidShapeException extends Exception{

    private final static String ERROR_MESSAGE = "Invalid shape";

    public InvalidShapeException() {
        super(ERROR_MESSAGE);
    }
}
