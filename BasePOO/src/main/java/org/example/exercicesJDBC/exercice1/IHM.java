package org.example.exercicesJDBC.exercice1;

import org.example.exercicesJDBC.JDBCConfig;

import java.lang.reflect.Method;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class IHM {
    private static Scanner scanner = new Scanner(System.in);
    private static Connection con;

    public static void startApp() {
        JDBCConfig config = new JDBCConfig("exercice1");
        try {
            con = DriverManager.getConnection(config.getFULL_URL(), config.getUSER(), config.getPASSWORD());
            if (con != null) {
                while (true) {
                    displayMenu();
                    System.out.println("Votre choix : ");
                    String choix = scanner.nextLine();
                    switch (choix) {
                        case "0" -> {
                            con.close();
                            return;
                        }
                        case "1" -> createEtudiant();
                        case "2" -> displayEtudiants();
                        case "3" -> {
                            int numClasse = askInput("Choisissez un numéro de classe :", Integer.class);
                            displayEtudiants(numClasse);
                        }
                        case "4" -> {
                            displayEtudiants();
                            int idEtudiant = askInput("Saisissez l'id de l'étudiant à supprimer", Integer.class);
                            deleteEtudiant(idEtudiant);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteEtudiant(int idEtudiant) throws SQLException {
        String request = "DELETE FROM Etudiant WHERE id_etudiant=?";
        PreparedStatement ps = con.prepareStatement(request);
        ps.setInt(1, idEtudiant);
        if (ps.executeUpdate() == 1) {
            System.out.println("L'étudiant a bien été supprimé.");
        }
        ps.close();
        askBeforeContinue();
    }

    private static void createEtudiant() throws SQLException {
        String nom = askInput("Quel est le nom de l'étudiant ?", String.class);
        String prenom = askInput("Quel est le prénom de l'étudiant ?", String.class);
        int numClasse = askInput("Quel est son numéro de classe ?", Integer.class);
        String dateDiplome = askInput("Quel est la date d'obtention du diplome (yyyy-MM-jj)?", String.class);
        try {
            Etudiant nouvEtudiant = Etudiant.builder()
                    .nom(nom)
                    .prenom(prenom)
                    .numClasse(numClasse)
                    .dateDiplome(Date.valueOf(LocalDate.parse(dateDiplome)))
                    .build();
            String request = "INSERT INTO Etudiant(nom, prenom, num_classe, date_diplome) VALUES(?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(request);
            ps.setString(1, nouvEtudiant.getNom());
            ps.setString(2, nouvEtudiant.getPrenom());
            ps.setInt(3, nouvEtudiant.getNumClasse());
            ps.setDate(4, nouvEtudiant.getDateDiplome());
            if (ps.executeUpdate() == 1) {
                System.out.println("L'étudiant a bien été créé.");
            }
            ps.close();
        } catch (DateTimeParseException e) {
            System.out.println(e.getMessage());
        }
        askBeforeContinue();
    }

    private static void displayEtudiants() throws SQLException {
        String request = "SELECT * FROM Etudiant ";
        selectEtudiants(request);
        askBeforeContinue();
    }

    private static void displayEtudiants(int numClasse) throws SQLException {
        String request = "SELECT * FROM Etudiant ";
        if (numClasse > 0) {
            request += "WHERE num_classe = " + numClasse + " ORDER BY num_classe";
            selectEtudiants(request);
        }
        askBeforeContinue();
    }

    private static void selectEtudiants(String request) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(request);
        while (rs.next()) {
            Etudiant nouvEtudiant = Etudiant.builder()
                    .idEtudiant(rs.getInt("id_etudiant"))
                    .nom(rs.getString("nom"))
                    .prenom(rs.getString("prenom"))
                    .numClasse(rs.getInt("num_classe"))
                    .dateDiplome(rs.getDate("date_diplome"))
                    .build();
            System.out.println(nouvEtudiant);
        }
        rs.close();
        st.close();
    }

    private static void displayMenu() {
        System.out.println("""
                === Gestion des étudiants ===
                1. Créer un étudiant
                2. Afficher tous les étudiants
                3. Afficher les étudiants d'une classe
                4. Supprimer un étudiant
                0. Quitter l'application
                """);
    }

    private static void askBeforeContinue() {
        System.out.println("Appuyez sur entrée pour continuer...");
        scanner.nextLine();
    }

    private static <T> T askInput(String asked, Class<T> type) {
        while (true) {
            System.out.println(asked);
            try {
                T inputValue;
                String inputString = scanner.nextLine();
                // la classe String n'a pas de méthode valueOf
                if (!type.equals(String.class)) {
                    Method valueOf = type.getMethod("valueOf", String.class);
                    inputValue = type.cast(valueOf.invoke(null, inputString));
                } else {
                    inputValue = type.cast(inputString);
                }
                return inputValue;
            } catch (Exception e) {
                System.out.println("Erreur: " + e.getMessage());
            }
        }
    }
}
