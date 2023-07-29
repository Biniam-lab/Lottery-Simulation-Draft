package demo.project.Lottery.Service;

import demo.project.Lottery.Model.LotteryPlayMethod;
import demo.project.Lottery.Model.LotteryTicket;
import demo.project.Lottery.Model.LotteryType;
import demo.project.Lottery.Repository.LotteryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotteryService {

    @Autowired
    private LotteryRepository lotteryRepository;

    @Autowired
    private NumbersGeneratorService numbersGeneratorService;

    public LotteryTicket saveTicketLottomaxQuickPick(LotteryTicket lotteryTicket) {

        String[] pickedLine;
        lotteryTicket.setLotteryPlayMethod(LotteryPlayMethod.QUICK_PICK);
        lotteryTicket.setLotteryType(LotteryType.LOTTOMAX);
        pickedLine = numbersGeneratorService.lottoMaxNumberGenerator();
        lotteryTicket.setTicket(pickedLine);
        return lotteryRepository.save(lotteryTicket);
    }

    public LotteryTicket saveTicketLotto649QuickPick(LotteryTicket lotteryTicket) {

        String[] pickedLine;
        lotteryTicket.setLotteryPlayMethod(LotteryPlayMethod.QUICK_PICK);
        lotteryTicket.setLotteryType(LotteryType.LOTTO649);
        pickedLine = numbersGeneratorService.lotto649NumberGenerator();
        lotteryTicket.setTicket(pickedLine);
        return lotteryRepository.save(lotteryTicket);
    }

    public List<LotteryTicket> findLottoMaxTickets() {
        return lotteryRepository.findLottoMaxTickets();
    }

    public List<LotteryTicket> findLotto649Tickets() {
        return lotteryRepository.findLotto649Tickets();
    }
}
