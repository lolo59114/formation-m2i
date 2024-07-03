package exercice5bowling;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Frame {
    public final int MAX_PINS = 10;
    private int score;
    private boolean lastFrame;
    private IGenerateur generateur;
    private List<Roll> rolls;

    public Frame(IGenerateur generateur, boolean lastFrame) {
        this.lastFrame = lastFrame;
        this.generateur = generateur;
        rolls = new ArrayList<>();
    }

    public boolean makeRoll(Roll roll){
        int maxRoll = 2;
        score +=  roll.randomPin(MAX_PINS - (score % MAX_PINS));
        if(lastFrame && score >= 10)
            maxRoll = 3;
        rolls.add(roll);
        return ((rolls.size() < maxRoll) && (score != MAX_PINS) || (lastFrame && rolls.size() < maxRoll));
    }

}
