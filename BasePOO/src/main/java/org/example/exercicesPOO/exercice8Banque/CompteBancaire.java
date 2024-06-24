package org.example.exercicesPOO.exercice8Banque;

import java.util.ArrayList;
import java.util.List;

public abstract class CompteBancaire {
    protected double solde;
    protected Client client;
    protected List<Operation> listeOperations;

    public CompteBancaire(double solde, Client client) {
        this.solde = solde;
        this.client = client;
        this.listeOperations = new ArrayList<>();
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Operation> getListeOperations() {
        return listeOperations;
    }

    private void ajouterUneOperation(Operation nouvelleOperation) {
        this.listeOperations.add(nouvelleOperation);
    }

    public void effectuerUneOperation(double montant, StatutOp statut) {
        Operation operation = new Operation(this.getListeOperations().size() + 1, montant, statut);
        switch (statut) {
            case RETRAIT -> solde -= montant;
            case DEPOT -> solde += montant;
        }
        this.ajouterUneOperation(operation);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " +
                "solde=" + solde;
    }
}