package demo.project.Lottery.Controller;

import demo.project.Lottery.Model.LotteryTicket;
import demo.project.Lottery.Service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LotteryController {

    @Autowired
    private LotteryService lotteryService;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to sample lottery simulation app!!";
    }

    @PostMapping("/purchase/{type}/{method}")
    public LotteryTicket saveTicketMax(@PathVariable("type") String type,
                                       @PathVariable("method") String method,
                                       LotteryTicket lotteryTicket) {

        return lotteryService.saveTicket(type, method, lotteryTicket);

    }
}
