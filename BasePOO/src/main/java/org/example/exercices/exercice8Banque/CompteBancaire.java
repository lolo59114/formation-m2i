package org.example.exercices.exercice8Banque;

public abstract class CompteBancaire {
    protected double solde;
    protected Client client;
    protected Operation[] listeOperations;

    public CompteBancaire(double solde, Client client) {
        this.solde = solde;
        this.client = client;
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

    public Operation[] getListeOperations() {
        return listeOperations;
    }

    public void ajouterUneOperation(Operation nouvelleOperation) {
        Operation[] nouvelleListeOperation = new Operation[listeOperations.length + 1];
        nouvelleListeOperation[nouvelleListeOperation.length - 1] = nouvelleOperation;
        this.listeOperations = nouvelleListeOperation;
    }

    public void effectuerUneOperation(double montant, StatutOp statut) {
        Operation operation = new Operation(this.getListeOperations().length + 1, montant, statut);
        this.ajouterUneOperation(operation);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " +
                "solde=" + solde;
    }
}