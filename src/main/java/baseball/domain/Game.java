package baseball.domain;

import baseball.common.SystemMessage;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    public static final int START = 1;
    public static final int END = 2;

    private Computer computer;
    private User user;

    private int gameState = START;

    public Game() {
        this.prepareNewGame();
    }

    public int getState() {
        return gameState;
    }

    public void prepareNewGame() {
        computer = new Computer();
        user = new User();

        System.out.println(SystemMessage.START_GAME);
    }

    public void inputUserNumber() {
        System.out.println(SystemMessage.INPUT_NUMBER);

        String userNumber = Console.readLine();
        user.setBallNumber(new BallNumber(userNumber));
    }

    public void checkTurn() {
        Result result = new Result(computer.getBallNumber(), user.getBallNumber());
        System.out.println(result.getHintMessages());

        if (3 > result.getStrike()) {
            return;
        }

        finishGame();
    }

    public void finishGame() {
        System.out.println(SystemMessage.USER_WIN);

        System.out.println(SystemMessage.GAME_FINISH);

        String userInputState = Console.readLine();
        if (END == Integer.parseInt(userInputState)) {
            gameState = END;
            return;
        }

        prepareNewGame();
    }
}
