package racingcar.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingValidator {

    public static void validateNames(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("자동차는 최소 1대 이상이어야 합니다.");
        }

        Set<String> set = new HashSet<>();
        for (String n : names) {
            if (!set.add(n.trim())) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }
    }

    public static void validateTryCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
