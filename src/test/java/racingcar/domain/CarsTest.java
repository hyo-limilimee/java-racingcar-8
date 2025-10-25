package racingcar.domain;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    void 우승자_계산() {
        Cars cars = new Cars(List.of("pobi", "woni", "jun"));
        cars.getAll().get(0).move(4);
        cars.getAll().get(2).move(4);

        List<Car> winners = cars.findWinners();
        assertThat(winners).extracting(Car::getName)
                .containsExactlyInAnyOrder("pobi", "jun");
    }
}
