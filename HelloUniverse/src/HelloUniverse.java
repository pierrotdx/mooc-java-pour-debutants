public class HelloUniverse {

    public static void main(String... args) {
        short year = 2006;
        short thresholdYear = 2006;
        short nbPlanetes = 9;

        if (year >= thresholdYear) {
            nbPlanetes = 8;
        }

        System.out.printf("En %d, les planètes du système solaire étaient au nombre de : %d", year, nbPlanetes);
    }

}