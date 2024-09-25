package org.example;

import java.util.ArrayList;
import java.util.List;

public class RechercheVille {
    private List<String> villes = List.of("Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver", "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok", "Hong Kong", "Dubaï", "Rome", "Istanbul");

    public List<String> rechercher(String mot)  {

        if(mot.equals("*"))
            return villes;
        if(mot.length()<2)
            throw new NotFoundException();
        return villes.stream().filter(v -> v.toUpperCase().contains(mot.toUpperCase())).toList();
//        List<String> villeTrouver = new ArrayList<>();
//        for (String ville : villes){
//            if(ville.toUpperCase().contains(mot.toUpperCase())){
//                villeTrouver.add(ville);
//            }
//        }
//        return villeTrouver;

    }
}
