package lotto.domain.validator;

import static lotto.constants.LottoConstants.MAX_NUMBER;
import static lotto.constants.LottoConstants.MIN_NUMBER;
import static lotto.constants.LottoConstants.NUMBERS_PER_GAME;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;

public class LottoNumberValidator {

    public static void validateNumberInRange(int number) {
        if (number < MIN_NUMBER.getValue() || number > MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException("[ERROR] 1~45 숫자만 가능합니다.");
        }
    }

    public static void validateNumbersInRange(List<Integer> numbers) {
        for (int number : numbers) {
            validateNumberInRange(number);
        }
    }

    public static void validateNumbersCount(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_PER_GAME.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개이여야 합니다.");
        }
    }

    public static void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
        }
    }

    public static void validateDuplicateBonus(Lotto numbers, int bonusNumber) {
        List<Integer> winningNumbers = numbers.getNumbers();
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 존재합니다.");
        }
    }
}
