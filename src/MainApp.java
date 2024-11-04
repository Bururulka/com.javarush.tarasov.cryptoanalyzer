package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','й','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э','ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    private static boolean fileExists = false;
    private static String filename = "";
    private static Scanner scanner = new Scanner(System.in);
    private static Scanner pathScanner = new Scanner(System.in);
    private static int mode = 0;
    private static boolean go = false;
    private static int key = 0;
    private static FileManager fileManager = new FileManager();
    private static List<String> textOfFile = List.of();
    private static List<String> encryptTextOfFile = new ArrayList<>(List.of());
    private static List<String> decryptTextOfFile = new ArrayList<>(List.of());
    private static String answer = "";
    private static String pathToWrite = "";
    private static final Cipher cipher = new Cipher(ALPHABET);

    public static void main(String[] args) {
        pathScanner.useDelimiter("Delimeter");

        while (!go) {
            System.out.println("Выберите режим работы программы. Нужно ввести номер варианта работы.");
            System.out.println("1.Шифровать");
            System.out.println("2.Расшифровать с помощью ключа");
            System.out.println("3.Расшифровать при помощи Brut force");
            System.out.println("4.Расшифровать при помощи статистического анализа текста");
            mode = scanner.nextInt();
            if (mode == 1 || mode == 2 || mode == 3 || mode == 4) {
                go = true;
            } else {
                System.out.println("Введите деиствительный номер режима работы!!!!");
            }
        }
        switch (mode) {
            case 1:
                encryptFile();
                break;
            case 2:
                decryptFile();
                break;
            case 3:
                decryptFile();
                break;
            case 4:
                decryptFile();
                break;
        }
    }

    private static void encryptFile(){
        selectPathToRead();
        selectKey();
        processEncrypt();
        selectPathToWriteEncrypt();
    }

    private static void decryptFile(){
        selectPathToRead();
        selectKey();
        processDecrypt();
        selectPathToWriteDecrypt();
    }
    private static void selectPathToRead(){
        while (!fileExists) {
            System.out.println("Введите путь файла который хотите зашифровать/расшифровать");
            filename = pathScanner.nextLine();
            fileExists = Validator.isFileExists(filename);
        }
    }
    private static void selectPathToWriteDecrypt(){
        System.out.println("Сохранить файл?");
        System.out.println("yes/no");
        answer = scanner.next();
        if (answer.equals("yes")) {
            System.out.println("Выберите директорию с именем нового файла");
            pathToWrite = pathScanner.nextLine();
            fileManager.writeFile(decryptTextOfFile,pathToWrite);
        }
    }
    private static void selectPathToWriteEncrypt(){
        System.out.println("Сохранить файл?");
        System.out.println("yes/no");
        answer = scanner.next();
        if (answer.equals("yes")) {
            System.out.println("Выберите директорию с именем нового файла");
            pathToWrite = pathScanner.nextLine();
            fileManager.writeFile(encryptTextOfFile,pathToWrite);
        }
    }
    private static void selectKey(){
        while (key<=0) {
            System.out.println("Введите ключ для шифрования/расшифровки файла");
            key = scanner.nextInt();
        }
    }
    private static void processEncrypt(){
        try {
            textOfFile = fileManager.readFile(filename);
        } catch (Exception e) {
            System.out.println("Неизвестная ошибка");
        }
        for(String textOfLine : textOfFile ){
            encryptTextOfFile.add(cipher.encrypt(textOfLine, key));
        }
    }
    private static void processDecrypt(){
        try {
            textOfFile = fileManager.readFile(filename);
        } catch (Exception e) {
            System.out.println("Неизвестная ошибка");
        }
        for(String textOfLine : textOfFile ){
            decryptTextOfFile.add(cipher.decrypt(textOfLine, key, mode));
        }
    }
}
