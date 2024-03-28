package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static hexlet.code.Differ.generate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Tests {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Test
    public void differentJSONFilesTest() throws IOException {
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
    public void sameJSONFileTest() throws IOException {
        var expected = " proxy: 123.234.53.22\n"
                + " host: hexlet.io\n"
                + " follow: false\n"
                + " timeout: 50\n";
        assertEquals(expected, generate("F:/Git Repos/java-project-71/app/src/test/resources/file1.json",
                "src/test/resources/file1.json"));
    }

    @Test
    public void noJSONFileTest() throws IOException {
        assertThrows(IOException.class, () -> {
            generate("F:/Git Repos/java-project-71/app/src/test/resources/file1.json",
                    "src/test/resources/noFile.json");
        });
    }

    @Test
    public void differentYAMLFilesTest() throws IOException {
        var expected = " characteristics: null\n"
                + "- material: Cotton\n"
                + "+ material: Denim\n"
                + "- size: S\n"
                + "+ size: 28\n"
                + " available_sizes: null\n"
                + "- price: 100\n"
                + "+ price: 120\n"
                + " name: Product A\n"
                + "- type: T-shirt\n"
                + "+ type: Jeans\n"
                + " products: null\n";
        assertEquals(expected, generate("F:/Git Repos/java-project-71/app/src/test/resources/file1.yaml",
                "src/test/resources/file2.yaml"));
    }

    @Test
    public void sameYAMLFileTest() throws IOException {
        var expected = " characteristics: null\n"
                + " material: Cotton\n"
                + " size: S\n"
                + " available_sizes: null\n"
                + " price: 100\n"
                + " name: Product A\n"
                + " type: T-shirt\n"
                + " products: null\n";
        assertEquals(expected, generate("F:/Git Repos/java-project-71/app/src/test/resources/file1.yaml",
                "src/test/resources/file1.yaml"));
    }

    @Test
    public void noYAMLFileTest() throws IOException {
        assertThrows(IOException.class, () -> {
            generate("F:/Git Repos/java-project-71/app/src/test/resources/file1.yaml",
                    "src/test/resources/noFile.yaml");
        });
    }

    @Test
    public void differentFiletypesTest() throws IOException {
        System.setOut(new PrintStream(outputStreamCaptor));
        generate("F:/Git Repos/java-project-71/app/src/test/resources/file1.yaml",
                "src/test/resources/file2.json");
        assertEquals("Files format mismatch", outputStreamCaptor.toString().trim());
    }
}
