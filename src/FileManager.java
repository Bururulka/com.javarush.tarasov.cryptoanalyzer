package src;

import java.io.IOException;
import java.nio.file.*;

public class FileManager {
    public String readFile(String filePath) throws IOException {
        // Логика чтения файла
        Path path = Paths.get(filePath);
        return Files.readString(path);
    }
    public void writeFile(String content, String filePath) {
        // Логика записи файла
        try {
            Files.createFile(Path.of(filePath));
            Files.writeString(Path.of(filePath), content);
        }
        catch (IOException e) {
            System.out.println("Неизвестная ошибка");
        }
    }
}
