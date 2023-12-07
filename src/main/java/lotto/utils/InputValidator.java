package lotto.utils;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {
    public static int validateNonNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다");
        }
    }

    public static List<Integer> validateNonNumericWinningNumbers(List<String> inputs) {
        List<Integer> numbers = new ArrayList<>();
        for (String input : inputs) {
            numbers.add(validateNonNumeric(input));
        }
        return numbers;
    }
}
