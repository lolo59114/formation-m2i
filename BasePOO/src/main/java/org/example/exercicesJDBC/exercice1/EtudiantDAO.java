package org.example.exercicesJDBC.exercice1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDAO {
    private Connection _connection;
    private PreparedStatement preparedStatement;
    private String request;
    private ResultSet resultSet;
    private List<Etudiant> etudiants;

    public EtudiantDAO(Connection _connection) {
        this._connection = _connection;
    }

    public boolean save(Etudiant etudiant) throws SQLException {
        request = "INSERT INTO Etudiant(nom, prenom, num_classe, date_diplome) VALUES(?, ?, ?, ?)";
        preparedStatement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, etudiant.getNom());
        preparedStatement.setString(2, etudiant.getPrenom());
        preparedStatement.setInt(3, etudiant.getNumClasse());
        preparedStatement.setDate(4, etudiant.getDateDiplome());
        int nbRow = preparedStatement.executeUpdate();
        resultSet = preparedStatement.getGeneratedKeys();
        if(resultSet.next()) {
            etudiant.setIdEtudiant(resultSet.getInt(1));
        }
        preparedStatement.close();
        resultSet.close();
        return nbRow == 1;
    }

    public boolean delete(int idEtudiant) throws SQLException {
        request = "DELETE FROM Etudiant WHERE idEtudiant = ?";
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setInt(1, idEtudiant);
        int nbRow = preparedStatement.executeUpdate();
        preparedStatement.close();
        return nbRow == 1;
    }

    public List<Etudiant> getAll() throws SQLException {
        request = "SELECT * FROM Etudiant";
        preparedStatement = _connection.prepareStatement(request);
        selectEtudiants();
        return etudiants;
    }

    public List<Etudiant> getByClasse(int numClasse) throws SQLException {
        request = "SELECT * FROM Etudiant";
        if (numClasse > 0) {
            request += " WHERE num_classe = ? ORDER BY num_classe";
        }
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setInt(1, numClasse);
        selectEtudiants();
        return etudiants;
    }

    private void selectEtudiants() {
        etudiants = new ArrayList<>();
        try {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Etudiant nouvEtudiant = Etudiant.builder()
                        .idEtudiant(resultSet.getInt("id_etudiant"))
                        .nom(resultSet.getString("nom"))
                        .prenom(resultSet.getString("prenom"))
                        .numClasse(resultSet.getInt("num_classe"))
                        .dateDiplome(resultSet.getDate("date_diplome"))
                        .build();
                etudiants.add(nouvEtudiant);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            request = null;
            try {
                if (resultSet != null && !resultSet.isClosed())
                    resultSet.close();
                if (preparedStatement != null && !preparedStatement.isClosed())
                    preparedStatement.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
