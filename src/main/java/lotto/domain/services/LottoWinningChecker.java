package lotto.domain.services;

import java.util.EnumMap;
import java.util.List;
import lotto.constants.LottoRank;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public class LottoWinningChecker {
    private final List<Lotto> purchasedLottos;
    private final WinningLotto winningLotto;
    private final EnumMap<LottoRank, Integer> rankCount;

    public LottoWinningChecker(List<Lotto> purchasedLottos, WinningLotto winningLotto) {
        this.purchasedLottos = purchasedLottos;
        this.winningLotto = winningLotto;
        this.rankCount = new EnumMap<>(LottoRank.class);
        initializePrizeCount();
    }

    private void initializePrizeCount() {
        for (LottoRank rank : LottoRank.values()) {
            rankCount.put(rank, 0);
        }
    }

    public void updateRankCount() {
        for (Lotto lotto : purchasedLottos) {
            int matchingCount = countMatchingNumbers(lotto);
            boolean hasBonusNumber = isBonusNumberMatched(lotto, winningLotto.getBonusNumber());
            LottoRank rank = calculateRank(matchingCount, hasBonusNumber);

            if (rank != null) {
                rankCount.put(rank, rankCount.get(rank) + 1);
            }
        }
    }

    private int countMatchingNumbers(Lotto purchasedLotto) {
        List<Integer> winningNumbers = winningLotto.getWinningNumbers();
        List<Integer> purchasedNumbers = purchasedLotto.getNumbers();
        return (int) purchasedNumbers.stream().filter(winningNumbers::contains).count();
    }

    private boolean isBonusNumberMatched(Lotto purchasedLotto, int bonusNumber) {
        List<Integer> purchasedNumbers = purchasedLotto.getNumbers();
        return purchasedNumbers.contains(bonusNumber);
    }

    private LottoRank calculateRank(int matchingCount, boolean hasBonusNumber) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank.getMatchCount() == matchingCount && rank.isBonus() == hasBonusNumber) {
                return rank;
            }
        }
        return null;
    }
}
