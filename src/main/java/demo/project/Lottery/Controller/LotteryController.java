package demo.project.Lottery.Controller;

import demo.project.Lottery.Model.LotteryTicket;
import demo.project.Lottery.Service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LotteryController {

    private final LotteryService lotteryService;

    @Autowired
    public LotteryController(LotteryService lotteryService) {
        this.lotteryService = lotteryService;
    }


    @GetMapping("/ticket/lottomax")
    public List<LotteryTicket> findLottoMaxTickets() {
        return lotteryService.findLottoMaxTickets();
    }

    @GetMapping("/ticket/lotto649")
    public List<LotteryTicket> findLotto649Tickets() {
        return lotteryService.findLotto649Tickets();
    }

    @GetMapping("/purchase/lottomax/quickpick")
    public List<Integer> getTicketLottoMaxQuickPick() {
        return lotteryService.getTicketLottoMaxQuickPick();
    }

    @GetMapping("/purchase/lotto649/quickpick")
    public List<Integer> getTicketLotto649QuickPick() {
        return lotteryService.getTicketLotto649QuickPick();
    }

    @PostMapping("/purchase/lottomax/quickpick")
    public LotteryTicket saveTicketLottoMaxQuickPick(@RequestBody List<Integer> userGeneratedLine, LotteryTicket lotteryTicket) {
        return lotteryService.saveTicketLottoMaxQuickPick(userGeneratedLine, lotteryTicket);
    }

    @PostMapping("/purchase/lotto649/quickpick")
    public LotteryTicket saveTicketLotto649QuickPick(@RequestBody List<Integer> userGeneratedLine, LotteryTicket lotteryTicket) {
        return lotteryService.saveTicketLotto649QuickPick(userGeneratedLine, lotteryTicket);
    }

    @PostMapping("/purchase/lottomax/selfpick")
    public LotteryTicket saveTicketLottoMaxSelfPick(@RequestBody List<Integer> userGeneratedLine, LotteryTicket lotteryTicket) {
        return lotteryService.saveTicketLottoMaxSelfPick(userGeneratedLine, lotteryTicket);
    }

    @PostMapping("/purchase/lotto649/selfpick")
    public LotteryTicket saveTicketLotto649SelfPick(@RequestBody List<Integer> userGeneratedLine, LotteryTicket lotteryTicket) {
        return lotteryService.saveTicketLotto649SelfPick(userGeneratedLine, lotteryTicket);
    }
}
