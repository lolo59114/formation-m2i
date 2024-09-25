package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RechercheVilleTest {

    private RechercheVille rechercheVille;

    @Test
    public void TestRechercheVilleWhenRechercherWithLessThan_2Char_RaiseException_NotFoundException(){
        //Arrange
        rechercheVille = new RechercheVille();
        String searchString = "a";

        //Act / Assert
        Assertions.assertThrows(NotFoundException.class,()->{
            rechercheVille.rechercher(searchString);
        });
    }

    @Test
    public void TestRechercheVilleWhenRechercherStringGreater_2Char_ReturnCitiesStartedWithChar(){
        //Arrange
        rechercheVille = new RechercheVille();
        String searchString = "Va";
        List<String> expected = List.of("Valence","Vancouver");

        //Act
        List<String> result = rechercheVille.rechercher(searchString);

        //Assert
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void TestRechercheVilleWhenRechercherStringGreater_2Char_NoCaseSensitive (){
        //Arrange
        rechercheVille = new RechercheVille();
        String searchString = "vA";
        List<String> expected = List.of("Valence","Vancouver");

        //Act
        List<String> result = rechercheVille.rechercher(searchString);

        //Assert
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void TestRechercheVilleWhenRechercherStringGreater_2Char_ReturnCitiesContainsChar (){
        //Arrange
        rechercheVille = new RechercheVille();
        String searchString = "ape";
        List<String> expected = List.of("Budapest");

        //Act
        List<String> result = rechercheVille.rechercher(searchString);

        //Assert
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void TestRechercheVilleWhenRechercher_CharAsterisk_ReturnAllCities (){
        //Arrange
        rechercheVille = new RechercheVille();
        String searchString = "*";
        List<String> expected = List.of("Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver", "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok", "Hong Kong", "Dubaï", "Rome", "Istanbul");

        //Act
        List<String> result = rechercheVille.rechercher(searchString);

        //Assert
        Assertions.assertEquals(expected,result);
    }
}
