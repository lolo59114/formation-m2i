package org.example.exercicesJDBC.exercice1;

import java.sql.*;

public class EtudiantDAO {
    private Connection _connection;
    private PreparedStatement statement;
    private String request;
    private ResultSet resultSet;

    public EtudiantDAO(Connection _connection) {
        this._connection = _connection;
    }

    public boolean save(Etudiant etudiant) throws SQLException {
        request = "INSERT INTO Etudiant(nom, prenom, num_classe, date_diplome) VALUES(?, ?, ?, ?)";
        statement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, etudiant.getNom());
        statement.setString(2, etudiant.getPrenom());
        statement.setInt(3, etudiant.getNumClasse());
        statement.setDate(4, etudiant.getDateDiplome());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();
        if(resultSet.next()) {
            etudiant.setIdEtudiant(resultSet.getInt(1));
        }
        statement.close();
        resultSet.close();
        return nbRow == 1;
    }
}
