package demo.project.Lottery.Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@DiscriminatorValue("LOTTO_649")
public class Lotto649 extends LotteryTicket{
    private final int LOWER_LIMIT = 1;
    private final int UPPER_LIMIT = 49;
    private final int NUMBER_OF_NUMBERS = 6;
    private final int NUMBER_OF_LINES = 1;

    @Enumerated(EnumType.STRING)
    private LotteryTicketType lotteryTicketType;
}
