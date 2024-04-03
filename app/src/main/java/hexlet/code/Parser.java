package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.Map;

public class Parser {

    public static Map<String, Object[]> parse(String fileString, String fileFormat)
            throws IOException {
        ObjectMapper objectMapper = fileFormat.equals("json") ? new JsonMapper() : new YAMLMapper();
        return objectMapper.readValue(fileString, Map.class);
    }
}
