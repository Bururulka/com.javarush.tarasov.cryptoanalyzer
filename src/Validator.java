package src;

import java.nio.file.*;

public class Validator {
    public boolean isFileExists(String filePath) {
        boolean isExist = false;
        // Проверка существования файла
        if (filePath == null || filePath.isEmpty()) {
            isExist = false;
        } else {
            Path path = Paths.get(filePath);
            if (Files.isRegularFile(path)) {
                if (Files.exists(path)) {
                    isExist = true;
                } else {
                    System.out.println("Введите действительный путь файла");
                }
            }
        }
        return isExist;
    }
    public boolean isDirExists(String filePath) {
        boolean isExist = false;
        if (filePath == null || filePath.isEmpty()) {
            isExist = false;
        } else {
            Path path = Paths.get(filePath);
            if (Files.isDirectory(path)) {
                if (Files.exists(path)) {
                    isExist = true;
                } else {
                    System.out.println("Введите действительный путь директории");
                }
            }
        }
        return isExist;
    }

}


