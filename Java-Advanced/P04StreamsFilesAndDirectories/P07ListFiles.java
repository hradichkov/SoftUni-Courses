package P04StreamsFilesAndDirectories;

import java.io.File;
import java.util.Arrays;

public class P07ListFiles {
    public static void main(String[] args) {

        File root = new File("C:\\Users\\hrist\\Desktop\\SoftUni\\3. Java Advanced\\" +
                "4 седмица - Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        Arrays.stream(root.listFiles())
                .filter(File::isFile)
                .forEach(f -> System.out.println(f.getName() + ": [" + f.length() + "]"));
    }
}
