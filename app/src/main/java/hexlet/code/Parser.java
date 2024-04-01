package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;

public class Parser {

    public static Map<Object, Map<String, Object[]>> parse(String firstString, String secondString, String fileFormat)
            throws IOException {
        ObjectMapper objectMapper = fileFormat.equals("json") ? new JsonMapper() : new YAMLMapper();
        var firstMap = objectMapper.readValue(firstString, Map.class);
        var secondMap = objectMapper.readValue(secondString, Map.class);
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
