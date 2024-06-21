package org.example.exercices.exercice8Banque;

import java.util.List;
import java.util.Scanner;

public class IHM {
    private static Scanner scanner = new Scanner(System.in);

    public static void debutApplication(Client client) {
        int choixUtilisateur;
        do {
            affichageMenuPrincipal();
            choixUtilisateur = saisiMenu(Menu.PRINCIPAL);
            switch (choixUtilisateur) {
                case 1 -> {
                    if (client.getListeDesComptes() != null) {
                        affichageListeComptes(client.getListeDesComptes());
                    }
                }
                case 2 -> {
                    affichageMenuCreationCompte();
                    int choixCompte = saisiMenu(Menu.CREATION_COMPTE);
                    if (choixCompte > 0) {
                        double soldeInitial = saisiSoldeCompteInitial();
                        client.creerCompteBancaire(choixCompte, soldeInitial);
                    }
                }
                case 3 -> {
                    if (client.getListeDesComptes() != null) {
                        affichageMenuEffectuerDepotRetrait(client.getListeDesComptes(), StatutOp.DEPOT);
                        int indexCompte = saisiChoixCompte(client.getListeDesComptes());
                        if (indexCompte > -1) {
                            CompteBancaire compteChoisi = client.getListeDesComptes().get(indexCompte);
                            compteChoisi.effectuerUneOperation(saisiMontantDepotRetrait(StatutOp.DEPOT), StatutOp.DEPOT);
                        }
                    }
                }
                case 4 -> {
                    if (client.getListeDesComptes() != null) {
                        affichageMenuEffectuerDepotRetrait(client.getListeDesComptes(), StatutOp.RETRAIT);
                        int indexCompte = saisiChoixCompte(client.getListeDesComptes());
                        if (indexCompte > -1) {
                            CompteBancaire compteChoisi = client.getListeDesComptes().get(indexCompte);
                            compteChoisi.effectuerUneOperation(saisiMontantDepotRetrait(StatutOp.RETRAIT), StatutOp.RETRAIT);
                        }
                    }
                }
                case 5 -> {
                    if (client.getListeDesComptes() != null) {
                        affichageMenuListCompte(client.getListeDesComptes());
                        int indexCompte = saisiChoixCompte(client.getListeDesComptes());
                        CompteBancaire compteChoisi = client.getListeDesComptes().get(indexCompte);
                        affichageListeOperations(compteChoisi.getListeOperations());
                        affichageSoldeCompte(compteChoisi);
                    }
                }
            }
        } while (choixUtilisateur != 0);
    }

    public static void affichageMenuPrincipal() {
        System.out.println("""
                \n=== Menu Principal ===
                1. Lister les comptes bancaires
                2. Créer un compte bancaire
                3. Effectuer un dépot
                4. Effectuer un retrait
                5. Afficher les opérations et le solde
                0. Quitter le programme
                """);
    }

    public static void affichageMenuCreationCompte() {
        System.out.println("""
                \n=== Création de Compte ===
                1. Créer un compte courant
                2. Créer un compte épargne
                3. Créer un compte payant
                0. Annuler la création de compte
                """);
    }

    public static void affichageMenuEffectuerDepotRetrait(List<CompteBancaire> listeComptes, StatutOp statut) {
        switch (statut) {
            case DEPOT -> System.out.println("\n=== Effectuer un dépot ===");
            case RETRAIT -> System.out.println("\n=== Effectuer un retrait ===");
        }
        affichageMenuListCompte(listeComptes);
    }

    public static void affichageMenuListCompte(List<CompteBancaire> listeComptes) {
        for (int i = 0; i < listeComptes.size(); i++) {
            CompteBancaire compte = listeComptes.get(i);
            System.out.println((i + 1) + ". " + compte);
        }
        System.out.println("0. Annuler l'opération");
    }

    public static int saisiChoixCompte(List<CompteBancaire> listeComptes) {
        int choix = 0;
        while (true) {
            System.out.println("Choisissez le compte: ");
            try {
                choix = Integer.parseInt(scanner.nextLine());
                if (choix < 0 || choix > listeComptes.size()) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Saisissez un choix valide !");
            }
        }
        // on retourne choix-1 pour matcher à l'index de la liste des comptes
        return choix - 1;
    }

    public static double saisiMontantDepotRetrait(StatutOp statut) {
        double montant = 0;
        while (true) {
            switch (statut) {
                case DEPOT -> System.out.println("Saisissez le montant de votre dépot: ");
                case RETRAIT -> System.out.println("Saisissez le montant de votre retrait: ");
            }
            try {
                montant = Double.parseDouble(scanner.nextLine());
                if (montant < 0) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Le montant saisi est invalide");
            }
        }
        return montant;
    }

    public static double saisiSoldeCompteInitial() {
        double soldeInitial = 0;
        while (true) {
            System.out.println("Votre solde initial : ");
            try {
                soldeInitial = Double.parseDouble(scanner.nextLine());
                if (soldeInitial < 0) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Le solde saisi est invalide");
            }
        }
        return soldeInitial;
    }

    public static int saisiMenu(Menu menu) {
        int choix = 0;
        while (true) {
            System.out.println("Votre choix : ");
            try {
                choix = Integer.parseInt(scanner.nextLine());
                switch (menu) {
                    case PRINCIPAL -> {
                        if (choix < 0 || choix > 5) {
                            throw new Exception();
                        }
                    }
                    case CREATION_COMPTE -> {
                        if (choix < 0 || choix > 3) {
                            throw new Exception();
                        }
                    }
                }
                break;
            } catch (Exception e) {
                System.out.print("(Saisissez un choix valide) ");
            }
        }
        return choix;
    }

    public static void affichageListeComptes(List<CompteBancaire> listeCompte) {
        for (CompteBancaire compte : listeCompte) {
            System.out.println(compte);
        }
        attendreUtilisateur();
    }

    public static void affichageListeOperations(List<Operation> listeOperations) {
        System.out.println(("Liste des Operations :"));
        System.out.println(listeOperations);
    }

    public static void affichageSoldeCompte(CompteBancaire compte) {
        System.out.println(compte);
        attendreUtilisateur();
    }

    private static void attendreUtilisateur() {
        System.out.println("\n Appuyez sur une touche pour continuer... ");
        scanner.nextLine();
    }


}
