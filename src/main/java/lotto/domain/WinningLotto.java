package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final List<Lotto> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Lotto> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
