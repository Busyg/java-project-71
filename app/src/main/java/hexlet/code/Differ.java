package hexlet.code;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        Path firstPath = Paths.get(filePath1).toAbsolutePath();
        Path secondPath = Paths.get(filePath2).toAbsolutePath();
        var parsedMap = Parser.parse(firstPath, secondPath);
        return Formatter.format(parsedMap, format);
    }

    public static String generate(String filePath1, String filePath2) throws IOException {
        Path firstPath = Paths.get(filePath1).toAbsolutePath();
        Path secondPath = Paths.get(filePath2).toAbsolutePath();
        var parsedMap = Parser.parse(firstPath, secondPath);
        return Formatter.format(parsedMap, "stylish");
    }
}
