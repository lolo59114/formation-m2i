package org.example.exercicesPOO.exercice8Banque;

public class Operation {
    private int numero;
    private double montant;
    private StatutOp statut;

    public Operation(int numero, double montant, StatutOp statut) {
        this.numero = numero;
        this.montant = montant;
        this.statut = statut;
    }

    public int getNumero() {
        return numero;
    }

    public double getMontant() {
        return montant;
    }

    public StatutOp getStatut() {
        return statut;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "numero=" + numero +
                ", montant=" + montant +
                ", statut=" + statut +
                '}';
    }
}
