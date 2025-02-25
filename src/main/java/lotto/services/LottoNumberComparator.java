package lotto.services;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.enums.LottoPrize;

public class LottoNumberComparator {
    private final List<Lotto> purchasedLottos;
    private final WinningLotto winningLotto;
    private final EnumMap<LottoPrize, Integer> prizeCount;

    public LottoNumberComparator(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        this.purchasedLottos = purchasedLottos;
        this.winningLotto = winningLotto;
        this.prizeCount = new EnumMap<>(LottoPrize.class);
        initializePrizeCount();
    }

    public EnumMap<LottoPrize, Integer> getPrizeCount() {
        return prizeCount;
    }

    protected void initializePrizeCount() {
        for (LottoPrize rank : LottoPrize.values()) {
            prizeCount.put(rank, 0);
        }
    }

    public void calculatePrizes() {
        for (Lotto lotto : purchasedLottos) {
            int matchCount = countMatchingNumbers(lotto);
            boolean isBonus = isBonusNumberMatched(lotto, winningLotto.getBonusNumber());
            LottoPrize rank = determinePrize(matchCount, isBonus);

            updatePrizeCount(rank);
        }
    }

    protected int countMatchingNumbers(Lotto purchasedLotto) {
        int matchCount = 0;
        List<Integer> winningNumbers = winningLotto.getWinningLotto().getNumbers();
        List<Integer> purchasedNumbers = purchasedLotto.getNumbers();
        for (int number : purchasedNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    protected boolean isBonusNumberMatched(Lotto purchasedLotto, int bonusNumber) {
        List<Integer> purchasedNumbers = purchasedLotto.getNumbers();
        return purchasedNumbers.contains(bonusNumber);
    }

    protected LottoPrize determinePrize(int matchCount, boolean bonus) {
        return LottoPrize.calculate(matchCount, bonus);
    }

    protected void updatePrizeCount(LottoPrize rank) {
        if (rank != null) {
            prizeCount.put(rank, prizeCount.get(rank) + 1);
        }
    }
}
