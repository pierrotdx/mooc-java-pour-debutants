public class Planete {
    static String forme = "Sphérique";
    static int nbPlanetesDecouvertes;

    String nom;
    String matiere;
    long diametre;
    int totalVisiteurs;
    Atmosphere atmosphere = new Atmosphere();
    Vaisseau vaisseau;

    Planete() {
        nbPlanetesDecouvertes++;
    }

    static String expansion(double distanceEnMdsKm) {
        return  distanceEnMdsKm < 14 ? "Oh la la mais c'est super rapide !" : "Je rêve ou c'est plus rapide que la lumière ?";
    }

    int revolution(int angle) {
        int nbToursComplets = angle / 360;
        System.out.printf("%s a effectué %d tours complets autour de son étoile.", nom, nbToursComplets);
        return nbToursComplets;
    }

    int rotation(int angle) {
        int nbToursComplets = angle / 360;
        System.out.printf("%s a effectué %d tours complets sur elle-même.", nom, nbToursComplets);
        return nbToursComplets;
    }

    Vaisseau accueillirVaisseau(Vaisseau vaisseau) {
        Vaisseau vaisseauEnPartance = this.vaisseau;
        if (vaisseauEnPartance == null) {
            System.out.println("Aucun vaisseau ne s'en va.");
        } else {
            System.out.printf("Un vaisseau de type %s doit s'en aller.\n", vaisseauEnPartance.type);
        }
        this.vaisseau = vaisseau;

        this.totalVisiteurs += vaisseau.nbPassagers;
        System.out.printf("Le nombre d'humains ayant déjà séjourné sur %s est actuellement de %d.\n", this.nom, this.totalVisiteurs);

        return vaisseauEnPartance;
    }

    void displayAthmosphere() {
        System.out.printf("L'athmosphère de %s est composée :\n", this.nom);
        System.out.printf("A %,.1f%% d'hydrogène\n", this.atmosphere.tauxHydrogene);
        System.out.printf("A %,.1f%% d'argon\n", this.atmosphere.tauxArgon);
        System.out.printf("A %,.1f%% de dioxyde de carbone\n", this.atmosphere.tauxDioxydeDeCarbone);
        System.out.printf("A %,.1f%% d'azote\n", this.atmosphere.tauxAzote);
        System.out.printf("A %,.1f%% d'hélium\n", this.atmosphere.tauxHelium);
        System.out.printf("A %,.1f%% de méthane\n", this.atmosphere.tauxMethane);
        System.out.printf("A %,.1f%% de sodium\n", this.atmosphere.tauxSodium);
    }
}
