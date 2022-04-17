package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    void 결과_객체_생성() {
        String ballNumber1 = "123";
        String ballNumber2 = "321";

        BallNumber ball1 = new BallNumber(ballNumber1);
        BallNumber ball2 = new BallNumber(ballNumber2);
        Result result = new Result(ball1, ball2);

        assertTrue(result.ball == 2);
        assertTrue(result.strike == 1);
    }

    @Test
    void 결과_객체_힌트_볼() {
        String ballNumber1 = "123";
        String ballNumber2 = "312";

        BallNumber ball1 = new BallNumber(ballNumber1);
        BallNumber ball2 = new BallNumber(ballNumber2);
        Result result = new Result(ball1, ball2);

        String hintMessages = "3볼";
        assertTrue(hintMessages.equals(result.getHintMessages()));
    }

    @Test
    void 결과_객체_힌트_스크라이크() {
        String ballNumber1 = "123";
        String ballNumber2 = "124";

        BallNumber ball1 = new BallNumber(ballNumber1);
        BallNumber ball2 = new BallNumber(ballNumber2);
        Result result = new Result(ball1, ball2);

        String hintMessages = "2스트라이크";
        assertTrue(hintMessages.equals(result.getHintMessages()));
    }

    @Test
    void 결과_객체_힌트_볼_스트라이크() {
        String ballNumber1 = "123";
        String ballNumber2 = "321";

        BallNumber ball1 = new BallNumber(ballNumber1);
        BallNumber ball2 = new BallNumber(ballNumber2);
        Result result = new Result(ball1, ball2);

        String hintMessages = "2볼 1스트라이크";
        assertTrue(hintMessages.equals(result.getHintMessages()));
    }

    @Test
    void 결과_객체_힌트_낫싱() {
        String ballNumber1 = "123";
        String ballNumber2 = "456";

        BallNumber ball1 = new BallNumber(ballNumber1);
        BallNumber ball2 = new BallNumber(ballNumber2);
        Result result = new Result(ball1, ball2);

        String hintMessages = "낫싱";
        assertTrue(hintMessages.equals(result.getHintMessages()));
  }

}
