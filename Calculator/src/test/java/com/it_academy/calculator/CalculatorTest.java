package com.it_academy.calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    private static Calculator calculator;

    @BeforeAll
    public static void setUP() throws Exception {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource({"1.0, 2.0, 3.0", "-1.0, -2.0, -3.0", "0, 1.0, 1.0", "1.0, -2.0, -1.0"})
    public void testDoubleValuesAddition(double number1, double number2, double expectedResult) {
//        assertEquals(expectedResult, calculator.addition(number1, number2));
        assertThat(calculator.addition(number1, number2)).as("Addition result").isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({"1.0, 2.0, -1.0", "1.0, -2.0, 3.0", "0, 1.0, -1.0", "-1.0, 2.0, -3.0", "-1.0, -2.0, 1.0"})
    public void testDoubleValuesSubtraction(double number1, double number2, double expectedResult) {
//        assertEquals(expectedResult, calculator.substraction(number1, number2));
        assertThat(calculator.subtraction(number1, number2)).as("Subtraction result").isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({"1.0, 2.0, 2.0", "-1.0, -2.0, 2.0", "0, 1.0, 0", "1.0, -2.0, -2.0"})
    public void testDoubleValuesMultiplication(double number1, double number2, double expectedResult) {
//        assertEquals(expectedResult, calculator.multiplication(number1, number2));
        assertThat(calculator.multiplication(number1, number2)).as("Multiplication result").isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({"1.0, 2.0, 0.5", "1.0, -2.0, -0.5", "0, 1.0, 0", "-1.0, -2.0, 0.5"})
    public void testDoubleValuesDivision(double number1, double number2, double expectedResult) {
//        assertEquals(expectedResult, calculator.division(number1, number2));
        assertThat(calculator.division(number1, number2)).as("Division result").isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({"1.0, 2.0, '+', 3.0", "1.0, -2.0, '-', 3.0", "0, 1.0, '*', 0", "-1.0, -2.0, '/', 0.5"})
    public void testCalculate(double number1, double number2, char operation, double expectedResult) {
//        assertEquals(expectedResult, calculator.calculate(number1, number2, operation));
        assertThat(calculator.calculate(number1, number2, operation)).as("Calculation result").isEqualTo(expectedResult);
    }

    @Test
    void testDivisionByZero() {
        Throwable exception = assertThrows(ArithmeticException.class, () -> calculator.division(1, 0));
//        assertEquals("Cannot divide by zero", exception.getMessage());
        assertThat(exception.getMessage()).as("Exception message").isEqualTo("Cannot divide by zero");
    }


}
