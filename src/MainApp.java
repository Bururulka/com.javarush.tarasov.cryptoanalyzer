package src;

import java.util.Scanner;

public class MainApp {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner pathScanner = new Scanner(System.in);
        pathScanner.useDelimiter("Delimeter");
        String filename = "";
        int mode = 0;
        boolean go = false;
        boolean fileExists = false;
        int key = 0;
        String textOfFile = "";
        String encryptTextOfFile = "";
        Cipher cipher = new Cipher(ALPHABET);
        String answer = "";
        String pathToWrite = "";
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
                while (!fileExists) {
                    System.out.println("Введите путь файла который хотите зашифровать");
                    filename = pathScanner.nextLine();
                    fileExists = Validator.isFileExists(filename);
                }
                while (key<=0) {
                    System.out.println("Введите ключ для шифрования файла");
                    key = scanner.nextInt();
                }
                FileManager fileManager = new FileManager();
                try {
                    textOfFile = fileManager.readFile(filename);
                } catch (Exception e) {
                    System.out.println("Неизвестная ошибка");
                }
                encryptTextOfFile = cipher.encrypt(textOfFile, key);
                System.out.println("Сохранить файл?");
                System.out.println("yes/no");
                answer = scanner.next();
                if (answer.equals("yes")) {
                    System.out.println("Выберите директорию с именем нового файла");
                    pathToWrite = pathScanner.nextLine();
                    fileManager.writeFile(encryptTextOfFile,pathToWrite);
                }
                break;
            case 2:
                while (!fileExists) {
                    System.out.println("Введите путь файла который хотите расшифровать");
                    filename = scanner.nextLine();
                    fileExists = Validator.isFileExists(filename);
                }
                System.out.println("Введите ключ для расшифровки файла");
                break;
            case 3:
                while (!fileExists) {
                    System.out.println("Введите путь файла который хотите расшифровать");
                    filename = scanner.next();
                    fileExists = Validator.isFileExists(filename);
                }
                break;
            case 4:
                while (!fileExists) {
                    System.out.println("Введите путь файла который хотите расшифровать");
                    filename = scanner.next();
                    fileExists = Validator.isFileExists(filename);
                }
                break;
        }
    }
}
