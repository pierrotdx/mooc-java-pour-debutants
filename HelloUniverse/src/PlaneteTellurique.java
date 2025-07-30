import java.lang.reflect.Type;

public class PlaneteTellurique extends Planete implements Habitable {

    Vaisseau vaisseauAccoste;
    int totalVisiteurs;
    Vaisseau[][] vaisseauxAccostes;

    PlaneteTellurique(String nom, int tailleBaieAccostage) {
        super(nom);
        this.vaisseauxAccostes = new Vaisseau[2][tailleBaieAccostage];
    }

    @Override
    public void accueillirVaisseaux(Vaisseau... vaisseaux) {
        for (Vaisseau vaisseau : vaisseaux) {
            Vaisseau[] quaiDAccostage;
            switch (vaisseau.type) {
                case CHASSEUR:
                case FREGATE:
                case CROISEUR:
                    quaiDAccostage = this.vaisseauxAccostes[0];
                default:
                    quaiDAccostage = this.vaisseauxAccostes[1];
            }
            ;
            for (int placeIndex = 0; placeIndex < quaiDAccostage.length; placeIndex++) {
                Vaisseau vaisseauACettePlace = quaiDAccostage[placeIndex];
                if (vaisseauACettePlace == null) {
                    quaiDAccostage[placeIndex] = vaisseau;
                    if (vaisseau instanceof VaisseauDeGuerre) {
                        ((VaisseauDeGuerre) vaisseau).desactiverArmes();
                    }
                    this.totalVisiteurs += vaisseau.nbPassagers;
                    break;
                }
            }
        }

        System.out.printf("Le nombre d'humains ayant déjà séjourné sur %s est actuellement de %d.\n", this.nom, this.totalVisiteurs);
    }

    boolean restePlaceDisponible(Vaisseau vaisseau) {
        Vaisseau[] quaiDAccostage;
        switch (vaisseau.type) {
            case CHASSEUR:
            case FREGATE:
            case CROISEUR:
                quaiDAccostage = this.vaisseauxAccostes[0];
            default:
                quaiDAccostage = this.vaisseauxAccostes[1];
        }

        boolean restePlace = false;
        for (int placeIndex = 0; placeIndex < quaiDAccostage.length; placeIndex++) {
            Vaisseau vaisseauACettePlace = quaiDAccostage[placeIndex];
            if (vaisseauACettePlace == null) {
                System.out.println("Il reste de la place dans la baie.");
                restePlace = true;
                break;
            }
        }
        return restePlace;
    }
}
