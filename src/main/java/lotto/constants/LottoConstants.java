package lotto.constants;

public enum LottoConstants {
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    NUMBERS_PER_GAME(6),
    BONUS_NUMBERS_PER_GAME(1);
    
    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
