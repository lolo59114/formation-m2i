package exercice3Dice;

import java.util.Random;

public class De implements Ide{
    @Override
    public int getRoll() {
        Random random = new Random();
        return random.nextInt(20);
    }
}