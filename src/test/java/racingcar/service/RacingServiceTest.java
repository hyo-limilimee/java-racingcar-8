package racingcar.service;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class RacingServiceTest {

    @DisplayName("시도 횟수만큼 playOnce()가 반복된다")
    @Test
    void playOnceRepeated() {
        RacingService service = new RacingService(List.of("pobi", "woni"));

        for (int i = 0; i < 5; i++) {
            service.playOnce();
        }

        List<String> renders = service.renderCars();
        assertThat(renders).hasSize(2);
        assertThat(renders.get(0)).contains("pobi");
    }

    @DisplayName("우승자 목록을 반환한다")
    @Test
    void getWinnerNames() {
        RacingService service = new RacingService(List.of("pobi", "woni", "jun"));

        for (int i = 0; i < 5; i++) {
            service.playOnce();
        }

        List<String> winners = service.getWinnerNames();
        assertThat(winners).isNotEmpty();
        assertThat(winners.size()).isBetween(1, 3);
    }

    @DisplayName("자동차 이름이 비어 있으면 예외 발생")
    @Test
    void invalidNamesThrows() {
        assertThatThrownBy(() -> new RacingService(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최소");
    }
}
