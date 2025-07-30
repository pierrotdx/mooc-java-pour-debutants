public abstract class Planete implements Comparable<Planete> {
    static String forme = "Sphérique";
    static int nbPlanetesDecouvertes;

    String nom;
    long diametre;
    Atmosphere atmosphere = new Atmosphere();
    float distanceEtoile;

    Planete(String nom) {
        this.nom = nom;
        nbPlanetesDecouvertes++;
    }

    static String expansion(double distanceEnMdsKm) {
        return distanceEnMdsKm < 14 ? "Oh la la mais c'est super rapide !" : "Je rêve ou c'est plus rapide que la lumière ?";
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

    void displayAthmosphere() {
        System.out.printf("L'athmosphère de %s est composée :\n", this.nom);
        if (this.atmosphere.tauxHydrogene != null) {
            System.out.printf("A %,.1f%% d'hydrogène\n", this.atmosphere.tauxHydrogene);
        }
        if (this.atmosphere.tauxArgon != null) {
            System.out.printf("A %,.1f%% d'argon\n", this.atmosphere.tauxArgon);
        }
        if (this.atmosphere.tauxDioxydeDeCarbone != null) {
            System.out.printf("A %,.1f%% de dioxyde de carbone\n", this.atmosphere.tauxDioxydeDeCarbone);
        }
        if (this.atmosphere.tauxAzote != null) {
            System.out.printf("A %,.1f%% d'azote\n", this.atmosphere.tauxAzote);
        }
        if (this.atmosphere.tauxHelium != null) {
            System.out.printf("A %,.1f%% d'hélium\n", this.atmosphere.tauxHelium);
        }
        if (this.atmosphere.tauxMethane != null) {
            System.out.printf("A %,.1f%% de méthane\n", this.atmosphere.tauxMethane);
        }
        if (this.atmosphere.tauxSodium != null) {
            System.out.printf("A %,.1f%% de sodium\n", this.atmosphere.tauxSodium);
        }
    }

    @Override
    public int compareTo(Planete autrePlanete) {
        if (this.distanceEtoile == autrePlanete.distanceEtoile) {
            return 0;
        } else if (this.distanceEtoile > autrePlanete.distanceEtoile) {
            return 1;
        }
        return -1;
    }
}
