package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingControllerTest {

    private InputView inputView;
    private OutputView outputView;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        inputView = new InputView() {
            @Override
            public List<String> readCarNames() {
                return List.of("pobi", "woni");
            }

            @Override
            public int readTryCount() {
                return 2;
            }
        };

        outputView = new OutputView();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @DisplayName("입력된 자동차 이름과 시도 횟수로 전체 경주 흐름이 정상 실행된다")
    @Test
    void runControllerFlow() {
        RacingController controller = new RacingController(inputView, outputView);
        controller.run();

        String output = outContent.toString();

        assertThat(output).contains("실행 결과");
        assertThat(output).contains("pobi");
        assertThat(output).contains("woni");
        assertThat(output).contains("최종 우승자");
    }

    @DisplayName("입력 검증 실패 시 IllegalArgumentException이 발생한다")
    @Test
    void invalidInputThrowsException() {
        InputView invalidInputView = new InputView() {
            @Override
            public List<String> readCarNames() {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }

            @Override
            public int readTryCount() {
                return 1;
            }
        };

        OutputView outputView = new OutputView();
        RacingController controller = new RacingController(invalidInputView, outputView);

        assertThatThrownBy(controller::run)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 입력");
    }

    @DisplayName("시도 횟수가 1 이상일 때만 반복 실행된다")
    @Test
    void tryCountIsPositive() {
        InputView customInputView = new InputView() {
            @Override
            public List<String> readCarNames() {
                return List.of("pobi", "woni");
            }

            @Override
            public int readTryCount() {
                return 3;
            }
        };

        RacingController controller = new RacingController(customInputView, outputView);
        controller.run();

        String output = outContent.toString();
        long count = output.lines().filter(line -> line.contains(":")).count();
        assertThat(count).isGreaterThan(0);
    }
}
