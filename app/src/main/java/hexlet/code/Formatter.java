package hexlet.code;

import java.util.Map;

import static hexlet.code.formatters.PlainFormatter.plainFormatter;
import static hexlet.code.formatters.StylishFormatter.stylishFormatter;

public class Formatter {
    public static String format(Map<Object, Map<String, Object[]>> parsedMap, String format) {
        var resultString = "";
        switch (format) {
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
