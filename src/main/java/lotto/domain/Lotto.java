package lotto.domain;

import java.util.List;
import lotto.domain.validator.LottoNumberValidator;

public class Lotto {
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoNumberValidator.validateNumbersInRange(numbers);
        LottoNumberValidator.validateNumbersCount(numbers);
        LottoNumberValidator.validateDuplicateNumbers(numbers);
    }
}
