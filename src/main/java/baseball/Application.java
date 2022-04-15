package baseball;

import baseball.common.SystemMessage;

public class Application {


   public static void main(String[] args) {
        print(SystemMessage.START_PROGRAM);
        print(SystemMessage.END_PROGRAM);
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
