package demo.project.Lottery.Service;

import demo.project.Lottery.Model.LotteryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("LottoMaxService")
public class LottoMaxService extends NumbersGeneratorService {

    @Autowired
    public LottoMaxService() {
        super(LotteryType.LOTTOMAX);
    }

    @Override
    protected String[] getTicket(List<Integer> userGeneratedLine) {
        String[] ticket = new String[LotteryType.LOTTOMAX.getNUMBER_OF_LINES()];
        if(userGeneratedLine.size() != LotteryType.LOTTOMAX.getNUMBER_OF_NUMBERS()){
            throw new IllegalArgumentException("Not valid line");
        }
        ticket[0] = userGeneratedLine.toString();
        for (int i = 1; i < ticket.length; i++) {
            ticket[i] = generateLine().toString();
        }
        return ticket;
    }

}
