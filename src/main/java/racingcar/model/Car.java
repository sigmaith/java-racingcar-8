package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public class Car {
    private String name;
    private Map<Integer, Integer> record;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.record = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("이름은 1글자 이상 5글자 이하 입니다.");
        }
    }

    public void moveForward(int round) {
        Integer prev = record.getOrDefault(round - 1, 0);
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            record.put(round, prev + 1);
            return;
        }
        record.put(round, prev);
    }

    public String getResultOf(int round) {
        return name + " : " + "-".repeat(getDistanceOf(round));
    }

    public Integer getDistanceOf(int round) {
        return record.get(round);
    }
}
