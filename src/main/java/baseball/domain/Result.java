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
    }

    private void checkStrike() {

        strike = 0;

        for(int index = 0 ; index < BALL_SIZE ; index++) {
            strike += isEqual(computer.getNumberByIndex(index + 1), user.getNumberByIndex(index + 1));
        }

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
