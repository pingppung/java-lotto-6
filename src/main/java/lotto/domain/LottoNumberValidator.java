package lotto.domain;

import static lotto.constants.LottoConstants.MAX_NUMBER;
import static lotto.constants.LottoConstants.MIN_NUMBER;
import static lotto.constants.LottoConstants.NUMBERS_PER_GAME;

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

    public void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_PER_GAME.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개이여야 합니다.");
        }
    }
}
