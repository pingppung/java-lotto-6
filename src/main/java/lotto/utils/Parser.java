package lotto.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String SEPARATOR = ",";
    private static final String MONEY_CURRENCY_PATTERN = "###,###";

    public static List<Integer> parseWinnginNumbers(String input) {
        return Arrays.stream(input.split(SEPARATOR))
                .map(String::trim)
                .map(Parser::convertToInt)
                .toList();
    }

    private static Integer convertToInt(String number) {
        return InputValidator.validateNonNumeric(number);
    }

    private static String formatCurrency(BigDecimal amount, String pattern) {
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        return decimalFormat.format(amount);
    }

    public static String formatMoneyCurrency(BigDecimal amount) {
        return formatCurrency(amount, MONEY_CURRENCY_PATTERN);
    }


}