package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.utils.InputValidator;

public class InputView {
    private static final String INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_CNT = "시도할 횟수는 몇 회인가요?";

    public List<String> readCarNames() {
        System.out.println(INPUT_MESSAGE);
        String input = Console.readLine();
        InputValidator.validateNotEmpty(input);
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();
    }

    public int readTryCount() {
        System.out.println(INPUT_TRY_CNT);
        String input = Console.readLine();
        InputValidator.validateNotEmpty(input);
        InputValidator.validateNumeric(input);
        return Integer.parseInt(input);
    }
}
