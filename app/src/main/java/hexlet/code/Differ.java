package hexlet.code;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Differ {
    public static String generate(String filePath1, String filePath2) throws IOException {
        Path firstPath = Paths.get(filePath1).toAbsolutePath();
        Path secondPath = Paths.get(filePath2).toAbsolutePath();
        return Parser.parse(firstPath, secondPath);
    }
}
