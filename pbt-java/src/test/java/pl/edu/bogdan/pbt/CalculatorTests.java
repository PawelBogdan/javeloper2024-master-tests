package pl.edu.bogdan.pbt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTests {
    @Test
    public void addingShouldWOrkCorrectly() {
        // given
        Calculator beforeAdding = new Calculator(1);

        // when
        Calculator afterAdding = beforeAdding.add(2);

        // then
        assertEquals(3, afterAdding.getCurrentValue());
    }
}