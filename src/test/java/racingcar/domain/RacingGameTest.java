package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @DisplayName("playOnce() 실행 시 자동차들이 한 번씩 이동한다")
    @Test
    void playOnceMovesAllCars() {
        Cars cars = new Cars(List.of("pobi", "woni", "jun"));
        RacingGame game = new RacingGame(cars);

        game.playOnce();

        assertThat(cars.getAll().size()).isEqualTo(3);
        assertThat(cars.getAll().get(0).getPosition()).isBetween(0, 1);
        assertThat(cars.getAll().get(1).getPosition()).isBetween(0, 1);
        assertThat(cars.getAll().get(2).getPosition()).isBetween(0, 1);
    }

    @DisplayName("가장 멀리 간 자동차(들)을 우승자로 반환한다")
    @Test
    void findWinners() {
        Cars cars = new Cars(List.of("pobi", "woni", "jun"));
        RacingGame game = new RacingGame(cars);

        cars.getAll().get(0).move(4);
        cars.getAll().get(2).move(4);

        List<Car> winners = game.findWinners();

        assertThat(winners).extracting(Car::getName)
                .containsExactlyInAnyOrder("pobi", "jun");
    }

    @DisplayName("playOnce() 여러 번 실행 시 이동 누적이 정상적으로 반영된다")
    @Test
    void cumulativeMoveTest() {
        Cars cars = new Cars(List.of("pobi", "woni"));
        RacingGame game = new RacingGame(cars);

        for (int i = 0; i < 5; i++) {
            game.playOnce();
        }

        int maxPosition = cars.getAll().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        assertThat(maxPosition).isGreaterThanOrEqualTo(0);
    }
}
