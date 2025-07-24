public class HelloUniverse {

    public static void main(String... args) {
        short year = 2007;
        short thresholdYear = 2006;
        short nbPlanetes;

        if (year < thresholdYear) {
            nbPlanetes = 9;
        } else {
            nbPlanetes = 8;
        }

        System.out.printf("En %d, les planètes du système solaire étaient au nombre de : %d", year, nbPlanetes);
    }

}