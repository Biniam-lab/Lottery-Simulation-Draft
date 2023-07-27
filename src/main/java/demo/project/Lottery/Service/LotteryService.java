package demo.project.Lottery.Service;

import demo.project.Lottery.Model.LotteryPlayMethod;
import demo.project.Lottery.Model.LotteryTicket;
import demo.project.Lottery.Model.LotteryType;
import demo.project.Lottery.Repository.LotteryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LotteryService {

    @Autowired
    private LotteryRepository lotteryRepository;

    @Autowired
    private NumbersGeneratorService numbersGeneratorService;

    public LotteryTicket saveTicketMax(String type, String method, LotteryTicket lotteryTicket) {

        if (type.equalsIgnoreCase(LotteryType.LOTTOMAX.name()) &&
                method.equalsIgnoreCase(LotteryPlayMethod.QUICK_PICK.name())) {
            lotteryTicket.setLotteryPlayMethod(LotteryPlayMethod.QUICK_PICK);
            lotteryTicket.setLotteryType(LotteryType.LOTTOMAX);
            String[] pickedLine = numbersGeneratorService.lottoMaxNumberGenerator();
            lotteryTicket.setTicket(pickedLine);
            return lotteryRepository.save(lotteryTicket);
        }
        return null;
    }

    //int randomNumber = lotteryType.getLOWER_LIMIT() + random.nextInt((lotteryType.getUPPER_LIMIT() - lotteryType.getLOWER_LIMIT()) + 1);
}
