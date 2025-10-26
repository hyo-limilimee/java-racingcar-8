package racingcar.controller;

import java.util.List;
import racingcar.service.RacingService;
import racingcar.service.RacingValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        try {
            List<String> names = inputView.readCarNames();
            int tryCount = inputView.readTryCount();
            RacingValidator.validateTryCount(tryCount);

            RacingService service = new RacingService(names);
            outputView.printResultTitle();

            for (int i = 0; i < tryCount; i++) {
                service.playOnce();
                outputView.printRound(service.renderCars());
            }

            outputView.printWinners(service.getWinnerNames());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }
}
