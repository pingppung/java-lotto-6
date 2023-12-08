package lotto.domain;

import static lotto.domain.validator.LottoNumberValidator.validateDuplicateBonus;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        validate();
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate() {
        validateDuplicateBonus(winningNumbers, bonusNumber);
    }
}
