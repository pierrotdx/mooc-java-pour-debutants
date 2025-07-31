package com.espacex.decouverte.enginsspatiaux;

public class VaisseauDeGuerre extends Vaisseau {
    private boolean armesDesactivees;

    public VaisseauDeGuerre(TypeVaisseau type) {
        super(type);
    }

    void attaque(Vaisseau cible, String arme, int dureeDeLAttaque) {
        if (this.armesDesactivees) {
            System.out.println("Attaque impossible, l'armement est désactivé.");
        }
        System.out.printf("Un vaisseau de type %s attaque un vaisseau de type %s en utilisant l'arme %s pendant %d minutes.\n", this.type, cible.type, arme, dureeDeLAttaque);
        cible.resistanceDuBouclier = 0;
        cible.blindage = cible.blindage / 2;
    }

    public void desactiverArmes() {
        this.armesDesactivees = true;
        System.out.printf("Désactivation des armes d'un vaisseau de type %s.\n", this.type);
    }

    public void activerArmes() {
        this.armesDesactivees = false;
        System.out.printf("Activation des armes d'un vaisseau de type %s.\n", this.type);
    }

    @Override
    void activerBouclier() {
        super.activerBouclier();
        this.desactiverArmes();
    }

    @Override
    public void emporterCargaison(int tonnage) throws DepassementTonnageException {
        int tonnageMaxEffectif = Math.min(2 * this.nbPassagers, this.tonnageMax);
        int tonnageTotal = this.tonnageActuel + tonnage;
        int exces = tonnageTotal - tonnageMaxEffectif;
        if (exces > 0 || this.type.equals(TypeVaisseau.CHASSEUR)) {
            throw new DepassementTonnageException(exces);
        }
        if (this.nbPassagers < 12) {
            return;
        }
        this.tonnageActuel = Math.min(tonnageTotal, tonnageMaxEffectif);
    }
}
