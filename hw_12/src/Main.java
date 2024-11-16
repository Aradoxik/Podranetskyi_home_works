import java.io.*;
import java.nio.file.*;

public class Main {


    public static class ReplaceSubstringInFile {

        public static void replaceSubstring(String filePath, String target, String replacement) {
            try {
                // Читання всього вмісту файлу
                String content = new String(Files.readAllBytes(Paths.get(filePath)));

                // Замінюємо підстрічку
                content = content.replace(target, replacement);

                // Записуємо новий вміст у файл
                Files.write(Paths.get(filePath), content.getBytes());
                System.out.println("Замінено підстрічку у файлі.");
            } catch (IOException e) {
                System.out.println("Помилка при роботі з файлом: " + e.getMessage());
            }
        }

        public static void main(String[] args) {
            String filePath = "input.txt"; // Вказати шлях до файлу
            String target = "старий текст"; // Підстрічка, яку треба замінити
            String replacement = "новий текст"; // Текст, на який буде здійснена заміна

            replaceSubstring(filePath, target, replacement);
        }
    }
    public static class CopyFile {

        public static void copyFileToBackup(String fileName) {
            try {
                // Читаємо вміст файлу
                byte[] content = Files.readAllBytes(Paths.get(fileName));

                // Записуємо вміст у новий файл з розширенням .bak
                String backupFileName = fileName + ".bak";
                Files.write(Paths.get(backupFileName), content);
                System.out.println("Файл скопійовано в " + backupFileName);
            } catch (IOException e) {
                System.out.println("Помилка при роботі з файлом: " + e.getMessage());
            }
        }

        public static void main(String[] args) {
            // Запитуємо ім'я файлу в користувача
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.print("Введіть ім'я файлу: ");
                String fileName = reader.readLine();
                copyFileToBackup(fileName);
            } catch (IOException e) {
                System.out.println("Помилка: " + e.getMessage());
            }
        }
    }
    public static class SplitFileByLines {

        public static void splitFile(String filePath) {
            try {
                BufferedReader reader = Files.newBufferedReader(Paths.get(filePath));
                BufferedWriter oddWriter = new BufferedWriter(new FileWriter("odd_lines.txt"));
                BufferedWriter evenWriter = new BufferedWriter(new FileWriter("even_lines.txt"));

                String line;
                int lineNumber = 1;
                while ((line = reader.readLine()) != null) {
                    if (lineNumber % 2 == 1) {
                        oddWriter.write(line);
                        oddWriter.newLine();
                    } else {
                        evenWriter.write(line);
                        evenWriter.newLine();
                    }
                    lineNumber++;
                }

                reader.close();
                oddWriter.close();
                evenWriter.close();

                System.out.println("Файл розділено на непарні та парні рядки.");
            } catch (IOException e) {
                System.out.println("Помилка при роботі з файлом: " + e.getMessage());
            }
        }

        public static void main(String[] args) {
            String filePath = "input.txt"; // Вказати шлях до файлу
            splitFile(filePath);
        }
    }
    public static class FileEncrypt {

        public static void encryptFile(String filePath, int shift) {
            try {
                String content = new String(Files.readAllBytes(Paths.get(filePath)));
                StringBuilder encryptedContent = new StringBuilder();

                for (char c : content.toCharArray()) {
                    if (Character.isLetter(c)) {
                        char newChar = (char) (c + shift);
                        if ((Character.isLowerCase(c) && newChar > 'z') || (Character.isUpperCase(c) && newChar > 'Z')) {
                            newChar -= 26;
                        }
                        encryptedContent.append(newChar);
                    } else {
                        encryptedContent.append(c);
                    }
                }

                Files.write(Paths.get(filePath), encryptedContent.toString().getBytes());
                System.out.println("Файл зашифровано.");
            } catch (IOException e) {
                System.out.println("Помилка при роботі з файлом: " + e.getMessage());
            }
        }

        public static void main(String[] args) {
            String filePath = "input.txt"; // Вказати шлях до файлу
            int shift = 3; // Зсув символів для шифрування
            encryptFile(filePath, shift);
        }
    }
    public static class FileDecrypt {

        public static void decryptFile(String filePath, int shift) {
            try {
                String content = new String(Files.readAllBytes(Paths.get(filePath)));
                StringBuilder decryptedContent = new StringBuilder();

                for (char c : content.toCharArray()) {
                    if (Character.isLetter(c)) {
                        char newChar = (char) (c - shift);
                        if ((Character.isLowerCase(c) && newChar < 'a') || (Character.isUpperCase(c) && newChar < 'A')) {
                            newChar += 26;
                        }
                        decryptedContent.append(newChar);
                    } else {
                        decryptedContent.append(c);
                    }
                }

                Files.write(Paths.get(filePath), decryptedContent.toString().getBytes());
                System.out.println("Файл розшифровано.");
            } catch (IOException e) {
                System.out.println("Помилка при роботі з файлом: " + e.getMessage());
            }
        }

        public static void main(String[] args) {
            String filePath = "input.txt"; // Вказати шлях до файлу
            int shift = 3; // Зсув символів для розшифрування
            decryptFile(filePath, shift);
        }
    }


    public static void main(String[] args) {
        System.out.println("Тестування методів програми:");

        // Тест для заміни підстрічки в файлі
        System.out.println("\nТест: Замінити підстрічку в файлі...");
        String filePathReplace = "input.txt";
        String target = "старий текст";
        String replacement = "новий текст";
        ReplaceSubstringInFile.replaceSubstring(filePathReplace, target, replacement);

        // Тест для копіювання файлу
        System.out.println("\nТест: Копіювати файл...");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Введіть ім'я файлу для копіювання: ");
            String fileNameCopy = null;
            try {
                fileNameCopy = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            CopyFile.copyFileToBackup(fileNameCopy);
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        // Тест для розділення файлу на парні та непарні рядки
        System.out.println("\nТест: Розділити файл на парні та непарні рядки...");
        String filePathSplit = "input.txt";
        SplitFileByLines.splitFile(filePathSplit);

        // Тест для шифрування файлу
        System.out.println("\nТест: Шифрувати файл...");
        String filePathEncrypt = "input.txt";
        int shiftEncrypt = 3;  // Зсув
        FileEncrypt.encryptFile(filePathEncrypt, shiftEncrypt);

        // Тест для розшифрування файлу
        System.out.println("\nТест: Розшифрувати файл...");
        String filePathDecrypt = "input.txt";
        int shiftDecrypt = 3;  // Зсув
        FileDecrypt.decryptFile(filePathDecrypt, shiftDecrypt);

        // Створення демонстраційного файлу для тестування (заміна підстрічки і шифрування)
        try {
            Files.write(Paths.get("input.txt"), "старий текст в файлі для тестування\nце ще одна лінія старого тексту".getBytes());
        } catch (IOException e) {
            System.out.println("Помилка при записі в файл: " + e.getMessage());
        }
    }
}