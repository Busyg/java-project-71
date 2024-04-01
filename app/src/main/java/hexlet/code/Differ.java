package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        Path firstPath = Paths.get(filePath1).toAbsolutePath();
        Path secondPath = Paths.get(filePath2).toAbsolutePath();
        var firstString = readFile(firstPath);
        var secondString = readFile(secondPath);
        var fileFormat = checkFileFormat(firstPath, secondPath);
        var parsedMap = Parser.parse(firstString, secondString, fileFormat);
        return Formatter.format(parsedMap, format);
    }

    public static String generate(String filePath1, String filePath2) throws IOException {
        Path firstPath = Paths.get(filePath1).toAbsolutePath();
        Path secondPath = Paths.get(filePath2).toAbsolutePath();
        var firstString = readFile(firstPath);
        var secondString = readFile(secondPath);
        var fileFormat = checkFileFormat(firstPath, secondPath);
        var parsedMap = Parser.parse(firstString, secondString, fileFormat);
        return Formatter.format(parsedMap, "stylish");
    }

    public static String readFile(Path filePath) throws IOException {
        return Files.readString(filePath);
    }

    public static String checkFileFormat(Path firstPath, Path secondPath) {
        if (firstPath.toString().endsWith("json") && secondPath.toString().endsWith("json")) {
            return "json";
        } else if (firstPath.toString().endsWith("yml") && secondPath.toString().endsWith("yml")) {
            return "yml";
        } else {
            throw new RuntimeException("Files format mismatch");
        }
    }
}
