package challenge1;

public class Challenge1 {

    public static String whoLikesIt(String... names) {

        int size = names.length;

        if (size == 0){
            return "no one likes this";
        } else if (size == 1) {
            return names[0] + " likes this";
        } else if (size == 2){
            return names[0] + " and " + names[1] + " like this";
        } else if (size == 3){
            return names[0] + ", " + names[1] + " and " + names[2] + " like this";
        } else {
            return names[0] + ", " + names[1] + " and " + (size-2) +  " others like this";
        }
    }

}
