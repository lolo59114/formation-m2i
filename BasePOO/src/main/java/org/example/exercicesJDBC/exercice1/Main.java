package org.example.exercicesJDBC.exercice1;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        IHM.startApp();


//                Statement stmt = con.createStatement();
//                String request = "SELECT * FROM livre";
//                ResultSet rs = stmt.executeQuery(request);
//                while (rs.next()) {
//                    System.out.println(rs.getString("titre") + " / " + rs.getString("auteur"));
//                }
//                stmt.close();
//                rs.close();

//                stmt = con.createStatement();
//                String request2 = "SELECT * FROM livre";
//                rs = stmt.executeQuery(request2);
//                List<Livre> livres = new ArrayList<>();
//                while (rs.next()) {
//                    livres.add(Livre.builder()
//                                .idLivre(rs.getInt("id_livre"))
//                                .titre(rs.getString("titre"))
//                                .auteur(rs.getString("auteur"))
//                                .build());
                }
//                System.out.println(livres);

//                stmt.close();
//                rs.close();


//                String request3 = "INSERT INTO livre (titre, auteur, isbn_13, date_publication, editeur) VALUES (?, ?, ?, ?, ?)";
//                PreparedStatement pstmt = con.prepareStatement(request3);
//                pstmt.setString(1, livre.getTitre());
//                pstmt.setString(2, livre.getAuteur());
//                pstmt.setString(3, livre.getIsbn13());
//                pstmt.setTimestamp(4, livre.getDatePublication());
//                pstmt.setString(5, livre.getEditeur());
//                int nbRows = pstmt.executeUpdate();
//                System.out.println(nbRows);

//                String request4 = "DELETE FROM livre WHERE auteur = ?";
//                PreparedStatement ps = con.prepareStatement(request4);
//                ps.setString(1, livre.getAuteur());
//                int nbRow = ps.executeUpdate();
//                System.out.println(nbRow);
//                ps.close();



}
