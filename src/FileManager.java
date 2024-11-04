package src;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class FileManager {
    public List<String> readFile(String filePath) throws IOException {
        // Логика чтения файла
        Path path = Path.of(filePath);
        return Files.readAllLines(path);
    }
    public void writeFile(List<String> content, String filePath) {
        // Логика записи файла
        try {
            Files.createFile(Path.of(filePath));
            Files.write(Path.of(filePath), content);
        }
        catch (IOException e) {
            System.out.println("Неизвестная ошибка");
        }
    }
}
