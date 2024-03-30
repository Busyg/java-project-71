package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;

public class Parser {

    public static Map<Object, Map<String, Object[]>> parse(Path firstPath, Path secondPath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        if (firstPath.toString().endsWith("json") && secondPath.toString().endsWith("json")) {
            objectMapper = new JsonMapper();
        } else if (firstPath.toString().endsWith("yaml") && secondPath.toString().endsWith("yaml")) {
            objectMapper = new YAMLMapper();
        } else {
            System.out.println("Files format mismatch");
            return new TreeMap<>();
        }
        String firstFile = Files.readString(firstPath);
        String secondFile = Files.readString(secondPath);
        var firstMap = objectMapper.readValue(firstFile, Map.class);
        var secondMap = objectMapper.readValue(secondFile, Map.class);
        var mapSet = new TreeSet<>();
        Map<Object, Map<String, Object[]>> result = new TreeMap<>();

        mapSet.addAll(firstMap.keySet());
        mapSet.addAll(secondMap.keySet());

        for (var key : mapSet) {
            if (firstMap.containsKey(key) && secondMap.containsKey(key)) {
                if (Objects.equals(firstMap.get(key), secondMap.get(key))) {
                    result.put(key, Map.of("noChange", new Object[]{firstMap.get(key)}));
                } else {
                    result.put(key, Map.of("changed", new Object[]{firstMap.get(key), secondMap.get(key)}));
                }
            } else if (firstMap.containsKey(key) && !secondMap.containsKey(key)) {
                result.put(key, Map.of("removed", new Object[]{firstMap.get(key)}));
            } else {
                result.put(key, Map.of("added", new Object[]{secondMap.get(key)}));
            }
        }
        return result;
    }
}
