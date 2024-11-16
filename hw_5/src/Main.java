import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//1
//        // Запитуємо у користувача перше число
//        System.out.print("Введіть перше число: ");
//        double num1 = scanner.nextDouble();
//
//        // Запитуємо у користувача друге число
//        System.out.print("Введіть друге число: ");
//        double num2 = scanner.nextDouble();
//
//        // Викликаємо функцію для обчислення кореня квадратного з суми квадратів
//        double result = calculateSquareRootOfSumOfSquares(num1, num2);
//
//        // Виводимо результат
//        System.out.println("Корінь квадратний з суми квадратів чисел: " + result);

        //2
        //processInputAndCalculateMinMax();

        //3
        // Запитуємо у користувача введення числа
        System.out.print("Введіть додатнє ціле число: ");
        int n = scanner.nextInt();

        // Перевіряємо, чи введене число є додатнім
        if (n <= 0) {
            System.out.println("Число повинно бути додатнім!");
            return;
        }

        // Викликаємо функцію для обчислення та виведення послідовності Коллатца
        int steps = collatzSequence(n);

        // Виводимо кількість кроків
        System.out.println("Кількість кроків: " + steps);

    }

    public static double calculateSquareRootOfSumOfSquares(double num1, double num2) {
        // Обчислюємо суму квадратів чисел
        double sumOfSquares = (num1 * num1) + (num2 * num2);

        // Повертаємо корінь квадратний з суми квадратів
        return Math.sqrt(sumOfSquares);
    }

    public static void processInputAndCalculateMinMax() {
        Scanner scanner = new Scanner(System.in);

        // Змінні для збереження найбільшого та найменшого числа
        Integer min = null;
        Integer max = null;

        // Початок циклу з введення чисел
        System.out.println("Введіть числа (для завершення введіть 0):");

        while (true) {
            String input = scanner.nextLine().trim();  // Зчитуємо ввід як рядок і обрізаємо пробіли

            // Перевіряємо, чи введено "stop" для завершення
            if (input.equalsIgnoreCase("stop")) {
                System.out.println("Введення завершено.");
                break;
            }

            // Перевіряємо, чи є це число
            try {
                int num = Integer.parseInt(input); // Пробуємо конвертувати рядок у ціле число

                if (num == 0) {
                    break;  // Якщо введено 0, виходимо з циклу
                }

                // Визначаємо найменше і найбільше число
                if (min == null || num < min) {
                    min = num;
                }
                if (max == null || num > max) {
                    max = num;
                }

            } catch (NumberFormatException e) {
                System.out.println("Будь ласка, введіть ціле число або 'stop' для завершення.");
            }
        }

        // Після завершення введення
        if (min == null && max == null) {
            System.out.println("Числа не було введено.");
        } else if (min.equals(max)) {
            System.out.println("Введене єдине число: " + min);
        } else {
            System.out.println("Найменше число: " + min);
            System.out.println("Найбільше число: " + max);
        }
    }

    public static int collatzSequence(int n) {
        int steps = 0;

        System.out.println("Послідовність Коллатца для числа " + n + ":");

        while (n != 1) {
            System.out.print(n + " ");  // Виводимо поточне значення n

            // Якщо число парне, ділимо його на 2
            if (n % 2 == 0) {
                n = n / 2;
            }
            // Якщо число непарне, множимо його на 3 і додаємо 1
            else {
                n = 3 * n + 1;
            }

            steps++;  // Збільшуємо лічильник кроків
        }

        // Виводимо останнє значення (1)
        System.out.println(n);

        return steps;  // Повертаємо кількість кроків
    }
}