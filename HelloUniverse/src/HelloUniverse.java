import java.util.*;

public class HelloUniverse {
    public static void main(String... args) {
        Galaxie systemeSolaire = new Galaxie();
        systemeSolaire.name = "Système solaire";
        systemeSolaire.planetes = new HashSet();

        PlaneteTellurique mercure = new PlaneteTellurique("Mercure", 0);
        mercure.diametre = 4880;
        systemeSolaire.planetes.add(mercure);

        PlaneteTellurique venus = new PlaneteTellurique("Venus", 2);
        venus.diametre = 12100;
        systemeSolaire.planetes.add(venus);

        PlaneteTellurique terre = new PlaneteTellurique("Terre", 19);
        terre.diametre = 12756;
        systemeSolaire.planetes.add(terre);

        PlaneteTellurique mars = new PlaneteTellurique("Mars", 2);
        mars.diametre = 6792;
        systemeSolaire.planetes.add(mars);

        PlaneteGazeuse jupiter = new PlaneteGazeuse("Jupiter");
        jupiter.diametre = 142984;
        systemeSolaire.planetes.add(jupiter);

        PlaneteGazeuse saturne = new PlaneteGazeuse("Saturne");
        saturne.diametre = 120536;
        systemeSolaire.planetes.add(saturne);

        PlaneteGazeuse uranus = new PlaneteGazeuse("Uranus");
        uranus.diametre = 51118;
        uranus.atmosphere.tauxHydrogene = new Float(83f);
        uranus.atmosphere.tauxHelium = new Float(15f);
        uranus.atmosphere.tauxMethane = new Float(2.5f);
        uranus.atmosphere.tauxAzote = new Float(0);
        systemeSolaire.planetes.add(uranus);

        PlaneteGazeuse neptune = new PlaneteGazeuse("Neptune");
        neptune.diametre = 49532;
        systemeSolaire.planetes.add(neptune);

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

        VaisseauDeGuerre chasseur1 = new VaisseauDeGuerre(TypeVaisseau.CHASSEUR);
        VaisseauDeGuerre chasseur2 = new VaisseauDeGuerre(TypeVaisseau.CHASSEUR);

        terre.accueillirVaisseaux(chasseur1, chasseur2, cargo);

        boolean recommencer = true;
        while (recommencer) {
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

            System.out.println("Quel est le nom de la planète sur laquelle vous voulez rendre ?");
            String nomPlanete = scanner.nextLine();
            Planete planeteChoisie = terre;
            Iterator<Planete> planeteIterator = systemeSolaire.planetes.iterator();
            // ou utiliser un for
            while (planeteIterator.hasNext()) {
                Planete planete = planeteIterator.next();
                if (planete.nom.equals(nomPlanete)) {
                    planeteChoisie = planete;
                }
            }

            if ((planeteChoisie instanceof PlaneteTellurique)) {
                boolean restePlace = ((PlaneteTellurique) planeteChoisie).restePlaceDisponible(vaisseauChoisi);
                if (restePlace) {
                    ((PlaneteTellurique) planeteChoisie).accueillirVaisseaux(vaisseauChoisi);

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
            } else {
                System.out.println("Cette planète n'est pas une planète tellurique. Impossible d'y atterrir.");
            }
        }
    }
}