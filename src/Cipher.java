package src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cipher {
    private char[] alphabet;
    public Cipher(char[] alphabet) {
        this.alphabet = alphabet;
    }

    public List<String> crypt(List<String> text, int shift, int mode) {
        // Логика расшифровки
        List<String> newText = new ArrayList<>();
            if (mode == 1 || mode == 2) {
                int realShift = 0;
                if (shift > alphabet.length) {
                    realShift = shift % alphabet.length;
                } else {
                    realShift = shift;
                }
                if (mode != 1) {
                    realShift = realShift * (-1);
                }
                for (String line : text) {
                    String newLine = "";
                    char[] textArray = line.toCharArray();
                    for (int i = 0; i < textArray.length; i++) {
                        char ch = textArray[i];
                        int index = Arrays.binarySearch(alphabet, ch);
                        if (index >= 0) {
                            index = index + realShift;
                            if (index < 0) {
                                index = alphabet.length + index;
                            }
                        }
                        textArray[i] = alphabet[index];
                    }
                    for (Object ch : textArray) {
                        newLine += ch;
                    }
                    newText.add(newLine);
                }
            }
        return newText;
    }
}
