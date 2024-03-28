package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

public class Parser {

    public static String parse(Path firstPath, Path secondPath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        if (firstPath.toString().endsWith("json") && secondPath.toString().endsWith("json")) {
            objectMapper = new JsonMapper();
        } else if (firstPath.toString().endsWith("yaml") && secondPath.toString().endsWith("yaml")) {
            objectMapper = new YAMLMapper();
        } else {
            System.out.println("Files format mismatch");
            return "";
        }
        String firstFile = Files.readString(firstPath);
        String secondFile = Files.readString(secondPath);
        var firstMap = objectMapper.readValue(firstFile, Map.class);
        var secondMap = objectMapper.readValue(secondFile, Map.class);
        var mapSet = new HashSet<>();
        var resultString = "";

        mapSet.addAll(firstMap.keySet());
        mapSet.addAll(secondMap.keySet());

        for (var key : mapSet) {
            if (firstMap.containsKey(key) && secondMap.containsKey(key)) {
                if (Objects.equals(firstMap.get(key), secondMap.get(key))) {
                    resultString += " " + key + ": " + String.valueOf(firstMap.get(key)) + "\n";
                } else {
                    resultString += "- " + key + ": " + String.valueOf(firstMap.get(key)) + "\n";
                    resultString += "+ " + key + ": " + String.valueOf(secondMap.get(key)) + "\n";
                }
            } else if (firstMap.containsKey(key) && !secondMap.containsKey(key)) {
                resultString += "- " + key + ": " + String.valueOf(firstMap.get(key)) + "\n";
            } else {
                resultString += "+ " + key + ": " + String.valueOf(secondMap.get(key)) + "\n";
            }
        }
        return resultString;
    }
}
