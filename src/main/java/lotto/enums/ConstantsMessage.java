package lotto.enums;

public enum ConstantsMessage {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    CONFIRM_PURCHASE_COUNT("%d개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    LOTTO_RESULT_HEADER("당첨 통계"),
    LOTTO_RESULT_SECTION("---"),
    PROFIT_RATE_MESSAGE("총 수익률은 %s%%입니다.");

    public final String message;

    ConstantsMessage(String message) {
        this.message = message;
    }
}
