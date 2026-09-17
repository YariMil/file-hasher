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
            String[] fileMessages = new String[] {
                    "Abracadabra, this is notes.txt, built for hashing!",
                    "Did you know hashing is awesome because it puts any input into a 64 hex string?",
                    "Even in this log.txt, a hash function still works!"};
            for (int i = 0; i < fileNames.length; i++) {
                fileNames[i].createNewFile();
                FileWriter writerForFile = new FileWriter(fileNames[i]);
                writerForFile.write(fileMessages[i]);
                writerForFile.close();
            }
            StringBuilder backupString = new StringBuilder();
            System.out.println("== Reading files back ==");
            for (int i = 0; i < fileNames.length; i++) {
                FileReader readerForFile = new FileReader(fileNames[i]);
                System.out.println(fileNames[i].getName() + ": ");
                while (readerForFile.ready()) {
                    char c = (char) readerForFile.read();
                    backupString.append(c);
                    System.out.print(c);
                }
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
            System.out.println();
            System.out.println("== Hashing files ==");
            String notesHex = hashFile("JavaFileSystem/notes.txt");
            String dataHex = hashFile("JavaFileSystem/data.txt");
            String logHex = hashFile("JavaFileSystem/log.txt");
            System.out.println("notes.txt: " + notesHex);
            System.out.println("data.txt: " + dataHex);
            System.out.println("log.txt: " + logHex);
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    /**
     * Reads the file at filePath and returns its SHA-256 hash as a lowercase 64-character
     * hexadecimal string.
     */
    public static String hashFile(String filePath) throws IOException {
        FileReader file = new FileReader(new File(filePath));
        StringBuilder fileContentsBuilder = new StringBuilder();
        while (file.ready()) {
            fileContentsBuilder.append((char) file.read());
        }
        file.close();
        String fileContents = fileContentsBuilder.toString();
        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            byte[] hash = sha256.digest(fileContents.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {

        }

        return "";
    }
}
