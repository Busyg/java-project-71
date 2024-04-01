package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static hexlet.code.Differ.generate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private static String expectedStylish = null;
    private static String expectedPlain = null;
    private static String expectedJson = null;

    @BeforeAll
    public static void init() throws IOException {
        expectedStylish = Files.readString(Path.of("src/test/resources/expectedStylish.txt"));
        expectedPlain = Files.readString(Path.of("src/test/resources/expectedPlain.txt"));
        expectedJson = Files.readString(Path.of("src/test/resources/expectedJson.json"));
    }

    @Test
    public void defaultJsonTest() throws IOException {
        assertEquals(expectedStylish, generate("src/test/resources/file1.json",
                "src/test/resources/file2.json"));
    }

    @Test
    public void stylishJsonTest() throws IOException {
        assertEquals(expectedStylish, generate("src/test/resources/file1.json",
                "src/test/resources/file2.json", "stylish"));
    }

    @Test
    public void plainJsonTest() throws IOException {
        assertEquals(expectedPlain, generate("src/test/resources/file1.json",
                "src/test/resources/file2.json", "plain"));
    }

    @Test
    public void jsonJsonTest() throws IOException {
        assertEquals(expectedJson, generate("src/test/resources/file1.json",
                "src/test/resources/file2.json", "json"));
    }

    @Test
    public void defaultYamlTest() throws IOException {
        assertEquals(expectedStylish, generate("src/test/resources/file1.yml",
                "src/test/resources/file2.yml"));
    }

    @Test
    public void stylishYamlTest() throws IOException {
        assertEquals(expectedStylish, generate("src/test/resources/file1.yml",
                "src/test/resources/file2.yml", "stylish"));
    }

    @Test
    public void plainYamlTest() throws IOException {
        assertEquals(expectedPlain, generate("src/test/resources/file1.yml",
                "src/test/resources/file2.yml", "plain"));
    }

    @Test
    public void jsonYamlTest() throws IOException {
        assertEquals(expectedJson, generate("src/test/resources/file1.yml",
                "src/test/resources/file2.yml", "json"));
    }
}
