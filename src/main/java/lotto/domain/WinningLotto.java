package lotto.domain;

import java.util.List;
import lotto.domain.validator.LottoNumberValidator;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        validate();
    }

    private void validate() {
        LottoNumberValidator.validateDuplicateBonus(winningNumbers, bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers.getNumbers();
    }
}
