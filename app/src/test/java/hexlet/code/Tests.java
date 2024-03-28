package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static hexlet.code.Differ.generate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Tests {
    @Test
    public void differentFilesTest() throws IOException {
        var expected = "- proxy: 123.234.53.22\n"
                + " host: hexlet.io\n"
                + "- follow: false\n"
                + "- timeout: 50\n"
                + "+ timeout: 20\n"
                + "+ verbose: true\n";
        assertEquals(expected, generate("F:/Git Repos/java-project-71/app/src/test/resources/file1.json",
                "src/test/resources/file2.json"));
    }

    @Test
    public void sameFileTest() throws IOException {
        var expected = " proxy: 123.234.53.22\n"
                + " host: hexlet.io\n"
                + " follow: false\n"
                + " timeout: 50\n";
        assertEquals(expected, generate("F:/Git Repos/java-project-71/app/src/test/resources/file1.json",
                "src/test/resources/file1.json"));
    }

    @Test
    public void noFileTest() throws IOException {
        assertThrows(IOException.class, () -> {
            generate("F:/Git Repos/java-project-71/app/src/test/resources/file1.json",
                    "src/test/resources/noFile.json");
        });
    }
}
