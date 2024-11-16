import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static class Student {
        // Поля базового класу
        private String name;
        private String surname;
        private int yearOfStudy;

        // Конструктор базового класу
        public Student(String name, String surname, int yearOfStudy) {
            this.name = name;
            this.surname = surname;
            this.yearOfStudy = yearOfStudy;
        }

        // Гетери для полів
        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public int getYearOfStudy() {
            return yearOfStudy;
        }

        // Метод для представлення студента
        public String introduce() {
            return "Студент: " + name + " " + surname + ", рік навчання: " + yearOfStudy;
        }

        // Метод, який повертає факультет студента (базовий клас не має цього, але він буде перевизначений у нащадках)
        public String getFaculty() {
            return "Не визначено";
        }
    }
    public static class EngineeringStudent extends Student {
        // Поле для спеціальності студента
        private String specialization;

        // Конструктор для студента факультету інженерії
        public EngineeringStudent(String name, String surname, int yearOfStudy, String specialization) {
            super(name, surname, yearOfStudy);  // Викликаємо конструктор батьківського класу
            this.specialization = specialization;
        }

        // Метод для отримання факультету
        @Override
        public String getFaculty() {
            return "Факультет інженерії";
        }

        // Спеціальний метод для студентів інженерії
        public String getSpecialization() {
            return specialization;
        }
    }
    public static class HumanitiesStudent extends Student {
        // Поле для спеціалізації студента
        private String specialization;

        // Конструктор для студента факультету гуманітарних наук
        public HumanitiesStudent(String name, String surname, int yearOfStudy, String specialization) {
            super(name, surname, yearOfStudy);  // Викликаємо конструктор батьківського класу
            this.specialization = specialization;
        }

        // Метод для отримання факультету
        @Override
        public String getFaculty() {
            return "Факультет гуманітарних наук";
        }

        // Спеціальний метод для студентів гуманітарних наук
        public String getSpecialization() {
            return specialization;
        }
    }

    public static void main(String[] args) {
// Створення об'єктів студентів різних факультетів
        EngineeringStudent engineeringStudent = new EngineeringStudent("Іван", "Петров", 2, "Комп'ютерні науки");
        HumanitiesStudent humanitiesStudent = new HumanitiesStudent("Марія", "Іванова", 3, "Філологія");

        // Виведення на екран інформації про студентів
        System.out.println(engineeringStudent.introduce());
        System.out.println("Факультет: " + engineeringStudent.getFaculty());
        System.out.println("Спеціалізація: " + engineeringStudent.getSpecialization());
        System.out.println();

        System.out.println(humanitiesStudent.introduce());
        System.out.println("Факультет: " + humanitiesStudent.getFaculty());
        System.out.println("Спеціалізація: " + humanitiesStudent.getSpecialization());
        System.out.println();

        // Запит на ввід нового студента
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть ім'я студента:");
        String name = scanner.nextLine();
        System.out.println("Введіть прізвище студента:");
        String surname = scanner.nextLine();
        System.out.println("Введіть рік навчання:");
        int yearOfStudy = scanner.nextInt();
        scanner.nextLine();  // Для зчитування символу після числа

        System.out.println("Виберіть факультет (1 - Інженерії, 2 - Гуманітарні науки):");
        int facultyChoice = scanner.nextInt();
        scanner.nextLine();  // Для зчитування символу після числа

        Student newStudent = null;

        if (facultyChoice == 1) {
            System.out.println("Введіть спеціалізацію:");
            String specialization = scanner.nextLine();
            newStudent = new EngineeringStudent(name, surname, yearOfStudy, specialization);
        } else if (facultyChoice == 2) {
            System.out.println("Введіть спеціалізацію:");
            String specialization = scanner.nextLine();
            newStudent = new HumanitiesStudent(name, surname, yearOfStudy, specialization);
        }

        // Виведення інформації про нового студента
        if (newStudent != null) {
            System.out.println(newStudent.introduce());
            System.out.println("Факультет: " + newStudent.getFaculty());
            if (newStudent instanceof EngineeringStudent) {
                System.out.println("Спеціалізація: " + ((EngineeringStudent) newStudent).getSpecialization());
            } else if (newStudent instanceof HumanitiesStudent) {
                System.out.println("Спеціалізація: " + ((HumanitiesStudent) newStudent).getSpecialization());
            }
        }
    }
}