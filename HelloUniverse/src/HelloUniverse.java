public class HelloUniverse {

    public static void main(String... args) {
        short year = 2006;
        short minYear = 1600;
        short maxYear = 2020;
        short thresholdYear = 2006;
        short nbPlanetes;

        if (year < minYear || year > maxYear) {
            System.out.printf("Le programme ne peut pas fournir de résultat pour l'année %d", year);
        } else {
             if (year < 1700) {
                nbPlanetes = 7;
             }
             else if (year < 1800) {
                nbPlanetes = 8;
             }
             else if (year <= 2006) {
                nbPlanetes = 9;
             }
             else {
                nbPlanetes = 8;
             }
             System.out.printf("En %d, les planètes du système solaire étaient au nombre de : %d", year, nbPlanetes);
        }

    }

}