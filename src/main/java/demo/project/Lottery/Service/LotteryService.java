package demo.project.Lottery.Service;

import demo.project.Lottery.Model.LotteryPlayMethod;
import demo.project.Lottery.Model.LotteryTicket;
import demo.project.Lottery.Model.LotteryType;
import demo.project.Lottery.Repository.LotteryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotteryService {

    private final LotteryRepository lotteryRepository;
    private final @Qualifier("Lotto649Service") NumbersGeneratorService numbersGeneratorService649;
    private final @Qualifier("LottoMaxService") NumbersGeneratorService numbersGeneratorServiceMax;

    @Autowired
    public LotteryService(LotteryRepository lotteryRepository, NumbersGeneratorService numbersGeneratorService649, NumbersGeneratorService numbersGeneratorServiceMax) {
        this.lotteryRepository = lotteryRepository;
        this.numbersGeneratorService649 = numbersGeneratorService649;
        this.numbersGeneratorServiceMax = numbersGeneratorServiceMax;
    }

    public LotteryTicket saveTicketLottomaxQuickPick(List<Integer> userGeneratedLine, LotteryTicket lotteryTicket) {
        String[] pickedLine;
        lotteryTicket.setLotteryPlayMethod(LotteryPlayMethod.QUICK_PICK);
        lotteryTicket.setLotteryType(LotteryType.LOTTOMAX);
        pickedLine = numbersGeneratorServiceMax.getTicket(userGeneratedLine);
        lotteryTicket.setTicket(pickedLine);
        return lotteryRepository.save(lotteryTicket);
    }

    public LotteryTicket saveTicketLotto649QuickPick(List<Integer> userGeneratedLine, LotteryTicket lotteryTicket) {
        String[] pickedLine;
        lotteryTicket.setLotteryPlayMethod(LotteryPlayMethod.QUICK_PICK);
        lotteryTicket.setLotteryType(LotteryType.LOTTO649);
        pickedLine = numbersGeneratorService649.getTicket(userGeneratedLine);
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
        return numbersGeneratorServiceMax.generateLine();
    }

    public List<Integer> getTicketLotto649QuickPick() {
        return numbersGeneratorService649.generateLine();
    }
}
