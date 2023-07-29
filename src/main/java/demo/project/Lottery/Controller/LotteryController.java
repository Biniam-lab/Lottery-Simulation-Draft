package demo.project.Lottery.Controller;

import demo.project.Lottery.Model.LotteryTicket;
import demo.project.Lottery.Service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LotteryController {

    @Autowired
    private LotteryService lotteryService;

    @GetMapping("/ticket/lottomax")
    public List<LotteryTicket> findLottoMaxTickets() {
        return lotteryService.findLottoMaxTickets();
    }

    @GetMapping("/ticket/lotto649")
    public List<LotteryTicket> findLotto649Tickets() {
        return lotteryService.findLotto649Tickets();
    }

    @PostMapping("/purchase/lottomax/quickpick")
    public LotteryTicket saveTicketLottomaxQuickPick(LotteryTicket lotteryTicket) {
        return lotteryService.saveTicketLottomaxQuickPick(lotteryTicket);
    }

    @PostMapping("/purchase/lotto649/quickpick")
    public LotteryTicket saveTicketLotto649QuickPick(LotteryTicket lotteryTicket) {
        return lotteryService.saveTicketLotto649QuickPick(lotteryTicket);
    }
}
