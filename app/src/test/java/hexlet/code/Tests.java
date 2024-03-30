package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static hexlet.code.Differ.generate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Tests {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Test
    public void differentJSONFilesTest() throws IOException {
        var expected = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";
        assertEquals(expected, generate("F:/Git Repos/java-project-71/app/src/test/resources/file1.json",
                "src/test/resources/file2.json", "stylish"));
    }

    @Test
    public void sameJSONFileTest() throws IOException {
        var expected = "{\n"
                + "    chars1: [a, b, c]\n"
                + "    chars2: [d, e, f]\n"
                + "    checked: false\n"
                + "    default: null\n"
                + "    id: 45\n"
                + "    key1: value1\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "    numbers2: [2, 3, 4, 5]\n"
                + "    numbers3: [3, 4, 5]\n"
                + "    setting1: Some value\n"
                + "    setting2: 200\n"
                + "    setting3: true\n"
                + "}";
        assertEquals(expected, generate("F:/Git Repos/java-project-71/app/src/test/resources/file1.json",
                "src/test/resources/file1.json", "stylish"));
    }

    @Test
    public void noJSONFileTest() throws IOException {
        assertThrows(IOException.class, () -> {
            generate("F:/Git Repos/java-project-71/app/src/test/resources/file1.json",
                    "src/test/resources/noFile.json", "stylish");
        });
    }

    @Test
    public void plainJSONFilesTest() throws IOException {
        var expected = "Property 'chars2' was updated. From [d, e, f] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [value1, value2]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed.\n"
                + "Property 'key2' was added with value: value2\n"
                + "Property 'numbers2' was updated. From [2, 3, 4, 5] to [22, 33, 44, 55]\n"
                + "Property 'numbers3' was removed.\n"
                + "Property 'numbers4' was added with value: [4, 5, 6]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From Some value to Another value\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to none\n";
        assertEquals(expected, generate("F:/Git Repos/java-project-71/app/src/test/resources/file1.json",
                "src/test/resources/file2.json", "plain"));
    }

    @Test
    public void differentYAMLFilesTest() throws IOException {
        var expected = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";
        assertEquals(expected, generate("F:/Git Repos/java-project-71/app/src/test/resources/file1.yaml",
                "src/test/resources/file2.yaml", "stylish"));
    }

    @Test
    public void sameYAMLFileTest() throws IOException {
        var expected = "{\n"
                + "    chars1: [a, b, c]\n"
                + "    chars2: [d, e, f]\n"
                + "    checked: false\n"
                + "    default: null\n"
                + "    id: 45\n"
                + "    key1: value1\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "    numbers2: [2, 3, 4, 5]\n"
                + "    numbers3: [3, 4, 5]\n"
                + "    setting1: Some value\n"
                + "    setting2: 200\n"
                + "    setting3: true\n"
                + "}";
        assertEquals(expected, generate("F:/Git Repos/java-project-71/app/src/test/resources/file1.yaml",
                "src/test/resources/file1.yaml", "stylish"));
    }

    @Test
    public void noYAMLFileTest() throws IOException {
        assertThrows(IOException.class, () -> {
            generate("F:/Git Repos/java-project-71/app/src/test/resources/file1.yaml",
                    "src/test/resources/noFile.yaml", "stylish");
        });
    }

    @Test
    public void plainYAMLFilesTest() throws IOException {
        var expected = "Property 'chars2' was updated. From [d, e, f] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [value1, value2]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed.\n"
                + "Property 'key2' was added with value: value2\n"
                + "Property 'numbers2' was updated. From [2, 3, 4, 5] to [22, 33, 44, 55]\n"
                + "Property 'numbers3' was removed.\n"
                + "Property 'numbers4' was added with value: [4, 5, 6]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From Some value to Another value\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to none\n";
        assertEquals(expected, generate("F:/Git Repos/java-project-71/app/src/test/resources/file1.yaml",
                "src/test/resources/file2.yaml", "plain"));
    }

    @Test
    public void differentFiletypesTest() throws RuntimeException {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            generate("F:/Git Repos/java-project-71/app/src/test/resources/file1.yaml",
                    "src/test/resources/file2.json", "stylish");
        });
        assertEquals("Files format mismatch", exception.getMessage());
    }
}
