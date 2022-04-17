package baseball.common;

public class ValidationBallNumberException extends IllegalArgumentException {

    public ValidationBallNumberException(String message) {
        System.out.println(message);
        System.exit(0);
    }

}
