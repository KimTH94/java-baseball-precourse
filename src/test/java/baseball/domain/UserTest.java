package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UserTest {

  @Test
  void 유저_객체_생성() {
      User user = new User();
      String userNumber = "123";
      BallNumber ballNumber = new BallNumber(userNumber);
      user.setBallNumber(ballNumber);
      assertNotNull(user);
      assertNotNull(user.getBallNumber());
  }

}
