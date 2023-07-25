package demo.project.Lottery.Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@DiscriminatorValue("LOTTO_MAX")
public class LottoMax extends LotteryTicket{
    private final int LOWER_LIMIT = 1;
    private final int UPPER_LIMIT = 50;
    private final int NUMBER_OF_NUMBERS = 7;
    private final int NUMBER_OF_LINES = 3;

    @Enumerated(EnumType.STRING)
    private LotteryTicketType lotteryTicketType;
}
