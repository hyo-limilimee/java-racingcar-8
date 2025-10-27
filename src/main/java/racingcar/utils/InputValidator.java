package racingcar.utils;

public class InputValidator {
    private static final String ERROR_INPUT_EMPTY = "입력은 비어 있을 수 없습니다.";
    private static final String ERROR_INPUT_NUM = "숫자만 입력 가능합니다.";

    public static void validateNotEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ERROR_INPUT_EMPTY);
        }
    }

    public static void validateNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ERROR_INPUT_NUM);
        }
    }
}
