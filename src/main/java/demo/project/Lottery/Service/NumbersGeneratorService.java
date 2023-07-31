package demo.project.Lottery.Service;

import demo.project.Lottery.Model.LotteryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public abstract class NumbersGeneratorService {

    private LotteryType lotteryType;

    @Autowired
    protected NumbersGeneratorService(LotteryType lotteryType) {
        this.lotteryType = lotteryType;
    }

    public LotteryType getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(LotteryType lotteryType) {
        this.lotteryType = lotteryType;
    }

    protected List<Integer> generateLine() {
        List<Integer> generatedLine = new ArrayList<>();
        int randomNumber = getRandomNumber();
        while (true) {

            if (generatedLine.contains(randomNumber))
                randomNumber = getRandomNumber();
            else
                generatedLine.add(randomNumber);

            if (generatedLine.size() == getLotteryType().getNUMBER_OF_NUMBERS())
                break;
        }
        Collections.sort(generatedLine);
        return generatedLine;
    }

    protected int getRandomNumber() {
        Random random = new Random();
        return (getLotteryType().getLOWER_LIMIT() + random.nextInt(getLotteryType().getUPPER_LIMIT()));
    }

    protected abstract String[] getTicket(List<Integer> userGeneratedLine);

}
