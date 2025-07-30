public class PlaneteTellurique extends Planete implements Habitable {

    Vaisseau vaisseauAccoste;
    int totalVisiteurs;
    Vaisseau[] vaisseauxAccostes;

    PlaneteTellurique(String nom, int tailleBaieAccostage) {
        super(nom);
        this.vaisseauxAccostes = new Vaisseau[tailleBaieAccostage];
    }

    @Override
    public void accueillirVaisseau(Vaisseau vaisseau) {
        for (int placeIndex = 0; placeIndex < this.vaisseauxAccostes.length; placeIndex++) {
            Vaisseau vaisseauACettePlace = this.vaisseauxAccostes[placeIndex];
            if (vaisseauACettePlace == null) {
                this.vaisseauxAccostes[placeIndex] = vaisseau;
                break;
            }
        }

        if (vaisseau instanceof VaisseauDeGuerre) {
            ((VaisseauDeGuerre) vaisseau).desactiverArmes();
        }

        this.totalVisiteurs += vaisseau.nbPassagers;
        System.out.printf("Le nombre d'humains ayant déjà séjourné sur %s est actuellement de %d.\n", this.nom, this.totalVisiteurs);
    }

    boolean restePlaceDisponible() {
        boolean restePlace = false;
        for (int placeIndex = 0; placeIndex < this.vaisseauxAccostes.length; placeIndex++) {
            Vaisseau vaisseauACettePlace = this.vaisseauxAccostes[placeIndex];
            if (vaisseauACettePlace == null) {
                System.out.println("Il reste de la place dans la baie.");
                restePlace = true;
                break;
            }
        }
        return restePlace;
    }
}
