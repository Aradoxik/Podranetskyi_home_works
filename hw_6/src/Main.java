//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import java.util.Random;
import java.util.Scanner;

public class Main {
    public static class MathLibrary {

        // Метод, що 10 разів виводить на екран ім'я й прізвище
        public void printNameAndSurname() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Ім'я Прізвище");
            }
        }

        // Метод, що виводить таблицю квадратів перших п'яти цілих додатних непарних чисел
        public void printSquaresOfOddNumbers() {
            for (int i = 1; i <= 10; i += 2) {
                System.out.println("Число: " + i + ", Квадрат: " + (i * i));
            }
        }

        // Метод, що обчислює суму перших n цілих додатних чисел
        public int sumOfFirstNNumbers(int n) {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            return sum;
        }

        // Метод, що обчислює суму перших n членів ряду 1, 3, 5, 7, ...
        public int sumOfOddSeries(int n) {
            int sum = 0;
            int currentNumber = 1;
            for (int i = 0; i < n; i++) {
                sum += currentNumber;
                currentNumber += 2;
            }
            return sum;
        }

        // Метод, що обчислює суму перших n членів ряду 1 + 1/2 + 1/3 + 1/4 +...
        public double sumOfFractionalSeries(int n) {
            double sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += 1.0 / i;
            }
            return sum;
        }

        // Метод, що виводить таблицю степенів двійки від нульової до десятої
        public void printPowersOfTwo() {
            for (int i = 0; i <= 10; i++) {
                System.out.println("2^" + i + " = " + Math.pow(2, i));
            }
        }

        // Метод, що обчислює факторіал введеного з клавіатури числа
        public long calculateFactorial(int number) {
            long factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
            return factorial;
        }

        // Метод, що виводить таблицю значень функції y = -2,4x^2 + 5x - 3 у діапазоні від -2 до 2 із кроком 0,25
        public void printFunctionValues() {
            double x = -2.0;
            while (x <= 2) {
                double y = -2.4 * Math.pow(x, 2) + 5 * x - 3;
                System.out.printf("x = %.2f, y = %.2f%n", x, y);
                x += 0.25;
            }
        }

        // Метод, що генерує 10 випадкових чисел у діапазоні від 1 до 10, виводить ці числа на екран і обчислює їх середнє арифметичне
        public double generateRandomNumbersAndCalculateAverage() {
            Random random = new Random();
            int sum = 0;
            System.out.println("Випадкові числа:");
            for (int i = 0; i < 10; i++) {
                int num = random.nextInt(10) + 1;
                System.out.print(num + " ");
                sum += num;
            }
            System.out.println();
            return sum / 10.0;
        }

        // Метод, що перевіряє, чи є ціле число простим
        public boolean isPrime(int number) {
            if (number <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }


    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        // Створення об'єкта бібліотеки
        MathLibrary library = new MathLibrary();
        Scanner scanner = new Scanner(System.in);

        // Автоматичний тест усіх методів

        // 1. Метод для виведення ім'я й прізвище 10 разів
        System.out.println("Тест 1: Ім'я та прізвище 10 разів:");
        library.printNameAndSurname();
        System.out.println();

        // 2. Метод для виведення таблиці квадратів перших п'яти непарних чисел
        System.out.println("Тест 2: Таблиця квадратів непарних чисел:");
        library.printSquaresOfOddNumbers();
        System.out.println();

        // 3. Метод для обчислення суми перших n цілих чисел
        System.out.println("Тест 3: Сума перших n цілих чисел.");
        System.out.print("Введіть n: ");
        int n = scanner.nextInt();
        int sum = library.sumOfFirstNNumbers(n);
        System.out.println("Сума перших " + n + " чисел: " + sum);
        System.out.println();

        // 4. Метод для обчислення суми перших n членів ряду 1, 3, 5, ...
        System.out.println("Тест 4: Сума перших n непарних чисел.");
        System.out.print("Введіть n: ");
        n = scanner.nextInt();
        sum = library.sumOfOddSeries(n);
        System.out.println("Сума перших " + n + " непарних чисел: " + sum);
        System.out.println();

        // 5. Метод для обчислення суми перших n членів ряду 1 + 1/2 + 1/3 + ...
        System.out.println("Тест 5: Сума перших n членів ряду 1 + 1/2 + 1/3 + ...");
        System.out.print("Введіть n: ");
        n = scanner.nextInt();
        double fractionalSum = library.sumOfFractionalSeries(n);
        System.out.println("Сума перших " + n + " членів ряду: " + fractionalSum);
        System.out.println();

        // 6. Метод для виведення таблиці степенів двійки
        System.out.println("Тест 6: Таблиця степенів двійки:");
        library.printPowersOfTwo();
        System.out.println();

        // 7. Метод для обчислення факторіалу
        System.out.println("Тест 7: Факторіал числа.");
        System.out.print("Введіть число для обчислення факторіалу: ");
        int number = scanner.nextInt();
        long factorial = library.calculateFactorial(number);
        System.out.println("Факторіал числа " + number + ": " + factorial);
        System.out.println();

        // 8. Метод для виведення таблиці значень функції y = -2,4x^2 + 5x - 3
        System.out.println("Тест 8: Таблиця значень функції y = -2,4x^2 + 5x - 3:");
        library.printFunctionValues();
        System.out.println();

        // 9. Метод для генерації випадкових чисел і обчислення їх середнього арифметичного
        System.out.println("Тест 9: Генерація випадкових чисел і обчислення середнього:");
        double average = library.generateRandomNumbersAndCalculateAverage();
        System.out.println("Середнє арифметичне випадкових чисел: " + average);
        System.out.println();

        // 10. Метод для перевірки простоти числа
        System.out.println("Тест 10: Перевірка простоти числа.");
        System.out.print("Введіть число для перевірки: ");
        number = scanner.nextInt();
        boolean isPrime = library.isPrime(number);
        System.out.println("Число " + number + (isPrime ? " є простим." : " не є простим."));
    }
}

