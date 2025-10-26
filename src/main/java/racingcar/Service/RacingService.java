package racingcar.Service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;

public class RacingService {

    private final RacingGame game;

    public RacingService(List<String> names) {
        RacingValidator.validateNames(names);
        this.game = new RacingGame(new Cars(names));
    }

    public void playOnce() {
        game.playOnce();
    }

    public List<String> renderCars() {
        return game.getCars().getAll()
                .stream()
                .map(Car::renderPosition)
                .collect(Collectors.toList());
    }

    public List<String> getWinnerNames() {
        return game.findWinners()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
