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

    private String[] pickedLine;

    public LotteryTicket saveTicket(String type, String method, LotteryTicket lotteryTicket) {

        if (type.equalsIgnoreCase(LotteryType.LOTTOMAX.name()) &&
                method.equalsIgnoreCase(LotteryPlayMethod.QUICK_PICK.name())) {
            lotteryTicket.setLotteryPlayMethod(LotteryPlayMethod.QUICK_PICK);
            lotteryTicket.setLotteryType(LotteryType.LOTTOMAX);
            pickedLine = numbersGeneratorService.lottoMaxNumberGenerator();
            lotteryTicket.setTicket(pickedLine);
            return lotteryRepository.save(lotteryTicket);
        } else if (type.equalsIgnoreCase(LotteryType.LOTTO649.name()) &&
                method.equalsIgnoreCase(LotteryPlayMethod.QUICK_PICK.name())) {
            lotteryTicket.setLotteryPlayMethod(LotteryPlayMethod.QUICK_PICK);
            lotteryTicket.setLotteryType(LotteryType.LOTTO649);
            pickedLine = numbersGeneratorService.lotto649NumberGenerator();
            lotteryTicket.setTicket(pickedLine);
            return lotteryRepository.save(lotteryTicket);
        }
        return null;
    }

}
