package lotto.domain;

import lotto.domain.validator.LottoNumberValidator;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        validate();
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate() {
        LottoNumberValidator.validateDuplicateBonus(winningNumbers, bonusNumber);
    }
}
