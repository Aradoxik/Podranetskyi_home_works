import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1
        //System.out.println("Введіть бал (0-100): ");
        //int score = scanner.nextInt();
        //String grade = getGrade(score);
        //System.out.println("Оцінка: " + grade);

        //2
        //System.out.println("Введіть число для визначенея парності: ");
        //int num = scanner.nextInt();
        //System.out.println(isEven(num));

        //3
        System.out.println("Введіть номер дня тижня (1-7): ");
        int dayNumber = scanner.nextInt();
        String dayName = getDayName(dayNumber);
        System.out.println("День тижня: " + dayName);
    }

    // Функція для визначення оцінки
    public static String getGrade(int score) {
        if (score >= 91 && score <= 100) {
            return "Excellent";
        } else if (score >= 81 && score <= 90) {
            return "Very good";
        } else if (score >= 71 && score <= 80) {
            return "Good";
        } else if (score >= 66 && score <= 70) {
            return "Satisfactorily";
        } else if (score >= 60 && score <= 65) {
            return "Weakly";
        } else if (score >= 30 && score <= 59) {
            return "Bad";
        } else if (score >= 0 && score <= 29) {
            return "Very bad";
        } else {
            return "Неприпустимий бал! Введіть число в діапазоні 0-100.";
        }
    }

    public static String isEven(int number) {
        return (number % 2 == 0) ? "парне" : "непарне";
    }

    public static String getDayName(int dayNumber) {
        switch (dayNumber) {
            case 1:
                return "Понеділок";
            case 2:
                return "Вівторок";
            case 3:
                return "Середа";
            case 4:
                return "Четвер";
            case 5:
                return "П'ятниця";
            case 6:
                return "Субота";
            case 7:
                return "Неділя";
            default:
                return "Неприпустимий номер! Введіть число від 1 до 7.";
        }
    }
}