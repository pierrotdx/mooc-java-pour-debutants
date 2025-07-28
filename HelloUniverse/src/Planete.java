public class Planete {
    String nom;
    String matiere;
    long diametre;
    int totalVisiteurs;

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
}
