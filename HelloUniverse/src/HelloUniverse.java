import java.util.Scanner;

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
        uranus.atmosphere.tauxHelium = 15f;
        uranus.atmosphere.tauxMethane = 2.5f;

        PlaneteGazeuse neptune = new PlaneteGazeuse("Neptune");
        neptune.diametre = 49532;

        VaisseauDeGuerre chasseur = new VaisseauDeGuerre("CHASSEUR");
        chasseur.nbPassagers = 4;
        VaisseauDeGuerre fregate = new VaisseauDeGuerre("FREGATE");
        fregate.nbPassagers = 9;
        VaisseauDeGuerre croiseur = new VaisseauDeGuerre("CROISEUR");
        croiseur.nbPassagers = 284;
        VaisseauCivil cargo = new VaisseauCivil("CARGO");
        cargo.nbPassagers = 938;
        VaisseauCivil vaisseauMonde = new VaisseauCivil("VAISSEAU-MONDE");
        vaisseauMonde.nbPassagers = 1;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Quel type de vaisseau voulez-vous manipuler ?");
        String typeVaisseauChoisi = scanner.nextLine();
        Vaisseau vaisseauChoisi;
        switch (typeVaisseauChoisi) {
            case "CHASSEUR":
                vaisseauChoisi = chasseur;
                break;
            case "FREGATE":
                vaisseauChoisi = fregate;
                break;
            case "CROISEUR":
                vaisseauChoisi = croiseur;
                break;
            case "CARGO":
                vaisseauChoisi = cargo;
                break;
            case "VAISSEAU-MONDE":
            default:
                vaisseauChoisi = chasseur;
        }

        System.out.println("Sur quelle planète voulez-vous vous rendre ?");
        String nomDePlaneteChoisie = scanner.nextLine();
        PlaneteTellurique planeteChoisie;
        switch (nomDePlaneteChoisie) {
            case "Mercure":
                planeteChoisie = mercure;
                break;
            case "Venus":
                planeteChoisie = venus;
                break;
            case "Terre":
                planeteChoisie = terre;
                break;
            case "Mars":
            default:
                planeteChoisie = mars;
        }
        planeteChoisie.accueillirVaisseau(vaisseauChoisi);

        System.out.println("Quel tonnage de livraison souhaitez-vous embarquer ?");
        int tonnageChoisi = scanner.nextInt();

        int tonnageRejete = vaisseauChoisi.emporterCargaison(tonnageChoisi);
        System.out.printf("Le tonnage rejeté est %d.\n", tonnageRejete);
    }
}