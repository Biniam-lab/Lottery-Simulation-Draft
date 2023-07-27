package demo.project.Lottery.Service;

import demo.project.Lottery.Model.LotteryType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class NumbersGeneratorService {

    protected String[] lottoMaxNumberGenerator() {
        List<Integer> generatedLine = new ArrayList<>();
        String[] ticket = new String[LotteryType.LOTTOMAX.getNUMBER_OF_LINES()];

        for (int i = 0; i < LotteryType.LOTTOMAX.getNUMBER_OF_LINES(); i++) {
            int randomNumber = getRandomNumberForMax();

            while (true) {

                if (generatedLine.contains(randomNumber))
                    randomNumber = getRandomNumberForMax();
                else
                    generatedLine.add(randomNumber);

                if (generatedLine.size() == LotteryType.LOTTOMAX.getNUMBER_OF_NUMBERS())
                    break;
            }
            Collections.sort(generatedLine);
            ticket[i] = generatedLine.toString();
            generatedLine.clear();
        }
        return ticket;
    }

    private int getRandomNumberForMax() {
        Random random = new Random();
        return (LotteryType.LOTTOMAX.getLOWER_LIMIT() + random.nextInt(LotteryType.LOTTOMAX.getUPPER_LIMIT()));
    }
}
