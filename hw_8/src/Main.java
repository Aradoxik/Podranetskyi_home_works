import java.util.NoSuchElementException;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static class Queue<T> {
        // Вузол черги (одна ланка списку)
        private static class Node<T> {
            T item;
            Node<T> next;

            Node(T item) {
                this.item = item;
            }
        }

        private Node<T> front, rear; // вказівники на початок та кінець черги
        private int size = 0; // поточний розмір черги
        private int maxSize; // максимальний розмір черги
        private boolean areNullElementsAllowed; // чи дозволено додавати null елементи

        // Конструктор за замовчуванням
        public Queue() {
            this.maxSize = Integer.MAX_VALUE;
            this.areNullElementsAllowed = true;
        }

        // Параметризований конструктор
        public Queue(int maxSize, boolean areNullElementsAllowed) {
            if (maxSize <= 0) {
                this.maxSize = Integer.MAX_VALUE;
            } else {
                this.maxSize = maxSize;
            }
            this.areNullElementsAllowed = areNullElementsAllowed;
        }

        // Додати елемент до черги
        public boolean add(T item) {
            if (!areNullElementsAllowed && item == null) {
                throw new NullPointerException("Null elements are not allowed");
            }
            if (size == maxSize) {
                throw new IllegalStateException("Queue is full");
            }
            Node<T> newNode = new Node<>(item);
            if (rear == null) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
            size++;
            return true;
        }

        // Повернути елемент-голову, але не видаляти
        public T element() {
            if (front == null) {
                throw new NoSuchElementException("Queue is empty");
            }
            return front.item;
        }

        // Додати елемент до черги, повертаючи true, якщо вдалося
        public boolean offer(T item) {
            if (!areNullElementsAllowed && item == null) {
                throw new NullPointerException("Null elements are not allowed");
            }
            if (size == maxSize) {
                return false;
            }
            Node<T> newNode = new Node<>(item);
            if (rear == null) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
            size++;
            return true;
        }

        // Видалити елемент-голову з черги та повернути його
        public T poll() {
            if (front == null) {
                return null;
            }
            T item = front.item;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            size--;
            return item;
        }

        // Видалити елемент-голову з черги та повернути його
        public T remove() {
            if (front == null) {
                throw new NoSuchElementException("Queue is empty");
            }
            T item = front.item;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            size--;
            return item;
        }

        // Повернути елемент-голову, не видаляючи його
        public T peek() {
            if (front == null) {
                return null;
            }
            return front.item;
        }

        // Перевірка, чи порожня черга
        public boolean empty() {
            return size == 0;
        }

        // Повернути індекс елемента у черзі, повертаючи -1, якщо елемент не знайдено
        public int search(T item) {
            Node<T> current = front;
            int index = 1;
            while (current != null) {
                if (current.item.equals(item)) {
                    return index;
                }
                current = current.next;
                index++;
            }
            return -1;
        }
    }
    public static class ParenthesesValidator {

        // Перевірка правильності рядка з дужками
        public static boolean isValid(String s) {
            Queue<Character> queue = new Queue<>();

            for (char c : s.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    queue.add(c); // додаємо відкриті дужки в чергу
                } else if (c == ')' || c == '}' || c == ']') {
                    if (queue.empty()) {
                        return false; // немає відкритої дужки для закритої
                    }
                    char openBracket = queue.poll(); // отримуємо першу відкриту дужку
                    if (!isMatching(openBracket, c)) {
                        return false; // дужки не відповідають
                    }
                }
            }
            return queue.empty(); // якщо черга порожня, всі дужки закриті правильно
        }

        // Перевірка на відповідність відкритої та закритої дужки
        private static boolean isMatching(char openBracket, char closeBracket) {
            return (openBracket == '(' && closeBracket == ')') ||
                    (openBracket == '{' && closeBracket == '}') ||
                    (openBracket == '[' && closeBracket == ']');
        }

        public static void main(String[] args) {
            // Тестування валідності різних рядків
            String[] testStrings = { "()", "()[]{}", "(]", "({[()]})", "([)]" };
            for (String s : testStrings) {
                System.out.println("String: " + s + " is valid? " + isValid(s));
            }
        }
    }

    public static void main(String[] args) {
        // Тестування черги
        Queue<Integer> queue = new Queue<>(3, true);
        try {
            queue.add(1);
            queue.add(2);
            queue.add(3);
            System.out.println("Element added successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            queue.add(4); // повинно викликати IllegalStateException
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Element at front: " + queue.element());

        System.out.println("Polling from queue: " + queue.poll());
        System.out.println("Element after poll: " + queue.peek());

        System.out.println("Search element 2: " + queue.search(2));

        System.out.println("Queue empty? " + queue.empty());

        // Тестування перевірки правильності парних дужок
        String testString = "()[]{}";
        System.out.println("String " + testString + " is valid? " + ParenthesesValidator.isValid(testString));
    }
}