package baseball;

import baseball.common.SystemMessage;
import baseball.common.ValidationBallNumberException;
import baseball.domain.BallNumber;
import baseball.domain.Computer;
import baseball.domain.Result;
import baseball.domain.User;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final int RESART = 1;
    private static final int END = 2;

    private static int GAME_STATE = 1;

    private static Computer computer;
    private static User user;

   public static void main(String[] args) {

       print(SystemMessage.START_PROGRAM);

       while(GAME_STATE != END) {

           gameSetting();
           inputUserNumber();
           checkTurn();

           GAME_STATE = END;
       }

        print(SystemMessage.END_PROGRAM);
    }

    private static void gameSetting() {
        computer = new Computer();
        user = new User();

        System.out.println(SystemMessage.START_GAME);
    }

    private static void inputUserNumber() {
       try {
           String userNumber = Console.readLine();
           user.setBallNumber(new BallNumber(userNumber));
       } catch (ValidationBallNumberException e) {
           e.printStackTrace();
        }

    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static void checkTurn() {

       Result result = new Result(computer.getBallNumber(), user.getBallNumber());

       print(result.printHint());

       if(result.strike == 3) {
           finishGame();
       }

    }

    private static void finishGame() {

       print(SystemMessage.USER_WIN);
       print(SystemMessage.GAME_FINISH);

       String gameStatus = Console.readLine();

       if(Integer.parseInt(gameStatus) == 2) {
           GAME_STATE = END;
           return;
       }

       print(SystemMessage.START_GAME);

    }

}
