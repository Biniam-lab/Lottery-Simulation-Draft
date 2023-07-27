package demo.project.Lottery.Repository;

import demo.project.Lottery.Model.LotteryTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LotteryRepository extends JpaRepository<LotteryTicket, Long> {
}
