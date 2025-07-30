import java.util.*;

public class HelloUniverse {
    public static void main(String... args) {
        Galaxie systemeSolaire = new Galaxie();
        systemeSolaire.nom = "Système solaire";
        systemeSolaire.planetes = new TreeSet<Planete>();

        PlaneteTellurique mercure = new PlaneteTellurique("Mercure", 0);
        mercure.diametre = 4880;
        mercure.distanceEtoile = 57.9f;

        PlaneteTellurique venus = new PlaneteTellurique("Venus", 2);
        venus.diametre = 12100;
        venus.distanceEtoile = 108.2f;

        PlaneteTellurique terre = new PlaneteTellurique("Terre", 19);
        terre.diametre = 12756;
        terre.distanceEtoile = 149.6f;

        PlaneteTellurique mars = new PlaneteTellurique("Mars", 2);
        mars.diametre = 6792;
        mars.distanceEtoile = 227.9f;
        mars.atmosphere.constituants = new HashMap<String, Float>();
        mars.atmosphere.constituants.put("CO2", 95f);
        mars.atmosphere.constituants.put("N2", 3f);
        mars.atmosphere.constituants.put("AR", 1.5f);
        mars.atmosphere.constituants.put("NO", 0.013f);

        System.out.println("L'atmosphère de Mars est constituée de :");
        for (Map.Entry<String, Float> entry : mars.atmosphere.constituants.entrySet()) {
            String element = entry.getKey();
            Float taux = entry.getValue();
            System.out.printf("%,.3f%% de %s\n", taux, element);
        }

        PlaneteGazeuse jupiter = new PlaneteGazeuse("Jupiter");
        jupiter.diametre = 142984;
        jupiter.distanceEtoile = 778.3f;

        PlaneteGazeuse saturne = new PlaneteGazeuse("Saturne");
        saturne.diametre = 120536;
        saturne.distanceEtoile = 1427f;

        PlaneteGazeuse uranus = new PlaneteGazeuse("Uranus");
        uranus.diametre = 51118;
        uranus.distanceEtoile = 2877.38f;
        uranus.atmosphere.tauxHydrogene = new Float(83f);
        uranus.atmosphere.tauxHelium = new Float(15f);
        uranus.atmosphere.tauxMethane = new Float(2.5f);
        uranus.atmosphere.tauxAzote = new Float(0);

        PlaneteGazeuse neptune = new PlaneteGazeuse("Neptune");
        neptune.diametre = 49532;
        neptune.distanceEtoile = 4497.07f;

        systemeSolaire.planetes.add(saturne);
        systemeSolaire.planetes.add(mars);
        systemeSolaire.planetes.add(uranus);
        systemeSolaire.planetes.add(neptune);
        systemeSolaire.planetes.add(jupiter);
        systemeSolaire.planetes.add(mercure);
        systemeSolaire.planetes.add(terre);
        systemeSolaire.planetes.add(venus);

        for (Planete planet : systemeSolaire.planetes) {
            System.out.println(planet.nom);
        }

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