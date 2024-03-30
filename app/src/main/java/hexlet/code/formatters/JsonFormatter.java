package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class JsonFormatter {
    public static String jsonFormatter(Map<Object, Map<String, Object[]>> parsedMap)
            throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        var addedMap = new TreeMap<>();
        var changedMap = new TreeMap<>();
        var notChangedMap = new TreeMap<>();
        var removedMap = new TreeMap<>();
        var resultMap = new HashMap<>();
        for (var key : parsedMap.entrySet()) {
            for (var entry : key.getValue().entrySet()) {
                switch (entry.getKey()) {
                    case "noChange":
                        notChangedMap.put(key.getKey(), entry.getValue()[0]);
                        break;
                    case "changed":
                        changedMap.put(key.getKey(), new String[] {
                                entry.getValue()[0] == null ? "null" : entry.getValue()[0].toString(),
                                entry.getValue()[1] == null ? "null" : entry.getValue()[1].toString()
                        });
                        break;
                    case "removed":
                        removedMap.put(key.getKey(), entry.getValue()[0]);
                        break;
                    case "added":
                        addedMap.put(key.getKey(), entry.getValue()[0]);
                        break;
                    default:
                        break;
                }
            }
        }
        resultMap.put("added", addedMap);
        resultMap.put("changed", changedMap);
        resultMap.put("notChanged", notChangedMap);
        resultMap.put("removed", removedMap);
        var resultString = objectMapper.writeValueAsString(resultMap);
        return resultString;
    }
}
