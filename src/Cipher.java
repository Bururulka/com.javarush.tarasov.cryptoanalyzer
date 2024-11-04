package src;

import java.util.Arrays;

public class Cipher {
    private char[] alphabet;
    public Cipher(char[] alphabet) {
        this.alphabet = alphabet;
    }
    public String encrypt(String text, int shift) {
        // Логика шифрования
        int realShift = 0;
        if (shift > alphabet.length) {
            realShift = shift % alphabet.length;
        } else{
            realShift = shift;
        }
        String newText = "";
        char[] textArray = text.toCharArray();
        for (int i = 0; i < textArray.length; i++) {
            char ch = textArray[i];
            int index = Arrays.binarySearch(alphabet, ch);
            if (index >= 0) {
                index = index + realShift;
            }
            textArray[i] = alphabet[index];
        }
        for (char ch : textArray) {
            newText += ch;
        }
        return newText;
    }
    public String decrypt(String encryptedText, int shift, int mode) {
        // Логика расшифровки
        switch (mode) {
            case 1:
                int realShift = 0;
                if (shift > alphabet.length) {
                    realShift = shift % alphabet.length;
                } else{
                    realShift = shift;
                }
                String newText = "";
                char[] textArray = encryptedText.toCharArray();
                for (int i = 0; i < textArray.length; i++) {
                    char ch = textArray[i];
                    int index = Arrays.binarySearch(alphabet, ch);
                    if (index >= 0) {
                        index = index - realShift;
                        if (index < 0) {
                            index = textArray.length + index ;
                        }
                    }
                    textArray[i] = alphabet[index];
                }
                for (char ch : textArray) {
                    newText += ch;
                }
                return newText;
            case 2:
                break;
        }
        return null;
    }
}
