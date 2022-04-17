package baseball.domain;

public class Computer {

    protected BallNumber ballNumber;

    public Computer() {
        this.ballNumber = new BallNumber();
    }

    public BallNumber getBallNumber() {
        return this.ballNumber;
    }
}
