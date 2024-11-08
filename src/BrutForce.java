package src;

import java.io.File;
import java.util.List;

public class BrutForce  {
    //сохранить все возможные варианты по всем ключам
    private char[] alphabet;
    public BrutForce(char[] alphabet) {
        this.alphabet = alphabet;
    }
    public void unlock(List<String> text, String path) {
        Cipher cipher = new Cipher(alphabet);
        FileManager fileManager = new FileManager();
        String pathWithFileName;
        for (int i = 0; i < alphabet.length; i++) {
            pathWithFileName = "";
            List<String> newFile;
            newFile = cipher.crypt(text, i, 2);
            pathWithFileName = path + File.separator +"brutForse_" + i+".txt";
            fileManager.writeFile(newFile, pathWithFileName);
        }
    }
}
