package racingcar.domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int position = 0;

    private static final String ERROR_CAR_NAME_EMPTY = "자동차 이름은 비어 있을 수 없습니다.";
    private static final String ERROR_CAR_NAME_LENGTH = "자동차 이름은 5자 이하여야 합니다.";

    public Car(String name) {
        validateName(name);
        this.name = name.trim();
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_EMPTY);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_LENGTH);
        }
    }

    public void move(int randomValue) {
        if (randomValue >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String renderPosition() {
        return name + " : " + "-".repeat(position);
    }
}


