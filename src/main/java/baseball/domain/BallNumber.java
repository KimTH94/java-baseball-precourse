package baseball.domain;

import baseball.common.SystemMessage;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.regex.Pattern;

public class BallNumber {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;
    public static final int BALL_SIZE = 3;

    private int[] ballNumber;

    public BallNumber() {

        this.ballNumber = new int[BALL_SIZE];

        for(int index = 0 ; index < BALL_SIZE ; index++) {
            ballNumber[index] = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
        }

        printBallNumber();

    }

    public BallNumber(String userBallNumber) {

        sizeValidation(userBallNumber);

        this.ballNumber = new int[BALL_SIZE];

        for(int index = 0 ; index < BALL_SIZE ; index++) {
            numberValidation(String.valueOf(userBallNumber.charAt(index)));
            ballNumber[index] = (int) userBallNumber.charAt(index) - '0';
        }

        duplicateValidation();

        printBallNumber();

    }

    private void numberValidation(String value) {

        if(!Pattern.matches("^[0-9]*$", value)) {
            throw new IllegalArgumentException(SystemMessage.NUMBER_EXCEPTION);
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
            throw new IllegalArgumentException(SystemMessage.DUPLICATE_EXCEPTION);
        }

    }

    private void sizeValidation(String value) {
        if(BALL_SIZE != value.length()) {
            throw new IllegalArgumentException(SystemMessage.SIZE_EXCEPTION);
        }
    }

    private void printBallNumber() {

        for(int index = 0 ; index < BALL_SIZE ; index++) {
            System.out.print(ballNumber[index] + " ");
        }
        System.out.println();

    }

}
