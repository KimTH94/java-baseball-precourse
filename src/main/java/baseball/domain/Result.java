package baseball.domain;

import static baseball.domain.BallNumber.BALL_SIZE;

public class Result {

    private BallNumber computer;
    private BallNumber user;
    public int strike = 0;
    public int ball = 0;

    private boolean userWin = false;

    public Result(BallNumber computer, BallNumber user) {
        this.computer = computer;
        this.user = user;
        checkStrike();
        checkBall();
    }

    private void checkStrike() {

        strike = 0;

        for(int index = 0 ; index < BALL_SIZE ; index++) {
            strike += isEqual(computer.getNumberByIndex(index + 1), user.getNumberByIndex(index + 1));
        }

    }

    private void checkBall() {

        ball = 0;

        for(int index = 0 ; index < BALL_SIZE ; index++) {
            ball += checkBallNumber(computer.getNumberByIndex(index + 1), index + 1);
        }

    }

    private int checkBallNumber(int value, int index) {

        int ballCount = 0;

        for(int next = index ; next < BALL_SIZE ; next++) {
            ballCount += isEqual(value, user.getNumberByIndex(next + 1));
        }

        for(int before = 0 ; before < index - 1 ; before++) {
            ballCount += isEqual(value, user.getNumberByIndex(before + 1));
        }

        return ballCount;
    }

    private int isEqual(int value1, int value2) {

        if(value1 == value2) {
            return 1;
        }

        return 0;

    }

    public String printHint() {

        String hint = "";

        if(ball != 0 && strike != 0) {
            hint += ball + "볼 " + strike + "스트라이크";
        }

        if(ball != 0 && strike == 0) {
            hint += ball + "볼";
        }

        if(ball == 0 && strike != 0) {
            hint += strike + "스트라이크";
        }

        if(ball == 0 && strike == 0) {
            hint += "낫싱";
        }

        return hint;

    }

}
