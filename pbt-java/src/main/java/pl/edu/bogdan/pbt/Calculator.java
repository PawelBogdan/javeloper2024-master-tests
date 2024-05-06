package pl.edu.bogdan.pbt;

public class Calculator {
    private final int value;

    public Calculator(int value) {
        this.value = value;
    }

    public Calculator add(int other) {
        return new Calculator(value + other);
    }

    public Calculator sub(int other) {
        return new Calculator(value - other);
    }

    public Calculator mul(int other) {
        return new Calculator(value * other);
    }

    public Calculator div(int other) {
        return new Calculator(value / other);
    }

    public int getCurrentValue() {
        return value;
    }
}
