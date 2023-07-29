package demo.project.Lottery.Service;

import demo.project.Lottery.Model.LotteryType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class NumbersGeneratorService {

    protected String[] lottoMaxNumberGenerator(List<Integer> userGeneratedLine) {
        List<Integer> generatedLine = new ArrayList<>();
        String[] ticket = new String[LotteryType.LOTTOMAX.getNUMBER_OF_LINES()];
        ticket[0] = userGeneratedLine.toString();
        for (int i = 1; i < LotteryType.LOTTOMAX.getNUMBER_OF_LINES(); i++) {
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

    protected List<Integer> lottoMaxNumber() {
        List<Integer> generatedLine = new ArrayList<>();
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
        return generatedLine;
    }

    private int getRandomNumberForMax() {
        Random random = new Random();
        return (LotteryType.LOTTOMAX.getLOWER_LIMIT() + random.nextInt(LotteryType.LOTTOMAX.getUPPER_LIMIT()));
    }

    protected String[] lotto649NumberGenerator(List<Integer> userGeneratedLine) {
        String[] ticket = new String[LotteryType.LOTTO649.getNUMBER_OF_LINES()];
        ticket[0] = userGeneratedLine.toString();
        return ticket;
    }

    private int getRandomNumberFor649() {
        Random random = new Random();
        return (LotteryType.LOTTO649.getLOWER_LIMIT() + random.nextInt(LotteryType.LOTTO649.getUPPER_LIMIT()));
    }

    protected List<Integer> lotto649Number() {
        List<Integer> generatedLine = new ArrayList<>();
        int randomNumber = getRandomNumberFor649();
        while (true) {

            if (generatedLine.contains(randomNumber))
                randomNumber = getRandomNumberFor649();
            else
                generatedLine.add(randomNumber);

            if (generatedLine.size() == LotteryType.LOTTO649.getNUMBER_OF_NUMBERS())
                break;
        }
        Collections.sort(generatedLine);
        return generatedLine;
    }
}
