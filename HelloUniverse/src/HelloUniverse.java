public class HelloUniverse {

    public static void main(String... args){
        short nbPlanetes = 8;
        String text = "Aux dernières nouvelles, le nombre total de planètes dans le système solaire est de : " + nbPlanetes;

        System.out.println(text);

        nbPlanetes++;
        text = "Il y a quelques années cependant, elles étaient au nombre de : " + nbPlanetes;

        System.out.println(text);
    }

}