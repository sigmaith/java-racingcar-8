package racingcar.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Race {

    private List<Car> cars;
    private int round;

    public Race(List<Car> cars, int round) {
        this.cars = cars;
        validate(round);
        this.round = round;
    }

    private void validate(int round) {
        if (round < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상으로 입력해주세요.");
        }
    }

    public Integer getRound() {
        return round;
    }

    public List<Car> start() {
        for (int r = 1; r <= round; r++) {
            raceRound(r);
        }
        return cars;
    }

    private void raceRound(int round) {
        for (Car car : cars) {
            car.moveForward(round);
        }
    }

    public List<Car> getWinner() {
        List<Car> winners = new ArrayList<>();
        int maxDist = -1;
        for (Car car : cars) {
            Integer dist = car.getDistanceOf(round);
            if (dist > maxDist) {
                maxDist = dist;
            }
        }

        for (Car car : cars) {
            if (car.getDistanceOf(round) == maxDist) {
                winners.add(car);
            }
        }

        return winners;
    }
}
