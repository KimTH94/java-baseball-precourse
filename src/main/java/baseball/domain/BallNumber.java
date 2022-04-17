package baseball.domain;

import baseball.common.SystemMessage;
import baseball.common.ValidationBallNumberException;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.regex.Pattern;

public class BallNumber {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;
    public static final int BALL_SIZE = 3;

    private int[] ballNumber;
    private boolean[] check;

    public BallNumber() {

        this.ballNumber = new int[BALL_SIZE];
        this.check = new boolean[MAX_VALUE];

        for(int index = 0 ; index < BALL_SIZE ; index++) {
            ballNumber[index] = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
        }

        printBallNumber();

    }

    public BallNumber(String userBallNumber) {

        sizeValidation(userBallNumber);

        this.ballNumber = new int[BALL_SIZE];

        for(int index = 0 ; index < BALL_SIZE ; index++) {
            rangeValidation(String.valueOf(userBallNumber.charAt(index)));
            numberValidation(String.valueOf(userBallNumber.charAt(index)));

            ballNumber[index] = (int) userBallNumber.charAt(index) - '0';
        }

        duplicateValidation();

        printBallNumber();

    }

    private void numberValidation(String value) {

        if(!Pattern.matches("^[0-9]*$", value)) {
            throw new ValidationBallNumberException(SystemMessage.NUMBER_EXCEPTION);
        }

    }

    private void duplicateValidation() {

        for(int index = 0 ; index < BALL_SIZE ; index++) {
            deplicateValue(index + 1, ballNumber[index]);
        }

    }

    private void deplicateValue(int startIndex, int value) {

        for(int index = startIndex ; index < BALL_SIZE ; index++) {
            isEqual(ballNumber[index], value);
        }

    }

    private void isEqual(int param1, int param2) {

        if(param1 == param2) {
            throw new ValidationBallNumberException(SystemMessage.DUPLICATE_EXCEPTION);
        }

    }

    private void sizeValidation(String value) {
        if(BALL_SIZE != value.length()) {
            throw new ValidationBallNumberException(SystemMessage.SIZE_EXCEPTION);
        }
    }

    private void rangeValidation(String value) {

        if(MIN_VALUE > Integer.parseInt(value) || MAX_VALUE < Integer.parseInt(value)) {
            throw new ValidationBallNumberException(SystemMessage.RANGE_EXCEPTION);
        }
    }

    public int getNumberByIndex(int index) {
        return ballNumber[index - 1];
    }

    private void printBallNumber() {

        for(int index = 0 ; index < BALL_SIZE ; index++) {
            System.out.print(ballNumber[index] + " ");
        }
        System.out.println();

    }

}
