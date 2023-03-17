import java.util.Scanner;

public class Calculator {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double number1 = getDouble();
        double number2 = getDouble();
        char operation = getOperation();
        double result = calculate(number1, number2, operation);
        System.out.println("Результат операции: " + result);
    }

    public static double getDouble() {
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

    public static char getOperation() {
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

    public static double calculate(double number1, double number2, char operation) {
        double result;
        switch (operation) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                if (number2 == 0) {
                    System.out.println("Делить на ноль нельзя !");
                    throw new ArithmeticException("Cannot divide by zero");
                }
                result = number1 / number2;
                break;
            default:
                System.out.println("Неверная операция ! Повторите ввод");
                result = calculate(number1, number2, getOperation());
        }
        return result;
    }
}
