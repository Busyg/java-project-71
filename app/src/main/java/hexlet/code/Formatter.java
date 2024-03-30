package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Map;

import static hexlet.code.formatters.JsonFormatter.jsonFormatter;
import static hexlet.code.formatters.PlainFormatter.plainFormatter;
import static hexlet.code.formatters.StylishFormatter.stylishFormatter;

public class Formatter {
    public static String format(Map<Object, Map<String, Object[]>> parsedMap, String format)
            throws JsonProcessingException {
        var resultString = "";
        switch (format) {
            case "json":
                resultString = jsonFormatter(parsedMap);
                break;
            case "plain":
                resultString = plainFormatter(parsedMap);
                break;
            case "stylish":
            default:
                resultString = stylishFormatter(parsedMap);
                break;
        }
        return resultString;
    }


}
