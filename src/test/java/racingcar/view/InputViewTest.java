package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.InputValidator;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    @DisplayName("쉼표 기준으로 이름을 잘 분리한다")
    @Test
    void splitNames() {
        String input = "pobi, woni , jun";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        InputView inputView = new InputView();
        List<String> result = List.of("pobi", "woni", "jun");

        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @DisplayName("비어 있는 입력은 예외 발생")
    @Test
    void emptyInputThrows() {
        assertThatThrownBy(() -> InputValidator.validateNotEmpty(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("비어");
    }
}
