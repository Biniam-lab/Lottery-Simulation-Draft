package demo.project.Lottery.Model;

public enum LotteryType {
    LOTTOMAX(1, 50, 7, 3),
    LOTTO649(1, 49, 6, 1);

    private final int LOWER_LIMIT;
    private final int UPPER_LIMIT;
    private final int NUMBER_OF_NUMBERS;
    private final int NUMBER_OF_LINES;

    LotteryType(int LOWER_LIMIT, int UPPER_LIMIT, int NUMBER_OF_NUMBERS, int NUMBER_OF_LINES) {
        this.LOWER_LIMIT = LOWER_LIMIT;
        this.UPPER_LIMIT = UPPER_LIMIT;
        this.NUMBER_OF_NUMBERS = NUMBER_OF_NUMBERS;
        this.NUMBER_OF_LINES = NUMBER_OF_LINES;
    }

    public int getLOWER_LIMIT() {
        return LOWER_LIMIT;
    }

    public int getUPPER_LIMIT() {
        return UPPER_LIMIT;
    }

    public int getNUMBER_OF_NUMBERS() {
        return NUMBER_OF_NUMBERS;
    }

    public int getNUMBER_OF_LINES() {
        return NUMBER_OF_LINES;
    }
}
