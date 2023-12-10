package lotto.domain;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;
import lotto.constants.LottoRank;
import lotto.utils.Parser;

public class WinningStatisticsResult {
    private static final String DEFAULT_RANK_PRINT_FORMAT = "%d개 일치 (%s원) - %d개";
    private static final String BONUS_RANK_PRINT_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public static String generateRankResults(EnumMap<LottoRank, Integer> ranks) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<LottoRank, Integer> entry : ranks.entrySet()) {
            LottoRank rank = entry.getKey();
            int winningCount = entry.getValue();

            String formattedResult = formatRankResult(rank, winningCount);
            sb.append(formattedResult).append(LINE_SEPARATOR);
        }
        return sb.toString();
    }

    private static String formatRankResult(LottoRank rank, int winningCount) {
        String resultSentence = selectRankSentence(rank);
        return buildFormattedRankResult(rank, winningCount, resultSentence);
    }

    private static String selectRankSentence(LottoRank rank) {
        String resultSentence = DEFAULT_RANK_PRINT_FORMAT;
        if (rank.isBonus()) {
            resultSentence = BONUS_RANK_PRINT_FORMAT;
        }
        return resultSentence;
    }

    private static String buildFormattedRankResult(LottoRank rank, int winningCount, String Sentence) {
        int matchingCount = rank.getMatchCount();
        BigDecimal prizeAmount = BigDecimal.valueOf(rank.getPrizeAmount());
        return String.format(Sentence, matchingCount, Parser.formatMoneyCurrency(prizeAmount), winningCount);
    }
}
