package hexlet.code;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

public class Differ {
    public static String generate(String filePath1, String filePath2) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String resultString = "";

        Path firstPath = Paths.get(filePath1).toAbsolutePath();
        Path secondPath = Paths.get(filePath2).toAbsolutePath();

        String firstFile = Files.readString(firstPath);
        String secondFile = Files.readString(secondPath);

        var firstMap = objectMapper.readValue(firstFile, Map.class);
        var secondMap = objectMapper.readValue(secondFile, Map.class);
        var mapSet = new HashSet<>();

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
