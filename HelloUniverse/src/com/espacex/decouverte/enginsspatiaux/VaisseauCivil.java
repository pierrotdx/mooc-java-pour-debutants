package com.espacex.decouverte.enginsspatiaux;

public class VaisseauCivil extends Vaisseau {
    public VaisseauCivil(TypeVaisseau type) {
        super(type);
    }

    @Override
    public int emporterCargaison(int tonnage) {
        int tonnageTotal = tonnage + this.tonnageActuel;
        this.tonnageActuel = Math.min(tonnageTotal, this.tonnageMax);
        int quantiteRejetee = tonnageTotal <= this.tonnageMax ? 0 : tonnageTotal - this.tonnageMax;
        return quantiteRejetee;
    }
}
