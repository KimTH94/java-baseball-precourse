package baseball.domain;

import static baseball.domain.BallNumber.BALL_SIZE;

public class Result {

    private final BallNumber computer;
    private final BallNumber user;
    private final boolean userWin = false;
    public int strike = 0;
    public int ball = 0;

    public Result(BallNumber computer, BallNumber user) {
        this.computer = computer;
        this.user = user;
        reSetResult();
        checkStrike();
        checkBall();
    }

    private void reSetResult() {
        strike = 0;
        ball = 0;
    }

    public int getStrike() {
        return this.strike;
    }

    private void checkStrike() {
        for(int index = 0; index < BALL_SIZE; index++) {
            strike += isEqual(computer.getNumberByIndex(index + 1), user.getNumberByIndex(index + 1));
        }
    }

    private void checkBall() {
        for(int index = 0; index < BALL_SIZE; index++) {
            ball += checkBallNumber(computer.getNumberByIndex(index + 1), index + 1);
        }
    }

    private int checkBallNumber(int value, int index) {
        int ballCount = 0;

        for(int next = index; next < BALL_SIZE; next++) {
            ballCount += isEqual(value, user.getNumberByIndex(next + 1));
        }

        for(int before = 0; before < index - 1; before++) {
            ballCount += isEqual(value, user.getNumberByIndex(before + 1));
        }

        return ballCount;
    }

    private int isEqual(int value1, int value2) {
        if (value1 == value2) {
            return 1;
        }

        return 0;
    }

    public String getHintMessages() {
        String hint = "";

        if (0 != ball && 0 != strike) {
            hint += ball + "볼 " + strike + "스트라이크";
        }

        if (0 != ball && 0 == strike) {
            hint += ball + "볼";
        }

        if (0 == ball && 0 != strike) {
            hint += strike + "스트라이크";
        }

        if (0 == ball && 0 == strike) {
            hint += "낫싱";
        }

        return hint;
    }

}
