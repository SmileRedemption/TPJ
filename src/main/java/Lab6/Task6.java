package Lab6;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dictionary dictionary = new Dictionary();
        String input;

        dictionary.addWord("Hello", "Привіт");
        dictionary.addWord("I","Я");
        dictionary.addWord("love", "люблю");

        System.out.print("t -> translate\na -> add new word\n->");
        while (!(input = scanner.nextLine()).equals("exit")) {
            if (input.startsWith("a")) {
                String[] temp = input.split(" +");
                dictionary.addWord(temp[1], temp[2]);
                System.out.println("Added");
            } else if (input.startsWith("t")) {
                String[] temp = input.split(" +");

                for (int i = 1; i < temp.length; i++) {
                    System.out.print(dictionary.translate(temp[i]) + " ");
                }

                System.out.println();
            } else {
                System.out.println("error");
            }
            System.out.print("t -> translate\na -> add new word\n->");
        }
    }
}

