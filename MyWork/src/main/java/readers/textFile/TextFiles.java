package readers.textFile;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextFiles {

    public static final String ENTER = "\n";

    @Test
    public void createTextFile() throws IOException {
        String file = "src/test/resources/datafiles/myTextFile1.txt";

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("Hasan" + ENTER);
        fileWriter.write("Özyer");
        fileWriter.close();

    }

    @Test
    public void writeToTextFile() throws IOException {
        String file = "src/test/resources/datafiles/myTextFile1.txt";

        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write("Java" + ENTER);
        fileWriter.write("World" + ENTER);
        fileWriter.close();
    }

    @Test
    public void readTextFile() throws IOException {
        String file = "src/test/resources/datafiles/myTextFile1.txt";
        Scanner sc = new Scanner(new File(file));
        while (sc.hasNext()) {
            System.out.println(sc.nextLine());
        }

        /*System.out.println(fileReader.read());
        System.out.println((int) 'H');*/

    }

}
