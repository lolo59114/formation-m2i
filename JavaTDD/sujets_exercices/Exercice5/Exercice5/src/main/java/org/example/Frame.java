package org.example;

import jdk.jshell.spi.ExecutionControl;
import org.example.Exception.NotImplementedEcxeption;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    private int score;
    private boolean lastFrame;
    private IGenerateur generateur;
    private List<Roll> rolls;

    public Frame(IGenerateur generateur, boolean lastFrame) {
        this.lastFrame = lastFrame;
        this.generateur = generateur;
        rolls = new ArrayList<>();
    }

    public int getScore (){
        score = 0;
        rolls.forEach(r -> score+=r.getPins());
        return score;
    }

    public boolean makeRoll2(){
        int max = 10;
        if(!lastFrame){
            if(rolls.size()>=2){
                return false;
            }
            if(!rolls.isEmpty()){
                Roll roll = rolls.get(0);
                if(roll.getPins() == 10){
                    return false;
                }
                max -= roll.getPins();
            }
            int p = generateur.randomPin(max);
            Roll roll = new Roll(p);
            rolls.add(roll);
            return true;
        }else{
            if((rolls.isEmpty() || rolls.get(0).getPins() == 10 || (rolls.size() == 2 && rolls.get(0).getPins()+rolls.get(1).getPins() == 10) || rolls.size()<2)  && rolls.size()<3){

                if(!rolls.isEmpty()){
                    if((rolls.size() == 2 && rolls.get(0).getPins()+rolls.get(1).getPins() == 10)){
                        max =10;
                    }else{
                        Roll lastRoll = rolls.get(rolls.size()-1);
                        if(lastRoll.getPins() != 10){
                            max -= lastRoll.getPins();
                        }
                    }
                }

                int p = generateur.randomPin(max);
                Roll roll = new Roll(p);
                rolls.add(roll);
                return true;
            }
        }
        return false;
    }

    public boolean makeRoll (){
        int max ;
        if(!lastFrame){
            if(rolls.isEmpty() || (rolls.size() < 2 && rolls.get(0).getPins() < 10)){
                //ternaire  boolean ?  if true execute  : if false execute
                max = rolls.isEmpty() ? 10 : 10 - rolls.get(0).getPins();
                rolls.add(new Roll(generateur.randomPin(max)));
                return true;
            }
            return false;
        }else{
            if(rolls.size() <= 2 && ((!rolls.isEmpty() && rolls.get(0).getPins() ==10) || (rolls.size() == 2 && rolls.get(0).getPins()+rolls.get(1).getPins() == 10)|| rolls.size()<2)){
               max = ((rolls.size() == 2 && rolls.get(0).getPins() + rolls.get(1).getPins() != 10) || (rolls.size() == 1 && rolls.get(0).getPins() != 10)) ? 10 - rolls.get(rolls.size()-1).getPins() :10;
               rolls.add(new Roll(generateur.randomPin(max)));
               return true;
            }
            return false;
        }
    }
}
