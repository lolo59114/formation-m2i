package exercice4ville;

import exercice4ville.exception.NotFoundException;

import java.util.List;


public class RechercheVille {
    private List<String> villes;
    public RechercheVille(List<String> villes) {
        this.villes = villes;
    }

    public List<String> rechercher(String mot) {
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
