public class HelloUniverse {
    public static void main(String... args) {
        Planete mercure = new Planete("Mercure");
        mercure.matiere = "tellurique";
        mercure.diametre = 4880;

        Planete venus = new Planete("Venus");
        venus.matiere = "tellurique";
        venus.diametre = 12100;

        Planete terre = new Planete("Terre");
        terre.matiere = "tellurique";
        terre.diametre = 12756;

        Planete mars = new Planete("Mars");
        mars.matiere = "tellurique";
        mars.diametre = 6792;

        Planete jupiter = new Planete("Jupiter");
        jupiter.matiere = "gazeuse";
        jupiter.diametre = 142984;

        Planete saturne = new Planete("Saturne");
        saturne.matiere = "gazeuse";
        saturne.diametre = 120536;

        Planete uranus = new Planete("Uranus");
        uranus.matiere = "gazeuse";
        uranus.diametre = 51118;
        uranus.atmosphere.tauxHydrogene = 83f;
        uranus.atmosphere.tauxHelium= 15f;
        uranus.atmosphere.tauxMethane = 2.5f;

        Planete neptune = new Planete("Neptune");

        neptune.matiere = "gazeuse";
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



    }
}