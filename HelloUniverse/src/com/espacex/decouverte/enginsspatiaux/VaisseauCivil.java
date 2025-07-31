package com.espacex.decouverte.enginsspatiaux;

public class VaisseauCivil extends Vaisseau {
    public VaisseauCivil(TypeVaisseau type) {
        super(type);
    }

    @Override
    public void emporterCargaison(int tonnage) throws DepassementTonnageException {
        int tonnageTotal = tonnage + this.tonnageActuel;
        int exces = tonnageTotal - this.tonnageMax;
        if (exces > 0) {
            throw new DepassementTonnageException(exces);
        }
        this.tonnageActuel = Math.min(tonnageTotal, this.tonnageMax);
    }
}
