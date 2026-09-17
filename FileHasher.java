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
            String[] fileNames = new String[] {"notes.txt", "data.txt", "log.txt"};
            for (int i = 0; i < fileNames.length; i++) {
                File newFile = new File("JavaFileSystem/" + fileNames[i]);
                newFile.createNewFile();
                FileWriter writerForFile = new FileWriter(newFile);
                writerForFile.write("This is " + fileNames[i] + ". Hooray! Yipee! I love it!");
                writerForFile.close();
            }
            // TODO (FH-3): read each file back, print it, and write all three into
            // Backup/backup.txt
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
