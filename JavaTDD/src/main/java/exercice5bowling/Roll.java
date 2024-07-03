package exercice5bowling;

import lombok.Data;

import java.util.Random;

@Data
public class Roll implements IGenerateur{
    private int pins;

    @Override
    public int randomPin(int max) {
        pins = max;
        Random random = new Random();
        return random.nextInt(pins);
    }
}
