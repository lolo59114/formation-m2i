package org.example.exercicesJDBC.exercice1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {

  private int idEtudiant;
  private String nom;
  private String prenom;
  private int numClasse;
  private java.sql.Date dateDiplome;

  @Override
  public String toString() {
    return "Etudiant{" +
            "idEtudiant=" + idEtudiant +
            ", nom='" + nom + '\'' +
            ", prenom='" + prenom + '\'' +
            ", numClasse=" + numClasse +
            ", dateDiplome=" + dateDiplome +
            '}';
  }
}
