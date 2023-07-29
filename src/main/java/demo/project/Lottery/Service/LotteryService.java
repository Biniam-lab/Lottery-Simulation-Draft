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

    public LotteryTicket saveTicketLottomaxQuickPick(List<Integer> userGeneratedLine, LotteryTicket lotteryTicket) {

        String[] pickedLine;
        lotteryTicket.setLotteryPlayMethod(LotteryPlayMethod.QUICK_PICK);
        lotteryTicket.setLotteryType(LotteryType.LOTTOMAX);
        pickedLine = numbersGeneratorService.lottoMaxNumberGenerator(userGeneratedLine);
        lotteryTicket.setTicket(pickedLine);
        return lotteryRepository.save(lotteryTicket);
    }

    public LotteryTicket saveTicketLotto649QuickPick(List<Integer> userGeneratedLine, LotteryTicket lotteryTicket) {

        String[] pickedLine;
        lotteryTicket.setLotteryPlayMethod(LotteryPlayMethod.QUICK_PICK);
        lotteryTicket.setLotteryType(LotteryType.LOTTO649);
        pickedLine = numbersGeneratorService.lotto649NumberGenerator(userGeneratedLine);
        lotteryTicket.setTicket(pickedLine);
        return lotteryRepository.save(lotteryTicket);
    }

    public List<LotteryTicket> findLottoMaxTickets() {
        return lotteryRepository.findLottoMaxTickets();
    }

    public List<LotteryTicket> findLotto649Tickets() {
        return lotteryRepository.findLotto649Tickets();
    }

    public List<Integer> getTicketLottoMaxQuickPick() {
        return numbersGeneratorService.lottoMaxNumber();
    }

    public List<Integer> getTicketLotto649QuickPick() {
        return numbersGeneratorService.lotto649Number();
    }
}
