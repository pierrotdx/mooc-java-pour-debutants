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


        VaisseauDeGuerre chasseur = new VaisseauDeGuerre();
        chasseur.type = "CHASSEUR";
        chasseur.blindage = 156;
        chasseur.resistanceDuBouclier = 2;
        chasseur.activerBouclier();

        VaisseauCivil vaisseauMonde = new VaisseauCivil();
        vaisseauMonde.type = "VAISSEAU-MONDE";
        vaisseauMonde.blindage = 4784;
        vaisseauMonde.resistanceDuBouclier = 30;
        vaisseauMonde.activerBouclier();

        chasseur.attaque(vaisseauMonde, "laser photonique", 3);
        vaisseauMonde.desactiverBouclier();
        System.out.printf("La durée de protection résiduelle du bouclier du Vaisseau-Monde est de %d minutes.\n", vaisseauMonde.resistanceDuBouclier);
        System.out.printf("La valeur du blindage du Vaisseau-Monde est de %d.\n", vaisseauMonde.blindage);

        mars.accueillirVaisseau(vaisseauMonde);
        mars.accueillirVaisseau(chasseur);

    }
}