package baseball;

import baseball.common.SystemMessage;
import baseball.domain.Game;

public class Application {

    public static void main(String[] args) {

        System.out.println(SystemMessage.START_PROGRAM);

        Game game = new Game();

        while (game.getState() != Game.END) {
            game.inputUserNumber();
            game.checkTurn();
        }

        System.out.println(SystemMessage.END_PROGRAM);
    }
}
