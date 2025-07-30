package com.espacex.decouverte.enginsspatiaux;

public enum TypeVaisseau {
    CHASSEUR("Chasseur"),
    FREGATE("Frégate"),
    CROISEUR("Croiseur"),
    CARGO("Cargo"),
    VAISSEAUMONDE("com.espacex.decouverte.enginsspatiaux.Vaisseau-Monde");

    String nom;

    private TypeVaisseau(String nom) {
        this.nom = nom;
    }
}
