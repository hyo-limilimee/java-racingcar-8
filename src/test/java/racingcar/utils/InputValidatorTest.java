package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class InputValidatorTest {

    @DisplayName("입력이 비어 있으면 예외 발생")
    @Test
    void validateNotEmpty_blankInput() {
        assertThatThrownBy(() -> InputValidator.validateNotEmpty(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("비어");
    }

    @DisplayName("입력이 null이면 예외 발생")
    @Test
    void validateNotEmpty_nullInput() {
        assertThatThrownBy(() -> InputValidator.validateNotEmpty(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("비어");
    }

    @DisplayName("숫자가 아닌 입력이면 예외 발생")
    @Test
    void validateNumeric_nonDigit() {
        assertThatThrownBy(() -> InputValidator.validateNumeric("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자");
    }

    @DisplayName("올바른 입력일 경우 예외가 발생하지 않는다")
    @Test
    void validateNumeric_success() {
        assertThatCode(() -> InputValidator.validateNumeric("123"))
                .doesNotThrowAnyException();
    }
}
