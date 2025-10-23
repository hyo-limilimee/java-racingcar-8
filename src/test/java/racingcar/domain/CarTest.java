package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class CarTest {

    @DisplayName("자동차 이름이 5자를 초과하면 예외 발생")
    @Test
    void invalidNameLength() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이름이 비어 있으면 예외 발생")
    @Test
    void blankName() {
        assertThatThrownBy(() -> new Car(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("랜덤 값이 4 이상이면 전진한다")
    @Test
    void moveSuccess() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("랜덤 값이 3 이하면 멈춘다")
    @Test
    void moveFail() {
        Car car = new Car("pobi");
        car.move(3);
        assertThat(car.getPosition()).isZero();
    }
}
