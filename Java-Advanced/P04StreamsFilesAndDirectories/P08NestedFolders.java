package P04StreamsFilesAndDirectories;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class P08NestedFolders {
    public static void main(String[] args) throws IOException {

        File root = new File("C:\\Users\\hrist\\Desktop\\SoftUni\\3. Java Advanced\\" +
                "4 седмица - Streams, Files and Directories\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\Files-and-Streams");

        System.out.println(Files.walk(root.toPath())
                .map(Path::toFile)
                .map(File::getName)
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
