package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RacingGame {
    private final Cars cars;

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public void playOnce() {
        for (Car car : cars.getAll()) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            car.move(randomValue);
        }
    }

    public Cars getCars() {
        return cars;
    }

    public List<Car> findWinners() {
        return cars.findWinners();
    }
}
