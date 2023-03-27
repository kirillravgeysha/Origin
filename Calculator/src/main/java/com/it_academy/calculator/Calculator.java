package com.it_academy.calculator;

import java.util.Scanner;

public class Calculator {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        double number1 = calculator.getDouble();
        double number2 = calculator.getDouble();
        char operation = calculator.getOperation();
        double result = calculator.calculate(number1, number2, operation);
        System.out.println("Результат операции: " + result);
    }

    public double getDouble() {
        System.out.println("Введите число:");
        double num;
        if (scanner.hasNextDouble()) {
            num = scanner.nextDouble();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();
            num = getDouble();
        }
        return num;
    }

    public char getOperation() {
        System.out.println("Введите операцию:");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    public double addition(double number1, double number2) {
        return number1 + number2;
    }

    public double subtraction(double number1, double number2) {
        return number1 - number2;
    }

    public double multiplication(double number1, double number2) {
        return number1 * number2;
    }

    public double division(double number1, double number2) {
        if (number2 == 0) {
            System.out.println("Делить на ноль нельзя !");
            throw new ArithmeticException("Cannot divide by zero");
        }
        return number1 / number2;
    }

    public double calculate(double number1, double number2, char operation) {
        double result;
        switch (operation) {
            case '+':
                result = addition(number1, number2);
                break;
            case '-':
                result = subtraction(number1, number2);
                break;
            case '*':
                result = multiplication(number1, number2);
                break;
            case '/':
                result = division(number1, number2);
                break;
            default:
                System.out.println("Неверная операция ! Повторите ввод");
                result = calculate(number1, number2, getOperation());
        }
        return result;
    }
}
