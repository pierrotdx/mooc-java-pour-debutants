public abstract class Vaisseau {
    TypeVaisseau type;
    int nbPassagers;
    int blindage;
    int resistanceDuBouclier;
    int tonnageMax;
    int tonnageActuel;


    Vaisseau(TypeVaisseau type) {
        this.type = type;
        switch (this.type) {
            case CHASSEUR:
                this.tonnageMax = 0;
                break;
            case FREGATE:
                this.tonnageMax = 50;
                break;
            case CROISEUR:
                this.tonnageMax = 100;
                break;
            case CARGO:
                this.tonnageMax = 500;
                break;
            case VAISSEAUMONDE:
                this.tonnageMax = 2000;
                break;
        }
    }

    void activerBouclier() {
        System.out.printf("Activation du bouclier d'un vaisseau de type %s\n", this.type);
    }

    void desactiverBouclier() {
        System.out.printf("Désactivation du bouclier d'un vaisseau de type %s\n", this.type);
    }

    abstract int emporterCargaison(int tonnage);
}
