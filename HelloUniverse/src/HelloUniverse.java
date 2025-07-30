import java.util.Scanner;

public class HelloUniverse {
    public static void main(String... args) {
        PlaneteTellurique mercure = new PlaneteTellurique("Mercure", 0);
        mercure.diametre = 4880;

        PlaneteTellurique venus = new PlaneteTellurique("Venus", 2);
        venus.diametre = 12100;

        PlaneteTellurique terre = new PlaneteTellurique("Terre", 19);
        terre.diametre = 12756;

        PlaneteTellurique mars = new PlaneteTellurique("Mars", 2);
        mars.diametre = 6792;

        PlaneteGazeuse jupiter = new PlaneteGazeuse("Jupiter");
        jupiter.diametre = 142984;

        PlaneteGazeuse saturne = new PlaneteGazeuse("Saturne");
        saturne.diametre = 120536;

        PlaneteGazeuse uranus = new PlaneteGazeuse("Uranus");
        uranus.diametre = 51118;
        uranus.atmosphere.tauxHydrogene = new Float(83f);
        uranus.atmosphere.tauxHelium = new Float(15f);
        uranus.atmosphere.tauxMethane = new Float(2.5f);
        uranus.atmosphere.tauxAzote = new Float(0);

        PlaneteGazeuse neptune = new PlaneteGazeuse("Neptune");
        neptune.diametre = 49532;

        VaisseauDeGuerre chasseur = new VaisseauDeGuerre(TypeVaisseau.CHASSEUR);
        chasseur.nbPassagers = 4;

        VaisseauDeGuerre fregate = new VaisseauDeGuerre(TypeVaisseau.FREGATE);
        fregate.nbPassagers = 9;

        VaisseauDeGuerre croiseur = new VaisseauDeGuerre(TypeVaisseau.CROISEUR);
        croiseur.nbPassagers = 284;

        VaisseauCivil cargo = new VaisseauCivil(TypeVaisseau.CARGO);
        cargo.nbPassagers = 938;

        VaisseauCivil vaisseauMonde = new VaisseauCivil(TypeVaisseau.VAISSEAUMONDE);
        vaisseauMonde.nbPassagers = 1;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Quel type de vaisseau voulez-vous manipuler ?");
        TypeVaisseau typeVaisseau = TypeVaisseau.valueOf(scanner.nextLine());
        Vaisseau vaisseauChoisi;
        switch (typeVaisseau) {
            case CHASSEUR:
                vaisseauChoisi = chasseur;
                break;
            case FREGATE:
                vaisseauChoisi = fregate;
                break;
            case CROISEUR:
                vaisseauChoisi = croiseur;
                break;
            case CARGO:
                vaisseauChoisi = cargo;
                break;
            case VAISSEAUMONDE:
            default:
                vaisseauChoisi = vaisseauMonde;
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

        boolean recommencer = true;
        while (recommencer) {
            boolean restePlace = planeteChoisie.restePlaceDisponible();
            if (restePlace) {
                planeteChoisie.accueillirVaisseau(vaisseauChoisi);

                System.out.println("Quel tonnage de livraison souhaitez-vous embarquer ?");
                int tonnageChoisi = scanner.nextInt();
                scanner.nextLine();

                int tonnageRejete = vaisseauChoisi.emporterCargaison(tonnageChoisi);
                System.out.printf("Le tonnage rejeté est %d.\n", tonnageRejete);
            } else {
                System.out.println("Le vaisseau ne peut pas se poser sur la planète par manque de place dans la baie.");
            }

            System.out.println("Voulez-vous recommencer oui/non ?");
            String utilisateurVeutRecommencer = scanner.nextLine();
            recommencer = utilisateurVeutRecommencer.equals("oui");
        }
    }
}