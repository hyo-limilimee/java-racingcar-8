package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String OUT_PRINT = "실행 결과";

    public void printResultTitle() {
        System.out.println(OUT_PRINT);
        System.out.println();
    }

    public void printRound(List<String> results) {
        for (String r : results) {
            System.out.println(r);
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public void printError(String message) {
        System.out.println("[ERROR] " + message);
    }
}
