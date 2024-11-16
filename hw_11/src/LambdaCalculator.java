//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class LambdaCalculator {

    @FunctionalInterface
    public interface MathOperation {
        double operate(double a, double b);
    }

    // Метод для виконання операцій
    public double calculate(MathOperation operation, double a, double b) {
        return operation.operate(a, b);
    }

    public static void main(String[] args) {
        // Створення екземпляра класу LambdaCalculator
        LambdaCalculator calculator = new LambdaCalculator();

        // Лямбда-вирази для базових математичних операцій:
        MathOperation addition = (a, b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = (a, b) -> a * b;
        MathOperation division = (a, b) -> b != 0 ? a / b : Double.NaN; // Ділення з перевіркою на 0

        // Демонстрація роботи лямбда-виразів
        double num1 = 10;
        double num2 = 5;

        System.out.println("Addition: " + calculator.calculate(addition, num1, num2));
        System.out.println("Subtraction: " + calculator.calculate(subtraction, num1, num2));
        System.out.println("Multiplication: " + calculator.calculate(multiplication, num1, num2));
        System.out.println("Division: " + calculator.calculate(division, num1, num2));
    }
}
