package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarFactory;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    public void start() {
        String carNames = InputView.getCarNames();
        Integer round = InputView.getRound();
        Race race = new Race(CarFactory.makeCars(carNames), round);
        List<Car> cars = race.start();
        OutputView.printCars(cars, race.getRound());
        OutputView.printWinner(race);
    }
}
