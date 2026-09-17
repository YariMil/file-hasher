import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



public class FileHasher {
    public static void main(String[] args) {
        try {
            File javaFileSystem = new File("JavaFileSystem");
            javaFileSystem.mkdir();
            File[] fileNames = new File[] {new File("JavaFileSystem/notes.txt"),
                    new File("JavaFileSystem/data.txt"), new File("JavaFileSystem/log.txt")};
            for (int i = 0; i < fileNames.length; i++) {
                fileNames[i].createNewFile();
                FileWriter writerForFile = new FileWriter(fileNames[i]);
                writerForFile.write("This is " + fileNames[i].getName()
                        + ". Hooray! Yipee! I love it! Actually, I should back this up.");
                writerForFile.close();
            }
            StringBuilder backupString = new StringBuilder();
            for (int i = 0; i < fileNames.length; i++) {
                FileReader readerForFile = new FileReader(fileNames[i]);
                while (readerForFile.ready()) {
                    char c = (char) readerForFile.read();
                    backupString.append(c);
                    System.out.print(c);
                }
                System.out.println();
                backupString.append("\n");
                readerForFile.close();
            }
            File backupDir = new File("Backup");
            backupDir.mkdir();
            File backupFile = new File("Backup/backup.txt");
            FileWriter backupWriter = new FileWriter(backupFile);
            backupFile.createNewFile();
            backupWriter.write(backupString.toString());
            backupWriter.close();
            // TODO (FH-4): print each file's name next to hashFile(path)
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    /**
     * Reads the file at filePath and returns its SHA-256 hash as a lowercase 64-character
     * hexadecimal string.
     */
    public static String hashFile(String filePath) throws IOException {
        // TODO (FH-4): read the whole file, digest it, convert the bytes to hex
        return "";
    }
}
