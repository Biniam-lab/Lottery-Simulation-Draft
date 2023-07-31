package demo.project.Lottery.Service;

import demo.project.Lottery.Model.LotteryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("Lotto649Service")
public class Lotto649Service extends NumbersGeneratorService {

    @Autowired
    public Lotto649Service() {
        super(LotteryType.LOTTO649);
    }

    @Override
    protected String[] getTicket(List<Integer> userGeneratedLine) {
        String[] ticket = new String[LotteryType.LOTTO649.getNUMBER_OF_LINES()];
        if(userGeneratedLine.size() != LotteryType.LOTTO649.getNUMBER_OF_NUMBERS()){
            throw new IllegalArgumentException("Not valid line");
        }
        ticket[0] = userGeneratedLine.toString();
        return ticket;
    }

}
