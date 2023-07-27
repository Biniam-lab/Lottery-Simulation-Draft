package demo.project.Lottery.Controller;

import demo.project.Lottery.Model.LotteryTicket;
import demo.project.Lottery.Service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
                                       @RequestBody LotteryTicket lotteryTicket) {

        return lotteryService.saveTicketMax(type, method, lotteryTicket);

    }
}
