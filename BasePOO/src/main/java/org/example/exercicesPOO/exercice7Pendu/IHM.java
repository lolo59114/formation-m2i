package org.example.exercicesPOO.exercice7Pendu;

import java.util.IllegalFormatException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IHM {
    private static Scanner scanner = new Scanner(System.in);

    public static void affichageDebut() {
        System.out.println("=== Paramètre de la partie ===");
    }

    public static void affichageFin() {
        System.out.println("Merci d'avoir joué !");
    }

    public static void affichageCreationPendu(int nbEssaiMax) {
        System.out.println("Jeu du pendu généré ! Nombre d'essais : " + nbEssaiMax);
    }

    public static void affichageMotATrouver(String mot) {
        System.out.println("Le mot à trouver : " + mot);
    }

    public static void affichagePendu(int noEssai, int nbEssaiMax) {
        String[][] penduAscii = {{"           ", "            ", "            ", "            ", "            ", "            ", "            "}, {"           ", "            ", "            ", "            ", "            ", "            ", "--------    "}, {"           ", "            ", "            ", " |          ", " |          ", " |          ", "--------    "}, {"           ", " |          ", " |          ", " |          ", " |          ", " |          ", "--------    "}, {"           ", " |/         ", " |          ", " |          ", " |          ", " |          ", "--------    "}, {"_____      ", " |/         ", " |          ", " |          ", " |          ", " |          ", "--------    "}, {"___________", " |/         ", " |          ", " |          ", " |          ", " |          ", "--------    "}, {"___________ ", " |/       | ", " |          ", " |          ", " |          ", " |          ", "--------    "}, {"___________ ", " |/       | ", " |        O ", " |       /|\\", " |       / \\", " |          ", "--------    "},};
        int noPendu = noEssai == 1 ? 0 : ((noEssai-1) * 8 / nbEssaiMax);
        for (int i = 0; i < 7; i++) {
            System.out.println(penduAscii[noPendu][i]);
        }
    }

    public static void affichageVictoire(int noEssai) {
        System.out.println("Bravo vous avez trouvé le mot mystère en " + noEssai + " essai(s) !");
    }

    public static void affichageDefaite(String motAtrouver) {
        System.out.println("Dommage, vous avez perdu ! Le mot à trouver était : " + motAtrouver);
    }

    public static void affichageNoEssaiRestant(int noEssai, int nbEssaiMax) {
        System.out.println("Il vous reste " + (nbEssaiMax - noEssai + 1) + " essais");
    }

    public static String saisiNombreEssaiParDefaut() {
        String reponse;
        while (true) {
            System.out.println("Voulez-vous un nombre d'essais spécifique (10 par défaut) ? y/n ");
            try {
                Pattern p = Pattern.compile("[yn]");
                reponse = scanner.nextLine().toLowerCase();
                Matcher m = p.matcher(reponse);
                if (!m.matches()) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.print("(Valeur attendu y ou n) ");
                continue;
            }
            break;
        }
        return reponse;
    }

    public static int saisiNombreEssai() {
        int reponse;
        while (true) {
            System.out.println("Combien voulez-vous d'essais ? ");
            try {
                reponse = Integer.parseInt(scanner.nextLine());
                if (reponse <= 0) {
                    throw new Exception();
                }
            } catch (IllegalFormatException e) {
                System.out.print("(Valeur incorrecte) ");
                continue;
            } catch (Exception e) {
                System.out.print("(Valeur négative ou 0) ");
                continue;
            }
            break;
        }
        return reponse;
    }

    public static String saisiLettrePendu() {
        String reponse;
        while (true) {
            System.out.println("Veuillez saisir une lettre : ");
            try {
                Pattern p = Pattern.compile("[a-z]");
                reponse = scanner.nextLine().toLowerCase();
                Matcher m = p.matcher(reponse);
                boolean b = m.matches();
                if (reponse.length() > 1) {
                    System.out.print("(Plus d'une lettre saisie) ");
                    throw new Exception();
                } else if (!m.matches()) {
                    System.out.print("(Pas une lettre) ");
                    throw new Exception();
                }
            } catch (IllegalFormatException e) {
                System.out.print("(Valeur incorrecte) ");
                continue;
            } catch (Exception e) {
                continue;
            }
            break;
        }
        return reponse;
    }
}
