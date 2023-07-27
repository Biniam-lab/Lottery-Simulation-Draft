package demo.project.Lottery.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class LotteryTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TicketID", nullable = false, updatable = false)
    private Long ticketNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Purchase_Date", nullable = false, updatable = false)
    private Date dateOfPurchase;

    @Column(name = "Ticket", nullable = false, updatable = false)
    private String[] ticket;

    @Enumerated(EnumType.STRING)
    @Column(name = "Lottery_Type", nullable = false, updatable = false)
    private LotteryType lotteryType;

    @Enumerated(EnumType.STRING)
    @Column(name = "Method", nullable = false, updatable = false)
    private LotteryPlayMethod lotteryPlayMethod;

    @PrePersist
    private void onCreate() {
        dateOfPurchase = new Date();
    }

    public LotteryTicket(String[] ticket, LotteryType lotteryType, LotteryPlayMethod lotteryPlayMethod) {
        this.ticket = ticket;
        this.lotteryType = lotteryType;
        this.lotteryPlayMethod = lotteryPlayMethod;
    }

    public LotteryTicket() {
    }

    public Long getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Long ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public String[] getTicket() {
        return ticket;
    }

    public void setTicket(String[] ticket) {
        this.ticket = ticket;
    }

    public LotteryType getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(LotteryType lotteryType) {
        this.lotteryType = lotteryType;
    }

    public LotteryPlayMethod getLotteryPlayMethod() {
        return lotteryPlayMethod;
    }

    public void setLotteryPlayMethod(LotteryPlayMethod lotteryPlayMethod) {
        this.lotteryPlayMethod = lotteryPlayMethod;
    }
}