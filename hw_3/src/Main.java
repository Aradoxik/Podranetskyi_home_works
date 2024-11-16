//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Досконалі числа до 10 000:");
        for (int number = 1; number <= 10000; number++) {
            if (isPerfect(number)) {
                System.out.println(number);
            }
        }

        System.out.println("\nДружні числа до 10 000:");
        for (int num1 = 1; num1 <= 10000; num1++) {
            int sum1 = sumOfDivisors(num1);
            if (sum1 > num1 && sum1 <= 10000) { // уникнення повторів та перевірка діапазону
                int sum2 = sumOfDivisors(sum1);
                if (sum2 == num1) {
                    System.out.println(num1 + " і " + sum1);
                }
            }
        }
    }

    // Метод для перевірки, чи є число досконалим
    public static boolean isPerfect(int number) {
        int sum = 0;

        // Знаходимо суму дільників числа
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        // Перевіряємо, чи дорівнює сума дільників самому числу
        return sum == number;
    }
    public static int sumOfDivisors(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}