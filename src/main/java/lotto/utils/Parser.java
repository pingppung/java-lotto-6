package lotto.utils;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String SEPARATOR = ",";

    public static List<Integer> parseWinnginNumbers(String input) {
        return Arrays.stream(input.split(SEPARATOR))
                .map(String::trim)
                .map(Parser::convertToInt)
                .toList();
    }

    private static Integer convertToInt(String number) {
        return InputValidator.validateNonNumeric(number);
    }

}