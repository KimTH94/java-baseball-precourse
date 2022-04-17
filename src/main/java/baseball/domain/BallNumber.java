package baseball.domain;

import baseball.common.SystemMessage;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.regex.Pattern;

public class BallNumber {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;
    public static final int BALL_SIZE = 3;

    private final int[] ballNumber;
    private final boolean[] check;

    public BallNumber() {
        this.ballNumber = new int[BALL_SIZE];
        this.check = new boolean[MAX_VALUE];

        for (int index = 0; index < BALL_SIZE; index++) {
            ballNumber[index] = inputComputerBallNumber();
            check[ballNumber[index] - 1] = true;
        }
    }

    public BallNumber(String userBallNumber) {
        this.ballNumber = new int[BALL_SIZE];
        this.check = new boolean[MAX_VALUE];

        sizeValidation(userBallNumber);

        for (int index = 0; index < BALL_SIZE; index++) {
            rangeValidation(String.valueOf(userBallNumber.charAt(index)));
            numberValidation(String.valueOf(userBallNumber.charAt(index)));

            ballNumber[index] = (int) userBallNumber.charAt(index) - '0';
        }

        duplicateValidation();
    }

    private int inputComputerBallNumber() {
        int input = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
        while (check[input - 1]) {
            input = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
        }

        return input;
    }

    private void numberValidation(String value) {
        if (!Pattern.matches("^[0-9]*$", value)) {
            throw new IllegalArgumentException(SystemMessage.NUMBER_EXCEPTION);
        }
    }

    private void duplicateValidation() {
        for (int index = 0; index < BALL_SIZE; index++) {
            deplicateValue(ballNumber[index]);
        }
    }

    private void deplicateValue(int value) {
        if (check[value - 1]) {
            throw new IllegalArgumentException(SystemMessage.DUPLICATE_EXCEPTION);
        } else {
            check[value - 1] = true;
        }
    }

    private void sizeValidation(String value) {
        if (BALL_SIZE < value.length()) {
            throw new IllegalArgumentException(SystemMessage.SIZE_EXCEPTION);
        }
    }

    private void rangeValidation(String value) {
        if (MIN_VALUE > Integer.parseInt(value) || MAX_VALUE < Integer.parseInt(value)) {
            throw new IllegalArgumentException(SystemMessage.RANGE_EXCEPTION);
        }
    }

    public int getNumberByIndex(int index) {
        return ballNumber[index - 1];
    }

}
