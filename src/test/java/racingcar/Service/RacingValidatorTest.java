package racingcar.Service;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingValidatorTest {

    @DisplayName("자동차 이름이 중복되면 예외가 발생한다")
    @Test
    void duplicateNamesThrows() {
        assertThatThrownBy(() -> RacingValidator.validateNames(List.of("pobi", "pobi")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @DisplayName("자동차 이름 목록이 비어 있으면 예외 발생")
    @Test
    void emptyNameListThrows() {
        assertThatThrownBy(() -> RacingValidator.validateNames(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최소");
    }

    @DisplayName("시도 횟수가 0 이하이면 예외 발생")
    @Test
    void invalidTryCountThrows() {
        assertThatThrownBy(() -> RacingValidator.validateTryCount(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상");
    }

    @DisplayName("정상 입력일 경우 예외가 발생하지 않는다")
    @Test
    void validInputsPass() {
        assertThatCode(() -> {
            RacingValidator.validateNames(List.of("pobi", "woni"));
            RacingValidator.validateTryCount(3);
        }).doesNotThrowAnyException();
    }
}
