package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    [Done] Read the sentence
    [Done] Split each words by space
    [Done] Store single word in List
    [Done] Print reversed
*/

public class ReversedSentence {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter your input: ");

            String input = sc.nextLine();

            List<String> individualWords = splitInputBySpace(input);

            printReversed(individualWords);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static List<String> splitInputBySpace(String input) {

        String[] individualWords = input.split(" ");

        List<String> indWordsArray = new ArrayList<>();

        for (int i = 0; i < individualWords.length; i++) {
            indWordsArray.add(individualWords[i]);
        }

        return indWordsArray;
    }

    public static void printReversed(List<String> arrayList) {
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            System.out.print(arrayList.get(i) + " ");
        }
    }

}
