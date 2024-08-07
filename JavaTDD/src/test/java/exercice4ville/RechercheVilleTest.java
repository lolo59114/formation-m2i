package exercice4ville;

import exercice4ville.exception.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

public class RechercheVilleTest {
    RechercheVille rec;
    List<String> villes = List.of("Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver", "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok", "Hong Kong", "Dubaï", "Rome", "Istanbul");
    @BeforeEach
    public void setup() {
        rec = new RechercheVille(villes);
    }

    @Test
    public void TestRechercherWhenMotIs_P_ThenThrowNotFoundException() {
        //Arrange
        String mot = "P";
        //Act Assert
        Assertions.assertThrows(NotFoundException.class,()->{rec.rechercher(mot);});
    }

    @Test
    public void TestRechercherWhenMotIs_Va_ThenReturnListeVillesStartWith_Va() {
        //Arrange
        String mot = "Va";
        //Act
        List<String> result = rec.rechercher(mot);
        // Assert
        assertThat(result).allMatch(s -> s.startsWith(mot));
    }

    @Test
    public void TestRechercherWhenMotIsCaseSensitive_va_ThenReturnListeVillesStartWith_Va() {
        //Arrange
        String mot = "va";
        List<String> listExpected = List.of("Vancouver", "Valence");
        //Act
        List<String> result = rec.rechercher(mot);
        // Assert
        assertThat(result).containsExactlyInAnyOrderElementsOf(listExpected);
    }

    @Test
    public void TestRechercherWhenMotIs_ape_ThenReturnListeVillesContains_ape() {
        //Arrange
        String mot = "ape";
        List<String> listExpected = List.of("Budapest");
        //Act
        List<String> result = rec.rechercher(mot);
        // Assert
        assertThat(result).containsExactlyInAnyOrderElementsOf(listExpected);
    }

    @Test
    public void TestRechercherWhenMotIsAnAsterix_ThenReturnListeAllVilles() {
        //Arrange
        String mot = "*";
        List<String> listExpected = villes;
        //Act
        List<String> result = rec.rechercher(mot);
        // Assert
        assertThat(result).containsExactlyInAnyOrderElementsOf(listExpected);
    }
}
