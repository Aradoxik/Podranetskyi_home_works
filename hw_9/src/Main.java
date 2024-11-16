//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Обробка NullPointerException
        try {
            String str = null;
            System.out.println(str.length());  // Викликає NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }

        // Обробка ArrayIndexOutOfBoundsException
        try {
            int[] arr = new int[5];
            System.out.println(arr[10]);  // Викликає ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }

        // Обробка ArithmeticException
        try {
            int result = 10 / 0;  // Викликає ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        }

        // Обробка IllegalArgumentException
        try {
            throw new IllegalArgumentException("Invalid argument!");  // Викликає IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        }

        // Обробка ClassCastException
        try {
            Object obj = "Hello";
            Integer num = (Integer) obj;  // Викликає ClassCastException
        } catch (ClassCastException e) {
            System.out.println("Caught ClassCastException: " + e.getMessage());
        }
    }
}



//NullPointerException:
//Викликається, коли намагаємося викликати метод на об'єкті, який не ініціалізований (значення null).

//ArrayIndexOutOfBoundsException:
//Викликається, коли намагаємося звернутися до індексу масиву, який виходить за межі його допустимого діапазону.

//ArithmeticException:
//Викликається при спробі ділення на нуль.

//IllegalArgumentException:
//Викликається, коли метод отримує недопустимий або неочікуваний аргумент.

//ClassCastException:
//Викликається, коли намагаємося виконати недопустиме приведення типу об'єкта.