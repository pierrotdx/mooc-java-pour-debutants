public class Planete {
    String nom;
    String matiere;
    long diametre;
    int totalVisiteurs;
    Atmosphere atmosphere = new Atmosphere();

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

    void accueillirVaisseau(int nbArrivants) {
        totalVisiteurs += nbArrivants;
    }

    void accueillirVaisseau(String typeDeVaisseau) {
        /* here we use `if` to force the use of the freshly-introduced `equals` method although `switch` would be cleaner */
        if (typeDeVaisseau.equals("CHASSEUR")) {
            totalVisiteurs += 3;
        } else if (typeDeVaisseau.equals("FREGATE")) {
            totalVisiteurs += 12;
        } else if (typeDeVaisseau.equals("CROISEUR")) {
            totalVisiteurs += 50;
        }
    }

    void displayAthmosphere() {
        System.out.printf("L'athmosphère de %s est composée :\n", this.nom);
        System.out.printf("A %,.1f%% d'hydrogène\n", this.atmosphere.hydrogene);
        System.out.printf("A %,.1f%% d'argon\n", this.atmosphere.argon);
        System.out.printf("A %,.1f%% de dioxyde de carbone\n", this.atmosphere.dioxydeDeCarbone);
        System.out.printf("A %,.1f%% d'azote\n", this.atmosphere.azote);
        System.out.printf("A %,.1f%% d'hélium\n", this.atmosphere.helium);
        System.out.printf("A %,.1f%% de méthane\n", this.atmosphere.methane);
        System.out.printf("A %,.1f%% de sodium\n", this.atmosphere.sodium);
    }
}
