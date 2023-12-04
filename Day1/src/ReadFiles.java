import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFiles {

    Scanner lines;

    public ReadFiles(String fileDir) {
        try {
            File file = new File(fileDir);
            this.lines = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }

    public boolean hasNextLine() {
        return lines.hasNextLine();
    }

    public String nextLine() {
        return lines.nextLine();
    }


}
