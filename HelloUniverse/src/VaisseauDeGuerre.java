public class VaisseauDeGuerre extends Vaisseau {
    boolean armesDesactivees;

    VaisseauDeGuerre(String type) {
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

    void desactiverArmes() {
        this.armesDesactivees = true;
        System.out.printf("Désactivation des armes d'un vaisseau de type %s.\n", this.type);
    }

    @Override
    void activerBouclier() {
        super.activerBouclier();
        this.desactiverArmes();
    }

    @Override
    int emporterCargaison(int tonnage) {
        if (this.nbPassagers < 12 || this.tonnageActuel > this.tonnageMax || this.type.equals("CHASSEUR")) {
            return tonnage;
        }
        int tonnageMaxEffectif = Math.min(2 * this.nbPassagers, this.tonnageMax);
        int tonnageTotal = this.tonnageActuel + tonnage;
        this.tonnageActuel = Math.min(tonnageTotal, tonnageMaxEffectif);
        int quantiteRejetee = Math.max(0, tonnageTotal - tonnageMaxEffectif);
        return quantiteRejetee;
    }
}
