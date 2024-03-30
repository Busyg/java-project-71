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
        var expected = "Property 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed.\n"
                + "Property 'key2' was added with value: value2\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From Some value to Another value\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to none";
        assertEquals(expected, generate("F:/Git Repos/java-project-71/app/src/test/resources/file1.json",
                "src/test/resources/file2.json", "plain"));
    }

    @Test
    public void jsonJSONFilesTest() throws IOException {
        var expected = "{\"removed\":{\"key1\":\"value1\",\"numbers3\":[3,4,5]},\"added\":{\"key2\":\"value2\","
                + "\"numbers4\":[4,5,6],\"obj1\":{\"nestedKey\":\"value\",\"isNested\":true}},"
                + "\"notChanged\":{\"chars1\":[\"a\",\"b\",\"c\"],\"numbers1\":[1,2,3,4]},"
                + "\"changed\":{\"chars2\":[\"[d, e, f]\",\"false\"],\"checked\":[\"false\",\"true\"],\"default\":"
                + "[\"null\",\"[value1, value2]\"],\"id\":[\"45\",\"null\"],\"numbers2\":[\"[2, 3, 4, 5]\","
                + "\"[22, 33, 44, 55]\"],\"setting1\":[\"Some value\",\"Another value\"],"
                + "\"setting2\":[\"200\",\"300\"],\"setting3\":[\"true\",\"none\"]}}";
        assertEquals(expected, generate("F:/Git Repos/java-project-71/app/src/test/resources/file1.json",
                "src/test/resources/file2.json", "json"));
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
        assertEquals(expected, generate("F:/Git Repos/java-project-71/app/src/test/resources/file1.yml",
                "src/test/resources/file2.yml", "stylish"));
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
        assertEquals(expected, generate("F:/Git Repos/java-project-71/app/src/test/resources/file1.yml",
                "src/test/resources/file1.yml", "stylish"));
    }

    @Test
    public void noYAMLFileTest() throws IOException {
        assertThrows(IOException.class, () -> {
            generate("F:/Git Repos/java-project-71/app/src/test/resources/file1.yml",
                    "src/test/resources/noFile.yml", "stylish");
        });
    }

    @Test
    public void plainYAMLFilesTest() throws IOException {
        var expected = "Property 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: value2\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From Some value to Another value\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to none";
        assertEquals(expected, generate("F:/Git Repos/java-project-71/app/src/test/resources/file1.yml",
                "src/test/resources/file2.yml", "plain"));
    }

    @Test
    public void jsonYAMLFilesTest() throws IOException {
        var expected = "{\"removed\":{\"key1\":\"value1\",\"numbers3\":[3,4,5]},\"added\":{\"key2\":\"value2\","
                + "\"numbers4\":[4,5,6],\"obj1\":{\"nestedKey\":\"value\",\"isNested\":true}},"
                + "\"notChanged\":{\"chars1\":[\"a\",\"b\",\"c\"],\"numbers1\":[1,2,3,4]},"
                + "\"changed\":{\"chars2\":[\"[d, e, f]\",\"false\"],\"checked\":[\"false\",\"true\"],\"default\":"
                + "[\"null\",\"[value1, value2]\"],\"id\":[\"45\",\"null\"],\"numbers2\":[\"[2, 3, 4, 5]\","
                + "\"[22, 33, 44, 55]\"],\"setting1\":[\"Some value\",\"Another value\"],"
                + "\"setting2\":[\"200\",\"300\"],\"setting3\":[\"true\",\"none\"]}}";
        assertEquals(expected, generate("F:/Git Repos/java-project-71/app/src/test/resources/file1.yml",
                "src/test/resources/file2.yml", "json"));
    }

    @Test
    public void differentFiletypesTest() throws IOException {
        System.setOut(new PrintStream(outputStreamCaptor));
        generate("F:/Git Repos/java-project-71/app/src/test/resources/file1.yml",
                "src/test/resources/file2.json", "plain");
        assertEquals("Files format mismatch", outputStreamCaptor.toString().trim());
    }
}
