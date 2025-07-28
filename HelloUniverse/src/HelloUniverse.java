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


        System.out.println(Planete.nbPlanetesDecouvertes);

    }
}