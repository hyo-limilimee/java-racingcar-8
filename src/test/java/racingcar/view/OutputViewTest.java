package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    @DisplayName("한 라운드 결과 출력 포맷이 올바르게 표시된다")
    @Test
    void printRoundFormat() {
        OutputView view = new OutputView();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        view.printRound(List.of("pobi : --", "woni : ---"));
        String output = out.toString().trim();

        assertThat(output).contains("pobi : --", "woni : ---");
    }

    @DisplayName("우승자 출력 형식이 올바르다")
    @Test
    void printWinnersFormat() {
        OutputView view = new OutputView();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        view.printWinners(List.of("pobi", "jun"));
        String output = out.toString().trim();

        assertThat(output).isEqualTo("최종 우승자 : pobi, jun");
    }

    @DisplayName("에러 메시지는 [ERROR]로 시작한다")
    @Test
    void printErrorFormat() {
        OutputView view = new OutputView();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        view.printError("잘못된 입력입니다.");
        String output = out.toString().trim();

        assertThat(output).startsWith("[ERROR]");
    }
}
