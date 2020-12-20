import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.core.Is.is;

import static org.hamcrest.MatcherAssert.assertThat;

public class Test1 extends Calculator {

    @Test
    public void positiveTestSubtractNumber() {
        Assertions.assertEquals(10, subtract(20, 10));
    }

    @ParameterizedTest
    @CsvSource(value = {"-11, 2", "4,-6", "14,20"})
    public void negativeTestSubtractNumber(int first, int second) {
        Assertions.assertEquals(-1, subtract(first, second));
    }

    @Test
    public void positiveTestMultiplyNumber() {
        assertThat(multiply(4, 2), Matchers.equalTo(8.0));
    }

    @ParameterizedTest
    @CsvSource(value = {"-11, 2", "4,-6", "101,201"})
    public void negativeTestMultiplyNumber(int first, int second) {
        Assertions.assertEquals(-1, subtract(first, second));
    }

    @Test
    public void positiveDivision() {
        Assertions.assertEquals(4, divide(16, 4));
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    public void negativeDivisionTest(int first, int second) {
        Assertions.assertEquals(0, divide(first, second));
    }

    static Stream<Arguments> methodSource() {
        return Stream.of(Arguments.of(-3, 4),
                Arguments.of(4, 25));
    }

    @Test
    public void testWithThrowException() throws DivideByZeroException {
        Assertions.assertThrows(DivideByZeroException.class, () -> divide(2, 0.0));
    }

    @DisplayName("Multiple test using RepeatedTest")
    @RepeatedTest(value = 5, name = "Multiple random operator multiply with another operator")
    public void multipleTest() {
        int firstOperator = (int)(Math.random() * 100);
        int secondOperator = (int)(Math.random() * 100);
        double expResult = (double) firstOperator * secondOperator;
        final double actualResult = Calculator.multiply(firstOperator, secondOperator);

        assertThat("actual result matches expected", actualResult, is(expResult));
    }

}
