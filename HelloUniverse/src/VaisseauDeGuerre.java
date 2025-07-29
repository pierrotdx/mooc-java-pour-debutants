public class VaisseauDeGuerre extends Vaisseau {
    void attaque(Vaisseau cible, String arme, int dureeDeLAttaque) {
        System.out.printf("Un vaisseau de type %s attaque un vaisseau de type %s en utilisant l'arme %s pendant %d minutes.\n", this.type, cible.type, arme, dureeDeLAttaque);
        cible.resistanceDuBouclier = 0;
        cible.blindage = cible.blindage / 2;
    }
}
