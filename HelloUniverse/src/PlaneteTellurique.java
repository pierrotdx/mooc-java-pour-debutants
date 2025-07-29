public class PlaneteTellurique extends Planete implements  Habitable {

    Vaisseau vaisseauAccoste;
    int totalVisiteurs;

    PlaneteTellurique(String nom) {
        super(nom);
    }

    @Override
    public Vaisseau accueillirVaisseau(Vaisseau vaisseau) {
        Vaisseau vaisseauEnPartance = this.vaisseauAccoste;
        if (vaisseauEnPartance == null) {
            System.out.println("Aucun vaisseau ne s'en va.");
        } else {
            System.out.printf("Un vaisseau de type %s doit s'en aller.\n", vaisseauEnPartance.type);
        }
        this.vaisseauAccoste = vaisseau;

        if (vaisseau instanceof VaisseauDeGuerre) {
            ((VaisseauDeGuerre) vaisseau).desactiverArmes();
        }

        this.totalVisiteurs += vaisseau.nbPassagers;
        System.out.printf("Le nombre d'humains ayant déjà séjourné sur %s est actuellement de %d.\n", this.nom, this.totalVisiteurs);

        return vaisseauEnPartance;
    }
}
