package lotto.domain;

import static lotto.constants.LottoConstants.MAX_NUMBER;
import static lotto.constants.LottoConstants.MIN_NUMBER;

import java.util.List;

public class LottoNumberValidator {
    public void validateNumberInRange(int number) {
        if (number < MIN_NUMBER.getValue() || number > MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException("[ERROR] 1~45 숫자만 가능합니다.");
        }
    }

    public void validateInRangeWinningNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberInRange(number);
        }
    }

}
