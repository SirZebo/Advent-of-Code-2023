import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFiles {

    Scanner line;

    public ReadFiles(String fileDir) {
        try {
            File file = new File(fileDir);
            this.line = new Scanner(file);

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }

    public boolean hasNextLine() {
        return line.hasNextLine();
    }

    public String nextLine() {
        return line.nextLine();
    }
}
