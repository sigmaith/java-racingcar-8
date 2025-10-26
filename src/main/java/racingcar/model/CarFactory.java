package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarFactory {
    public static List<Car> makeCars(String input) {
        String[] names = input.split(",");
        return Arrays.stream(names).map(Car::new).toList();
    }
}
