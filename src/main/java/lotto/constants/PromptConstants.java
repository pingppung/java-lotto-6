package lotto.constants;

public enum PromptConstants {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    CONFIRM_PURCHASE_COUNT("%d개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS_HEADER("당첨 통계"),
    WINNING_STATISTICS_SECTION("---"),
    PROFIT_RATE_MESSAGE("총 수익률은 %s%%입니다.");
    public final String message;

    PromptConstants(String message) {
        this.message = message;
    }
}
