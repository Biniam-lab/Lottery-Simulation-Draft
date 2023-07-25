package demo.project.Lottery.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class LotteryTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ticketNumber;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfPurchase;


    private int[] pickedLine;

    @PrePersist
    protected void onCreate(){
        dateOfPurchase = new Date();
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

    public int[] getPickedLine() {
        return pickedLine;
    }

    public void setPickedLine(int[] pickedLine) {
        this.pickedLine = pickedLine;
    }
}
