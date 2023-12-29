/*
1.Напишіть програму, яка отримає рядок з максимальною кількістю слів із заданого файлу.

2.Відкрийте код додатка за завданням Task 3 Simple OOP і внесіть наступні зміни (хто виконав Task 3 Mid OOP
ігнорує це завдання, але все ж ознайомлюється з теорією):
    - додайте в меню команду для збереження набору об'єктів в файл;
    - передбачте можливість читання набору об'єктів з файлу.

3.Зашифрувати вхідний символьний потік за наступним алгоритмом: замінити кожний символ на такий, код якого
більший на значення коду ключового символу. При виконанні завдання:
    a.Реалізувати метод, який реалізує шифрування
    b.Реалізувати метод, який реалізує дешифрування.
    c.Використати для розв'язання задачі потоки типу FilerOutputStream-FilterInputStream/FilterWriter-FilteredReader.

4.Підрахувати частоту, з якою зустрічаються теги на сторінці по URL (URL на ваш вибір).
    a.Вивести результати наступним чином: в порядку зростання для тегів в лексикографічному порядку
    b.Вивести результати наступним чином: в порядку зростання по частоті появи тегів

ВИМОГИ
    1.Передбачте можливість введення розташування та ім’я файлу для збереження даних.
    2.Використовуйте об'єктні потоки для роботи з файлом.
    3.Застосуйте серіалізацію за замовчуванням для роботи з файлами.
    4.Виділіть роботу з файлами в окремий клас.
    5.Дані для пошуку інформації в наборі даних повинні вводитися набором з клавіатури.
    6.Передбачте обробку коректності введення даних через блоки try-catch.
*/

package Lab5;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1: ");
        String path = "src/main/java/Lab5/lab5.txt";
        FileController fileController = new FileController();
        fileController.readFileAndGetTask(path);
        System.out.println("Max number of words in a line: " + fileController.getCountOfWordsInMaxLine());
        System.out.println("Line with max word count: ");
        List<String> lines = fileController.getMaxLines();

        for (String line : lines) {
            System.out.println(line);
        }

        System.out.println();
        System.out.println("Task 3: ");
        String resultOfEncryption = CryptionText.encryption("Text for encrypt","wordForCrypt");
        System.out.println(resultOfEncryption);
        String resultOfDecryption = CryptionText.decryption(resultOfEncryption,"wordForCrypt");
        System.out.println(resultOfDecryption);
    }
}
