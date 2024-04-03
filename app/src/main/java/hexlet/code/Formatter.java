package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Map;

import static hexlet.code.formatters.JsonFormatter.jsonFormatter;
import static hexlet.code.formatters.PlainFormatter.plainFormatter;
import static hexlet.code.formatters.StylishFormatter.stylishFormatter;

public class Formatter {
    public static String format(List<Map<String, Object>> parsedMapList, String format)
            throws JsonProcessingException {
        var resultString = "";
        switch (format) {
            case "json":
                resultString = jsonFormatter(parsedMapList);
                break;
            case "plain":
                resultString = plainFormatter(parsedMapList);
                break;
            case "stylish":
                resultString = stylishFormatter(parsedMapList);
                break;
            default:
                throw new RuntimeException("Unsupported format: " + format);
        }
        return resultString;
    }


}
