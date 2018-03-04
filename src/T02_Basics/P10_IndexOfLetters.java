package T02_Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10_IndexOfLetters {
    public static void main(String[] args) throws IOException {

        char[] alphabet = new char[26];
        for (char letter = 'a'; letter <= 'z'; letter++) {
            alphabet[letter - 'a'] = letter;
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = reader.readLine();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
//            System.out.printf("%s -> %d%n", letter, letter - 'a');    -- no need of char[] alphabet
            for (int j = 0; j < alphabet.length; j++) {
                char arrLetter = alphabet[j];
                if (letter == arrLetter) {
                    System.out.printf("%s -> %d%n", letter, j);
                }
            }
        }
    }
}
