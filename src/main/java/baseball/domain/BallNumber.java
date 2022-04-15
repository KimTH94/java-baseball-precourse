package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

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

    private void printBallNumber() {

        for(int index = 0 ; index < BALL_SIZE ; index++) {
            System.out.print(ballNumber[index] + " ");
        }
        System.out.println();
    }

}
