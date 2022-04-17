package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class ComputerTest {

    @Test
    void 컴퓨터_객체_생성() {
        Computer computer = new Computer();
        assertNotNull(computer);
    }

    @Test
    void 컴퓨터_객체_숫자_생성() {
        Computer computer = new Computer();
        assertNotNull(computer.getBallNumber());
    }

}
