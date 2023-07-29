package demo.project.Lottery.Repository;

import demo.project.Lottery.Model.LotteryTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LotteryRepository extends JpaRepository<LotteryTicket, Long> {

    @Query(value = "SELECT * FROM Lottery_Ticket WHERE Lottery_Type = 'LOTTOMAX'", nativeQuery = true)
    List<LotteryTicket> findLottoMaxTickets();

    @Query(value = "SELECT * FROM Lottery_Ticket WHERE Lottery_Type = 'LOTTO649'", nativeQuery = true)
    List<LotteryTicket> findLotto649Tickets();
}
