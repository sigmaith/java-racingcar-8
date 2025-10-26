package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Race;

public class OutputView {
    public static void printCars(List<Car> cars, int round) {
        System.out.println("\n실행 결과");
        for (int r = 1; r <= round; r++) {
            for (Car car : cars) {
                System.out.println(car.getResultOf(r));
            }
            System.out.println();
        }
    }

    public static void printWinner(Race race) {
        List<Car> winners = race.getWinner();
        List<String> winnerNames = winners.stream().map(Car::getName).toList();
        System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
    }
}
