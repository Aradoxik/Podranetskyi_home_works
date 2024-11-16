import java.util.Scanner;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//1
//        System.out.print("Введіть числа, розділені пробілами: ");
//        String input = scanner.nextLine();
//
//        String[] numberStrings = input.split(" ");
//
//        int[] numbers = new int[numberStrings.length];
//        for (int i = 0; i < numberStrings.length; i++) {
//            numbers[i] = Integer.parseInt(numberStrings[i]);
//        }
//
//        double average = calculateAverage(numbers);
//
//        System.out.println("Середнє арифметичне: " + average);


//2
//        System.out.print("Введіть кількість елементів масиву: ");
//        int n = scanner.nextInt();
//
//        int[] array = new int[n];
//
//        System.out.println("Введіть " + n + " елементів масиву:");
//        for (int i = 0; i < n; i++) {
//            array[i] = scanner.nextInt();
//        }
//
//        reverseArray(array);
//        System.out.println("Масив у зворотному порядку:");
//        printArray(array);


//3
        // Введення розмірів для першої матриці
        System.out.print("Введіть кількість рядків для першої матриці: ");
        int rowsA = scanner.nextInt();
        System.out.print("Введіть кількість стовпців для першої матриці: ");
        int colsA = scanner.nextInt();

        // Введення розмірів для другої матриці
        System.out.print("Введіть кількість рядків для другої матриці: ");
        int rowsB = scanner.nextInt();
        System.out.print("Введіть кількість стовпців для другої матриці: ");
        int colsB = scanner.nextInt();

        // Перевірка на можливість множення
        if (colsA != rowsB) {
            System.out.println("Помилка: Кількість стовпців першої матриці повинна дорівнювати кількості рядків другої матриці.");
            return;
        }

        // Генерація двох матриць з випадковими числами
        int[][] matrixA = generateMatrix(rowsA, colsA);
        int[][] matrixB = generateMatrix(rowsB, colsB);

        // Виведення початкових матриць
        System.out.println("Перша матриця:");
        printMatrix(matrixA);
        System.out.println("Друга матриця:");
        printMatrix(matrixB);

        // Множення матриць
        int[][] result = multiplyMatrices(matrixA, matrixB);

        // Виведення результату
        System.out.println("Результат множення:");
        printMatrix(result);

    }

    public static double calculateAverage(int[] numbers) {
        if (numbers.length == 0) {
            return 0; // Якщо масив порожній, повертаємо 0
        }

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return (double) sum / numbers.length; // Обчислюємо середнє арифметичне
    }

    public static void reverseArray(int[] array) {
        int start = 0;
        int end = array.length - 1;

        // Обмін елементів масиву місцями
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static int[][] generateMatrix(int rows, int cols) {
        Random random = new Random();
        int[][] matrix = new int[rows][cols];

        // Заповнення матриці випадковими числами від 1 до 10
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(10) + 1; // Генерація випадкових чисел від 1 до 10
            }
        }
        return matrix;
    }
    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;

        int[][] result = new int[rowsA][colsB];

        // Множення матриць
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return result;
    }
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }
}