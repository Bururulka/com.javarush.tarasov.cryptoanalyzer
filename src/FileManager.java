package src;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class FileManager {
    public List<String> readFile(String filePath) throws IOException {
        Path path = Path.of(filePath);
        return Files.readAllLines(path);
    }
    public void writeFile(List<String> content, String pathToWrite){
        // Логика записи файла
        try {
            Files.createFile(Path.of(pathToWrite));
            Files.write(Path.of(pathToWrite), content);
        }
        catch (IOException e) {
            System.out.println("Неизвестная ошибка записи в файл");
        }
    }
    public void createNewDir(String pathToWrite){
        try {
            Files.createDirectory(Path.of(pathToWrite));
        }
        catch (IOException e) {
            System.out.println("Неизвестная ошибка создания директории");
        }
    }
}
