package exercice4Ville;

import exercice4Ville.exception.NotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RechercheVille {
    private List<String> villes;
    public RechercheVille(List<String> villes) {
        this.villes = villes;
    }

    public List<String> Rechercher(String mot) {
        List<String> villesTrouvees;
        if(mot.equals("*")) {
            villesTrouvees = villes;
        } else if(mot.length() < 2) {
            throw new NotFoundException("Ville non trouvable, veuillez saisir plus de caractères");
        } else {
            villesTrouvees = villes.stream().filter(s -> s.toLowerCase().contains(mot.toLowerCase())).toList();
        }
        return villesTrouvees;
    }
}
