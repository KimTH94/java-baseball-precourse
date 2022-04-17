package baseball.domain;

import static baseball.domain.BallNumber.BALL_SIZE;
import static baseball.domain.BallNumber.MAX_VALUE;
import static baseball.domain.BallNumber.MIN_VALUE;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class BallNumberTest extends NsTest  {

    @Test
    void 컴퓨터_볼_객채_생성() {
        boolean[] check = new boolean[MAX_VALUE];
        BallNumber ballNumber = new BallNumber();

        for(int index = 0; index < BALL_SIZE; index++) {
            int value = ballNumber.getNumberByIndex(index + 1);
            assertTrue(MIN_VALUE <= value && value <= MAX_VALUE);
            assertTrue(!check[value - 1]);
            check[value - 1] = true;
        }
    }

    @Test
    void 유저_볼_객체_생성() {
        String userNumber = "123";
        boolean[] check = new boolean[MAX_VALUE];
        BallNumber ballNumber = new BallNumber(userNumber);

        for(int index = 0; index < BALL_SIZE; index++) {
            int value = ballNumber.getNumberByIndex(index + 1);
            assertTrue(MIN_VALUE <= value && value <= MAX_VALUE);
            assertTrue(!check[value - 1]);
            check[value - 1] = true;
        }
    }

    @Test
    void 숫자_정합성_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("ㄱㄴㄷ"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복_정합성_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("111"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사이즈_정합성_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1234"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 볼_객체_숫자_가져오기() {
        String userNumber = "123";
        BallNumber ballNumber = new BallNumber(userNumber);

        assertTrue(1 == ballNumber.getNumberByIndex(1));
        assertTrue(2 == ballNumber.getNumberByIndex(2));
        assertTrue(3 == ballNumber.getNumberByIndex(3));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }


}
