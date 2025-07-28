public class Planete {
    String nom;
    String matiere;
    long diametre;

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
}
