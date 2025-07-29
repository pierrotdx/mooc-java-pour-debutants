public class HelloUniverse {
    public static void main(String... args) {
        PlaneteTellurique mercure = new PlaneteTellurique("Mercure");
        mercure.diametre = 4880;

        PlaneteTellurique venus = new PlaneteTellurique("Venus");
        venus.diametre = 12100;

        PlaneteTellurique terre = new PlaneteTellurique("Terre");
        terre.diametre = 12756;

        PlaneteTellurique mars = new PlaneteTellurique("Mars");
        mars.diametre = 6792;

        PlaneteGazeuse jupiter = new PlaneteGazeuse("Jupiter");
        jupiter.diametre = 142984;

        PlaneteGazeuse saturne = new PlaneteGazeuse("Saturne");
        saturne.diametre = 120536;

        PlaneteGazeuse uranus = new PlaneteGazeuse("Uranus");
        uranus.diametre = 51118;
        uranus.atmosphere.tauxHydrogene = 83f;
        uranus.atmosphere.tauxHelium= 15f;
        uranus.atmosphere.tauxMethane = 2.5f;

        PlaneteGazeuse neptune = new PlaneteGazeuse("Neptune");
        neptune.diametre = 49532;

        int quantiteRefusee;

       VaisseauDeGuerre chasseur = new VaisseauDeGuerre("CHASSEUR");
       terre.accueillirVaisseau(chasseur);
       quantiteRefusee = chasseur.emporterCargaison(20);
        System.out.printf("La quantité refusée est de %d.\n", quantiteRefusee);

       VaisseauDeGuerre fregate = new VaisseauDeGuerre("FREGATE");
       fregate.nbPassagers = 100;
       terre.accueillirVaisseau(fregate);
       quantiteRefusee = fregate.emporterCargaison(45);
       System.out.printf("La quantité refusée est de %d.\n", quantiteRefusee);
       quantiteRefusee = fregate.emporterCargaison(12);
       System.out.printf("La quantité refusée est de %d.\n", quantiteRefusee);

       VaisseauDeGuerre fregate2 = new VaisseauDeGuerre("FREGATE");
       fregate2.nbPassagers = 14;
       quantiteRefusee = fregate2.emporterCargaison(30);
       System.out.printf("La quantité refusée est de %d.\n", quantiteRefusee);

       VaisseauCivil vaisseauMonde = new VaisseauCivil("VAISSEAU-MONDE");
       terre.accueillirVaisseau(vaisseauMonde);
        quantiteRefusee = vaisseauMonde.emporterCargaison(1560);
        System.out.printf("La quantité refusée est de %d.\n", quantiteRefusee);
        quantiteRefusee = vaisseauMonde.emporterCargaison(600);
        System.out.printf("La quantité refusée est de %d.\n", quantiteRefusee);
    }
}