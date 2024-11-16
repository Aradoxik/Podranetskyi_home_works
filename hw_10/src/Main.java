import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static class FibonacciRecursion {
        // Рекурсивна функція для обчислення числа Фібоначчі
        public static int fibonacci(int n) {
            if (n <= 1) {
                return n;
            }
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    private static int[] memo;
    // Рекурсивна функція для обчислення елемента ряду x_n
    public static int calculateX(int n) {
        // Якщо елемент вже обчислений, просто повертаємо його з пам'яті
        if (memo[n] != -1) {
            return memo[n];
        }

        // Рекурсивно обчислюємо x_n = x_(n-1) + x_(n-3)
        if (n - 3 >= 0) {
            memo[n] = calculateX(n - 1) + calculateX(n - 3);
        }

        return memo[n];
    }

    // Лічильник кількості перенесених дисків
    private static int moveCount = 0;
    // Рекурсивна функція для перенесення дисків
    public static void moveDisks(int n, char source, char target, char auxiliary) {
        if (n == 1) {
            // Переміщаємо один диск з source на target
            System.out.println("Перемістіть диск 1 з " + source + " на " + target);
            moveCount++; // Збільшуємо лічильник перенесень
        } else {
            // Переміщаємо n-1 дисків на допоміжну голку
            moveDisks(n - 1, source, auxiliary, target);

            // Переміщаємо найбільший диск на цільову голку
            System.out.println("Перемістіть диск " + n + " з " + source + " на " + target);
            moveCount++; // Збільшуємо лічильник перенесень

            // Переміщаємо n-1 дисків з допоміжної голки на цільову
            moveDisks(n - 1, auxiliary, target, source);
        }
    }


    public static void main(String[] args) {
        //1
        // Створення об'єкта для зчитування введення користувача
        Scanner scanner = new Scanner(System.in);
        //FibonacciRecursion f = new FibonacciRecursion();
        // Запит користувача на введення числа, до якого обчислюються числа Фібоначчі
        //System.out.print("Введіть максимальне значення числа Фібоначчі: ");
        //int maxValue = scanner.nextInt();
        //int i = 0;
        int fibNumber;
        // Виведення чисел Фібоначчі до заданого максимуму
        //while ((fibNumber = fibonacci(i)) < maxValue) {
        //    System.out.println(i + " - " + fibNumber);
        //    i++;
        //}



//2
// Запит користувача на введення числа K
//        System.out.print("Введіть число K: ");
//        int K = scanner.nextInt();
//
//        // Ініціалізація масиву для зберігання значень ряду (для оптимізації)
//        memo = new int[K + 1];
//
//        // Заповнення масиву базовими значеннями
//        for (int i = 0; i <= K; i++) {
//            memo[i] = -1;  // Початкове значення -1, щоб позначити невідомі елементи
//        }
//
//        // Початкові умови для ряду
//        if (K >= 0) memo[0] = 1;
//        if (K >= 1) memo[1] = 1;
//        if (K >= 2) memo[2] = 2;
//
//        // Обчислення суми ряду від 0 до K
//        int sum = 0;
//        for (int i = 0; i <= K; i++) {
//            sum += calculateX(i);
//        }
//
//        // Виведення результату
//        System.out.println("Сума ряду до " + K + " елемента (включно): " + sum);


//3
        // Введення кількості дисків
        System.out.print("Введіть кількість дисків: ");
        int n = scanner.nextInt();

        // Введення цільової голки
        System.out.print("Введіть цільову голку (A, B або C): ");
        char target = scanner.next().charAt(0);

        // Ділимо на три голки: початкову, цільову та допоміжну
        char source = 'A';
        char auxiliary = 'B';

        // Якщо цільова голка введена як 'A', то використовуємо іншу для допоміжної
        if (target == 'A') {
            auxiliary = 'C';
        } else if (target == 'B') {
            auxiliary = 'C';
        }

        // Починаємо переміщення дисків
        moveDisks(n, source, target, auxiliary);

        // Виводимо загальну кількість перенесених дисків
        System.out.println("Загальна кількість переміщень: " + moveCount);


        scanner.close();
    }
}