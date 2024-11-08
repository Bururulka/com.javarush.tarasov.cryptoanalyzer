package src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','й','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э','ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner pathScanner = new Scanner(System.in);
        Validator validator = new Validator();
        int key = 0;
        String filename = "";
        boolean go = false;
        int mode = 0;
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

        boolean fileExists = false;
        while (!fileExists) {
            System.out.println("Введите путь файла который хотите зашифровать/расшифровать");
            filename = pathScanner.nextLine();
            fileExists = validator.isFileExists(filename);
        }
        if (mode == 1 || mode == 2) {
            while (key <= 0) {
                System.out.println("Введите ключ для шифрования/расшифровки файла");
                key = scanner.nextInt();
            }
        }

        FileManager fileManager = new FileManager();
        List<String> oldFile = new ArrayList<>(List.of());
        try {
            oldFile = fileManager.readFile(filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (mode == 1 || mode == 2) {
            Cipher cipher = new Cipher(ALPHABET);
            List<String> newFile;
            newFile = cipher.crypt(oldFile, key, mode);
            System.out.println("Выберите директорию с именем нового файла");
            String pathToWrite = pathScanner.nextLine();
            fileManager.writeFile(newFile, pathToWrite);
        }
        if (mode == 3) {
            System.out.println("Выберите директорию, куда складывать варианты расшифровки");
            String pathToWriteAllFiles = pathScanner.nextLine();
            BrutForce brutForce = new BrutForce(ALPHABET);
            brutForce.unlock(oldFile, pathToWriteAllFiles);
        }
        if (mode == 4) {

        }

    }

}
