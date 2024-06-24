package org.example.exercicesPOO.exercice2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Film {
    private String titre;
    private String realisateur;
    private LocalDate anneeSortie;
    private String genre;

    public Film(String titre, String realisateur, String anneeSortie, String genre) {
        this.titre = titre;
        this.realisateur = realisateur;
        this.anneeSortie = LocalDate.parse(anneeSortie, DateTimeFormatter.BASIC_ISO_DATE);
        this.genre = genre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public LocalDate getAnneeSortie() {
        return anneeSortie;
    }

    public void setAnneeSortie(LocalDate anneeSortie) {
        this.anneeSortie = anneeSortie;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Film{" +
                "titre='" + titre + '\'' +
                ", realisateur='" + realisateur + '\'' +
                ", anneeSortie=" + anneeSortie +
                ", genre='" + genre + '\'' +
                '}';
    }
}
